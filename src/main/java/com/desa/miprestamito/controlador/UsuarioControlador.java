package com.desa.miprestamito.controlador;

import com.desa.miprestamito.modelo.Usuario;
import com.desa.miprestamito.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Usuarios")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServices;

    private static Logger logger
            = Logger.getLogger(
            UsuarioControlador.class.getName());
    @PostMapping("/guardarUsuario")
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        logger.log(Level.INFO, "Se ejecuta el metodo guardarUsuario");
        System.out.print(usuario);
        return usuarioServices.save(usuario);
    }

    @GetMapping("/all")
    public Iterable<Usuario> listarUsuarios(){
        logger.log(Level.INFO, "Se ejecuta el metodo listarUsuarios");
        return usuarioServices.listarUsuarios();
    }

    @GetMapping("/UsuariosId/{id}")
    public Usuario listarUsuarioId(@PathVariable(value = "id") Long id){
        logger.log(Level.INFO, "Se ejecuta el metodo listarUsuarioId");
        return usuarioServices.listarId(id);
    }

   //http://localhost:8081/muestras-medicas/api/Usuarios/Juarezgump655
    @GetMapping("/{usuario}")
    public Optional<Usuario> buscarPorUsername(@PathVariable(value = "usuario") String correo){
        logger.log(Level.INFO, "Se ejecuta el metodo buscarPorUsername");
        return usuarioServices.findbyCorreo(correo);
    }

}
