import java.util.Random;

public class HigherGrade2 {
    static int arraySize = 10; //Number of elements in the array
    static final double MULTIPLE = 1.2; //After every iteration, the array size changes by this much
    static final int RANGE = arraySize; //The values in the array are between 1 and RANGE
    static final int TIMES_SORTED = 100; //How many times to do the tests
    static long startTime1, startTime2, endTime1, endTime2, totalTime1, totalTime2;

    //Comparison between execution times of Quicksort and Mergesort
    public static void compare() {

        Random random = new Random();

        //Do the test and count time
        for (int i = 1; i < TIMES_SORTED + 1; i++) {

            int arr1[] = new int[arraySize];
            int arr2[] = new int[arraySize];

            for (int a = 0; a < arraySize; a++) {
                arr2[a] = arr1[a] = random.nextInt(RANGE) + 1;
            }

            startTime1 = System.nanoTime();
            QuickSort.sort(arr1, false);
            endTime1 = System.nanoTime();
            //QuickSort.printArray(arr1);

            startTime2 = System.nanoTime();
            MergeSort.sort(arr2, 0);
            endTime2 = System.nanoTime();
            //MergeSort.printArray(arr2);

            totalTime1 += endTime1 - startTime1;
            totalTime2 += endTime2 - startTime2;

            System.out.println("Sorting number " + i + ", with array size " + formatBigNumbers(arraySize) + ":");
            System.out.println("QuickSort time: " + formatBigNumbers(endTime1 - startTime1) + " nanoseconds");
            System.out.println("MergeSort time: " + formatBigNumbers(endTime2 - startTime2) + " nanoseconds");
            System.out.println("");
            arraySize *= MULTIPLE;
        }
        System.out.println("QuickSort total time: " + formatBigNumbers(totalTime1) + " nanoseconds");
        System.out.println("MergeSort total time: " + formatBigNumbers(totalTime2) + " nanoseconds");

        if (totalTime1 < totalTime2) {
            System.out.println("QuickSort was faster by " + formatBigNumbers(((totalTime2) - (totalTime1)) / TIMES_SORTED) + " nanoseconds on average");
        } else {
            System.out.println("MergeSort was faster by " + formatBigNumbers(((totalTime1) - (totalTime2)) / TIMES_SORTED) + " nanoseconds on average");
        }
    }

    /**
     * Sorts the elements using insertion sort
     * @param array the array to be sorted
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    /**
     * Makes 1000000 look like 1,000,000
     * @param bigNumber the number to be formatted
     */
    public static StringBuilder formatBigNumbers(long bigNumber) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;

        while (bigNumber > 0) {
            sb.insert(0, bigNumber % 10 );
            bigNumber = bigNumber / 10;
            if(counter == 3){
                sb.insert(0, ",");
                counter = 0;
            }
            counter++;
        }
        if(sb.indexOf(",") == 0) {
            sb.delete(0,1);
        }
        return sb;
    }
}
