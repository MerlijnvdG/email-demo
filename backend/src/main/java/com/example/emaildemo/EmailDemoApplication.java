package com.example.emaildemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailDemoApplication {

    private final MailSenderService mailService;

    public EmailDemoApplication(MailSenderService mailService) {
        this.mailService = mailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmailDemoApplication.class, args);
    }
}
