import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sorts a list of integers in ascending order using selection sort.
 * Returns a new sorted list, leaving the original list unchanged.
 * Algorithm is not stable.
 * Time: O(nˆ2)
 * Space: O(1) -> in place algorithm
 */
public class SelectionSort {

    public List<Integer> sort(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers); // ensures mutability

        for(int i = 0; i < sorted.size() - 1; i++) {
            int current_min_index = i;

            for(int j = i + 1; j < sorted.size(); j++) {
                if(sorted.get(j) < sorted.get(current_min_index)) {
                    current_min_index = j;
                }
            }
            // Swap only if needed
            if (current_min_index != i) {
                Collections.swap(sorted, i, current_min_index);
            }
        }
        return sorted;
    }
}
/**
 * Given a list of n elements:
 *
 * Start from the first element (index i = 0).
 *
 * Find the smallest element in the unsorted part (i … n-1).
 *
 * Swap it with the element at position i.
 *
 * Move the boundary between sorted and unsorted part one step forward (i++).
 *
 * Repeat until the entire list is sorted.
 * */