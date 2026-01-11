package com.example.emaildemo;

public record EmailDTO (
    String to,
    String subject,
    String body
)
{}
