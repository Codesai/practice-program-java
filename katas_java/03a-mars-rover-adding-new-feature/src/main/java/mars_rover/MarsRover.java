package mars_rover;

public class MarsRover {

    private Vector vector;

    public MarsRover(int x, int y, String direction) {
        this.vector = new Vector(new Coordinates(x, y), Direction.parse(direction));
    }

    public void receive(String commandsSequence) {
        for (String commandCode : commandsSequence.split("")) {
            Command command = null;
            if (commandCode.equals("r")) {
                command = new TurnRight();
            } else if (commandCode.equals("l")) {
                command = new TurnLeft();
            } else if (commandCode.equals("f")) {
                command = new MoveForward();
            } else if (commandCode.equals("b")) {
                command = new MoveBackward();
            } else {
                command = new UnknownCommand();
            }
            command.execute(vector);
        }
    }

    @Override
    public String toString() {
        return "MarsRover [vector=" + vector + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vector == null) ? 0 : vector.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MarsRover other = (MarsRover) obj;
        if (vector == null) {
            if (other.vector != null)
                return false;
        } else if (!vector.equals(other.vector))
            return false;
        return true;
    }
}
