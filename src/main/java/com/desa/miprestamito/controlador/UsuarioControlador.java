package com.desa.miprestamito.controlador;

import com.desa.miprestamito.Projections.contUsuariosProjection;
import com.desa.miprestamito.Projections.tablaUsersProjection;
import com.desa.miprestamito.Projections.traerCargoProjection;
import com.desa.miprestamito.Projections.traerPaProjection;
import com.desa.miprestamito.modelo.Usuario;
import com.desa.miprestamito.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptada);
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

    @GetMapping("/tablaUsuarios")
    public List<tablaUsersProjection> traerTabla(){
        return (List<tablaUsersProjection>) usuarioServices.tablaUsuarios();
    }

    @GetMapping("/traerPuntos")
    public List<traerPaProjection> traerPuntos(){

        return(List<traerPaProjection>) usuarioServices.traerPuntos();

    }

    @GetMapping("/traerCargo")
    public List<traerCargoProjection> traerCargo(){
        return (List<traerCargoProjection>) usuarioServices.traerCargo();
    }

    @PutMapping("/modificarUsuario/{idUsuario}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Long idUsuario, @RequestBody Usuario nuevoUsuario){
        Usuario Usuario1= usuarioServices.modificarUsuario(idUsuario, nuevoUsuario);
        return  ResponseEntity.ok(Usuario1);
    }

@GetMapping("/contUsuario/{dpi}")
    public contUsuariosProjection contUsuarios(@PathVariable String dpi){
        return usuarioServices.contUsuarios(dpi);
}






}
