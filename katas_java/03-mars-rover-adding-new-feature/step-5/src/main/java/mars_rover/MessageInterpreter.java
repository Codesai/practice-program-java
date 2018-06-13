package mars_rover;

public interface MessageInterpreter {
    Commands createCommands(String message);
}
