package tut8;

public class Dog {
    // <state>
    private String name;
    private int age;
    private int weight;
    private boolean isMale;
    private int happiness;
    // </state>

    // <identity>
    public Dog(String name, int age, int weight, boolean isMale) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isMale = isMale;
    }

    public Dog(String name) {
        this.name = name;
        this.age = 3;
        this.weight = 10;
        this.isMale = true;
    }
    // </identity>

    // <state>
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    // </state>

    // <behaviour>
    public void eat()
    {
        this.happiness++;
        this.weight++;
    }

    public void walk()
    {
        this.happiness+= 3;
        this.weight--;
    }

    public void chaseCat()
    {
        if(this.age > 5) this.happiness -= 2;
        else this.happiness++;
        this.weight--;
    }
    // </behaviour>

}
