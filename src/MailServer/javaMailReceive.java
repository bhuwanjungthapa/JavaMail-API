package MailServer;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Address;

public class javaMailReceive {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        try {
            Session session = Session.getInstance(props);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "x@gmail.com", "fhrtld bsmz");

            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);

            System.out.println("--------------------------------------");
            Message message = inbox.getMessage(inbox.getMessageCount());

            Address[] fromAddresses = message.getFrom();
            System.out.print("From:");
            for (Address fromAddress : fromAddresses) {
                System.out.println(fromAddress.toString());
            }

            System.out.println("Subject: " + message.getSubject());

            System.out.println("Text: " + message.getContent().toString());

            inbox.close(true);
            store.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
