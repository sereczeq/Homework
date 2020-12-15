package Lab11;

public class SpecialistEmployee extends Employee {
    int bonus;

    public SpecialistEmployee(String surname, String firstName, int salary, int bonus) {
        super(surname, firstName, salary);
        this.bonus = bonus;
    }

    public void raiseBonus(int howMany)
    {
        bonus += howMany;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "SpecialistEmployee{" +
                "surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary + '\'' +
                ", bonus=" + bonus +
                '}';
    }
}
