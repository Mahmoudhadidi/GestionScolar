/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;

import java.time.LocalDate;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class EmailZ {
    
    public static void sendMail(String recepient,/*LocalDate date ,*/String prenom) throws Exception{
    System.out.println("preparing to send emaill!!!!!!!!!!!");
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", "smtp.googlemail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.starttls.enable", "true");
    
    String myAccountEmail = "mohamedzakaria.boutamine@esprit.tn";
    String password = "helloworldbyzakaria@gmail.com";
    Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
            });
        
    Message message = prepareMessage(session,myAccountEmail,recepient,/*date,*/prenom);
        Transport.send(message);
        System.out.println("message sent successfully!!!!!!!!!!!");
    }
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient, /*LocalDate date ,*/ String prenom) throws AddressException, MessagingException
    {        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Creation de club");
            message.setText("Bonjour"+" "+prenom+",\n\n"
                    + "vous devez être présent au bureau de Service éleves premier étage bloc(C) le:"+" "/*date*/);
            return message;       
    }
    
    
}
