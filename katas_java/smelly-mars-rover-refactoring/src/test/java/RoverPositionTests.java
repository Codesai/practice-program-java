import static org.junit.Assert.*;

import org.junit.Test;

public class RoverPositionTests {
    @Test
    public void facingNorthMoveForward() {
        Rover rover = new Rover(0, 0, "N");

        rover.receive("f");

        assertEquals(new Rover(0, 1, "N"), rover);
    }

    @Test
    public void facingNorthMoveBackward() {
        Rover rover = new Rover(0, 0, "N");

        rover.receive("b");

        assertEquals(new Rover(0, -1, "N"), rover);
    }

    @Test
    public void facingSouthMoveForward() {
        Rover rover = new Rover(0, 0, "S");

        rover.receive("f");

        assertEquals(new Rover(0, -1, "S"), rover);
    }

    @Test
    public void facingSouthMoveBackward() {
        Rover rover = new Rover(0, 0, "S");

        rover.receive("b");

        assertEquals(new Rover(0, 1, "S"), rover);
    }

    @Test
    public void facingWestMoveForward() {
        Rover rover = new Rover(0, 0, "W");

        rover.receive("f");

        assertEquals(new Rover(-1, 0, "W"), rover);
    }

    @Test
    public void facingWestMoveBackward() {
        Rover rover = new Rover(0, 0, "W");

        rover.receive("b");

        assertEquals(new Rover(1, 0, "W"), rover);
    }

    @Test
    public void facingEastMoveForward() {
        Rover rover = new Rover(0, 0, "E");

        rover.receive("f");

        assertEquals(new Rover(1, 0, "E"), rover);
    }

    @Test
    public void facingEastMoveBackward() {
        Rover rover = new Rover(0, 0, "E");

        rover.receive("b");

        assertEquals(new Rover(-1, 0, "E"), rover);
    }
}
