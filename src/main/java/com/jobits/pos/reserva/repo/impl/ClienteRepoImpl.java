/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.core.domain.Cliente;
import com.jobits.pos.reserva.core.repo.ClienteRepo;
import com.jobits.pos.reserva.repo.entity.ClienteEntity;

public class ClienteRepoImpl extends AbstractRepo<Cliente, ClienteEntity>
        implements ClienteRepo {

    public ClienteRepoImpl() {
        super(Cliente.class, ClienteEntity.class);
    }

}
