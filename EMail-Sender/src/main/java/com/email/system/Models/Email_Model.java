package com.email.system.Models;

import lombok.Data;

@Data

public class Email_Model {
        private String from;
        private String to;
        private String subject;
        private String message;
        private String filePath;
    }
