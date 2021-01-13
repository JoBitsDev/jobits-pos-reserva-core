/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jobits.pos.reserva.repo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * JoBits
 * @author Jorge
 * 
 */
@Entity
@Table(name = "reserva")
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva"),
    @NamedQuery(name = "Reserva.findByFechareserva", query = "SELECT r FROM Reserva r WHERE r.fechareserva = :fechareserva"),
    @NamedQuery(name = "Reserva.findByHorareserva", query = "SELECT r FROM Reserva r WHERE r.horareserva = :horareserva"),
    @NamedQuery(name = "Reserva.findByDuracionreservasegundos", query = "SELECT r FROM Reserva r WHERE r.duracionreservasegundos = :duracionreservasegundos"),
    @NamedQuery(name = "Reserva.findByEstado", query = "SELECT r FROM Reserva r WHERE r.estado = :estado"),
    @NamedQuery(name = "Reserva.findByNotasreserva", query = "SELECT r FROM Reserva r WHERE r.notasreserva = :notasreserva"),
    @NamedQuery(name = "Reserva.findByCheckin", query = "SELECT r FROM Reserva r WHERE r.checkin = :checkin"),
    @NamedQuery(name = "Reserva.findByCheckout", query = "SELECT r FROM Reserva r WHERE r.checkout = :checkout")})
public class ReservaEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fechareserva")
    @Temporal(TemporalType.DATE)
    private Date fechareserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horareserva")
    @Temporal(TemporalType.TIME)
    private Date horareserva;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "notasreserva")
    private String notasreserva;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreserva")
    private Long idreserva;
    @Column(name = "duracionreservasegundos")
    private Integer duracionreservasegundos;
    @Column(name = "checkin")
    @Temporal(TemporalType.TIME)
    private Date checkin;
    @Column(name = "checkout")
    @Temporal(TemporalType.TIME)
    private Date checkout;
    @JoinColumn(name = "categoriaidcategoria", referencedColumnName = "idcategoria")
    @ManyToOne
    private CategoriaEntity categoriaidcategoria;
    @JoinColumn(name = "clienteidcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private ClienteEntity clienteidcliente;
    @JoinColumn(name = "ubicacionidubicacion", referencedColumnName = "idubicacion")
    @ManyToOne
    private UbicacionEntity ubicacionidubicacion;

    public ReservaEntity() {
    }

    public ReservaEntity(Long idreserva) {
        this.idreserva = idreserva;
    }

    public ReservaEntity(Long idreserva, Date fechareserva, Date horareserva) {
        this.idreserva = idreserva;
        this.fechareserva = fechareserva;
        this.horareserva = horareserva;
    }

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }


    public Integer getDuracionreservasegundos() {
        return duracionreservasegundos;
    }

    public void setDuracionreservasegundos(Integer duracionreservasegundos) {
        this.duracionreservasegundos = duracionreservasegundos;
    }


    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public CategoriaEntity getCategoriaidcategoria() {
        return categoriaidcategoria;
    }

    public void setCategoriaidcategoria(CategoriaEntity categoriaidcategoria) {
        this.categoriaidcategoria = categoriaidcategoria;
    }

    public ClienteEntity getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(ClienteEntity clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    public UbicacionEntity getUbicacionidubicacion() {
        return ubicacionidubicacion;
    }

    public void setUbicacionidubicacion(UbicacionEntity ubicacionidubicacion) {
        this.ubicacionidubicacion = ubicacionidubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaEntity)) {
            return false;
        }
        ReservaEntity other = (ReservaEntity) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.reserva.core.domain.Reserva[ idreserva=" + idreserva + " ]";
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Date getHorareserva() {
        return horareserva;
    }

    public void setHorareserva(Date horareserva) {
        this.horareserva = horareserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotasreserva() {
        return notasreserva;
    }

    public void setNotasreserva(String notasreserva) {
        this.notasreserva = notasreserva;
    }

}
