package Lab12;

public class Task2Class {
    protected static void causeException(Object[] objectArray) throws ArrayStoreException
    {
        Person person = new Person("Peter", "Parker", 19);
        Employee employee = new Employee("Edward", "Elrik", 20, 2500);
        Developer developer = new Developer("David", "Dobrik", 21, 3500, "Senior", "Front end");


        // given array is of type employee, will add normally
        objectArray[0] = employee;
        // given array is of type employee (superclass of developer), will add normally
        objectArray[1] = developer;
        //will cause an exception, person is a superclass of employee, not other way around
        objectArray[2] = person;
    }
}
