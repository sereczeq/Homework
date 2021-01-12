package Lab12;

import java.util.Objects;

public class Developer extends Employee {
    String level;
    String specialization;

    public Developer(String name, String surname, int age, int salary, String level, String specialization) {
        super(name, surname, age, salary);
        this.level = level;
        this.specialization = specialization;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(getLevel(), developer.getLevel()) &&
                Objects.equals(getSpecialization(), developer.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLevel(), getSpecialization());
    }

    @Override
    public String toString() {
        return "Developer{" +
                "level='" + level + '\'' +
                ", specialization='" + specialization + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
