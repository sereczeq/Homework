package lab13;

import javafx.util.Pair;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MergeSort {
    static int[] sort(int[] array) throws InterruptedException {
        if(array.length <= 1) return array;
        else //return merge(sort(split(array)[0]), sort(split(array)[1]));
        {
            int[] arr1 = split(array)[0];
            int[] arr2 = split(array)[1];
            final int[][] finalArray = new int[1][1];
            final int[][] finalArray2 = new int[1][1];
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        finalArray[0] = sort(arr1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                       finalArray2[0] = sort(arr2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            return merge(finalArray[0], finalArray2[0]);
        }
    }

    static int[] merge(int[] array1, int[] array2)
    {
        int[] newArray = new int[array1.length + array2.length];
        for(int i = 0, arr1Counter = 0, arr2Counter = 0; i < newArray.length; i++)
        {
            if(arr2Counter >= array2.length || (arr1Counter < array1.length && array1[arr1Counter] < array2[arr2Counter])) newArray[i] = array1[arr1Counter++];
            else newArray[i] = array2[arr2Counter++];
        }
        return newArray;
    }

    static int[][] split(int[] array)
    {
        int[] newArray1 = new int[array.length/2];
        int[] newArray2 = new int[array.length - newArray1.length];
        System.arraycopy(array, 0, newArray1, 0, newArray1.length);
        System.arraycopy(array, newArray1.length, newArray2, 0, newArray2.length);
        return new int[][]{newArray1, newArray2};
    }
}