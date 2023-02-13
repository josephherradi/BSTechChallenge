package com.backend.bt.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component

public class EmailService {
    private final static String EMAIL_CONFIRMATION_SUBJECT = "Welcome";

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendConfirmationEmail(String email) {
        // build email
        // send message
        String message = "Dear user welcome to recipe web app" ;
        String from = "jee.server.spring@gmail.com";

        send(email, from, message);
    }
    @Async
    private void send(String to, String from, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(EMAIL_CONFIRMATION_SUBJECT);
            helper.setText(email);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("failed to send email");
            throw new IllegalStateException("failed to send email");
        }
    }
}