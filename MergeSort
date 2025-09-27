package algorithms;

public class MergeSort {
    private static final int CUTOFF = 10;

    public static void sort(int[] arr, Metrics m) {
        int[] buffer = new int[arr.length];
        m.addAllocation();
        mergeSort(arr, buffer, 0, arr.length - 1, m);
    }

    private static void mergeSort(int[] arr, int[] buffer, int left, int right, Metrics m) {
        m.enterRecursion();
        if (right - left <= CUTOFF) {
            insertionSort(arr, left, right, m);
            m.exitRecursion();
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, buffer, left, mid, m);
        mergeSort(arr, buffer, mid + 1, right, m);
        merge(arr, buffer, left, mid, right, m);
        m.exitRecursion();
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right, Metrics m) {
        System.arraycopy(arr, left, buffer, left, right - left + 1);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            m.addComparison();
            if (buffer[i] <= buffer[j]) arr[k++] = buffer[i++];
            else arr[k++] = buffer[j++];
        }
        while (i <= mid) arr[k++] = buffer[i++];
    }

    private static void insertionSort(int[] arr, int left, int right, Metrics m) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i], j = i - 1;
            while (j >= left) {
                m.addComparison();
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
    }
}
