package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.helpers.MarsRoverBuilder.aMarsRover;

public class ReceivingDisplacementCommandTest {

    @Test
    public void moves_forward_when_pointing_north() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("N").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(5, 5).pointing("N").build()));
    }

    @Test
    public void moves_forward_when_pointing_east() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("E").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(6, 4).pointing("E").build()));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("S").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(5, 3).pointing("S").build()));
    }

    @Test
    public void moves_forward_when_pointing_west() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("W").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(4, 4).pointing("W").build()));
    }

    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("N").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(5, 3).pointing("N").build()));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("E").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(4, 4).pointing("E").build()));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("S").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(5, 5).pointing("S").build()));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(5, 4).pointing("W").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(6, 4).pointing("W").build()));
    }
}
