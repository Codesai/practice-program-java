package test.birthdaygreetings.helpers;

import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.repositories.DateRepresentation;

import java.text.ParseException;

public class OurDateFactory {
    public static OurDate ourDateFromString(String dateAsString) throws ParseException {
        return new DateRepresentation(dateAsString).toDate();
    }
}
