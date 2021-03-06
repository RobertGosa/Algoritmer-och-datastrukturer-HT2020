import java.util.Scanner;

public class Uppg2Swaps {

    //Used to sort and array with insertion sort and count the swaps
    public static void swapCounter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many values should be in the array?");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the values one at a time: ");

        for(int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }

        int swaps = InsertionSort.sort(array);
        System.out.println("Sorted array: ");
        InsertionSort.printArray(array);
        System.out.println("Number of swaps: " + swaps);
}

}
