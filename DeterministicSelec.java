package algorithms;

import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] arr, int k, Metrics m) {
        return select(arr, 0, arr.length - 1, k, m);
    }

    private static int select(int[] arr, int left, int right, int k, Metrics m) {
        if (left == right) return arr[left];

        m.enterRecursion();
        int pivot = medianOfMedians(arr, left, right, m);
        int pivotIndex = partition(arr, left, right, pivot, m);

        if (k == pivotIndex) { m.exitRecursion(); return arr[k]; }
        else if (k < pivotIndex) {
            int result = select(arr, left, pivotIndex - 1, k, m);
            m.exitRecursion();
            return result;
        } else {
            int result = select(arr, pivotIndex + 1, right, k, m);
            m.exitRecursion();
            return result;
        }
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics m) {
        while (left <= right) {
            while (arr[left] < pivot) { left++; m.addComparison(); }
            while (arr[right] > pivot) { right--; m.addComparison(); }
            if (left <= right) {
                int tmp = arr[left]; arr[left] = arr[right]; arr[right] = tmp;
                left++; right--;
            }
        }
        return left - 1;
    }

    private static int medianOfMedians(int[] arr, int left, int right, Metrics m) {
        if (right - left < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[(left + right) / 2];
        }
        int subRight = left;
        for (int i = left; i <= right; i += 5) {
            int subEnd = Math.min(i + 4, right);
            Arrays.sort(arr, i, subEnd + 1);
            int median = arr[i + (subEnd - i) / 2];
            arr[subRight++] = median;
            m.addComparison();
        }
        return medianOfMedians(arr, left, subRight - 1, m);
    }
}
