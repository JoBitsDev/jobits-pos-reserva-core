/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jobits.pos.reserva.repo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "cliente", schema = "reserva")
@NamedQueries({
    @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT c FROM ClienteEntity c"),
    @NamedQuery(name = "ClienteEntity.findByIdcliente", query = "SELECT c FROM ClienteEntity c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "ClienteEntity.findByNombrecliente", query = "SELECT c FROM ClienteEntity c WHERE c.nombrecliente = :nombrecliente"),
    @NamedQuery(name = "ClienteEntity.findByTelefonocliente", query = "SELECT c FROM ClienteEntity c WHERE c.telefonocliente = :telefonocliente"),
    @NamedQuery(name = "ClienteEntity.findByApellidocliente", query = "SELECT c FROM ClienteEntity c WHERE c.apellidocliente = :apellidocliente"),
    @NamedQuery(name = "ClienteEntity.findByDireccioncliente", query = "SELECT c FROM ClienteEntity c WHERE c.direccioncliente = :direccioncliente"),
    @NamedQuery(name = "ClienteEntity.findByMunicipiocliente", query = "SELECT c FROM ClienteEntity c WHERE c.municipiocliente = :municipiocliente"),
    @NamedQuery(name = "ClienteEntity.findByProvinciacliente", query = "SELECT c FROM ClienteEntity c WHERE c.provinciacliente = :provinciacliente")})
public class ClienteEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefonocliente")
    private String telefonocliente;
    @Size(max = 255)
    @Column(name = "apellidocliente")
    private String apellidocliente;
    @Size(max = 255)
    @Column(name = "direccioncliente")
    private String direccioncliente;
    @Size(max = 255)
    @Column(name = "municipiocliente")
    private String municipiocliente;
    @Size(max = 255)
    @Column(name = "provinciacliente")
    private String provinciacliente;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Long idcliente;
    @OneToMany(mappedBy = "clienteidcliente")
    private Collection<ReservaEntity> reservaCollection;

    public ClienteEntity() {
    }

    public ClienteEntity(Long idcliente) {
        this.idcliente = idcliente;
    }

    public ClienteEntity(Long idcliente, String nombrecliente, String telefonocliente) {
        this.idcliente = idcliente;
        this.nombrecliente = nombrecliente;
        this.telefonocliente = telefonocliente;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }


    public Collection<ReservaEntity> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<ReservaEntity> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.reserva.core.domain.Cliente[ idcliente=" + idcliente + " ]";
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getTelefonocliente() {
        return telefonocliente;
    }

    public void setTelefonocliente(String telefonocliente) {
        this.telefonocliente = telefonocliente;
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

    public String getMunicipiocliente() {
        return municipiocliente;
    }

    public void setMunicipiocliente(String municipiocliente) {
        this.municipiocliente = municipiocliente;
    }

    public String getProvinciacliente() {
        return provinciacliente;
    }

    public void setProvinciacliente(String provinciacliente) {
        this.provinciacliente = provinciacliente;
    }

}
