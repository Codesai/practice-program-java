package birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.CannotReadEmployeesException;
import birthdaygreetings.core.Employee;
import birthdaygreetings.core.OurDate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmployeesFile {
    private final Iterator<String> linesIterator;

    private EmployeesFile(Iterator<String> linesIterator) {
        this.linesIterator = linesIterator;
    }

    public static EmployeesFile loadFrom(String path) {
        return new EmployeesFile(FileReader.readSkippingHeader(path));
    }

    public List<Employee> extractEmployees() {
        List<Employee> employees = new ArrayList<>();
        while (linesIterator.hasNext()) {
            String line = linesIterator.next();
            EmployeeCsvRepresentation representation = new EmployeeCsvRepresentation(line);
            employees.add(representation.convertToEmployee());
        }
        return employees;
    }

    private class EmployeeCsvRepresentation {
        private String content;
        private final String[] tokens;

        public EmployeeCsvRepresentation(String content) {
            this.content = content;
            this.tokens = content.split(", ");
        }

        public Employee convertToEmployee() {
            return new Employee(firstName(), lastName(), birthDate(), email());
        }

        private String lastName() {
            return tokens[0];
        }

        private String email() {
            return tokens[3];
        }

        private String firstName() {
            return tokens[1];
        }

        private OurDate birthDate() {
            try {
                return new DateRepresentation(dateAsString()).toDate();
            } catch (ParseException exception) {
                throw new CannotReadEmployeesException(
                    String.format("Badly formatted employee birth date in: '%s'", content),
                    exception
                );
            }
        }

        private String dateAsString() {
            return tokens[2];
        }
    }

    private static class FileReader {
        public static Iterator<String> readSkippingHeader(String pathString) {
            Path path = Paths.get(pathString);
            try {
                return skipHeader(readFile(path));
            } catch (IOException exception) {
                throw new CannotReadEmployeesException(
                    String.format("cannot loadFrom file = '%s'", path.toAbsolutePath()),
                    exception
                );
            }
        }

        private static Iterator<String> readFile(Path path) throws IOException {
            List<String> lines = Files.readAllLines(path);
            return lines.iterator();
        }

        private static Iterator<String> skipHeader(Iterator<String> iterator) {
            iterator.next();
            return iterator;
        }
    }
}
