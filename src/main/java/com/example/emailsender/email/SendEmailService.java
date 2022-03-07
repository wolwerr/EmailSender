package com.example.emailsender.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailService {

    @Autowired
    private final JavaMailSender envioEmailDoJava;

    public SendEmailService(final JavaMailSender javaMailSender){
        this.envioEmailDoJava = javaMailSender;
    }

    public void enviar(String para, String titulo, String conteudo){
        log.info("Sendind email to confirm the data..");

        var mensagem = new SimpleMailMessage();

        mensagem.setTo(para);
        mensagem.setSubject(titulo);
        mensagem.setText(conteudo);
        envioEmailDoJava.send(mensagem);
        log.info("Email sented");
    }
}
