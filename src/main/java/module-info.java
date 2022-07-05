module com.example.store {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires log4j;
    requires com.zaxxer.hikari;

    exports com.example.store.service;
    exports com.example.store.model;
    exports com.example.store.entity;
    exports com.example.store.dao;


    exports com.example.store.controller;
    opens com.example.store.controller to javafx.fxml;
}