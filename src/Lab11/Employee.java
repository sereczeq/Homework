package Lab11;

import java.util.Objects;

public class Employee {
    String surname;
    String firstName;

    int salary;

    public Employee(String surname, String firstName, int salary) {
        this.surname = surname;
        this.firstName = firstName;
        this.salary = salary;
    }

    public void increaseSalary(float percentage)
    {
        this.salary += (int) (this.salary * percentage/100);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getSurname().equals(employee.getSurname()) &&
                getFirstName().equals(employee.getFirstName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getFirstName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
