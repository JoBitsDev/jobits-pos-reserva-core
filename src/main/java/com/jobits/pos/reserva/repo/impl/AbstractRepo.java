/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.repo.module.ReservaRepoModule;
import com.root101.clean.core.domain.services.ResourceHandler;
import org.jobits.app.repo.*;

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
