package mars_rover;

import mars_rover.location.Vector;

import java.util.List;

public class MarsRover {

    private static final int DISPLACEMENT = 1;
    private final NasaCommunicationProtocol communicationProtocol;
    private Vector vector;

    public MarsRover(int x, int y, String direction) {
        this.vector = Vector.create(x, y, direction);
        communicationProtocol = new NasaCommunicationProtocol();
    }

    public void receive(String message) {
        execute(createCommands(message));
    }

    private void execute(List<Command> commands) {
        for (Command command : commands) {
            vector = command.execute(vector);
        }
    }

    private List<Command> createCommands(String message) {
        return communicationProtocol.createCommands(message, DISPLACEMENT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarsRover marsRover = (MarsRover) o;

        return vector != null ? vector.equals(marsRover.vector) : marsRover.vector == null;
    }

    @Override
    public int hashCode() {
        return vector != null ? vector.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
            "vector=" + vector +
            '}';
    }

}
