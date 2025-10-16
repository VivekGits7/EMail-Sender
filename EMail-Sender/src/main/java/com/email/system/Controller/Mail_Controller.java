package com.email.system.Controller;

import com.email.system.Models.Email_Model;
import com.email.system.Services.Email_Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/email")
public class Mail_Controller {

    @Autowired
    private Email_Service emailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody Email_Model emailModel) {
        try {
            log.info("[ Controller ]");
            emailService.sendEmailWithAttachment(emailModel);
            return "✅ Email sent successfully!";
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}
