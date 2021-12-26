package com.jack_the_coder.bilboard_backend.serviceImplementation;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


import com.jack_the_coder.bilboard_backend.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
@Service
public class EmailServiceImplementation implements EmailService {
    final String username = "bilboard.helpdesk@gmail.com";
    final String password = "JackTheCoder06";
    Properties prop = new Properties();

    /**
     * Method for sending an email
     * @param email is a String
     * @param messageOfMail is a String
     * @param head is a String
     * @return boolean
     * @apiNote Method for sending an email
     */
    @Override
    public boolean sendEmail ( String email , String messageOfMail , String head ) {
        prop.put( "mail.imap.host" , "imap.gmail.com" );
        prop.put( "mail.imap.port" , "993" );
        prop.put( "mail.imap.starttls.enable" , "true" );
        prop.put( "mail.smtp.host" , "smtp.gmail.com" );
        prop.put( "mail.smtp.port" , "465" );
        prop.put( "mail.smtp.auth" , "true" );
        prop.put( "mail.smtp.socketFactory.port" , "465" );
        prop.put( "mail.smtp.socketFactory.class" , "javax.net.ssl.SSLSocketFactory" );

        Session session = Session.getInstance( prop ,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication () {
                        return new PasswordAuthentication( username , password );
                    }
                } );

        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( "bilboard.helpdesk@gmail.com" ) );
            message.setRecipients(
                    Message.RecipientType.TO ,
                    InternetAddress.parse( email )
            );
            message.setSubject( head );
            message.setText( messageOfMail );
            Transport.send( message );
            return true;
        } catch ( Exception e ) {
            System.out.println( e );
            return false;
        }
    }
}
