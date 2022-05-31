package com.ziletech.ecommerce.service.impl;

import com.ziletech.ecommerce.service.EmailService;
import dto.EmailTemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendTextEmail(EmailTemplateDTO emailTemplate) {
        SimpleMailMessage message = new SimpleMailMessage();
        String address = emailTemplate.getSendTo();
        send(emailTemplate, message, address);
    }

    private void send(EmailTemplateDTO emailTemplate, SimpleMailMessage msg, String address) {
        msg.setTo(address);
        msg.setSubject(emailTemplate.getSubject());
        msg.setText(emailTemplate.getBody());
        javaMailSender.send(msg);
    }

}
