package mars_rover.message_interpreters.command_types;

import mars_rover.location.Vector;

public class TurningRight implements Command {
    @Override
    public Vector execute(Vector vector) {
        return vector.turnRight();
    }
}
