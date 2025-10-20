import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>(List.of(1, 64, 4, 25, 12, 12, 22, 11));

        // Selection sort
        SelectionSort sorter = new SelectionSort();
        List<Integer> sorted = sorter.sort(numbers);

        System.out.println("Original: " + numbers);
        System.out.println("Sorted Selection sort:   " + sorted);

        System.out.println();

        // Bubble sort
        BubbleSort bubble_sorter = new BubbleSort();
        List<Integer> sorted_bubble = bubble_sorter.sort(numbers);

        System.out.println("Original: " + numbers);
        System.out.println("Sorted Bubble sort:   " + sorted_bubble);

        System.out.println();

        // Insertion sort
        InsertionSort insertion_sorter = new InsertionSort();
        List<Integer> sorted_insertion = insertion_sorter.sort(numbers);

        System.out.println("Original: " + numbers);
        System.out.println("Sorted Insertion sort:   " + sorted_insertion);

    }
}