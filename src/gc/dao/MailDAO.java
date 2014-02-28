/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.dao;


import gc.entities.Mail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author mahmoud
 */
public class MailDAO {
    
 public static boolean envoieMessage (Mail m,String to[])/*(String from, String password,String message, String to[]) */{
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", m.getMailAdmin());
        props.put("mail.smtp. password", m.getPasswordAdmin());
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {

  
            mimeMessage.setFrom(new InternetAddress(m.getMailAdmin()));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (int i = 0; i < toAddress.length; i++) {
                 mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);

            }
            
            mimeMessage.setSubject(m.getObjet());
            mimeMessage.setText(m.getMessage());
            Transport transport =session.getTransport("smtp");
            transport.connect(host,m.getMailAdmin(),m.getPasswordAdmin());
             transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients() );
            transport.close();
            return true;
        } catch (MessagingException me) {
            me.printStackTrace();

        }
        return false;
    }
    
}