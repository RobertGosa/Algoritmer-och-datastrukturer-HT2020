import java.util.Scanner;

public class HigherGrade1 {

    //Sort the elements in descending order
    public static void invertedSort(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many values should be in the array?");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the values one at a time: ");

        //Store the data as inverter in the array
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt() * -1;
        }

        //Sort the array and print out the right value
        InsertionSort.sort(array);
        System.out.println("Sorted array: ");
        for(int i = 0; i < array.length; i++) {
            array[i] *= -1;
            System.out.print(array[i] + " ");
        }
    }
}
