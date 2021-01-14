/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.repo.util.JpaCRUDRepository;
import com.jobits.pos.reserva.core.domain.Categoria;
import com.jobits.pos.reserva.repo.module.ReservaRepoModule;
import com.jobits.pos.reserva.core.repo.CategoriaRepo;
import com.jobits.pos.reserva.repo.entity.CategoriaEntity;
import com.jobits.pos.reserva.repo.util.ConnectionPool;

public class CategoriaRepoImpl extends JpaCRUDRepository<Categoria, CategoriaEntity>
        implements CategoriaRepo {

    public CategoriaRepoImpl() {
        super(ReservaRepoModule.getInstance()
                .getImplementation(ConnectionPool.class), Categoria.class, CategoriaEntity.class);
    }

}
