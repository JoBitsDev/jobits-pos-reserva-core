/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase.impl;

import com.jobits.pos.reserva.core.domain.Ubicacion;
import com.jobits.pos.reserva.core.domain.UbicacionEstado;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.repo.UbicacionRepo;
import com.jobits.pos.reserva.core.usecase.UbicacionUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import java.util.Optional;

public class UbicacionUseCaseImpl extends DefaultCRUDUseCase<Ubicacion>
        implements UbicacionUseCase {

    UbicacionRepo repo = ReservaCoreModule.getInstance().getImplementation(UbicacionRepo.class);
    
    public UbicacionUseCaseImpl() {
        setRepo(repo);
    }

    @Override
    public Ubicacion activarUbicacion(int idUbicacion) {
        Ubicacion u = Optional.ofNullable(findBy(idUbicacion)).orElseThrow();
        u.setEstadoubicacion(UbicacionEstado.HABILITADA.getEstado());
        return u;
    }

    @Override
    public Ubicacion desactivarUbicacion(int idUbicacion) {
        Ubicacion u = Optional.ofNullable(findBy(idUbicacion)).orElseThrow();
        u.setEstadoubicacion(UbicacionEstado.INABILITADA.getEstado());
        return u;
    }

}
