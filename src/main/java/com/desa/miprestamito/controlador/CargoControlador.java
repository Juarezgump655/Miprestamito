package com.desa.miprestamito.controlador;

import com.desa.miprestamito.modelo.Cargo;
import com.desa.miprestamito.servicio.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Cargo")
@CrossOrigin(origins = "http://localhost:4200/")
public class CargoControlador {

    @Autowired
    private CargoService cargoService;

    private static Logger logger
            = Logger.getLogger(
            CargoControlador.class.getName());

    @PostMapping("/guardar")
    public Cargo guardarCargo(@RequestBody Cargo cargo){
        logger.log(Level.INFO, "Se ejecuta el metodo guardarCargo");
        return cargoService.save(cargo);
    }

    @GetMapping("/all")
    public Iterable<Cargo> listarCargos(){
        logger.log(Level.INFO, "Se ejecuta el metodo listarCargos");
        return cargoService.listarCargos();
    }

}
