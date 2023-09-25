package com.emailapi.emailapi.Service;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;



@Service
public class Emailservice {  //these service sends email 

    public boolean sendEmail(String To, String Subject, String Messege) {
        boolean flag = false;
        try {

            String From = "softtech276@gmail.com";
            String host = "smtp.gmail.com";

            // get the system properties
            Properties properties = System.getProperties();

            // setting host
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            // Step 1 : to get the Session object

            Session session = Session.getInstance(properties, new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication("softtech276@gmail.com", "fljrxhtnfadtlkkk");

                }

            });

            session.setDebug(true);

            // Step 2: compose the message

            MimeMessage mm = new MimeMessage(session);
            try {

                // from email
                mm.setFrom(From);

                // adding recipient
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(To));

                // adding subject to message
                mm.setSubject(Subject);

                // adding text to message
                mm.setText(Messege);

                // send

                // Step 3: send the message using Transport class

                Transport.send(mm);
                System.out.println("message sent...");
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
