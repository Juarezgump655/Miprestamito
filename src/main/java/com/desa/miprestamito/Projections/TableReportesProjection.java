package com.desa.miprestamito.Projections;

import java.util.Date;

public interface TableReportesProjection {

    String getcorrelativo();

    String getPuntoAtencion();
    String getRegion();
    String getEstado();

    String getMedioIngreso();

    Date getFechaCreacion();
    String getDetalle();

    String getTiempoOperacion();
}
