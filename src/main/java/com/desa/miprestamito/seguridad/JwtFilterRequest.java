package com.desa.miprestamito.seguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;
    private static Logger logger
            = Logger.getLogger(
            JwtFilterRequest.class.getName());
    @Autowired
    private UsuarioDetailService usuarioDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.log(Level.INFO, "Se ejecuta el metodo doFilterInternal");
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            String token = authorizationHeader.substring(7);
            String username = jwtUtil.extractUsername(token);
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = usuarioDetailService.loadUserByUsername(username);
                if(jwtUtil.validateToken(token, userDetails)){
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
