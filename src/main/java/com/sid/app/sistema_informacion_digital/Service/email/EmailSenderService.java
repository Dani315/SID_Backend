package com.sid.app.sistema_informacion_digital.Service.email;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class EmailSenderService {
    public  void enviarConGMail(String destinatario, String asunto, String giftId) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
         String remitente = "viafirmadaniela@gmail.com";  //Para la dirección nomcuenta@gmail.com

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "SofkaUniversity2021+");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setContent("Hola!\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "Estamos muy felices de contar contigo, recientemente nos visitaste en una de nuestras tiendas físicas y como recompensa te obsequiamos  un bono del 15% de descuento en tu próxima compra.\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "Para redimirlo debes acercarte  a una de nuestras tiendas físicas en los próximos 10 días, mostrando en la caja el siguiente código:\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "<h4>CÓDIGO DE DESCUENTO: "+giftId+"</h4>\n" +
                    "<br>\n" +
                    "<u>\n" +
                    "Información importante:\n" +
                    "<br>\n" +
                    "El código es único y solo es canjeable una sola vez. La tienda contará con asesores que consultarán el estado del bono como método de control.\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "Recuerda llevar tu cédula para validar tu identidad.\n" +
                    "</u>", "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente,  "SofkaUniversity2021+");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            throw new RuntimeException("PROBLEMAS AL ENVIAR EL CORREO ELECTRONICO: " + me.getMessage());  //Si se produce un error
        }
    }


}
