/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase.impl;

import com.jobits.pos.reserva.core.domain.Reserva;
import com.jobits.pos.reserva.core.repo.ReservaRepo;
import com.jobits.pos.reserva.core.usecase.ReservaUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReservaUseCaseImpl extends DefaultCRUDUseCase<Reserva> implements ReservaUseCase {

    private final ReservaRepo reservaRepo;

    public ReservaUseCaseImpl(ReservaRepo reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    @Override
    public Reserva create(Reserva newObject) throws RuntimeException {
        if (validarReserva(newObject)) {
            reservaRepo.startTransaction();
            Reserva newReserva = super.create(newObject);
            reservaRepo.startTransaction();
            return newReserva;
        }
        throw new IllegalArgumentException("Error creando el objeto");
    }

    @Override
    public Reserva edit(Reserva objectToUpdate) throws RuntimeException {
        if (validarReserva(objectToUpdate)) {
            reservaRepo.startTransaction();
            Reserva updatedReserva = super.edit(objectToUpdate);
            reservaRepo.startTransaction();
            return updatedReserva;
        }
        throw new IllegalArgumentException("Error creando el objeto");
    }

    private boolean validarReserva(Reserva reservaPorValidar) {
        List<Reserva> reservas = reservaRepo.findReservasDeDia(reservaPorValidar.getFechareserva());
        for (int i = 0; i < reservas.size();) {
            if (reservaPorValidar.getUbicacionidubicacion() != null) {
                if (!reservas.get(i).getUbicacionidubicacion().equals(reservaPorValidar.getUbicacionidubicacion())) {
                    reservas.remove(i);
                    continue;
                }
            }
            if (validarRangoFechas(reservas.get(i), reservaPorValidar)) {
                reservas.remove(i);
            } else {
                throw new IllegalArgumentException("La reserva a crear causa conflictos con " + reservas.get(i) + " en el sistema");
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
