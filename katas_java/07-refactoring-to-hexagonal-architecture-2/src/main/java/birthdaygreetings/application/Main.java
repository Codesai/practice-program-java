package birthdaygreetings.application;

import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.repositories.FileEmployeesRepository;

import java.util.Date;

public class Main {

    private static final String EMPLOYEES_FILE_PATH = "employee_data.txt";
    private static final String SENDER_EMAIL_ADDRESS = "sender@here.com";
    private static final String HOST = "localhost";
    private static final int SMTP_PORT = 25;

    public static void main(String[] args) {
        BirthdayService service = new BirthdayService(
            new FileEmployeesRepository(EMPLOYEES_FILE_PATH));
        try {
            OurDate today = new OurDate(new Date());
            service.sendGreetings(today, HOST, SMTP_PORT, SENDER_EMAIL_ADDRESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
