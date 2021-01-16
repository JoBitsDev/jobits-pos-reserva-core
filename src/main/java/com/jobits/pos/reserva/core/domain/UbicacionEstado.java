/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.domain;

import com.root101.clean.core.domain.services.ResourceHandler;

/**
 *
 * @author Jorge
 */
public enum UbicacionEstado {

    HABILITADA("com.jobits.pos.reserva.domain.ubicacion_estado_habilitada"),
    INABILITADA("com.jobits.pos.reserva.domain.ubicacion_estado_inhabilitada");

    private final String estado;

    private UbicacionEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return ResourceHandler.getString(estado);
    }

}
