public class InsertionSort {

    static int swaps = 0;
    static int inversions;

    /**
     * Sorting an array using insertion sort
     * @param array the array to be sorted
     * @return the number of swaps performed during execution
     */
    public static int sort(int[] array){
        printArray(array);
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0 && array[j-1] > array[j]; j--){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                printArray(array);
                swaps++;
            }
        }
        return swaps;
    }

    /**
     * Sorting arrays so that all the negative numbers come first
     * @param array the array to be sorted
     */
    public static void signSort(int[] array){
        for(int i = 1; i < array.length; i++){
            if(array[i] < 0) {
            for(int j = i; j > 0 && array[j - 1] >= 0; j--){
                    printArray(array);
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    swaps++;
                }
            }
        }
    }

    /**
     * Counts the amount of inversions in an array
     * @param array the array to be sorted
     * @return the number of inversions
     */
    public static int countInversions(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
               if(array[i] > array[j]){
                   printInversion(i, j, array[i], array[j]);
                   inversions++;
               }
            }
        }
        return inversions;
    }

    /**
     * Prints the values in the array
     * @param array the array to be printed
     */
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Prints inversions with the given format
     * @param i the position of the first element
     * @param j the position of the second element
     * @param valueI the value of the first element
     * @param valueJ the calue of the second element
     */
    public static void printInversion(int i, int j, int valueI, int valueJ){
        System.out.println("[" + i + ", " + valueI + "] <-> [" + j + ", " + valueJ + "]");
    }

}
