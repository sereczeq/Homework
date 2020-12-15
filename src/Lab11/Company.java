package Lab11;

import java.util.Vector;

class Company {
    private Vector<Employee> employees = new Vector<Employee>();

    public boolean addEmployee(Employee newEmployee)
    {
        if (employees.contains(newEmployee)) return false;
        return employees.add(newEmployee);
    }

    public void increaseSalary(float percentage) throws Exception {
        if(percentage < 0) throw new Exception("percentage is not proper");
        for (Employee employee : employees) employee.increaseSalary(percentage);
    }

    public void increaseBonus(int howMuch) throws Exception {
        if(howMuch < 0) throw new Exception("bonus is negative");
        for(Employee employee : employees)
            if(employee instanceof SpecialistEmployee)
                ((SpecialistEmployee) employee).raiseBonus(howMuch);
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}
