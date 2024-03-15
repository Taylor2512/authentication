package com.monodev.authentication.models.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RolPermisos")
public class RolPermiso {
    @Id
    @ManyToOne
    private Rol rol;
    
    @Id
    @ManyToOne
    private Permiso permiso;
 
}
