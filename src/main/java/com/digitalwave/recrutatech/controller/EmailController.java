package com.digitalwave.recrutatech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.service.EmailService;

@RestController
public class EmailController {
    
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/enviar-email")
    public String enviarEmail() {
        String destinatario = "destinatario@email.com";
        String assunto = "Assunto do E-mail";
        String corpo = "Conteúdo do E-mail";

        emailService.enviarEmailSimples(destinatario, assunto, corpo);

        return "E-mail enviado com sucesso!";
    }
}
