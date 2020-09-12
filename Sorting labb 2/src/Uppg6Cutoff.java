import java.util.Random;

public class Uppg6Cutoff {
    static final int ARRAY_SIZE = 10000000;
    static final int RANGE = 1000;
    static final int TIMES_SORTED = 30;
    static int[] fastestCutoff = new int[TIMES_SORTED];
    static int counter = 0;
    static long startTime, endTime, time, fastestTime = -1;

    public static void compare(){

        int arr1[] = new int[ARRAY_SIZE];
        int arr2[] = new int[ARRAY_SIZE];
        Random random = new Random();
        for(int a = 0; a < ARRAY_SIZE; a++) {
            arr1[a] = random.nextInt(RANGE) + 1;
        }

        //Do the test and count time
        for(int i = 0; i < TIMES_SORTED + 1; i++) {

            for(int a = 0; a < ARRAY_SIZE; a++) {
                arr2[a] = arr1[a];
            }

            startTime = System.currentTimeMillis();
            MergeSort.sort(arr2, i);
            endTime = System.currentTimeMillis();
            //MergeSort.printArray(arr2);

            time = endTime - startTime;
            if(fastestTime == -1 || time < fastestTime){
                fastestTime = time;
                for(int b = 0; b < fastestCutoff.length; b++){ // New fastest time, reset the array
                    fastestCutoff[b] = 0;
                }
                fastestCutoff[0] = i + 1;
                counter = 0; // Reset the counter
            } else if(time == fastestTime){
                fastestCutoff[counter] = i + 1; // We don't know how many values the array should hold so it has the maximum value of the loops (TIMES_SORTED). Therefore it is filled with 0's by default. To diferentiate from when the saved cutoff value is 0 and the default values are 0, we increment the saved value by 1 and decrease it before printing
                counter++;
            }

            System.out.println("Cutoff value " + i + ":");
            System.out.println("Time: " + (endTime - startTime) + " milliseconds");
            System.out.println("");
        }

        System.out.print("Fastest time was " + fastestTime + "ms with cutoff ");
        for(int i = 0; i < fastestCutoff.length; i++){
            if(fastestCutoff[i] != 0){
                System.out.print((fastestCutoff[i] - 1) + " "); // Because the saved value is +1 we decrease it by 1 before printing
            }
        }

    }
}
