package mars_rover;

import mars_rover.location.Vector;

public interface Command {
    Vector execute(Vector vector);
}
