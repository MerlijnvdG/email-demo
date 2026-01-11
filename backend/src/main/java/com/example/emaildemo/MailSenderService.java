package com.example.emaildemo;

import jakarta.mail.internet. MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org. springframework.mail.javamail.MimeMessageHelper;

import org.springframework. stereotype.Service;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendNewMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void sendHtmlMail(String to, String subject, String htmlContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendWelcomeMail(String to, String userName) {
        String subject = "Welkom bij onze applicatie!";
        String htmlContent = createWelkomEmailTemplate(userName);
        sendHtmlMail(to, subject, htmlContent);
    }

    private String createWelkomEmailTemplate(String naam) {
        return """
            <!DOCTYPE html>
            <html lang="nl">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Welkom</title>
            </head>
            <body style="margin: 0; padding: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f4f4;">
                <table role="presentation" style="width: 100%%; border-collapse: collapse;">
                    <tr>
                        <td style="padding: 40px 0; text-align: center;">
                            <table role="presentation" style="width:  600px; margin: 0 auto; background-color: #ffffff; border-radius: 16px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); overflow: hidden;">
                                <!-- Header met gradient -->
                                <tr>
                                    <td style="background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); padding: 50px 40px; text-align: center;">
                                        <h1 style="margin: 0; color: #ffffff; font-size: 32px; font-weight: 700;">
                                            🎉 Welkom! 
                                        </h1>
                                    </td>
                                </tr>
                                
                                <!-- Content -->
                                <tr>
                                    <td style="padding: 40px;">
                                        <h2 style="color: #333333; font-size: 24px; margin:  0 0 20px 0;">
                                            Hallo %s!  👋
                                        </h2>
                                        
                                        <p style="color: #666666; font-size: 16px; line-height: 1.6; margin: 0 0 20px 0;">
                                            Wat fijn dat je je hebt aangemeld!  We zijn blij je te verwelkomen in onze community.
                                        </p>
                                        
                                        <p style="color: #666666; font-size: 16px; line-height: 1.6; margin: 0 0 30px 0;">
                                            Je account is succesvol aangemaakt en je kunt nu aan de slag.  Hier zijn een paar dingen die je kunt doen:
                                        </p>
                                        
                                        <!-- Features lijst -->
                                        <table role="presentation" style="width:  100%%; border-collapse: collapse; margin-bottom: 30px;">
                                            <tr>
                                                <td style="padding: 15px; background-color: #f8f9fa; border-radius:  8px; margin-bottom: 10px;">
                                                    <span style="font-size: 24px; margin-right: 10px;">📧</span>
                                                    <span style="color: #333333; font-size: 16px; font-weight: 600;">Emails versturen</span>
                                                    <p style="color: #666666; font-size: 14px; margin: 5px 0 0 34px;">
                                                        Stuur mooie HTML emails naar je contacten
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="padding: 15px; background-color: #f8f9fa; border-radius: 8px;">
                                                    <span style="font-size: 24px; margin-right: 10px;">⚡</span>
                                                    <span style="color: #333333; font-size: 16px; font-weight: 600;">Snel en betrouwbaar</span>
                                                    <p style="color: #666666; font-size: 14px; margin: 5px 0 0 34px;">
                                                        Onze service is 24/7 beschikbaar
                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                        
                                        <!-- Call to action button -->
                                        <table role="presentation" style="width: 100%%; border-collapse: collapse;">
                                            <tr>
                                                <td style="text-align: center; padding: 20px 0;">
                                                    <a href="http://localhost:5173" style="display: inline-block; padding: 15px 40px; background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); color: #ffffff; text-decoration: none; border-radius: 8px; font-weight: 600; font-size:  16px; box-shadow: 0 4px 6px rgba(102, 126, 234, 0.4);">
                                                        🚀 Ga naar Dashboard
                                                    </a>
                                                </td>
                                            </tr>
                                        </table>
                                        
                                        <p style="color: #999999; font-size: 14px; line-height: 1.6; margin: 30px 0 0 0; text-align: center;">
                                            Heb je vragen?  Neem gerust contact met ons op! 
                                        </p>
                                    </td>
                                </tr>
                                
                                <!-- Footer -->
                                <tr>
                                    <td style="background-color: #f8f9fa; padding: 30px 40px; text-align: center; border-top: 1px solid #e9ecef;">
                                        <p style="color: #999999; font-size: 12px; margin: 0 0 10px 0;">
                                            © 2026 Email Demo Applicatie.  Alle rechten voorbehouden.
                                        </p>
                                        <p style="color: #999999; font-size: 12px; margin: 0;">
                                            <a href="#" style="color: #667eea; text-decoration: none; margin:  0 10px;">Privacy</a> | 
                                            <a href="#" style="color: #667eea; text-decoration: none; margin: 0 10px;">Voorwaarden</a> | 
                                            <a href="#" style="color: #667eea; text-decoration: none; margin: 0 10px;">Support</a>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
            </html>
            """.formatted(naam);
    }
}
