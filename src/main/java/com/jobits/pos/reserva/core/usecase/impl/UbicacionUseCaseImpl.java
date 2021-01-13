/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase.impl;

import com.jobits.pos.reserva.core.domain.Ubicacion;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.repo.UbicacionRepo;
import com.jobits.pos.reserva.core.usecase.UbicacionUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;

public class UbicacionUseCaseImpl extends DefaultCRUDUseCase<Ubicacion>
        implements UbicacionUseCase {

    public UbicacionUseCaseImpl() {
        setRepo(ReservaCoreModule.getInstance().getImplementation(UbicacionRepo.class));
    }

}
