package mars_rover;

public class Rover {

    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = direction;
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l") || command.equals("r")) {

                // Rotate Rover
                if (direction.equals("N")) {
                    if (command.equals("r")) {
                        direction = "E";
                    } else {
                        direction = "W";
                    }
                } else if (direction.equals("S")) {
                    if (command.equals("r")) {
                        direction = "W";
                    } else {
                        direction = "E";
                    }
                } else if (direction.equals("W")) {
                    if (command.equals("r")) {
                        direction = "N";
                    } else {
                        direction = "S";
                    }
                } else {
                    if (command.equals("r")) {
                        direction = "S";
                    } else {
                        direction = "N";
                    }
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (direction.equals("N")) {
                    y += displacement;
                } else if (direction.equals("S")) {
                    y -= displacement;
                } else if (direction.equals("W")) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;

    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
            "direction='" + direction + '\'' +
            ", y=" + y +
            ", x=" + x +
            '}';
    }
}
