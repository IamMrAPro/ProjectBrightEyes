/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.model.profile;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class EmailDAO {

    public static void MailResetPassword(String email, String newpassword, String account) throws AddressException, jakarta.mail.MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;
        System.out.println(email);
        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        // mail khach
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        mailMessage.setSubject("Request to reset password");
        String emailBody = "\n"
                + "        <div>\n"
                + "            <div style=\"font-size: 20px\">Hello," + account + "</div>\n"
                + "\n"
                + "            <div style=\"font-size: 15px\">** This is an automated message -- please do not reply as you will not receive a response. **\n"
                + "               <br><br> This message is in response to your request to reset your account password. Please click the link below and follow the instructions to change your password.\n"
                + "\n"
                + "              <br> <br> Your password is: " + newpassword + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "              <br>  Thank you.\n"
                + "\n"
                + "              <br><br> <br>   Bright eye clinic.</div>\n"
                + "\n"
                + "        </div>";
        mailMessage.setContent(emailBody, "text/html");
        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "anhhq02@gmail.com", "commwhfhhhyzwkbg");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }

    public static void MailConfirmAppointment(String email, String name, String date, String time) throws AddressException, jakarta.mail.MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;
        System.out.println(email);
        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        // mail khach
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        mailMessage.setSubject("Appointment Confirmation");
        String emailBody = "\n"
                + "        <div>\n"
                + "            <div style=\"font-size: 20px\">Dear " + name + ",</div>\n"
                + "\n"
                + "            <div style=\"font-size: 15px\">** This is an automated message -- please do not reply as you will not receive a response. **\n"
                + "               <br><br> This email is to confirm your scheduled appointment with us on " + date + " at " + time + ".\n"
                + "\n"
                + "              <br> <br> If you need to cancel or reschedule, please contact us as soon as possible.\n"
                + "\n"
                + "\n"
                + "\n"
                + "              <br>  Thank you for choosing our services.\n"
                + "\n"
                + "              <br><br> <br>   Bright eye clinic.</div>\n"
                + "\n"
                + "        </div>";
        mailMessage.setContent(emailBody, "text/html");
        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "anhhq02@gmail.com", "commwhfhhhyzwkbg");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }
public static void MailCancelAppointment(String email, String name, String date, String time) throws AddressException, jakarta.mail.MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;
        System.out.println(email);
        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        // mail khach
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        mailMessage.setSubject("Appointment Cancellation Confirmation");
        String emailBody = "\n"
                + "        <div>\n"
                + "            <div style=\"font-size: 20px\">Dear " + name + ",</div>\n"
                + "\n"
                + "            <div style=\"font-size: 15px\">** This is an automated message -- please do not reply as you will not receive a response. **\n"
                + "               <br><br> This email is to confirm the cancellation of your scheduled appointment with us on " + date + " at " + time + ".\n"
                + "\n"
                + "              <br> <br> We hope that you will consider rescheduling your appointment with us in the future.\n"
                + "\n"
                + "\n"
                + "\n"
                + "              <br>  Thank you for considering our services.\n"
                + "\n"
                + "              <br><br> <br>   Bright eye clinic.</div>\n"
                + "\n"
                + "        </div>";
        mailMessage.setContent(emailBody, "text/html");
        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "anhhq02@gmail.com", "commwhfhhhyzwkbg");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUM_LENGTH = 4;

    public static String RandomPassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // add the first two random letters
        for (int i = 0; i < 2; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        // add the next four random numbers
        for (int i = 0; i < NUM_LENGTH; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

}
