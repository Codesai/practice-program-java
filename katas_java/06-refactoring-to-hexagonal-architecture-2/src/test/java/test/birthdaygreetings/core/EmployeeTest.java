package test.birthdaygreetings.core;

import birthdaygreetings.core.Employee;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee("foo", "bar", ourDateFromString("1990/01/31"), "a@b.c");

        assertFalse("no birthday", employee.isBirthday(ourDateFromString("2008/01/30")));

        assertTrue("birthday", employee.isBirthday(ourDateFromString("2008/01/31")));
    }
}
