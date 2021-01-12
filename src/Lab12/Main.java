package Lab12;

import java.util.Comparator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Peter", "Parker", 19);
        Employee employee = new Employee("Edward", "Elrik", 20, 2500);
        Developer developer = new Developer("David", "Dobrik", 21, 3500, "Senior", "Front end");

        Company company = new Company();
        //added three different classes to the same array
        company.addEmployee(person, employee, developer);

        System.out.println(company.toString());

        /*
        -----------------------------------------------------------------------------------------
        Task 2
         */

        Employee[] employees = new Employee[] {null, null, null};
        try {
            Task2Class.causeException(employees);
        }
        catch (ArrayStoreException e)
        {
            System.err.println("Array Store Exception caught");
            e.printStackTrace();
        }

        /*
        -----------------------------------------------------------------------------------------
        Task 3
         */

        System.out.println("--------------------Task 3------------------------");

        Vector<Float> floats = new Vector<Float>();
        floats.add(4f);
        floats.add(-10.5f);
        floats.add(123.123f);

        Vector<Double> doubles = new Vector<Double>();
        doubles.add(4.0);
        doubles.add(-10.5);
        doubles.add(123.123123123);

        Vector<Integer> integers = new Vector<Integer>();
        integers.add(4);
        integers.add(-10);
        integers.add(123);

        //the same methods on different Vector types
        System.out.println(SumNumbers.sum(floats));
        System.out.println(SumNumbers.sum(doubles));
        System.out.println(SumNumbers.sum(integers));

    }
}
