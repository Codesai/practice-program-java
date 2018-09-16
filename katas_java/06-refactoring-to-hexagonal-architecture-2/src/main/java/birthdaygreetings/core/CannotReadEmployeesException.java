package birthdaygreetings.core;

public class CannotReadEmployeesException extends RuntimeException {
    public CannotReadEmployeesException(String cause, Exception exception) {
        super(cause, exception);
    }
}
