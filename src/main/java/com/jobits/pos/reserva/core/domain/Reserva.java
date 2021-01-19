/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.domain;

import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.ValidationException;
import com.root101.clean.core.utils.validation.Validable;
import com.root101.clean.core.utils.validation.ValidationResult;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotNull;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class Reserva implements Validable{

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd'/'MM'/'yy");

    private Integer idreserva;
    @NotNull(message = "#msg.com.jobits.pos.campo_nulo#")
    private LocalDate fechareserva;
    @NotNull(message = "#msg.com.jobits.pos.campo_nulo#")
    private LocalTime horareserva;
    @NotNull(message = "#msg.com.jobits.pos.campo_nulo#")
    private Integer duracionreservasegundos;
    private String estado;
    private String notasreserva;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private Cliente clienteidcliente;
    @NotNull(message = "#msg.com.jobits.pos.campo_nulo#")
    private Categoria categoriaidcategoria;
    @NotNull(message = "#msg.com.jobits.pos.campo_nulo#")
    private Ubicacion ubicacionidubicacion;

    public Reserva() {
    }

    public Reserva(LocalDate fechareserva, LocalTime horareserva,
            Integer duracionreservasegundos, Ubicacion ubicacion) {
        this.fechareserva = fechareserva;
        this.horareserva = horareserva;
        this.duracionreservasegundos = duracionreservasegundos;
        this.ubicacionidubicacion = ubicacion;
        setEstado(ReservaEstado.AGENDADA.getRecursoEstado());
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    public Categoria getCategoriaidcategoria() {
        return categoriaidcategoria;
    }

    public void setCategoriaidcategoria(Categoria categoriaidcategoria) {
        this.categoriaidcategoria = categoriaidcategoria;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        if (checkin != null) {
            setEstado(ReservaEstado.CHEQUEADA.getRecursoEstado());
        }
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        if (checkout != null) {
            setEstado(ReservaEstado.COMPLETADA.getRecursoEstado());
        }
        this.checkout = checkout;
    }

    public Cliente getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(Cliente clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    public Integer getDuracionreservasegundos() {
        return duracionreservasegundos;
    }

    public void setDuracionreservasegundos(Integer duracionreservasegundos) {
        this.duracionreservasegundos = duracionreservasegundos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = validateEstado(estado);
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

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public String getNotasreserva() {
        return notasreserva;
    }

    public void setNotasreserva(String notasreserva) {
        this.notasreserva = notasreserva;
    }

    public Ubicacion getUbicacionidubicacion() {
        return ubicacionidubicacion;
    }

    public void setUbicacionidubicacion(Ubicacion ubicacionidubicacion) {
        this.ubicacionidubicacion = ubicacionidubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return fechareserva.format(formatter) + idreserva;
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        v.throwException();
        return v;
    }

    private String validateEstado(String estado) {
        for (ReservaEstado v : ReservaEstado.values()) {
            if (estado.equals(v.getRecursoEstado())) {
                return estado;
            }
        }
        throw new IllegalArgumentException(ResourceHandler.getString("msg.com.jobits.pos.reserva.core.domain.estado_no_valido"));
    }
    
}
