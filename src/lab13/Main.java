package lab13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{6, 7, 100, 1, 2, 3, 4, 5, 1, 1, 1, 5, 5, 5, 5, 1, 4, 2,5 ,23, 434 ,234, 32, 423,4,23, 423,4, 234, 32, 4, 23,4, 23,423,4,32,423, 4,234,324,325 ,56,6, 7,658,768,76,8,7  ,563,4, 5,32, 4,234,2, 3,432,54,6,547,657,568,75,856,7};
        System.out.println(Arrays.toString(mergeSort.sort(array)));
    }
}
