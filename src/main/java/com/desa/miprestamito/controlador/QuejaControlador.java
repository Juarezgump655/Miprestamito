package com.desa.miprestamito.controlador;

import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.servicio.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Queja")
@CrossOrigin(origins = "*")
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
    public List<Queja> listarQuejaPorUsuario(@PathVariable(value = "id") String id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorUsuario");
        return(List<Queja>)  QuejaService.listarQuejasPorUsuario(id);
    }

    @GetMapping("/Quejas-por-PuntosAtencion/{idPuntosAtencion}")
    public ResponseEntity<Iterable<Queja>> listarQuejaPorPuntoAtencion(@PathVariable(value = "idPuntosAtencion") Long idPuntosAtencion){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorPuntoAtencion");
        return ResponseEntity.ok(QuejaService.listarQuejasPorPuntoAtencion(idPuntosAtencion));
    }

    @GetMapping("/{estado}")
    public List<Queja> listarQuejaPorEstado(@PathVariable(value = "estado") Long estado){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorEstado");
        return(List<Queja>) QuejaService.listarQuejasPorEstado(estado);
    }

    @GetMapping("/Quejas-por-tipo-quejas/{id}")
    public List<Queja> listarQuejaPorTipoQueja(@PathVariable(value = "id") Long id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorTipoQueja");
        return(List<Queja>) QuejaService.listarQuejasIdTipoQueja(id);
    }
/*
    @PutMapping("/actualizar/{id}")
    public Queja actualizarQueja(@PathVariable(value = "id") Long id, @RequestBody Queja queja){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo actualizarQueja");
        Queja quejaActual = QuejaService.listarId(id);
        quejaActual.setEstado(queja.getEstado());
        quejaActual.setFecha(queja.getFecha());
        quejaActual.setPuntosAtencion(queja.getPuntosAtencion());
        quejaActual.setTipoQueja(queja.getTipoQueja());
        quejaActual.setUsuario(queja.getUsuario());
        quejaActual.setDescripcion(queja.getDescripcion());
        return QuejaService.save(quejaActual);
    }
*/

}
