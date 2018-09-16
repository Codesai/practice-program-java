package birthdaygreetings.core;

import java.util.List;

public interface EmployeesRepository {
    List<Employee> whoseBirthdayIs(OurDate today);
}
