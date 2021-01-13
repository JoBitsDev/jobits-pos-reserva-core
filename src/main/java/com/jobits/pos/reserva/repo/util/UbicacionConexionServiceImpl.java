/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
public class UbicacionConexionServiceImpl implements UbicacionConexionService {

    private UbicacionWrapper ubicaciones;
    private ObjectMapper om = new ObjectMapper();
    private String FILE_NAME = "ubicaciones.json";

    public UbicacionConexionServiceImpl() {
        try {
            ubicaciones = getUbicacionesAlmacenadas();
        } catch (IOException ex) {
            try {
                File f = new File(FILE_NAME);
                f.createNewFile();
                ubicaciones = new UbicacionWrapper(UbicacionConexionModel.getDefaultUbicaciones(), 0);
                guardarUbicacionesAlmacenadas();
            } catch (IOException ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error de IO. {0}", ex1.getMessage());
            }
        }
    }

    private UbicacionWrapper getUbicacionesAlmacenadas() throws IOException {
        return om.readValue(new File(FILE_NAME), UbicacionWrapper.class);
    }

    private void guardarUbicacionesAlmacenadas() throws IOException {
        om.writeValue(new File(FILE_NAME), ubicaciones);
    }

    public UbicacionWrapper getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(UbicacionWrapper ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public void setSelectedUbicacion(int pos) throws IOException {
        ubicaciones.setSelectedUbicacion(pos);
        guardarUbicacionesAlmacenadas();
    }

    public void setSelectedUbicacion(UbicacionConexionModel ubicacionSeleccionada)
            throws IOException {
        ubicaciones.setUbicacionSeleccionada(ubicacionSeleccionada);
        guardarUbicacionesAlmacenadas();
    }

    public void editUbicacion(UbicacionConexionModel ubicacionEditada, int pos)
            throws IOException, IllegalArgumentException {
        ubicaciones.getUbicaciones()[pos] = ubicacionEditada;
        guardarUbicacionesAlmacenadas();

    }

}
