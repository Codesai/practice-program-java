package mars_rover;

import mars_rover.location.Vector;
import mars_rover.message_interpreters.command_types.Command;

import java.util.List;

public class Commands {

    private List<Command> commandsList;

    public Commands(List<Command> commandsList) {
        this.commandsList = commandsList;
    }

    public Vector execute(Vector vector) {
        for (Command command : commandsList) {
            vector = command.execute(vector);
        }
        return vector;
    }
}
