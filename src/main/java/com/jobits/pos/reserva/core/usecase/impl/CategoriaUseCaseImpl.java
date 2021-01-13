/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase.impl;

import com.jobits.pos.reserva.core.domain.Categoria;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.repo.CategoriaRepo;
import com.jobits.pos.reserva.core.usecase.CategoriaUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;

public class CategoriaUseCaseImpl extends DefaultCRUDUseCase<Categoria>
        implements CategoriaUseCase {

    public CategoriaUseCaseImpl() {
        setRepo(ReservaCoreModule.getInstance().getImplementation(CategoriaRepo.class));
    }

}
