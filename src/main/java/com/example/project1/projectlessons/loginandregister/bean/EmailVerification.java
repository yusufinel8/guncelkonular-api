package com.example.project1.projectlessons.loginandregister.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Setter
@Getter
public class EmailVerification {

    private final JavaMailSender mailSender;

    public int kod;

    @Autowired
    public EmailVerification(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public int sendSimpleEmail(String mail) {
        SimpleMailMessage message = new SimpleMailMessage();

        String subject="Bu kod ile sisteme giriş yapabilirsiniz";

        int min = 100000;
        int max = 999999;
        kod = ThreadLocalRandom.current().nextInt(min, max + 1);

        String body=String.valueOf(kod);

        message.setFrom("springemail1@gmail.com");
        message.setTo(mail);
        message.setText(body);
        message.setSubject(subject);
        //mailSender.send(message);
        System.out.println("Mail sender");
        return kod;
    }
}
