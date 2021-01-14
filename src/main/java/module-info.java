/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module com.jobits.pos.reserva {
    requires com.google.guice;
    requires com.fasterxml.jackson.databind;
    requires java.logging;
    requires java.desktop;
    requires com.root101clean.core;

    exports com.jobits.pos.reserva.core.domain;
    exports com.jobits.pos.reserva.core.usecase;
    exports com.jobits.pos.reserva.core.repo;
    exports com.jobits.pos.reserva.core.module;
    exports com.jobits.pos.reserva.repo.module;
}
