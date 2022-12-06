package com.restapi.Email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * The type Email properties.
 */
public class EmailProperties {

    private Session session;

    /**
     * Sets session.
     *
     * @param session the session
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * Gets session.
     *
     * @return the session
     */
    public Session getSession() {
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hrishikeshnalavade22@gmail.com","czzpkkgkjyzvekps");
            }
        });

        return session;
    }
}
