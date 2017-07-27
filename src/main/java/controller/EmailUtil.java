package controller;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EmailUtil
{
    public static void sendEmail(Session session, String toEmail, String subject, String body)
    {
        try
        {
            MimeMessage message = new MimeMessage(session);

            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            message.addHeader("format", "flowed");
            message.addHeader("Content-Transfer-Encoding", "8bit");

            message.setFrom(new InternetAddress("from_address", "bez_otveta"));
            message.setReplyTo(InternetAddress.parse("from address2", false));
            message.setSubject(subject, "UTF-8");
            message.setText(body, "UTF-8");
            message.setSentDate(new Date());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            System.out.println("message is ready");

            Transport.send(message);

            System.out.println("email sent");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
