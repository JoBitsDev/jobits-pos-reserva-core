/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.domain;

import com.root101.clean.core.domain.services.ResourceHandler;
import java.time.LocalTime;
import java.util.Collection;
import javax.validation.constraints.NotBlank;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class Ubicacion {

    private Long idubicacion;

    @NotBlank(message = "#msg.com.jobits.pos.campo_nulo#")
    private String nombreubicacion;

    private boolean disponible = true;
    private LocalTime disponibledesde = LocalTime.MIDNIGHT;
    private LocalTime disponiblehasta = LocalTime.MAX;

    private String estadoubicacion;
    private String colorubicacion = ResourceHandler.getString("com.jobits.pos.reserva.default_color");
    private Collection<Reserva> reservaCollection;

    public Ubicacion() {
    }

    public Ubicacion(Long idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Ubicacion(Long idubicacion, String nombreubicacion) {
        this.idubicacion = idubicacion;
        this.nombreubicacion = nombreubicacion;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.idubicacion == null && other.idubicacion != null) || (this.idubicacion != null && !this.idubicacion.equals(other.idubicacion))) {
            return false;
        }
        return true;
    }

    public String getColorubicacion() {
        return colorubicacion;
    }

    public void setColorubicacion(String colorubicacion) {
        this.colorubicacion = colorubicacion;
    }

    public LocalTime getDisponibledesde() {
        return disponibledesde;
    }

    public void setDisponibledesde(LocalTime disponibledesde) {
        this.disponibledesde = disponibledesde;
    }

    public LocalTime getDisponiblehasta() {
        return disponiblehasta;
    }

    public void setDisponiblehasta(LocalTime disponiblehasta) {
        this.disponiblehasta = disponiblehasta;
    }

    public String getEstadoubicacion() {
        return estadoubicacion;
    }

    public void setEstadoubicacion(String estadoubicacion) {
        this.estadoubicacion = estadoubicacion;
    }

    public Long getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Long idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getNombreubicacion() {
        return nombreubicacion;
    }

    public void setNombreubicacion(String nombreubicacion) {
        this.nombreubicacion = nombreubicacion;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idubicacion != null ? idubicacion.hashCode() : 0);
        return hash;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.reserva.core.domain.Ubicacion[ idubicacion=" + idubicacion + " ]";
    }

}
