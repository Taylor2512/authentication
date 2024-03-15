package com.monodev.authentication.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UsertRequest {

    @NotBlank(message = "El nombre es requerido")
    @NotNull(message = "El nombre no puede ser nulo")
    private @NotNull String nombre;

    @NotBlank(message = "El correo electrónico es requerido")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico no es válido")
    private String correoElectronico;

    @NotBlank(message = "La contraseña es requerida")
    private String contrasena;

    public UsertRequest() {
    }

    public UsertRequest(String nombre, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
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
}
