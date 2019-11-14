package mars_rover;

public class MoveBackward implements Command {
    @Override
    public void execute(Vector vector) {
        vector.moveBackward();
    }
}
