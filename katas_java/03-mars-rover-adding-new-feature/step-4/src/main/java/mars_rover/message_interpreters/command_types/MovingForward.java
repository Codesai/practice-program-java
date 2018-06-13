package mars_rover.message_interpreters.command_types;

import mars_rover.Command;
import mars_rover.location.Vector;

public class MovingForward implements Command {
    private int delta;

    public MovingForward(int delta) {
        this.delta = delta;
    }

    @Override
    public Vector execute(Vector vector) {
        return vector.moveForward(delta);
    }
}
