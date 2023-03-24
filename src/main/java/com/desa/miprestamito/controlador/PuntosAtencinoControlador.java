package com.desa.miprestamito.controlador;

import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.servicio.PuntoAtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/PuntosAtencion")
@CrossOrigin(origins = "http://localhost:4200/")
public class PuntosAtencinoControlador {


    @Autowired
    private PuntoAtencionService puntosAtencionService;


    private static Logger logger
            = Logger.getLogger(
            PuntosAtencinoControlador.class.getName());

    @PostMapping("/guardar")
    public PuntosAtencion guardarPuntosAtencion(@RequestBody PuntosAtencion puntosAtencion){
        logger.log(Level.INFO, "Se ejecuta el metodo guardarPuntosAtencion");
        System.out.print(puntosAtencion);
          return puntosAtencionService.save(puntosAtencion);
    }

    @GetMapping("/all")
    public Iterable<PuntosAtencion> listarPuntosAtencion(){
        logger.log(Level.INFO, "Se ejecuta el metodo listarPuntosAtencion");
        return puntosAtencionService.listarPuntosAtencion();
    }


    @GetMapping("/PuntosAtencionId/{id}")
    public PuntosAtencion listarPuntosAtencionId(@PathVariable(value = "id") Long id){
        logger.log(Level.INFO, "Se ejecuta el metodo listarPuntosAtencionId");
        return puntosAtencionService.listarId(id);
    }

    List<regionesParaPuntosProjection>catalogoRegiones;
    @GetMapping("/traerRegiones")
    public List<regionesParaPuntosProjection>traerRegiones(){
        logger.log(Level.INFO, "Se ejecuta el metodo traerRegiones");
    if (this.catalogoRegiones==null){
        this.catalogoRegiones= puntosAtencionService.traerRegiones();
        return this.catalogoRegiones;
    }else{
        return this.catalogoRegiones;
    }
    }



}
