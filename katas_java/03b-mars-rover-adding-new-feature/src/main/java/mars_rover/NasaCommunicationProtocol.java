package mars_rover;

import mars_rover.command_types.*;

import java.util.ArrayList;
import java.util.List;

class NasaCommunicationProtocol {
    List<Command> createCommands(String message, int displacement) {
        List<Command> commands = new ArrayList<>();
        for (String commandRepresentation : parseMessage(message)) {
            commands.add(createCommand(commandRepresentation, displacement));
        }
        return commands;
    }

    private String[] parseMessage(String message) {
        return message.split("");
    }

    private Command createCommand(String commandRepresentation, int displacement) {

        if (commandRepresentation.equals("r")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("l")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("f")) {
            return new MovingForward(displacement);
        } else if (commandRepresentation.equals("b")) {
            return new MovingBackwards(displacement);
        } else {
            return new UnknownCommand();
        }
    }
}
