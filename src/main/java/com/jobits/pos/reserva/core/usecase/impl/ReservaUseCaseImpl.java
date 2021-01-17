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

public class ReservaUseCaseImpl extends DefaultCRUDUseCase<Reserva> implements ReservaUseCase {

    private final ReservaRepo repo = ReservaCoreModule.getInstance().getImplementation(ReservaRepo.class);

    public ReservaUseCaseImpl() {
        setRepo(repo);
    }

    @Override
    public boolean cancelar(long idReserva) {
        Reserva r = repo.findBy(idReserva);
        if (r == null) {
            throw new IllegalArgumentException();
        }
        r.setEstado(ReservaEstado.CONCELADA.getRecursoEstado());
        repo.startTransaction();
        repo.edit(r);
        repo.commitTransaction();
        return true;
    }

    @Override
    public boolean checkIn(long idReserva, LocalDateTime checkinTime) {
        Reserva r = repo.findBy(idReserva);
        if (r == null || r.getEstado().equals(ReservaEstado.CONCELADA.getRecursoEstado())) {
            throw new IllegalArgumentException();
        }
        r.setCheckin(checkinTime);
        repo.startTransaction();
        repo.edit(r);
        repo.commitTransaction();
        return true;
    }

    @Override
    public boolean checkOut(long idReserva, LocalDateTime checkoutTime) {
        Reserva r = repo.findBy(idReserva);
        if (r == null || r.getEstado().equals(ReservaEstado.CONCELADA.getRecursoEstado())) {
            throw new IllegalArgumentException();
        }
        r.setCheckin(checkoutTime);
        repo.startTransaction();
        repo.edit(r);
        repo.commitTransaction();
        return true;
    }

    @Override
    public Reserva create(Reserva newObject) throws RuntimeException {
        if (validarReserva(newObject)) {
            repo.startTransaction();
            Reserva newReserva = super.create(newObject);
            repo.commitTransaction();
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
            return updatedReserva;
        }
        throw new IllegalArgumentException(ResourceHandler.getString("msg.com.jobits.pos.error_creando_obj"));
    }

    @Override
    public List<Reserva> getReservasDisponibles(LocalDate diaDereservas) {
        return repo.findReservasDeDia(diaDereservas);
    }

    private boolean validarReserva(Reserva reservaPorValidar) {
        List<Reserva> reservas = repo.findReservasDeDia(reservaPorValidar.getFechareserva());
        for (int i = 0; i < reservas.size();) {
            if (reservaPorValidar.getUbicacionidubicacion() != null) {
                if (reservaPorValidar.getUbicacionidubicacion()
                        .getEstadoubicacion().equals(UbicacionEstado.INABILITADA.getEstado())) {
                    throw new IllegalArgumentException(ResourceHandler
                            .getString("msg.com.jobits.pos.reserva.core.domain.reserva_ubicacion_inhabilitada"));
                }
                if (!reservas.get(i).getUbicacionidubicacion().equals(reservaPorValidar.getUbicacionidubicacion())) {
                    reservas.remove(i);
                    continue;
                }
            }
            if (reservas.get(i).getCategoriaidcategoria().equals(reservaPorValidar.getCategoriaidcategoria())) {
                if (validarRangoFechas(reservas.get(i), reservaPorValidar)) {
                    reservas.remove(i);
                } else {
                    throw new IllegalArgumentException(
                            String.format(ResourceHandler
                                    .getString("msg.com.jobits.pos.reserva.core.domain.reserva_fecha_invalida"),
                                    reservas.get(i)));
                }
            }

        }
        return reservas.isEmpty();
    }

    private boolean validarRangoFechas(Reserva reserva, Reserva reservaPorValidar) {
        LocalTime endTime = reserva.getHorareserva().plus(reservaPorValidar.getDuracionreservasegundos(), ChronoUnit.SECONDS);
        LocalTime startTime = reserva.getHorareserva();

        LocalTime auxStartTime = reservaPorValidar.getHorareserva();
        LocalTime auxEndTime = reservaPorValidar.getHorareserva()
                .plus(reservaPorValidar.getDuracionreservasegundos(), ChronoUnit.SECONDS);

        if (auxEndTime.isAfter(startTime) && auxEndTime.isBefore(endTime)) {
            return false;
        }
        if (auxStartTime.isAfter(startTime) && auxStartTime.isBefore(endTime)) {
            return false;
        }
        return true;
    }

}
