package mainframe;

import controller.EmailUtil;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class Main
{
    public static void main(String[] args)
    {
        final String fromEmail = "denis.oblako@gmail.com";
        final String password = "Xx123456";
        final String toEmail = "podnklada@gmail.com";

        System.out.println("Email Start");

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator auth = new Authenticator()
        {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        EmailUtil.sendEmail(session, toEmail,"Zagolovok", "Telo soobsheniya");
    }
}
