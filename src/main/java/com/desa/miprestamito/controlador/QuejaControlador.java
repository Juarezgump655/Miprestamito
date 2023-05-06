package com.desa.miprestamito.controlador;

import com.desa.miprestamito.Projections.*;
import com.desa.miprestamito.modelo.MedioIngeresoQueja;
import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.repositorio.TipoQuejaRepo;
import com.desa.miprestamito.servicio.MedioIngresoQuejaService;
import com.desa.miprestamito.servicio.PuntoAtencionService;
import com.desa.miprestamito.servicio.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Queja")
@CrossOrigin(origins = "*")
public class QuejaControlador {

    @Autowired
    private QuejaService QuejaService;

    @Autowired
    private MedioIngresoQuejaService medioIngresoQuejaService;

    @Autowired
    private PuntoAtencionService puntoAtencionService;

    @Autowired
    private TipoQuejaRepo tipoQuejaRepo;

    private static Logger logger
            = Logger.getLogger(
            QuejaControlador.class.getName());


    @PostMapping("/guardar")
    public Queja guardarQueja(@RequestBody Queja queja){
        Calendar fechaActual = Calendar.getInstance(); // Obtener la fecha y hora actual
        queja.setFechacreacion(fechaActual);
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

    @GetMapping("/correlativo/{id}")
    public CorrelativoProjection getCorrelativo(@PathVariable(value = "id") Long id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo getCorrelativo");
        return QuejaService.getCorrelativo(id);
    }

    @GetMapping("/Quejas-por-Usuarios/{id}")
    public List<Queja> listarQuejaPorUsuario(@PathVariable(value = "id") String id){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorUsuario");
        return(List<Queja>)  QuejaService.listarQuejasPorUsuario(id);
    }

    @GetMapping("/QuejaporPuntosAtencion/{idPuntosAtencion}")
    public List <TableReportesProjection>listarQuejaPorPuntoAtencion(@PathVariable(value = "idPuntosAtencion") Long idPuntosAtencion){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarQuejaPorPuntoAtencion");
        return(List<TableReportesProjection>) QuejaService.listarQuejasPorPuntoAtencion(idPuntosAtencion);
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


    @GetMapping("/medio-ingreso")
    public List<MedioIngeresoQueja> listarCatalogoMedioIngreso(){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarCatalogoMedioIngreso ");
        return(List<MedioIngeresoQueja>) medioIngresoQuejaService.listarMedioIngresoQueja();
    }

    @GetMapping("/puntos-atencion")
    public List<PuntoAtencionProjection> listarPuntosAtencion(){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarPuntosAtencion ");
        return(List<PuntoAtencionProjection>) puntoAtencionService.traerPuntosDeAencion();
    }

    @GetMapping("/tipo-queja")
    public List<TipoQuejaProjection> listarTipoQueja(){
        logger.log(java.util.logging.Level.INFO, "Se ejecuta el metodo listarTipoQueja ");
        return(List<TipoQuejaProjection>) tipoQuejaRepo.listarTipoQueja();
    }

    @GetMapping("/tablaAsignacionQueja")
    public List<tablaAsignacionQuejaProjection> tablaAsignacionQueja(){
        return(List<tablaAsignacionQuejaProjection>) QuejaService.tablaAsignacionQueja();
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
