/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.core.domain.Reserva;
import com.jobits.pos.reserva.core.module.ReservaRepoModule;
import com.jobits.pos.reserva.core.repo.ReservaRepo;
import com.jobits.pos.reserva.repo.entity.ReservaEntity;
import com.jobits.pos.reserva.repo.util.ConnectionPool;
import java.time.LocalDate;
import java.util.List;

public class ReservaRepoImpl extends JpaCRUDRepository<Reserva, ReservaEntity>
        implements ReservaRepo {

    public ReservaRepoImpl() {
        super(ReservaRepoModule.getInstance()
                .getImplementation(ConnectionPool.class), Reserva.class, ReservaEntity.class);
    }

    @Override
    public List<Reserva> findReservasDeDia(LocalDate diaDeReservas) {
        return getEntityManager().createNamedQuery("Reserva.findByFechareserva")
                .setParameter("fechareserva", diaDeReservas).getResultList();
    }

}
