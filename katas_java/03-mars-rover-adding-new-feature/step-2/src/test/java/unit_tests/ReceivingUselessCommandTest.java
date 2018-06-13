package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.helpers.MarsRoverBuilder.aMarsRoverAnywherePointingToAnyDirection;

public class ReceivingUselessCommandTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = aMarsRoverAnywherePointingToAnyDirection().build();

        marsRover.receive("");

        assertThat(marsRover, is(aMarsRoverAnywherePointingToAnyDirection().build()));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = aMarsRoverAnywherePointingToAnyDirection().build();

        marsRover.receive("*");

        assertThat(marsRover, is(aMarsRoverAnywherePointingToAnyDirection().build()));
    }
}
