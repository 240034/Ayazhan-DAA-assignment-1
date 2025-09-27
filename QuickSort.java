package algorithms;

import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] arr, Metrics m) {
        quickSort(arr, 0, arr.length - 1, m);
    }

    private static void quickSort(int[] arr, int left, int right, Metrics m) {
        while (left < right) {
            m.enterRecursion();
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivot = arr[pivotIndex];
            int i = left, j = right;
            while (i <= j) {
                while (arr[i] < pivot) { i++; m.addComparison(); }
                while (arr[j] > pivot) { j--; m.addComparison(); }
                if (i <= j) {
                    int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
                    i++; j--;
                }
            }
            if (j - left < right - i) {
                if (left < j) quickSort(arr, left, j, m);
                left = i;
            } else {
                if (i < right) quickSort(arr, i, right, m);
                right = j;
            }
            m.exitRecursion();
        }
    }
}
