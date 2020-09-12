import java.util.Random;

public class HigherGrade2 {
    static int arraySize = 10;
    static final double MULTIPLE = 1.2;
    static final int RANGE = 1000;
    static final int TIMES_SORTED = 100;
    static long startTime1, startTime2, endTime1, endTime2, totalTime1, totalTime2;

    public static void compare() {

        Random random = new Random();

        //Do the test and count time
        for (int i = 1; i < TIMES_SORTED + 1; i++) {

            int arr1[] = new int[arraySize];
            int arr2[] = new int[arraySize];

            for (int a = 0; a < arraySize; a++) {
                arr2[a] = arr1[a] = random.nextInt(RANGE) + 1;
            }

            startTime1 = System.currentTimeMillis();
            QuickSort.sort(arr1);
            endTime1 = System.currentTimeMillis();

            //QuickSort.printArray(arr1);

            startTime2 = System.currentTimeMillis();
            MergeSort.sort(arr2, 20);
            endTime2 = System.currentTimeMillis();
            //MergeSort.printArray(arr2);

            totalTime1 += endTime1 - startTime1;
            totalTime2 += endTime2 - startTime2;

            System.out.println("Sorting number " + i + ", with array size " + formatBigNumbers(arraySize) + ":");
            System.out.println("QuickSort time: " + (endTime1 - startTime1) + " milliseconds");
            System.out.println("MergeSort time: " + (endTime2 - startTime2) + " milliseconds");
            System.out.println("");
            arraySize *= MULTIPLE;
        }
        System.out.println("QuickSort total time: " + totalTime1 + " miliseconds");
        System.out.println("MergeSort total time: " + totalTime2 + " miliseconds");

        if (totalTime1 < totalTime2) {
            System.out.println("QuickSort was faster by " + (((totalTime2) - (totalTime1))) / TIMES_SORTED + " miliseconds on average");
        } else {
            System.out.println("MergeSort was faster by " + (((totalTime1) - (totalTime2))) / TIMES_SORTED + " miliseconds on average");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static StringBuilder formatBigNumbers(int bigNumber) {
        StringBuilder sb = new StringBuilder();
        int dividedBy = 10;
        int prevNumber = 0;
        int counter = 1;
        while(bigNumber/dividedBy > 0) {
            int numberToPrint = (bigNumber - ((bigNumber / dividedBy) * dividedBy) - prevNumber);
            while(numberToPrint/10 > 0){
                numberToPrint /= 10;
            }
            prevNumber += numberToPrint;
            sb.insert(0, numberToPrint);
            if(counter == 3){
                sb.insert(0, ",");
                counter = 0;
            }
            dividedBy *= 10;
            counter++;
        }
        sb.insert(0, bigNumber/(dividedBy/10));
        return sb;
    }

}
