/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase.impl;

import com.jobits.pos.reserva.core.domain.Cliente;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.repo.ClienteRepo;
import com.jobits.pos.reserva.core.usecase.ClienteUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;

public class ClienteUseCaseImpl extends DefaultCRUDUseCase<Cliente> implements ClienteUseCase {

    public ClienteUseCaseImpl() {
        setRepo(ReservaCoreModule.getInstance().getImplementation(ClienteRepo.class));
    }

}
