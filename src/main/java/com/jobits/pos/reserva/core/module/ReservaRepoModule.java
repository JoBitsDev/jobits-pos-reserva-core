/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jobits.pos.reserva.repo.util.ResourceServiceImpl;
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

    private ReservaRepoModule() {
        updateDB();
        registerResources();

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

    private void registerResources() {
        ResourceHandler.registerResourceService(new ResourceServiceImpl());
    }

    private void updateDB() {
        String url = ResourceHandler.getString("com.jobits.pos.db.current_conn_url");
        String user = ResourceHandler.getString("com.jobits.pos.db.current_conn_user");
        String pass = ResourceHandler.getString("com.jobits.pos.db.current_conn_pass");
        String schema = ResourceHandler.getString("com.jobits.pos.reserva.repo.db.shema");

        Flyway flyWay = Flyway.configure()
                .dataSource(url, user, pass)
                .createSchemas(true)
                .schemas(schema)
                .load();
        flyWay.migrate();
    }

}
