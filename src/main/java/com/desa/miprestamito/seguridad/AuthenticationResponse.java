package com.desa.miprestamito.seguridad;

public class AuthenticationResponse {
    private String jwt;

    private String nombre;

    private String Rol;

    private String puntoAtencion;

    public AuthenticationResponse(String jwt, String nombre, String rol, String puntoAtencion) {
        this.jwt = jwt;
        this.nombre = nombre;
        Rol = rol;
        this.puntoAtencion = puntoAtencion;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public String getPuntoAtencion() {
        return puntoAtencion;
    }

    public void setPuntoAtencion(String puntoAtencion) {
        this.puntoAtencion = puntoAtencion;
    }
}
