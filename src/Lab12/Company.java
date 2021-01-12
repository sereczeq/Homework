package Lab12;

import java.util.Vector;

public class Company {
    private Vector<Person> employees = new Vector<Person>();

    public Company(Vector<Person> employees) {
        this.employees = employees;
    }

    public Company() {
    }

    public boolean addEmployee(Person newEmployee) {
        if (employees.contains(newEmployee)) return false;
        return employees.add(newEmployee);
    }

    public void addEmployee(Person... newEmployees) {
        for (Person newEmployee : newEmployees) {
            if (employees.contains(newEmployee)) continue;
            employees.add(newEmployee);

        }
    }

    public void increaseSalary(float percentage) throws Exception {
        if (percentage < 0) throw new Exception("percentage is not proper");
        for (Person person : employees) {
            if (person instanceof Employee) {
                Employee employee = (Employee) person;
                employee.increaseSalary(percentage);
            }
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}

