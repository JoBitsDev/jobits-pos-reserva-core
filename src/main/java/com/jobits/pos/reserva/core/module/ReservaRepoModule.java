/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.AlreadyInitModule;
import com.root101.clean.core.exceptions.NotInitModule;
import org.flywaydb.core.Flyway;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class ReservaRepoModule extends DefaultAbstractModule {

    public static final String MODULE_NAME = "Reserva Repo Module";

    private final Injector inj = Guice.createInjector();

    private static ReservaRepoModule INSTANCE;

    public ReservaRepoModule() {

        Flyway flyWay = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/Venavento", "postgres", "7965801")
                .createSchemas(true)
                .schemas("reserva")
                .load();
        flyWay.migrate();

    }

    public static ReservaRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NotInitModule(ResourceHandler.getString("com.jobits.pos.reservarepo.name"));
        }
        return INSTANCE;
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @param repoModule
     * @return
     * @Deprecated
     */
    public static ReservaRepoModule init() {
        if (INSTANCE != null) {
            throw new AlreadyInitModule(ResourceHandler.getString("com.jobits.pos.reservarepo.name"));
        }
        INSTANCE = new ReservaRepoModule();
        return getInstance();
    }

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

}
