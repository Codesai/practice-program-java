package test.birthdaygreetings.core;

import birthdaygreetings.core.OurDate;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

public class OurDateTest {
    @Test
    public void identifies_if_two_dates_were_in_the_same_day() throws Exception {
        OurDate ourDate = ourDateFromString("1789/01/24");
        OurDate sameDay = ourDateFromString("2001/01/24");
        OurDate notSameDay = ourDateFromString("1789/01/25");
        OurDate notSameMonth = ourDateFromString("1789/02/25");

        assertTrue("same", ourDate.isSameDay(sameDay));
        assertFalse("not same day", ourDate.isSameDay(notSameDay));
        assertFalse("not same month", ourDate.isSameDay(notSameMonth));
    }
}
