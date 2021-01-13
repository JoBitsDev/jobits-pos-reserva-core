/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jorge
 * Created: 13 ene. 2021
 */

CREATE TABLE reserva.Categoria (
  idCategoria SERIAL NOT NULL, 
  nombre      varchar(255) NOT NULL, 
  color       int4, 
  PRIMARY KEY (idCategoria));
CREATE TABLE Reserva.Cliente (
  idCliente        SERIAL NOT NULL, 
  nombreCliente    varchar(255) NOT NULL, 
  telefonoCliente  varchar(255) NOT NULL, 
  apellidoCliente  varchar(255), 
  direccionCliente varchar(255), 
  municipioCliente varchar(255), 
  provinciaCliente varchar(255), 
  PRIMARY KEY (idCliente));
CREATE TABLE Reserva.Reserva (
  idReserva               BIGSERIAL NOT NULL, 
  fechaReserva            date NOT NULL, 
  horaReserva             time NOT NULL, 
  duracionReservaSegundos int4, 
  estado                  varchar(255), 
  notasReserva            varchar(255), 
  checkIn                 time, 
  checkOut                time, 
  ClienteidCliente        int8, 
  UbicacionidUbicacion    int8, 
  CategoriaidCategoria    int4, 
  PRIMARY KEY (idReserva));
CREATE TABLE Reserva.Ubicacion (
  idUbicacion     SERIAL NOT NULL, 
  nombreUbicacion varchar(255) NOT NULL, 
  colorUbicacion  varchar(255), 
  estadoUbicacion varchar(255), 
  disponibleDesde time, 
  disponibleHasta time, 
  PRIMARY KEY (idUbicacion));
CREATE INDEX Reserva_fechaReserva 
  ON Reserva.Reserva (fechaReserva);
ALTER TABLE Reserva.Reserva ADD CONSTRAINT FKReserva610395 FOREIGN KEY (CategoriaidCategoria) REFERENCES reserva.Categoria (idCategoria);
ALTER TABLE Reserva.Reserva ADD CONSTRAINT FKReserva714156 FOREIGN KEY (UbicacionidUbicacion) REFERENCES Reserva.Ubicacion (idUbicacion) ON DELETE Set null;
ALTER TABLE Reserva.Reserva ADD CONSTRAINT FKReserva966083 FOREIGN KEY (ClienteidCliente) REFERENCES Reserva.Cliente (idCliente) ON DELETE Set null;

