import java.util.Scanner;

public class HigherGrade1 {

    public static void invertedSort(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many values should be in the array?");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the values one at a time: ");

        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt() * -1;
        }

        InsertionSort.sort(array);
        System.out.println("Sorted array: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] * -1 + " ");
        }
    }
}