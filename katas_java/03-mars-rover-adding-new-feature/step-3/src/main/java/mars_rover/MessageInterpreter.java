package mars_rover;

import java.util.List;

public interface MessageInterpreter {
    List<Command> createCommands(String message);
}
