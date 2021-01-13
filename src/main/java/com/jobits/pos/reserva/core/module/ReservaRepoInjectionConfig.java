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
        bind(ReservaUseCase.class).to(ReservaUseCaseImpl.class).in(Singleton.class);
    }

}
