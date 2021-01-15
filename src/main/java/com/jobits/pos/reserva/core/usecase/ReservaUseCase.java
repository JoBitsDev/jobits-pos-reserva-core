/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase;

import com.jobits.pos.reserva.core.domain.Reserva;
import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public interface ReservaUseCase extends CRUDUseCase<Reserva> {

    public List<Reserva> getReservasDisponibles(LocalDate diaDereservas);

    public boolean checkIn(long idReserva, LocalDateTime checkinTime);

    public boolean checkOut(long idReserva, LocalDateTime checkoutTime);
    
    public boolean cancelar(long idReserva);

}
