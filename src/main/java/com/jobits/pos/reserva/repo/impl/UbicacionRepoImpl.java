/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.repo.util.JpaCRUDRepository;
import com.jobits.pos.reserva.core.domain.Ubicacion;
import com.jobits.pos.reserva.core.domain.UbicacionEstado;
import com.jobits.pos.reserva.core.repo.UbicacionRepo;
import com.jobits.pos.reserva.repo.entity.UbicacionEntity;
import com.jobits.pos.reserva.repo.util.ConnectionPool;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

public class UbicacionRepoImpl extends JpaCRUDRepository<Ubicacion, UbicacionEntity>
        implements UbicacionRepo {

    public UbicacionRepoImpl() {
        super(ConnectionPool.getInstance(), Ubicacion.class, UbicacionEntity.class);
    }

    @Override
    public List<Ubicacion> findAllActivas() {
        Query query = getEntityManager().createNamedQuery("UbicacionEntity.findByEstadoubicacion");
        query.setParameter("estadoubicacion", UbicacionEstado.HABILITADA.getEstado());
        try {
            return converter.from(query.getResultList());
        } catch (Exception ex) {
            Logger.getLogger(UbicacionRepoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    @Override
    public List<Ubicacion> findRange(int cantidad, int pagina) {
        int[] range = {cantidad * pagina, (cantidad * pagina) + cantidad};
        return findRange(range);
    }

}
