package com.desa.miprestamito.servicio;
import com.desa.miprestamito.modelo.Region;

import java.util.List;

public interface RegionService {

    public Region save(Region region);

    public List<Region> listarRegiones();

    public Region listarId(Long id);


}
