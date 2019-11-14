package mars_rover;

public class TurnLeft implements Command {
    @Override
    public void execute(Vector vector) {
        vector.turnLeft();
    }
}
