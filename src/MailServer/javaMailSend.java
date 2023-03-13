package MailServer;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class javaMailSend {
    public static void main(String[] args) {

        String receipent = "a@gmail.com";
        String sender = "b@gmail.com";

        final String uname = "x@gmail.com";
        final String pwd = "fggjgn ergnejg egrjgnkwe";

        String smthost = "smtp.gmail.com";

        Properties propvis = new Properties();
        propvis.put("mail.smtp.auth","true");
        propvis.put("mail.smtp.starttls.enable","true");
        propvis.put("mail.smtp.host", smthost);
        propvis.put("mail.smtp.port", "587");

        //session object


        Session sessionobj = Session.getInstance(propvis, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(uname, pwd);
            }
        });
        try{
            Message messageobj = new MimeMessage(sessionobj);
            messageobj.setFrom(new InternetAddress(sender));
            messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipent));

            messageobj.setSubject("T subject");

            messageobj.setText("Hello  java api");

            Transport.send(messageobj);
            System.out.println("Email sent successfully");
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}