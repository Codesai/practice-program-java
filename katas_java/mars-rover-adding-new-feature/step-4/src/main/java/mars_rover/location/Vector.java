package mars_rover.location;

public class Vector {

    private final Coordinates coordinates;
    private final Direction direction;

    public static Vector create(int x, int y, String direction) {
        return new Vector(new Coordinates(x, y), Direction.parse(direction));
    }

    private Vector(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Vector turnRight() {
        return new Vector(coordinates, direction.turnRight());
    }

    public Vector turnLeft() {
        return new Vector(coordinates, direction.turnLeft());
    }

    public Vector moveForward(int delta) {
        return new Vector(direction.moveForward(coordinates, delta), direction);
    }

    public Vector moveBackwards(int delta) {
        return new Vector(direction.moveBackwards(coordinates, delta), direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (coordinates != null ? !coordinates.equals(vector.coordinates) : vector.coordinates != null) return false;
        return direction == vector.direction;
    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vector{" +
            "coordinates=" + coordinates +
            ", direction=" + direction +
            '}';
    }
}
