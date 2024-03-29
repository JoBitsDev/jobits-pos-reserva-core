/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.domain;

import com.root101.clean.core.domain.services.ResourceHandler;
import javax.validation.constraints.NotBlank;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class Categoria implements Comparable<Categoria> {

    private Integer idcategoria;
    @NotBlank(message = "#msg.com.jobits.pos.campo_nulo#")
    private String nombre;
    private Integer color = Integer.parseInt(ResourceHandler.getString("com.jobits.pos.reserva.default_color"));

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(String nombre, Integer color) {
        this.nombre = nombre;
        this.color = color;
    }

    @Override
    public int compareTo(Categoria o) {
        return getIdcategoria().compareTo(o.getIdcategoria());
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "(" + idcategoria + ") " + nombre;
    }

}
