package birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.OurDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateRepresentation {
    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private final String dateAsString;

    public DateRepresentation(String dateAsString) {
        this.dateAsString = dateAsString;
    }

    public OurDate toDate() throws ParseException {
        return new OurDate(
            new SimpleDateFormat(DATE_FORMAT).parse(dateAsString)
        );
    }
}
