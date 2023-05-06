package com.desa.miprestamito.Projections;

public interface tablaUsersProjection {
    Long getIdUsuario();
    String getNombreUsuario();

    String getApellidosUsuario();
    String getRegion();
    String getPuntoAtencion();
    String getCargo();
    String getCorreo();
    String getEstado();

    Long getIdCargo();

    Long getIdPuntoAtencion();

}
