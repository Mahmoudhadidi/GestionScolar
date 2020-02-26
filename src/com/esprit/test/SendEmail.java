package com.esprit.test ; 
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public   boolean sendEmail(String to , String subject , String emailContent){
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mariem.romdhani@esprit.tn", "13012930");
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("mariem.romdhani@esprit.tn"));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            message.setContent("<html><body>" + emailContent + "</body></html>", "text/html; charset=utf-8");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true ;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false ; 
        }
    }
    
    
    public static void main(String[] args) {
//        AdminController a = new AdminController();
SendEmail m = new SendEmail();
          m.sendEmail("mariem.romdhani@esprit.tn", "reclamation", "check your compte");
     
    }
}