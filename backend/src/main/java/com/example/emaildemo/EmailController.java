package com.example.emaildemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {
    private final MailSenderService mailService;

    public EmailController(MailSenderService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) {
        mailService.sendNewMail(
                emailDTO.to(),
                emailDTO.subject(),
                emailDTO.body()
        );
        return ResponseEntity.ok("Email sent successfully");
    }

    @PostMapping("/welcome")
    public ResponseEntity<String> sendWelkomEmail(@RequestBody WelcomeEmailDTO welcomeEmailDTO) {
        System.out.println("=== DEBUG INFO ===");
        System.out.println("Received DTO: " + welcomeEmailDTO);
        System.out.println("To: " + welcomeEmailDTO. to());
        System.out. println("Name: " + welcomeEmailDTO.name());
        System.out.println("==================");
        mailService.sendWelcomeMail(
                welcomeEmailDTO.to(),
                welcomeEmailDTO.name()
        );
        return ResponseEntity.ok("Welkom email succesvol verzonden!");
    }
}
