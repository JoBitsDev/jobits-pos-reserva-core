/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.root101.clean.core.domain.services.ResourceHandler;
import javax.persistence.EntityManager;
import org.jboss.logging.Logger;

/**
 *
 * @author Jorge
 */
public class ConnectionPool {

    private static ConnectionPool INSTANCE;

    public static ConnectionPool getInstance() {
        String nombreUbicacion = ResourceHandler.getString("com.jobits.pos.db.current_conn_name");
        String url = ResourceHandler.getString("com.jobits.pos.db.current_conn_url");
        String user = ResourceHandler.getString("com.jobits.pos.db.current_conn_user");
        String pass = ResourceHandler.getString("com.jobits.pos.db.current_conn_pass");
        String driver = ResourceHandler.getString("com.jobits.pos.db.current_conn_driver");
        String tipoUbicacion = ResourceHandler.getString("com.jobits.pos.db.current_conn_tipo");
        UbicacionConexionModel model = UbicacionConexionModel.from(nombreUbicacion, url,
                user, pass, driver,
                UbicacionConexionModel.TipoUbicacion.valueOf(tipoUbicacion));
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool(model);
        } else {
            INSTANCE.init(model);
        }
        return INSTANCE;
    }

    private final String URL = "javax.persistence.jdbc.url";
    private final String USER = "javax.persistence.jdbc.user";
    private final String PASSWORD = "javax.persistence.jdbc.password";
    private final String DRIVER = "javax.persistence.jdbc.driver";

    private EntityManagerFactory EMF;
    private List<EntityManagerFactoryCache> cachedEmf = new ArrayList<>();
    private EntityManager currentConnection;

    private UbicacionConexionModel currentUbicacion;
    private final String persistenceUnitName
            = ResourceHandler.getString("com.jobits.pos.reserva.repol.util.persistence_unit_name");

    private ConnectionPool(UbicacionConexionModel connectionProperties) {
        init(connectionProperties);
    }

    public EntityManagerFactory getEMF() {
        return EMF;
    }

    public EntityManager getCurrentConnection() {
        return currentConnection;
    }

    public UbicacionConexionModel getCurrentUbicacion() {
        return currentUbicacion;
    }

    public void resetConnection() {
        init(currentUbicacion);
    }

    private HashMap<String, String> getConnectionsPropeties(UbicacionConexionModel connectionProperties) {
        HashMap<String, String> prop = new HashMap<>();
        prop.put(URL, connectionProperties.getUrl());
        prop.put(USER, connectionProperties.getUsuario());
        prop.put(PASSWORD, connectionProperties.getContrasena());
        prop.put(DRIVER, connectionProperties.getDriver());
        return prop;
    }

    private EntityManagerFactory getEmfFrom(UbicacionConexionModel connectionsProperties) {
        for (EntityManagerFactoryCache cache : cachedEmf) {
            if (cache.getUbicaicon().equals(connectionsProperties)) {
                return cache.getFactory();
            }
        }
        EntityManagerFactory newFactory = Persistence.createEntityManagerFactory(persistenceUnitName, getConnectionsPropeties(connectionsProperties));
        EntityManagerFactoryCache cacheItem = new EntityManagerFactoryCache(newFactory, connectionsProperties);
        cachedEmf.add(cacheItem);
        return newFactory;

    }

    private void init(UbicacionConexionModel connectionProperties) {
        if (connectionProperties.equals(currentUbicacion)) {
            return;
        }
        EMF = getEmfFrom(connectionProperties);
        currentUbicacion = connectionProperties;
        if (EMF != null) {
            initConnections();

        } else {
            throw new NullPointerException(
                    ResourceHandler.getString("msg.com.jobits.pos.null_pointer_EMF_not_Found"));
        }
    }

    private boolean initConnections() {
        try {
            EMF.getCache().evictAll();
            currentConnection = EMF.createEntityManager();
            return true;
        } catch (Exception e) {
            Logger.getLogger(ConnectionPool.class).log(Logger.Level.ERROR, e.getMessage());
            return false;
        }
    }

    private class EntityManagerFactoryCache {

        private final EntityManagerFactory factory;
        private final UbicacionConexionModel ubicaicon;

        public EntityManagerFactoryCache(EntityManagerFactory factory, UbicacionConexionModel ubicaicon) {
            this.factory = factory;
            this.ubicaicon = ubicaicon;
        }

        public EntityManagerFactory getFactory() {
            return factory;
        }

        public UbicacionConexionModel getUbicaicon() {
            return ubicaicon;
        }

    }

}
