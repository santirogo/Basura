package edu.co.sergio.mundo.dao;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import util.Conexion;

public class EnviarMail {

    private String cod;

    public EnviarMail() throws URISyntaxException {
        this.cod = Integer.toString((int) Math.floor(Math.random() * (1000000 - 100000 + 1) + (100000)));
    }

    public void sendMail(String toAdd) {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "appumartsw@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            
            System.out.println("Entro Al Metodo De Registro");
            
            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("appumartsw@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(toAdd));
            message.addHeader("Disposition-Notification-To", "appumartsw@gmail.com");
            message.setSubject("Verificación de cuenta");
            message.setText("Tu código: "+this.cod);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("appumartsw@gmail.com", "dondetusicompras");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCod() {

        return cod;

    }
    
    
    public void sendCheckOut(String toAdd, ArrayList<String> orden){
    
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "chuidiang@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("appumartsw@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(toAdd));
            message.setSubject("Orden");
            message.setText("Tu orden: ");
            for (int i = 0; i < orden.size(); i++) {
                message.setText(orden.get(i));
            }

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("appumartsw@gmail.com", "dondetusicompras");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
    
