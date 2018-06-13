package unit_tests.helpers;

import mars_rover.MarsRover;

public class MarsRoverBuilder {

    private String direction;
    private int x;
    private int y;

    public static MarsRoverBuilder aMarsRover() {
        return new MarsRoverBuilder();
    }

    public static MarsRoverBuilder aMarsRoverAtIrrelevantPosition() {
        return aMarsRover().at(0,0);
    }

    public static MarsRoverBuilder aMarsRoverAnywherePointingToAnyDirection() {
        return aMarsRover().at(0,0).pointing("N");
    }

    public MarsRoverBuilder at(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public MarsRoverBuilder pointing(String direction) {
        this.direction = direction;
        return this;
    }

    public MarsRover build() {
        return new MarsRover(x, y, direction);
    }
}