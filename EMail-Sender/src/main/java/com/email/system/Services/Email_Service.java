package com.email.system.Services;

import com.email.system.Models.Email_Model;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;

@Slf4j
@Service
public class Email_Service {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(
            Email_Model emailModel
    ) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailModel.getFrom());
            helper.setTo(emailModel.getTo());
            helper.setSubject(emailModel.getSubject());
            helper.setText(emailModel.getMessage());

            if (emailModel.getFilePath() != null && !emailModel.getFilePath().isEmpty()) {
                File file = new File(emailModel.getFilePath());
                if (file.exists()) {
                    FileSystemResource resource = new FileSystemResource(file);
                    helper.addAttachment(resource.getFilename(), resource);
                } else {
                    log.info("⚠️ File not found at path: " + emailModel.getFilePath());
                    System.out.println("⚠️ File not found at path: " + emailModel.getFilePath());
                }
            }

            mailSender.send(message);
            log.info("✅ Email sent successfully with attachment!");
            System.out.println("✅ Email sent successfully with attachment!");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("❌ Failed to send email: " + e.getMessage());
            throw new RuntimeException("❌ Failed to send email: " + e.getMessage());
        }
    }
    }

