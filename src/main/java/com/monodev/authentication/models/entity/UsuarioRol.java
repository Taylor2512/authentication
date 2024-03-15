package com.monodev.authentication.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "UsuarioRoles")
public class UsuarioRol {
    @Id
    @ManyToOne
    private Usuario usuario;
    
    @Id
    @ManyToOne
    private Rol rol;
}
