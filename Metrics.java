package algorithms;

public class Metrics {
    public long comparisons = 0;
    public long allocations = 0;
    public long maxRecursionDepth = 0;

    private long currentDepth = 0;

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxRecursionDepth) {
            maxRecursionDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public void addComparison() {
        comparisons++;
    }

    public void addAllocation() {
        allocations++;
    }

    public void reset() {
        comparisons = 0;
        allocations = 0;
        maxRecursionDepth = 0;
        currentDepth = 0;
    }

    @Override
    public String toString() {
        return "comparisons=" + comparisons +
                ", allocations=" + allocations +
                ", maxDepth=" + maxRecursionDepth;
    }
}
