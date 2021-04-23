/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.core.domain.Categoria;
import com.jobits.pos.reserva.core.repo.CategoriaRepo;
import com.jobits.pos.reserva.repo.entity.CategoriaEntity;

public class CategoriaRepoImpl extends AbstractRepo<Categoria, CategoriaEntity>
        implements CategoriaRepo {

    public CategoriaRepoImpl() {
        super(Categoria.class, CategoriaEntity.class);
    }

}
