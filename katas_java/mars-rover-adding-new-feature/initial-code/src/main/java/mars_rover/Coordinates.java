package mars_rover;

class Coordinates {

    private final int x;
    private final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinates incrementX(int delta) {
        return new Coordinates(x + delta, y);
    }

    Coordinates incrementY(int delta) {
        return new Coordinates(x, y + delta);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
