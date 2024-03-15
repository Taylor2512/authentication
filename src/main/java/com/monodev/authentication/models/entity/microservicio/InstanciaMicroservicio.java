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
@Table(name = "instancias_microservicios")
public class InstanciaMicroservicio {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "version_microservicio_id", nullable = false)
    private VersionMicroservicio versionMicroservicio;

    @Column(nullable = false, length = 255)
    private String hostname;

    @Column(nullable = false)
    private int puerto;

    @Column(nullable = false)
    private boolean estado = true;

    public InstanciaMicroservicio() {
    }

    public InstanciaMicroservicio(UUID id, VersionMicroservicio versionMicroservicio, String hostname, int puerto,
            boolean estado) {
        this.id = id;
        this.versionMicroservicio = versionMicroservicio;
        this.hostname = hostname;
        this.puerto = puerto;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public VersionMicroservicio getVersionMicroservicio() {
        return versionMicroservicio;
    }

    public void setVersionMicroservicio(VersionMicroservicio versionMicroservicio) {
        this.versionMicroservicio = versionMicroservicio;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
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
        result = prime * result + ((versionMicroservicio == null) ? 0 : versionMicroservicio.hashCode());
        result = prime * result + ((hostname == null) ? 0 : hostname.hashCode());
        result = prime * result + puerto;
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
        InstanciaMicroservicio other = (InstanciaMicroservicio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (versionMicroservicio == null) {
            if (other.versionMicroservicio != null)
                return false;
        } else if (!versionMicroservicio.equals(other.versionMicroservicio))
            return false;
        if (hostname == null) {
            if (other.hostname != null)
                return false;
        } else if (!hostname.equals(other.hostname))
            return false;
        if (puerto != other.puerto)
            return false;
        if (estado != other.estado)
            return false;
        return true;
    }

    
}