package com.ziletech.ecommerce.controller;

import com.ziletech.ecommerce.service.EmailService;
import dto.EmailTemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notifications/api/email")
@Slf4j
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailTemplateDTO emailTemplate) {
        try {
            log.info("Sending Simple Text Email....");
            emailService.sendTextEmail(emailTemplate);
            return new ResponseEntity<>("Email sent", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error in sending email" + ex, HttpStatus.BAD_REQUEST);
        }
    }


}
