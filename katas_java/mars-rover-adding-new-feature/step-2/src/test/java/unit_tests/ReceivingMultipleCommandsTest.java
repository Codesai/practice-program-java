package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.helpers.MarsRoverBuilder.aMarsRover;

public class ReceivingMultipleCommandsTest {

    @Test
    public void receives_multiple_commands() {
        MarsRover marsRover = aMarsRover().at(7,4).pointing("E").build();

        marsRover.receive("frrbbl");

        assertThat(marsRover, is(aMarsRover().at(10,4).pointing("S").build()));
    }
}
