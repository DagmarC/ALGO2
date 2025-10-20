import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public List<Integer> sort(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<Integer>(numbers);

        for (int i = 0; i < sorted.size(); i++) {
            int swaps = 0;
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j) > sorted.get(j + 1)) {
                    Collections.swap(sorted, j, j + 1);
                    swaps++;
                }
            }
            if (swaps == 0) {
                break; // array is already sorted - no swap was needed
            }
        }
        return sorted;
    }
}
