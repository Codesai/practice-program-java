package mars_rover.interpreters.command_types;

import mars_rover.Command;
import mars_rover.location.Vector;

public class UnknownCommand implements Command {
    @Override
    public Vector execute(Vector vector) {
        return vector;
    }
}
