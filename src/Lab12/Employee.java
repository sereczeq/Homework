package Lab12;

import java.util.Objects;

public class Employee extends Person {

    int salary;

    public Employee(String name, String surname, int age, int salary) {
        super(name, surname, age);
        this.salary = salary;
    }

    public void increaseSalary(float percentage)
    {
        this.salary += (int) (this.salary * percentage/100);
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
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
