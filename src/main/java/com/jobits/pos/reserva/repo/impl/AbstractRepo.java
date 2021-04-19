/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.repo.module.ReservaRepoModule;
import org.jobits.db.pool.ConnectionPoolHandler;
import org.jobits.db.pool.JpaCRUDRepository;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public abstract class AbstractRepo<Domain, Entity> extends JpaCRUDRepository<Domain, Entity> {

    public AbstractRepo(Class<Domain> domainClass, Class<Entity> entityClass) {
        super(ConnectionPoolHandler.getConnectionPoolService(ReservaRepoModule.getInstance().getModuleName()), domainClass, entityClass);
    }

}
