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
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 150)
    private String correoElectronico;

    @Column(length = 50)
    private String contrasena;

    @ManyToOne
    private Tenant tenant;
    
    public Usuario() {
    }

    public Usuario(UUID id, String nombre, String correoElectronico, String contrasena, Tenant tenant) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.tenant = tenant;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    
}
