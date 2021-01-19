package lab13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[]{6, 7, 100, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(MergeSort.sort(array)));
    }
}
