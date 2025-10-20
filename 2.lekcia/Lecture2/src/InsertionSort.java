import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public List<Integer> sort(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);

        // 1st element at index 0 is trivially sorted -> start from the 2nd element
        for (int i = 1; i < numbers.size(); i++) {
            int j = i - 1;
            int element_to_insert = numbers.get(i);

            while (j > 0 && element_to_insert < sorted.get(j)) {
                sorted.set(j + 1, sorted.get(j)); // copy the elements that are greater than the element being inserted
                j--;
            }
            // Insert the element at the correct position j+1, since j-- was performed and the condition checked afterwards
            sorted.set(j+1, element_to_insert);
        }
        return sorted;
    }
}
