package com.desa.miprestamito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorreoController {

    @Autowired
    private JavaMailSender javaMailSender;


    public ResponseEntity<?> enviarCorreo(String destinatario, String asunto, String cuerpo) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(destinatario);
        email.setSubject(asunto);
        email.setText(cuerpo);
        email.setFrom("miprestamito35@outlook.com");
       javaMailSender.send(email);

        return ResponseEntity.ok("Correo enviado");
    }

}
