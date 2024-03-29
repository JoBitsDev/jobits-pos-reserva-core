/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase.impl;

import com.jobits.pos.reserva.core.domain.Reserva;
import com.jobits.pos.reserva.core.domain.ReservaEstado;
import com.jobits.pos.reserva.core.domain.UbicacionEstado;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.repo.ReservaRepo;
import com.jobits.pos.reserva.core.usecase.ReservaUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.clean.core.domain.services.ResourceHandler;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReservaUseCaseImpl extends DefaultCRUDUseCase<Reserva> implements ReservaUseCase {

    private final ReservaRepo repo = ReservaCoreModule.getInstance().getImplementation(ReservaRepo.class);

    public ReservaUseCaseImpl() {
        setRepo(repo);
    }

    @Override
    public boolean cancelar(int idReserva) {
        Reserva r = repo.findBy(idReserva);
        if (r == null) {
            throw new IllegalArgumentException();
        }
        if (r.getEstado().equals(ReservaEstado.COMPLETADA.getRecursoEstado())) {
            throw new IllegalStateException("msg.com.jobits.pos.reserva.core.cancelar_reserva_completada");
        }
        r.setEstado(ReservaEstado.CANCELADA.getRecursoEstado());
        repo.startTransaction();
        repo.edit(r);
        repo.commitTransaction();
        firePropertyChange(RESERVA_CANCELADA_PROPERTY, null, r);
        return true;
    }

    @Override
    public boolean checkIn(int idReserva, LocalDateTime checkinTime) {
        Reserva r = repo.findBy(idReserva);
        if (r == null || r.getEstado().equals(ReservaEstado.CANCELADA.getRecursoEstado())) {
            throw new IllegalArgumentException();
        }
        if (r.getFechareserva().until(checkinTime, ChronoUnit.DAYS) > 0) {
            throw new IllegalArgumentException("msg.com.jobits.pos.core.domain.reserva_checkin_future");
        }
        firePropertyChange(BEFORE_CHECK_IN_PROPERTY, null, r);
        r.setCheckin(checkinTime);
        repo.startTransaction();
        repo.edit(r);
        repo.commitTransaction();
        firePropertyChange(AFTER_CHECK_IN_PROPERTY, null, r);
        return true;
    }

    @Override
    public boolean checkOut(int idReserva, LocalDateTime checkoutTime) {
        Reserva r = repo.findBy(idReserva);
        if (r == null) {
            throw new IllegalArgumentException("msg.com.jobits.pos.core.domain.reserva_checkout_invalido");
        }
        if (!r.getEstado().equals(ReservaEstado.CHEQUEADA.getRecursoEstado())) {
            return true;
        }
        r.setCheckout(checkoutTime);
        repo.startTransaction();
        repo.edit(r);
        repo.commitTransaction();
        firePropertyChange(AFTER_CHECK_OUT_PROPERTY, null, r);
        return true;
    }

    @Override
    public Reserva create(Reserva newObject) throws RuntimeException {
        if (validarReserva(newObject)) {
            repo.startTransaction();
            Reserva newReserva = super.create(newObject);
            repo.commitTransaction();
            firePropertyChange("create", null, newReserva);
            return newReserva;
        }
        throw new IllegalArgumentException(ResourceHandler.getString("msg.com.jobits.pos.error_creando_obj"));
    }

    @Override
    public Reserva edit(Reserva objectToUpdate) throws RuntimeException {
        if (validarReserva(objectToUpdate)) {
            repo.startTransaction();
            Reserva updatedReserva = super.edit(objectToUpdate);
            repo.commitTransaction();
            firePropertyChange("edit", null, updatedReserva);
            return updatedReserva;
        }
        throw new IllegalArgumentException(ResourceHandler.getString("msg.com.jobits.pos.error_creando_obj"));
    }

    @Override
    public List<Reserva> getReservasDisponibles(LocalDate diaDereservas) {
        List<Reserva> ret = repo.findReservasDeDia(diaDereservas);
        return ret.stream().filter((Reserva t) 
                -> !t.getEstado().equals(ReservaEstado.CANCELADA.getRecursoEstado())).collect(Collectors.toList());
    }

    private boolean validarReserva(Reserva reservaPorValidar) {
        if (LocalDateTime.of(reservaPorValidar.getFechareserva(), reservaPorValidar.getHorareserva()).isBefore(LocalDateTime.now().minusMinutes(10))) {
            throw new IllegalArgumentException(
                    ResourceHandler.getString("msg.com.jobits.pos.reserva.core.domain.reserva_hora_incorrecta"));
        }
        List<Reserva> reservas = getReservasDisponibles(reservaPorValidar.getFechareserva());
        reservas.remove(reservaPorValidar);
        for (int i = 0; i < reservas.size();) {
            if (reservaPorValidar.getUbicacionidubicacion()
                    .getEstadoubicacion().equals(UbicacionEstado.INABILITADA.getEstado())) {
                throw new IllegalArgumentException(ResourceHandler
                        .getString("msg.com.jobits.pos.reserva.core.domain.reserva_ubicacion_inhabilitada"));
            }
            if (!reservas.get(i).getUbicacionidubicacion().equals(reservaPorValidar.getUbicacionidubicacion())) {
                reservas.remove(i);
                continue;
            }
            if (reservas.get(i).getCategoriaidcategoria().equals(reservaPorValidar.getCategoriaidcategoria())) {
                if (validarRangoFechas(reservas.get(i), reservaPorValidar)) {
                    reservas.remove(0);
                    continue;
                } else {
                    throw new IllegalArgumentException(
                            String.format(ResourceHandler
                                    .getString("msg.com.jobits.pos.reserva.core.domain.reserva_fecha_invalida"),
                                    reservas.get(i)));
                }
            } else {
                reservas.remove(0);
            }
        }
        reservaPorValidar.validate();
        return reservas.isEmpty();
    }

    private boolean validarRangoFechas(Reserva reserva, Reserva reservaPorValidar) {
        LocalTime endTime = reserva.getHorareserva().plus(reservaPorValidar.getDuracionMinutos(), ChronoUnit.MINUTES);
        LocalTime startTime = reserva.getHorareserva();

        LocalTime auxStartTime = reservaPorValidar.getHorareserva();
        LocalTime auxEndTime = reservaPorValidar.getHorareserva()
                .plus(reservaPorValidar.getDuracionMinutos(), ChronoUnit.MINUTES);

        if (auxEndTime.isAfter(startTime) && auxEndTime.isBefore(endTime)) {
            return false;
        }
        if (auxStartTime.isAfter(startTime) && auxStartTime.isBefore(endTime)) {
            return false;
        }
        return true;
    }

}
