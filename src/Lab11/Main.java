package Lab11;

public class Main {
    public static void main(String[] args) {
        // making a regular employee
        Employee john = new Employee("Kowalski", "John", 2500);
        System.out.println(john.toString());

        // making a specialist employee
        SpecialistEmployee tom = new SpecialistEmployee("Wick", "Thomas", 5400, 1000);
        System.out.println(tom.toString());

        // making a company
        Company company = new Company();
        company.addEmployee(new Employee("Pence", "Michael", 2000));
        company.addEmployee(john);
        company.addEmployee(tom);
        System.out.println(company.toString());

        // checking company's functionality
        System.out.println("50% salary increase");
        try {
            company.increaseSalary(50f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(company.toString());
        System.out.println("-12% salary increase (should cause an exception, nothing should change in the company)");
        try {
            company.increaseSalary(-12f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(company.toString());
        System.out.println("500 bonus increase (only Thomas's bonus should change0");
        try {
            company.increaseBonus(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(company.toString());
    }
}
