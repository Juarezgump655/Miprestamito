package com.desa.miprestamito.seguridad;

public class AuthenticationResponse {
    private String jwt;

    private String nombre;

    public AuthenticationResponse(String jwt, String nombre) {
        this.nombre = nombre;
        this.jwt = jwt;
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
}
