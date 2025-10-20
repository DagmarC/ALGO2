import java.util.ArrayList;
import java.util.List;

public class Quicksort {

    public static List<Integer> quicksort(List<Integer> arr) {
        // Base case: empty or one element
        if (arr.size() <= 1) {
            return arr;
        }

        // Choose a pivot (middle element for balance)
        int pivotIndex = arr.size() / 2;
        int pivot = arr.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition
        for (int i = 0; i < arr.size(); i++) {
            if (i == pivotIndex) continue; // skip pivot
            int val = arr.get(i);
            if (val < pivot) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        // Recursively sort left and right
        List<Integer> sorted = new ArrayList<>();

        sorted.addAll(quicksort(left));
        sorted.add(pivot);
        sorted.addAll(quicksort(right));

        return sorted;
    }
}