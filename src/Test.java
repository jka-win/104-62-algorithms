import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        testBubbleSort(new Integer[][] {
                { 4, 1, 3, 9, 7 },
                { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
        });

        testQuickSort(new Integer[][] {
                { 4, 1, 3, 9, 7 },
                { 2, 1, 6, 10, 4, 1, 3, 9, 7 },
        });

        testCountingSort(new String[] {
                "edsab",
                "geeksforgeeks",
        });

        testSearch(new String[][] {
                { "batmanandrobinarebat", "bat" },
                { "abesdu", "edu" },
        });
    }

    private static void testBubbleSort(Integer[][] cases) {
        System.out.println("# Bubble Sort");
        for (Integer[] test : cases) {
            System.out.println("Input:  " + Arrays.toString(test));
            Algorithms.bubbleSort(test);
            System.out.println("Output: " + Arrays.toString(test));
        }
        System.out.println();
    }

    private static void testQuickSort(Integer[][] cases) {
        System.out.println("# Quick Sort");
        for (Integer[] test : cases) {
            System.out.println("Input:  " + Arrays.toString(test));
            Algorithms.quickSort(test);
            System.out.println("Output: " + Arrays.toString(test));
        }
        System.out.println();
    }

    private static void testCountingSort(String[] cases) {
        System.out.println("# Counting Sort");
        for (String test : cases) {
            System.out.println("Input:  " + test);
            String out = Algorithms.countSort(test);
            System.out.println("Output: " + out);
        }
        System.out.println();
    }

    private static void testSearch(String[][] cases) {
        System.out.println("# Search");
        for (String[] test : cases) {
            System.out.println("Input:  " + Arrays.toString(test));
            List<Integer> out = Algorithms.search(test[0], test[1]);
            System.out.println("Output: " + out);
        }
        System.out.println();
    }
}
