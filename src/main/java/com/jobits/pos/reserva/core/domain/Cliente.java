/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.domain;

import java.util.Collection;
import javax.validation.constraints.*;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class Cliente {

    private Integer idcliente;
    @NotNull(message = "#msg.com.jobits.pos.nombre_nulo#")
    private String nombrecliente;
    @NotNull(message = "#msg.com.jobits.pos.apellido_nulo#")
    private String apellidocliente;
    @NotBlank(message = "#msg.com.jobits.pos.campo_nulo#")
    @Size(max = 10, message = "#msg.com.jobits.pos.telefono_size_validation#")
    private String telefonocliente;
    private String direccioncliente;
    private String municipiocliente;
    private String provinciacliente;
    private Collection<Reserva> reservaCollection;

    public Cliente() {
    }

    public Cliente(String nombrecliente, String telefonocliente) {
        this.nombrecliente = nombrecliente;
        this.telefonocliente = telefonocliente;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    public String getApellidocliente() {
        return apellidocliente;
    }

    public void setApellidocliente(String apellidocliente) {
        this.apellidocliente = apellidocliente;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getMunicipiocliente() {
        return municipiocliente;
    }

    public void setMunicipiocliente(String municipiocliente) {
        this.municipiocliente = municipiocliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getProvinciacliente() {
        return provinciacliente;
    }

    public void setProvinciacliente(String provinciacliente) {
        this.provinciacliente = provinciacliente;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public String getTelefonocliente() {
        return telefonocliente;
    }

    public void setTelefonocliente(String telefonocliente) {
        this.telefonocliente = telefonocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.reserva.core.domain.Cliente[ idcliente=" + idcliente + " ]";
    }

}
