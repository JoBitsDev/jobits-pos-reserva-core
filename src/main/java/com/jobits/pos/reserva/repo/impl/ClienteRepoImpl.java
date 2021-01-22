/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.repo.util.JpaCRUDRepository;
import com.jobits.pos.reserva.core.domain.Cliente;
import com.jobits.pos.reserva.repo.module.ReservaRepoModule;
import com.jobits.pos.reserva.core.repo.ClienteRepo;
import com.jobits.pos.reserva.repo.entity.ClienteEntity;
import com.jobits.pos.reserva.repo.util.ConnectionPool;

public class ClienteRepoImpl extends JpaCRUDRepository<Cliente, ClienteEntity>
        implements ClienteRepo {

    public ClienteRepoImpl() {
        super(ConnectionPool.getInstance(), Cliente.class, ClienteEntity.class);
    }

}
