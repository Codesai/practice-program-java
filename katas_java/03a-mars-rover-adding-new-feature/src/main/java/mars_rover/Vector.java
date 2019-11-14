package mars_rover;

public class Vector {

    private static final int MOVEMENT_DELTA = 1;

    private Coordinates coordinates;
    private Direction direction;

    public Vector(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
        Vector other = (Vector) obj;
        if (coordinates == null) {
            if (other.coordinates != null)
                return false;
        } else if (!coordinates.equals(other.coordinates))
            return false;
        if (direction != other.direction)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vector [coordinates=" + coordinates + ", direction=" + direction + "]";
    }

    public void turnRight() {
        this.direction = direction.turnRight();
    }

    public void turnLeft() {
        this.direction = direction.turnLeft();
    }

    public void moveBackward() {
        // TODO : pass MOVEMENT_DELTA in the constructor
        this.coordinates = direction.moveBackwards(coordinates, MOVEMENT_DELTA);
    }

    public void moveForward() {
        // TODO : pass MOVEMENT_DELTA in the constructor
        this.coordinates = direction.moveForward(coordinates, MOVEMENT_DELTA);
    }

}
