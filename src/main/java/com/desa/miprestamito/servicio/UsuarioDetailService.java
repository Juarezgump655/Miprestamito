package com.desa.miprestamito.servicio;


import com.desa.miprestamito.modelo.Usuario;
import com.desa.miprestamito.repositorio.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UsuarioDetailService implements UserDetailsService {
    @Autowired
    private UsuarioRepo repositorio;
    private static List<User> users = new ArrayList();

    private static Logger logger
            = Logger.getLogger(
            UsuarioDetailService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.log(Level.INFO, "se ejecuta el metodo loadUserByUsername");
        findbyUsuario(username).ifPresent(u -> users.add(new User(u.getCorreo(), "{noop}" + u.getPassword(), new ArrayList<>())));
        Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findAny();
        if (!user.isPresent()) {
            logger.log(Level.WARNING, "User not found by name: " + username);
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        return new User(user.get().getUsername(), user.get().getPassword(), user.get().getAuthorities());
    }

    public Optional<Usuario> findbyUsuario(String correo) {
        logger.log(Level.INFO, "se ejecuta el metodo findbyUsuario");
        return repositorio.findByCorreo(correo);
    }

}
   /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */