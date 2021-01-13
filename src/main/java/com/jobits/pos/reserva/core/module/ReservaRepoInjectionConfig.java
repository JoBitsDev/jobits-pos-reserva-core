/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jobits.pos.reserva.core.repo.CategoriaRepo;
import com.jobits.pos.reserva.core.repo.ClienteRepo;
import com.jobits.pos.reserva.core.repo.ReservaRepo;
import com.jobits.pos.reserva.core.repo.UbicacionRepo;
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
