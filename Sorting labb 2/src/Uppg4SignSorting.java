import java.util.Random;

public class Uppg4SignSorting {

    public static void signSort() {
        int ARRAY_SIZE = 10;
        int RANGE = 10;
        Random rand = new Random();
        int[] array = new int[ARRAY_SIZE];
        int random;

        //create random array
        for(int i = 0; i < ARRAY_SIZE; i++) {
            random = rand.nextInt(RANGE * 2 + 1) - RANGE; //för tal mellan -10 och +10. 0 till 20 - 10
            array[i] = random;
        }
        InsertionSort.signSort(array);
        InsertionSort.printArray(array);
    }

}
