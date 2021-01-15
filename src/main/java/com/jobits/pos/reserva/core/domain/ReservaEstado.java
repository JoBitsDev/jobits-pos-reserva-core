/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.domain;

import com.root101.clean.core.domain.services.ResourceHandler;
import java.util.logging.Logger;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public enum ReservaEstado {

    AGENDADA("com.jobits.pos.reserva.domain.reserva_estado_agendada"),
    CHEQUEADA("com.jobits.pos.reserva.domain.reserva_estado_chequeada"),
    COMPLETADA("com.jobits.pos.reserva.domain.reserva_estado_completada"),
    CONCELADA("com.jobits.pos.reserva.domain.reserva_estado_cancelada"),
    RECHAZADA("com.jobits.pos.reserva.domain.reserva_estado_rechazada");

    /**
     * El recurso a buscar en los .properties
     */
    private final String recursoEstado;

    private ReservaEstado(String recursoEstado) {
        this.recursoEstado = recursoEstado;
    }

    public String getRecursoEstado() {
        return ResourceHandler.getString(recursoEstado);
    }
    
    

}
