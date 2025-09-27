package algorithms;

import java.util.*;

public class ClosestPair {
    public static class Point {
        public double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] points, Metrics m) {
        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
        return closest(points, 0, points.length - 1, m);
    }

    private static double closest(Point[] pts, int left, int right, Metrics m) {
        if (right - left <= 3) return bruteForce(pts, left, right, m);

        m.enterRecursion();
        int mid = (left + right) / 2;
        double d1 = closest(pts, left, mid, m);
        double d2 = closest(pts, mid + 1, right, m);
        double d = Math.min(d1, d2);

        List<Point> strip = new ArrayList<>();
        double midX = pts[mid].x;
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].x - midX) < d) strip.add(pts[i]);
        }
        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                m.addComparison();
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }
        }
        m.exitRecursion();
        return d;
    }

    private static double bruteForce(Point[] pts, int l, int r, Metrics m) {
        double min = Double.MAX_VALUE;
        for (int i = l; i <= r; i++)
            for (int j = i + 1; j <= r; j++) {
                m.addComparison();
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        return min;
    }

    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
