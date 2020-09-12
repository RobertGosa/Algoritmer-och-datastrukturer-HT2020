import java.util.Scanner;

public class Uppg3Inversions {

    public static void inversionCounter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many values should be in the array?");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the values one at a time: ");

        for(int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }

        int inversions = InsertionSort.countInversions(array);
        System.out.println("Number of inversions: " + inversions);
        int swaps = InsertionSort.sort(array);
        System.out.println("Sorted array: ");
        InsertionSort.printArray(array);
        System.out.println("Number of swaps: " + swaps);
    }
}
