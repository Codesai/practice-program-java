package birthdaygreetings.core;

import java.util.Date;
import java.util.GregorianCalendar;

public class OurDate {
    private Date date;

    public OurDate(Date date) {
        this.date = date;
    }

    public boolean isSameDay(OurDate anotherDate) {
        return anotherDate.getDay() == this.getDay()
            && anotherDate.getMonth() == this.getMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OurDate)) return false;

        OurDate ourDate = (OurDate) o;

        return date != null ? date.equals(ourDate.date) : ourDate.date == null;
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }

    private int getDay() {
        return getPartOfDate(GregorianCalendar.DAY_OF_MONTH);
    }

    private int getMonth() {
        return 1 + getPartOfDate(GregorianCalendar.MONTH);
    }

    private int getPartOfDate(int part) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(part);
    }
}
