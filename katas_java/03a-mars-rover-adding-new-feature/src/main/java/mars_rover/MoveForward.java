package mars_rover;

public class MoveForward implements Command {
    @Override
    public void execute(Vector vector) {
        vector.moveForward();
    }
}
