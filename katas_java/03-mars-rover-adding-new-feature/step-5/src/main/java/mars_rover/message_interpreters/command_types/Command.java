package mars_rover.message_interpreters.command_types;

import mars_rover.location.Vector;

public interface Command {
    Vector execute(Vector vector);
}
