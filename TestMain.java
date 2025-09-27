package app;

import algorithms.*;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        Metrics m = new Metrics();

        // MergeSort
        int[] arr = {5, 3, 8, 1, 2};
        MergeSort.sort(arr, m);
        System.out.println("MergeSort ok? " + Arrays.equals(arr, new int[]{1,2,3,5,8}) + " | " + m);

        // QuickSort
        m.reset();
        arr = new int[]{10, 7, 8, 9, 1, 5};
        QuickSort.sort(arr, m);
        System.out.println("QuickSort ok? " + Arrays.equals(arr, new int[]{1,5,7,8,9,10}) + " | " + m);

        // DeterministicSelect
        m.reset();
        int[] arr2 = {7, 2, 5, 3, 9, 1};
        int k = 3;
        int result = DeterministicSelect.select(arr2.clone(), k, m);
        int[] sorted = arr2.clone();
        Arrays.sort(sorted);
        System.out.println("Select ok? " + (result == sorted[k]) + " | " + m);

        // Closest Pair
        m.reset();
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2),
                new ClosestPair.Point(5, 5)
        };
        double d = ClosestPair.closestPair(pts, m);
        System.out.println("ClosestPair distance = " + d + " | " + m);
    }
}
