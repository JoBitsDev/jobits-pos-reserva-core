/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.module;

import com.google.inject.AbstractModule;
import com.jobits.pos.reserva.core.usecase.ReservaUseCase;
import com.jobits.pos.reserva.core.usecase.impl.ReservaUseCaseImpl;
import com.google.inject.Singleton;
import com.jobits.pos.reserva.core.repo.CategoriaRepo;
import com.jobits.pos.reserva.core.repo.ClienteRepo;
import com.jobits.pos.reserva.core.repo.ReservaRepo;
import com.jobits.pos.reserva.core.repo.UbicacionRepo;
import com.jobits.pos.reserva.core.usecase.CategoriaUseCase;
import com.jobits.pos.reserva.core.usecase.ClienteUseCase;
import com.jobits.pos.reserva.core.usecase.UbicacionUseCase;
import com.jobits.pos.reserva.core.usecase.impl.CategoriaUseCaseImpl;
import com.jobits.pos.reserva.core.usecase.impl.ClienteUseCaseImpl;
import com.jobits.pos.reserva.core.usecase.impl.UbicacionUseCaseImpl;
import com.jobits.pos.reserva.repo.impl.CategoriaRepoImpl;
import com.jobits.pos.reserva.repo.impl.ClienteRepoImpl;
import com.jobits.pos.reserva.repo.impl.ReservaRepoImpl;
import com.jobits.pos.reserva.repo.impl.UbicacionRepoImpl;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
class ReservaRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ReservaRepo.class).to(ReservaRepoImpl.class).in(Singleton.class);
        bind(ClienteRepo.class).to(ClienteRepoImpl.class).in(Singleton.class);
        bind(CategoriaRepo.class).to(CategoriaRepoImpl.class).in(Singleton.class);
        bind(UbicacionRepo.class).to(UbicacionRepoImpl.class).in(Singleton.class);
    }

}
