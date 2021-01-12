package Lab12;

import java.util.Comparator;

public class Main {
    public static void main(String[] args)
    {
        Person person = new Person("Peter", "Parker", 19);
        Employee employee = new Employee("Edward", "Elrik", 20, 2500);
        Developer developer = new Developer("David", "Dobrik", 21, 3500, "Senior", "Front end");

        Company company = new Company();
        company.addEmployee(person, employee, developer);

        System.out.println(company.toString());
    }
}
