package com.monodev.authentication.models.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicios")
public class Servicio {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
    @Column(length = 100)
    private String nombreServicio;

    @Column(length = 100)
    private String claveAPI;
    
    @ManyToOne
    private Tenant tenant;
}
