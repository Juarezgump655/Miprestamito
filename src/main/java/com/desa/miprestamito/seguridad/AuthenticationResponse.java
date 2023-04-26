package com.desa.miprestamito.seguridad;

public class AuthenticationResponse {
    private String jwt;

    private String nombre;

    private String Rol;

    public AuthenticationResponse(String jwt, String nombre, String Rol) {
        this.nombre = nombre;
        this.jwt = jwt;
        this.Rol = Rol;
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

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
}
