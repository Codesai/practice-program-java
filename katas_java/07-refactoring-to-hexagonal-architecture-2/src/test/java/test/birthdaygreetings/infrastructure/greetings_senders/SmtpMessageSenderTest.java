package test.birthdaygreetings.infrastructure.greetings_senders;

import birthdaygreetings.core.Employee;
import birthdaygreetings.core.GreetingMessage;
import birthdaygreetings.core.GreetingsSender;
import birthdaygreetings.infrastructure.greetings_senders.SmtpGreetingsSender;
import org.junit.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class SmtpMessageSenderTest {

    private static final int SMTP_PORT = 25;
    private String SMTP_HOST = "localhost";
    private static final String FROM = "sender@here.com";

    private List<Message> messagesSent;

    @Test
    public void sending_greetings_by_email() throws IOException, MessagingException {
        messagesSent = new ArrayList<>();
        GreetingsSender greetingsSender = new SmtpGreetingsSender(SMTP_HOST, SMTP_PORT, FROM) {
            @Override
            protected void sendMessage(Message msg) throws MessagingException {
                messagesSent.add(msg);
            }
        };
        String employeeEmail = "oh@lala.com";
        String employeeName = "Pepe";
        List<Employee> employees = Arrays.asList(new Employee(employeeName, "Koko", null, employeeEmail));
        List<GreetingMessage> messages = GreetingMessage.generateForSome(employees);

        greetingsSender.send(messages);

        assertThat("message not sent?", messagesSent.size(), is(1));
        Message message = messagesSent.get(0);
        assertEquals("Happy Birthday, dear " + employeeName + "!", message.getContent());
        assertEquals("Happy Birthday!", message.getSubject());
        assertEquals(1, message.getAllRecipients().length);
        assertEquals(employeeEmail, message.getAllRecipients()[0].toString());
    }
}

