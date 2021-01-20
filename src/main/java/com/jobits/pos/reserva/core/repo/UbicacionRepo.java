/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.repo;

import com.jobits.pos.reserva.core.domain.Ubicacion;
import java.util.List;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public interface UbicacionRepo extends com.root101.clean.core.app.repo.CRUDRepository<Ubicacion> {

    public List<Ubicacion> findRange(int cantidad, int pagina);

    public List<Ubicacion> findAllActivas();

}
