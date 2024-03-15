package com.monodev.authentication.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServicioRoles")
public class ServicioRol {
    @Id
    @ManyToOne
    private Servicio servicio;
    
    @Id
    @ManyToOne
    private Rol rol;
    
    @Column(length = 50)
    private String columna1;
    
    @Column(length = 100)
    private String columna2;
}
