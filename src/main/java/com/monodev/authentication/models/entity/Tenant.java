package com.monodev.authentication.models.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tenants")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(length = 100)
    private String nombre;
    
    @Column(length = 200)
    private String informacionContacto;
    
    @Column(length = 500)
    private String configuracionEspecifica;
    
    // Getters y setters
}