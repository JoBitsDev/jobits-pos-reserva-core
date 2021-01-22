/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.jobits.pos.reserva.core.usecase.CategoriaUseCase;
import com.jobits.pos.reserva.core.usecase.ClienteUseCase;
import com.jobits.pos.reserva.core.usecase.ReservaUseCase;
import com.jobits.pos.reserva.core.usecase.UbicacionUseCase;
import com.jobits.pos.reserva.core.usecase.impl.CategoriaUseCaseImpl;
import com.jobits.pos.reserva.core.usecase.impl.ClienteUseCaseImpl;
import com.jobits.pos.reserva.core.usecase.impl.ReservaUseCaseImpl;
import com.jobits.pos.reserva.core.usecase.impl.UbicacionUseCaseImpl;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
class ReservaInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ReservaUseCase.class).to(ReservaUseCaseImpl.class).in(Scopes.SINGLETON);
        bind(ClienteUseCase.class).to(ClienteUseCaseImpl.class).in(Scopes.SINGLETON);
        bind(CategoriaUseCase.class).to(CategoriaUseCaseImpl.class).in(Scopes.SINGLETON);
        bind(UbicacionUseCase.class).to(UbicacionUseCaseImpl.class).in(Scopes.SINGLETON);

    }

}
