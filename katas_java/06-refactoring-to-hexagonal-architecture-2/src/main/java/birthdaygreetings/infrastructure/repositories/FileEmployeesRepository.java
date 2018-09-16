package birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.Employee;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.core.OurDate;

import java.util.List;
import java.util.stream.Collectors;

public class FileEmployeesRepository implements EmployeesRepository {
    private final String path;

    public FileEmployeesRepository(String path) {
        this.path = path;
    }

    @Override
    public List<Employee> whoseBirthdayIs(OurDate today) {
        return allEmployees().stream()
            .filter(employee -> employee.isBirthday(today))
            .collect(Collectors.toList());
    }

    private List<Employee> allEmployees() {
        EmployeesFile employeesFile = EmployeesFile.loadFrom(path);
        return employeesFile.extractEmployees();
    }
}
