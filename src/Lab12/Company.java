package Lab12;

import java.util.Arrays;
import java.util.Vector;

public class Company {
    private Person[] employees;

    public Company(Person[] employees) {
        this.employees = employees;
    }

    public Company() {
        employees = null;
    }

    public boolean addEmployee(Person newEmployee) {
        if(employees == null){
            employees = new Person[] {newEmployee};
            return true;
        }
        Person[] newArray = new Person[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            //check if employee already exists
            if (employees[i] == newEmployee) return false;
            newArray[i] = employees[i];
        }
        newArray[newArray.length - 1] = newEmployee;
        employees = newArray;
        return true;
    }

    public void addEmployee(Person... newEmployees) {
        for (Person newEmployee : newEmployees)
            addEmployee(newEmployee);
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
                "employees=" + Arrays.toString(employees) +
                '}';
    }
}

