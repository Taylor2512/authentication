package com.monodev.authentication.models.entity.microservicio;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "versiones_microservicios")
public class VersionMicroservicio {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "microservicio_id", nullable = false)
    private Microservicio microservicio;

    @Column(nullable = false, length = 20)
    private String version;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private boolean estado = true;

    public VersionMicroservicio() {
    }

    public VersionMicroservicio(UUID id, Microservicio microservicio, String version, String descripcion,
            boolean estado) {
        this.id = id;
        this.microservicio = microservicio;
        this.version = version;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Microservicio getMicroservicio() {
        return microservicio;
    }

    public void setMicroservicio(Microservicio microservicio) {
        this.microservicio = microservicio;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        result = prime * result + ((microservicio == null) ? 0 : microservicio.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
        VersionMicroservicio other = (VersionMicroservicio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (microservicio == null) {
            if (other.microservicio != null)
                return false;
        } else if (!microservicio.equals(other.microservicio))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (estado != other.estado)
            return false;
        return true;
    }
    

   
}