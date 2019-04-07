package test.birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.CannotReadEmployeesException;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.repositories.FileEmployeesRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.StringContains.containsString;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

public class FileEmployeeRepositoryTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();
    private OurDate ANY_DATE;

    @Before
    public void setUp() throws Exception {
        ANY_DATE = ourDateFromString("2016/01/01");
    }

    @Test
    public void fails_when_the_file_does_not_exist() throws Exception {

        EmployeesRepository employeesRepository = new FileEmployeesRepository("non-existing.file");
        expected.expect(CannotReadEmployeesException.class);
        expected.expectMessage(containsString("cannot loadFrom file"));
        expected.expectMessage(containsString("non-existing.file"));

        employeesRepository.whoseBirthdayIs(ANY_DATE);
    }

    @Test
    public void fails_when_the_file_does_not_have_the_necessary_fields() throws Exception {

        EmployeesRepository employeesRepository = new FileEmployeesRepository("src/test/resources/wrong_data__wrong-date-format.csv");
        expected.expect(CannotReadEmployeesException.class);
        expected.expectMessage(containsString("Badly formatted employee birth date in"));

        employeesRepository.whoseBirthdayIs(ANY_DATE);
    }
}