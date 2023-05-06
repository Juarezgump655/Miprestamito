package com.desa.miprestamito.Projections;

import java.util.Calendar;
import java.util.Date;

public interface tablaAsignacionQuejaProjection {
    Long getIdQueja();
    String getCorrelativo();
    Date getFechaCreacion();

}
