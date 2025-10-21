import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3, 8, 4);
        List<Integer> sorted = Quicksort.quicksort(numbers);
        System.out.println("Sorted list: " + sorted);

        int[] arr = new int[]{8, 8, 2, 4, 55, 9, 8, 0, 66, 55};
        System.out.println(Arrays.toString(arr));
        Mergesort.mergesort(arr, 0, arr.length - 1);
        System.out.println("Mergesort result: " + Arrays.toString(arr));
    }
}
