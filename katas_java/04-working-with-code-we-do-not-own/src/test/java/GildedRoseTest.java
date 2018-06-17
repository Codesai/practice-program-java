import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {
    @Test
    public void shouldFail() {
        assertThat(false, is(true));
    }
}
