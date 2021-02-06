/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import org.jobits.app.repo.JpaCRUDRepository;
import com.jobits.pos.reserva.core.domain.Reserva;
import com.jobits.pos.reserva.repo.module.ReservaRepoModule;
import com.jobits.pos.reserva.core.repo.ReservaRepo;
import com.jobits.pos.reserva.repo.entity.ReservaEntity;
import org.jobits.app.repo.ConnectionPool;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepoImpl extends JpaCRUDRepository<Reserva, ReservaEntity>
        implements ReservaRepo {

    public ReservaRepoImpl() {
        super(ConnectionPool.getInstance(), Reserva.class, ReservaEntity.class);
    }

    @Override
    public List<Reserva> findReservasDeDia(LocalDate diaDeReservas) {
        try {
            return converter.from(getEntityManager().createNamedQuery("ReservaEntity.findByFechareserva")
                    .setParameter("fechareserva", diaDeReservas).getResultList());
        } catch (Exception ex) {
            return new ArrayList<>();
    }
    }

}
