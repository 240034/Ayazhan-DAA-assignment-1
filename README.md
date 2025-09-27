# Assignment 1

##  Overview
This project implements classic divide-and-conquer algorithms with safe recursion patterns and metrics collection.

Algorithms implemented:
- **MergeSort** (with cutoff for small arrays and reusable buffer),
- **QuickSort** (randomized pivot, recurse on smaller side),
- **Deterministic Select** (Median of Medians),
- **Closest Pair of Points in 2D** (O(n log n)).

Metrics include:
- number of comparisons,
- allocations,
- maximum recursion depth,
- execution time.

# Recurrence Analysis

MergeSort:
T(n) = 2T(n/2) + O(n) → O(n log n) 
QuickSort:
T(n) = T(k) + T(n−k−1) + O(n).
Average case: O(n log n)
Worst case: O(n²)
Deterministic Select:
T(n) = T(7n/10) + O(n) → O(n).
Closest Pair:
T(n) = 2T(n/2) + O(n) → O(n log n).

# Conclusion

Experimental measurements confirm the theoretical asymptotics.
Observed recursion depths match expected O(log n).
Constant-factor effects influence performance on small inputs.
