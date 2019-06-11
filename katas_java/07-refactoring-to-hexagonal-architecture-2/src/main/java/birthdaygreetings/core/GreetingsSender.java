package birthdaygreetings.core;

import java.util.List;

public interface GreetingsSender {
    void send(List<GreetingMessage> greetings);
}
