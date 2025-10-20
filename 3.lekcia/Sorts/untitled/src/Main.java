import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3, 8, 4);
        List<Integer> sorted = Quicksort.quicksort(numbers);
        System.out.println("Sorted list: " + sorted);
    }
}
