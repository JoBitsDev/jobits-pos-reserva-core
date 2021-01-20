/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.usecase;

import com.jobits.pos.reserva.core.domain.Ubicacion;
import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface UbicacionUseCase extends CRUDUseCase<Ubicacion> {

    public Ubicacion activarUbicacion(int idUbicacion);
    
    public Ubicacion desactivarUbicacion(int idUbicacion);
    
    public List<Ubicacion> getUbicacaionesActivas(int cantidad,int pagina);
    
    public int getCantidadUbicacionesActivas();
    
}
