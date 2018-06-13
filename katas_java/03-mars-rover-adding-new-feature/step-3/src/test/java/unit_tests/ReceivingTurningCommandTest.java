package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.helpers.MarsRoverBuilder.aMarsRoverAtIrrelevantPosition;

public class ReceivingTurningCommandTest {

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("N").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("E").build()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("E").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("S").build()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("S").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("W").build()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("W").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("N").build()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("N").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("W").build()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("W").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("S").build()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("S").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("E").build()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("E").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAtIrrelevantPosition().understandingNasaCommands().pointing("N").build()));
    }
}
