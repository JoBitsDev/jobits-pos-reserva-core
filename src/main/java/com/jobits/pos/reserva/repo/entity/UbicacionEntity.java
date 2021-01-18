/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jobits.pos.reserva.repo.entity;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * JoBits
 * @author Jorge
 * 
 */
@Entity
@Table(name = "ubicacion", schema = "reserva")
@NamedQueries({
    @NamedQuery(name = "UbicacionEntity.findAll", query = "SELECT u FROM UbicacionEntity u"),
    @NamedQuery(name = "UbicacionEntity.findByIdubicacion", query = "SELECT u FROM UbicacionEntity u WHERE u.idubicacion = :idubicacion"),
    @NamedQuery(name = "UbicacionEntity.findByNombreubicacion", query = "SELECT u FROM UbicacionEntity u WHERE u.nombreubicacion = :nombreubicacion"),
    @NamedQuery(name = "UbicacionEntity.findByColorubicacion", query = "SELECT u FROM UbicacionEntity u WHERE u.colorubicacion = :colorubicacion"),
    @NamedQuery(name = "UbicacionEntity.findByEstadoubicacion", query = "SELECT u FROM UbicacionEntity u WHERE u.estadoubicacion = :estadoubicacion"),
    @NamedQuery(name = "UbicacionEntity.findByDisponibledesde", query = "SELECT u FROM UbicacionEntity u WHERE u.disponibledesde = :disponibledesde"),
    @NamedQuery(name = "UbicacionEntity.findByDisponiblehasta", query = "SELECT u FROM UbicacionEntity u WHERE u.disponiblehasta = :disponiblehasta")})
public class UbicacionEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreubicacion")
    private String nombreubicacion;
    @Size(max = 255)
    @Column(name = "colorubicacion")
    private String colorubicacion;
    @Size(max = 255)
    @Column(name = "estadoubicacion")
    private String estadoubicacion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idubicacion")
    private Long idubicacion;
    @Column(name = "disponibledesde")
    private LocalTime disponibledesde;
    @Column(name = "disponiblehasta")
    private LocalTime disponiblehasta;

    public UbicacionEntity() {
    }

    public UbicacionEntity(Long idubicacion) {
        this.idubicacion = idubicacion;
    }

    public UbicacionEntity(Long idubicacion, String nombreubicacion) {
        this.idubicacion = idubicacion;
        this.nombreubicacion = nombreubicacion;
    }

    public Long getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Long idubicacion) {
        this.idubicacion = idubicacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idubicacion != null ? idubicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionEntity)) {
            return false;
        }
        UbicacionEntity other = (UbicacionEntity) object;
        if ((this.idubicacion == null && other.idubicacion != null) || (this.idubicacion != null && !this.idubicacion.equals(other.idubicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.reserva.core.domain.Ubicacion[ idubicacion=" + idubicacion + " ]";
    }

    public String getNombreubicacion() {
        return nombreubicacion;
    }

    public void setNombreubicacion(String nombreubicacion) {
        this.nombreubicacion = nombreubicacion;
    }

    public String getColorubicacion() {
        return colorubicacion;
    }

    public void setColorubicacion(String colorubicacion) {
        this.colorubicacion = colorubicacion;
    }

    public String getEstadoubicacion() {
        return estadoubicacion;
    }

    public void setEstadoubicacion(String estadoubicacion) {
        this.estadoubicacion = estadoubicacion;
    }

}
