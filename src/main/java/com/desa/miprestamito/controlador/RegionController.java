package com.desa.miprestamito.controlador;

import com.desa.miprestamito.modelo.Region;
import com.desa.miprestamito.servicio.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Region")
@CrossOrigin(origins = "http://localhost:4200/")
public class RegionController {

    @Autowired
    private RegionService regionService;

    public static Logger logger
            = Logger.getLogger(
            RegionController.class.getName());

    @PostMapping("/guardar")
    public Region guardarRegion(@RequestBody Region region){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo guardarRegion");
        return regionService.save(region);
    }

    @GetMapping("/all")
    public List<Region> listarRegiones(){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarRegiones");
        return(List<Region>) regionService.listarRegiones();
    }

    @GetMapping("/RegionId/{id}")
    public Region listarRegionId(@PathVariable(value = "id") Long id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarRegionId");
        return regionService.listarId(id);
    }

}
