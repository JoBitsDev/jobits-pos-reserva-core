/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@Entity
@Table(name = "reserva", schema = "reserva")
@NamedQueries({
    @NamedQuery(name = "ReservaEntity.findAll", query = "SELECT r FROM ReservaEntity r"),
    @NamedQuery(name = "ReservaEntity.findByIdreserva", query = "SELECT r FROM ReservaEntity r WHERE r.idreserva = :idreserva"),
    @NamedQuery(name = "ReservaEntity.findByFechareserva", query = "SELECT r FROM ReservaEntity r WHERE r.fechareserva = :fechareserva"),
    @NamedQuery(name = "ReservaEntity.findByHorareserva", query = "SELECT r FROM ReservaEntity r WHERE r.horareserva = :horareserva"),
    @NamedQuery(name = "ReservaEntity.findByEstado", query = "SELECT r FROM ReservaEntity r WHERE r.estado = :estado"),
    @NamedQuery(name = "ReservaEntity.findByNotasreserva", query = "SELECT r FROM ReservaEntity r WHERE r.notasreserva = :notasreserva"),
    @NamedQuery(name = "ReservaEntity.findByCheckin", query = "SELECT r FROM ReservaEntity r WHERE r.checkin = :checkin"),
    @NamedQuery(name = "ReservaEntity.findByCheckout", query = "SELECT r FROM ReservaEntity r WHERE r.checkout = :checkout")})
public class ReservaEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fechareserva")
    private LocalDate fechareserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horareserva")
    private LocalTime horareserva;
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
    private Integer idreserva;
    @Column(name = "duracionreservaminutos")
    private Integer duracionMinutos;
    @Column(name = "checkin")
    private LocalDateTime checkin;
    @Column(name = "checkout")
    private LocalDateTime checkout;
    @JoinColumn(name = "categoriaidcategoria", referencedColumnName = "idcategoria")
    @ManyToOne
    private CategoriaEntity categoriaidcategoria;
    @JoinColumn(name = "clienteidcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private ClienteEntity clienteidcliente;
    @JoinColumn(name = "ubicacionidubicacion", referencedColumnName = "idubicacion")
    @ManyToOne
    private UbicacionEntity ubicacionidubicacion;

    @Column(name = "nopedidoasociado")
    private String numeroPedidoAsociado;

    public ReservaEntity() {
    }

    public ReservaEntity(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public ReservaEntity(Integer idreserva, LocalDate fechareserva, LocalTime horareserva) {
        this.idreserva = idreserva;
        this.fechareserva = fechareserva;
        this.horareserva = horareserva;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
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

    public String getNumeroPedidoAsociado() {
        return numeroPedidoAsociado;
    }

    public void setNumeroPedidoAsociado(String numeroPedidoAsociado) {
        this.numeroPedidoAsociado = numeroPedidoAsociado;
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

    public LocalDate getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(LocalDate fechareserva) {
        this.fechareserva = fechareserva;
    }

    public LocalTime getHorareserva() {
        return horareserva;
    }

    public void setHorareserva(LocalTime horareserva) {
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
