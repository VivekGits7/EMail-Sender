package com.email.system.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class Health_Check {
    @GetMapping
    public String healthCheck() {
        return "Email System is up and running!";
    }
}
