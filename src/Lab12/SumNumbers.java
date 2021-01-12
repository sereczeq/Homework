package Lab12;

import java.util.Collection;

public class SumNumbers {
    public static <T extends Number> double sum(Collection<T> collection)
    {
        double sum = 0;
        for (Number number: collection
             ) {

            sum += number.doubleValue();
        }
        return sum;
    }
}
