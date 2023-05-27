package com.desa.miprestamito.controlador;


import com.desa.miprestamito.Projections.TipoQuejaProjection;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.modelo.TipoQueja;
import com.desa.miprestamito.servicio.impl.TIpoQuejaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/tipoQueja")
@CrossOrigin(origins = "*")
public class tipoQuejaControlador {

    @Autowired
    private TIpoQuejaServiceImpl service;

    private static Logger logger
            = Logger.getLogger(
            QuejaControlador.class.getName());

    @PostMapping("/guardar")
    public TipoQueja guardarTipoQueja(@RequestBody TipoQueja tipoQueja){
        logger.log(Level.INFO, "Se ejecuta el metodo guardarTipoQueja");
        return service.save(tipoQueja);
    }

    @GetMapping("/obtenerTipos")
    public List<TipoQuejaProjection> traerTipos(){
        logger.log(Level.INFO, "Se ejecuta el metodo traerTipos");
        return (List<TipoQuejaProjection>) service.listarTipoQueja();
    }

    @PutMapping("/modificarTipoQueja/{idTipoQueja}")
    public ResponseEntity<TipoQueja> modificarTipoQueja(@PathVariable Long idTipoQueja , @RequestBody TipoQueja nuevoTipoqueja) {
        //PuntosAtencion puntoModificado =  puntosAtencionService.modificarPuntos(idPuntoAtencion,nuevoPunto);
        TipoQueja newTipoqueja = service.modificarTipo(idTipoQueja, nuevoTipoqueja);
        return ResponseEntity.ok(newTipoqueja);
    }

    @GetMapping("/contSiglas/{siglasQueja}")
    public ResponseEntity<?>contSiglas(@PathVariable String siglasQueja){
        return ResponseEntity.ok(service.contSiglasQueja(siglasQueja));
    }



}
