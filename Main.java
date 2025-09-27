package app;

import algorithms.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Metrics m = new Metrics();

        int[] arr = {5, 2, 9, 1, 7};
        MergeSort.sort(arr, m);
        System.out.println("MergeSort: " + Arrays.toString(arr));
        System.out.println("Metrics: " + m);
    }
}
