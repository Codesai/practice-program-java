package birthdaygreetings.application;

import birthdaygreetings.core.Employee;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.core.GreetingMessage;
import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.repositories.FileEmployeesRepository;
import birthdaygreetings.core.GreetingsSender;

import javax.mail.MessagingException;
import java.util.List;

public class BirthdayService {

    private EmployeesRepository employeesRepository;
    private GreetingsSender greetingsSender;

    public BirthdayService(FileEmployeesRepository fileEmployeesRepository, GreetingsSender greetingsSender) {
        employeesRepository = fileEmployeesRepository;
        this.greetingsSender = greetingsSender;
    }

    public void sendGreetings(OurDate date) throws MessagingException {
        this.greetingsSender.send(greetingMessagesFor(employeesHavingBirthday(date)));
    }

    private List<GreetingMessage> greetingMessagesFor(List<Employee> employees) {
        return GreetingMessage.generateForSome(employees);
    }

    private List<Employee> employeesHavingBirthday(OurDate today) {
        return employeesRepository.whoseBirthdayIs(today);
    }
}
