package com.gihtub.onechesz.gpt_therapy.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
System.out.println("!!!! EmailService !");
        this.javaMailSender = javaMailSender;
    }

    public void sendMailTo(String email, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("GPT Therapy Instruction");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
