package com.desa.miprestamito.controlador;

import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.servicio.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Queja")
@CrossOrigin(origins = "http://localhost:4200/")
public class QuejaControlador {

    @Autowired
    private QuejaService QuejaService;

    private static Logger logger
            = Logger.getLogger(
            QuejaControlador.class.getName());


    @PostMapping("/guardar")
    public Queja guardarQueja(@RequestBody Queja queja){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo guardarQueja");
        System.out.print("guardarQueja");
        return QuejaService.save(queja);
    }

    @GetMapping("/all")
    public List<Queja> listarQueja(){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQueja");
        return(List<Queja>) QuejaService.listarQuejas();
    }

    @GetMapping("/QuejaId/{id}")
    public Queja listarQuejaId(@PathVariable(value = "id") Long id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaId");
        return QuejaService.listarId(id);
    }

    @GetMapping("/Quejas-por-Usuarios/{id}")
    public List<Queja> listarQuejaPorUsuario(@PathVariable(value = "id") Long id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorUsuario");
        return(List<Queja>)  QuejaService.listarQuejasPorUsuario(id);
    }

    @GetMapping("/Quejas-por-PuntosAtencion/{id}")
    public List<Queja> listarQuejaPorPuntoAtencion(@PathVariable(value = "id") Long id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorPuntoAtencion");
        return(List<Queja>)  QuejaService.listarQuejasPorPuntoAtencion(id);
    }

    @GetMapping("/Quejas-por-Estado/{estado}")
    public List<Queja> listarQuejaPorEstado(@PathVariable(value = "estado") Long estado){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorEstado");
        return(List<Queja>) QuejaService.listarQuejasPorEstado(estado);
    }



}
