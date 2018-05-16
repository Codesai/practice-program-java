import static org.junit.Assert.*;

import org.junit.Test;

public class RoverRotationTests {
    @Test
    public void facingNorthRotateLeft() {
        Rover rover = new Rover(0, 0, "N");

        rover.receive("l");

        assertEquals(new Rover(0, 0, "W"), rover);
    }

    @Test
    public void facingNorthRotateRight() {
        Rover rover = new Rover(0, 0, "N");

        rover.receive("r");

        assertEquals(new Rover(0, 0, "E"), rover);
    }

    @Test
    public void facingSouthRotateLeft() {
        Rover rover = new Rover(0, 0, "S");

        rover.receive("l");

        assertEquals(new Rover(0, 0, "E"), rover);
    }

    @Test
    public void facingSouthRotateRight() {
        Rover rover = new Rover(0, 0, "S");

        rover.receive("r");

        assertEquals(new Rover(0, 0, "W"), rover);
    }

    @Test
    public void facingWestRotateLeft() {
        Rover rover = new Rover(0, 0, "W");

        rover.receive("l");

        assertEquals(new Rover(0, 0, "S"), rover);
    }

    @Test
    public void facingWestRotateRight() {
        Rover rover = new Rover(0, 0, "W");

        rover.receive("r");

        assertEquals(new Rover(0, 0, "N"), rover);
    }

    @Test
    public void facingEastRotateLeft() {
        Rover rover = new Rover(0, 0, "E");

        rover.receive("l");

        assertEquals(new Rover(0, 0, "N"), rover);
    }

    @Test
    public void facingEastRotateRight() {
        Rover rover = new Rover(0, 0, "E");

        rover.receive("r");

        assertEquals(new Rover(0, 0, "S"), rover);
    }
}
