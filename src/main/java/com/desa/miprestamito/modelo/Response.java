package com.desa.miprestamito.modelo;

public class Response {

    private String message;

    public String getMessage() {
        return message;
    }

    public Response(String message) {
        super();
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
