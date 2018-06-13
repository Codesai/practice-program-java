package mars_rover;

import mars_rover.command_types.*;

import java.util.ArrayList;
import java.util.List;

class NASAMessageInterpreter {

    private static final int MOVEMENT_DELTA = 1;

    List<Command> createCommands(String message) {
        List<Command> commands = new ArrayList<>();
        for (String commandRepresentation : parseMessage(message)) {
            commands.add(createCommand(commandRepresentation));
        }
        return commands;
    }

    private String[] parseMessage(String message) {
        return message.split("");
    }

    private Command createCommand(String commandRepresentation) {

        if (commandRepresentation.equals("r")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("l")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("f")) {
            return new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("b")) {
            return new MovingBackwards(MOVEMENT_DELTA);
        } else {
            return new UnknownCommand();
        }
    }
}
