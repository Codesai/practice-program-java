package birthdaygreetings.infrastructure.greetings_senders;

import birthdaygreetings.core.GreetingMessage;
import birthdaygreetings.core.GreetingsSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class SmtpGreetingsSender implements GreetingsSender {
    private final String from;
    private final Session session;

    public SmtpGreetingsSender(String smtpHost, int smtpPort, String from) {
        this.from = from;
        this.session = createSession(smtpPort, smtpHost);
    }

    @Override
    public void send(List<GreetingMessage> greetings) {
        try {
            for (GreetingMessage greeting : greetings) {
                sendMessage(constructMessage(greeting));
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Message constructMessage(GreetingMessage message) throws MessagingException {
        String recipient = message.to();
        String body = message.text();
        String subject = message.subject();
        Message msg = new MimeMessage(this.session);
        msg.setFrom(new InternetAddress(from));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
            recipient));
        msg.setSubject(subject);
        msg.setText(body);
        return msg;
    }

    private Session createSession(int smtpPort, String smtpHost) {
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        return Session.getDefaultInstance(props, null);
    }

    // made protected for testing :-(
    protected void sendMessage(Message msg) throws MessagingException {
        Transport.send(msg);
    }
}
