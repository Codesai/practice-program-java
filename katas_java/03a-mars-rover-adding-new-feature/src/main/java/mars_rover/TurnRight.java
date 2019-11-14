package mars_rover;

public class TurnRight implements Command {
    @Override
    public void execute(Vector vector) {
        vector.turnRight();
    }
}
