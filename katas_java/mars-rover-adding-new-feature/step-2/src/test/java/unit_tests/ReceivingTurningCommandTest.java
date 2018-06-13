package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.helpers.MarsRoverBuilder.aMarsRoverAtIrrelevantPosition;

public class ReceivingTurningCommandTest {

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("E").build()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("E").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("S").build()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("S").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("W").build()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("W").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("N").build()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("W").build()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("W").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("S").build()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("S").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("E").build()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().pointing("E").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().pointing("N").build()));
    }
}
