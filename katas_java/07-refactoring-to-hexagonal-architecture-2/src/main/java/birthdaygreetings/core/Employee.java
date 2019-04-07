package birthdaygreetings.core;

public class Employee {

    private OurDate birthDate;
    private String lastName;
    private String firstName;
    private String email;

    public Employee(String firstName, String lastName, OurDate birthDate,
                    String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public boolean isBirthday(OurDate today) {
        return today.isSameDay(birthDate);
    }

    String email() {
        return email;
    }

    String firstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Employee " + firstName + " " + lastName + " <" + email
            + "> born " + birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (birthDate != null ? !birthDate.equals(employee.birthDate) : employee.birthDate != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return email != null ? email.equals(employee.email) : employee.email == null;
    }

    @Override
    public int hashCode() {
        int result = birthDate != null ? birthDate.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
