package lab13;

import java.util.Arrays;

public class MergeSort {
    private int threads = 0;
    private final int maxThreads = 8;

    public int[] sort(int[] array)
    {
        if (array.length <= 1) return array;
        else if (threads++ < maxThreads) {
            final int[][] arr1 = new int[1][1]; //IDE made this automatically, it works so thanks JetBrains
            final int[][] arr2 = new int[1][1];
            Thread t1 = new Thread(() -> arr1[0] = sort(split(array)[0]));
            Thread t2 = new Thread(() -> arr2[0] = sort(split(array)[1]));
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return merge(arr1[0], arr2[0]);
        } else return merge(sort(split(array)[0]), sort(split(array)[1]));

    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        for (int i = 0, arr1Counter = 0, arr2Counter = 0; i < newArray.length; i++) {
            if (arr2Counter >= array2.length || (arr1Counter < array1.length && array1[arr1Counter] < array2[arr2Counter]))
                newArray[i] = array1[arr1Counter++];
            else newArray[i] = array2[arr2Counter++];
        }
        return newArray;
    }

    private static int[][] split(int[] array) {
        return new int[][]{Arrays.copyOf(array, array.length / 2), Arrays.copyOfRange(array, array.length / 2, array.length)};
    }
}