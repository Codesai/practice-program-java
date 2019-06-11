package birthdaygreetings.application;

import birthdaygreetings.core.Employee;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.core.GreetingMessage;
import birthdaygreetings.core.OurDate;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class BirthdayService {

    private EmployeesRepository employeesRepository;

    public BirthdayService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public void sendGreetings(OurDate date, String smtpHost, int smtpPort, String sender) throws MessagingException {

        send(greetingMessagesFor(employeesHavingBirthday(date)),
            smtpHost, smtpPort, sender);
    }

    private List<GreetingMessage> greetingMessagesFor(List<Employee> employees) {
        return GreetingMessage.generateForSome(employees);
    }

    private List<Employee> employeesHavingBirthday(OurDate today) {
        return employeesRepository.whoseBirthdayIs(today);
    }

    private void send(List<GreetingMessage> messages, String smtpHost, int smtpPort, String sender) throws MessagingException {
        for (GreetingMessage message : messages) {
            String recipient = message.to();
            String body = message.text();
            String subject = message.subject();
            sendMessage(smtpHost, smtpPort, sender, subject, body, recipient);
        }
    }

    private void sendMessage(String smtpHost, int smtpPort, String sender,
                             String subject, String body, String recipient)
        throws MessagingException {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        Session session = Session.getDefaultInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
            recipient));
        msg.setSubject(subject);
        msg.setText(body);

        // Send the message
        sendMessage(msg);
    }

    // made protected for testing :-(
    protected void sendMessage(Message msg) throws MessagingException {
        Transport.send(msg);
    }

}
