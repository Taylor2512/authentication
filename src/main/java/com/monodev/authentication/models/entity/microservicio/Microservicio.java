package com.monodev.authentication.models.entity.microservicio;
 import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "microservicios")
public class Microservicio {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String endpoint;

    @Column(nullable = false)
    private boolean estado = true;

    public UUID getId() {
        return id;
    }
    

    public Microservicio(UUID id, String nombre, String descripcion, String endpoint, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.endpoint = endpoint;
        this.estado = estado;
    }


    public Microservicio() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((endpoint == null) ? 0 : endpoint.hashCode());
        result = prime * result + (estado ? 1231 : 1237);
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Microservicio other = (Microservicio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (endpoint == null) {
            if (other.endpoint != null)
                return false;
        } else if (!endpoint.equals(other.endpoint))
            return false;
        if (estado != other.estado)
            return false;
        return true;
    }
    
 
}
