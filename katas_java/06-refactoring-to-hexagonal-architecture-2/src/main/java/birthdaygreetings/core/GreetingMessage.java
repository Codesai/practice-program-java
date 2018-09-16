package birthdaygreetings.core;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GreetingMessage {

    private final String to;
    private final Greeting greeting;

    private GreetingMessage(String to, Greeting greeting) {
        this.to = to;
        this.greeting = greeting;
    }

    public static List<GreetingMessage> generateForSome(List<Employee> employees) {
        return employees.stream().map(GreetingMessage::generateFor).collect(toList());
    }

    private static GreetingMessage generateFor(Employee employee) {
        Greeting greeting = Greeting.forBirthdayOf(employee);
        String recipient = employee.email();
        return new GreetingMessage(recipient, greeting);
    }

    public String subject() {
        return this.greeting.header();
    }

    public String text() {
        return this.greeting.content();
    }

    public String to() {
        return this.to;
    }
}
