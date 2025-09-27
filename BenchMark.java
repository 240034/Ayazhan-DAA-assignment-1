package app;

import algorithms.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchMark {
    private static final Random rand = new Random();

    private static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(1_000_000);
        return arr;
    }

    public static void main(String[] args) {
        String file = "metrics.csv"; // файл для записи результатов
        try (FileWriter out = new FileWriter(file)) {
            out.write("algo,n,timeNs,comparisons,allocations,maxDepth\n");

            int[] sizes = {100, 500, 1000, 5000, 10000, 20000};

            for (int n : sizes) {
                int[] arr;

                // MergeSort
                arr = randomArray(n);
                Metrics m = new Metrics();
                long t1 = System.nanoTime();
                MergeSort.sort(arr, m);
                long t2 = System.nanoTime();
                out.write("MergeSort," + n + "," + (t2 - t1) + "," +
                        m.comparisons + "," + m.allocations + "," + m.maxRecursionDepth + "\n");

                // QuickSort
                arr = randomArray(n);
                m.reset();
                t1 = System.nanoTime();
                QuickSort.sort(arr, m);
                t2 = System.nanoTime();
                out.write("QuickSort," + n + "," + (t2 - t1) + "," +
                        m.comparisons + "," + m.allocations + "," + m.maxRecursionDepth + "\n");

                // Select (k = n/2)
                arr = randomArray(n);
                m.reset();
                t1 = System.nanoTime();
                DeterministicSelect.select(arr, n / 2, m);
                t2 = System.nanoTime();
                out.write("Select," + n + "," + (t2 - t1) + "," +
                        m.comparisons + "," + m.allocations + "," + m.maxRecursionDepth + "\n");

                // Closest Pair
                ClosestPair.Point[] pts = new ClosestPair.Point[n];
                for (int i = 0; i < n; i++) {
                    pts[i] = new ClosestPair.Point(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
                }
                m.reset();
                t1 = System.nanoTime();
                double d = ClosestPair.closestPair(pts, m);
                t2 = System.nanoTime();
                out.write("ClosestPair," + n + "," + (t2 - t1) + "," +
                        m.comparisons + "," + m.allocations + "," + m.maxRecursionDepth + "\n");
            }

            System.out.println("✅ Metrics saved to " + file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
