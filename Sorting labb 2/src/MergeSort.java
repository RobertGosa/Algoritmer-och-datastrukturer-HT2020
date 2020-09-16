public class MergeSort {

    static int CUTOFF; //The value when the Mergesort cuts off to insertion sort

    /**
     * Merge two arrays back in order
     * @param arr1 the first array
     * @param arr2 the second array
     * @param low the lowest position
     * @param mid the position in the middle
     * @param high the highest position
     */
    public static void merge(int[] arr1, int[] arr2, int low, int mid, int high){
        for(int k = low; k <= high; k++) {
            arr2[k] = arr1[k];
        }

        int i = low, j = mid + 1;
        for(int k = low; k <= high; k++){
            if(i > mid ){
                arr1[k] = arr2[j++];
            } else if (j > high){
                arr1[k] = arr2[i++];
            } else if (arr2[j] < arr2[i]) {
                arr1[k] = arr2[j++];
            } else {
                arr1[k] = arr2[i++];
            }
        }
    }

    /**
     * Divide the array into smaller sub arrays and call merge
     * @param arr1 the first array
     *  @param arr2 the second array
     *  @param low the lowest position
     *  @param high the highest position
     */
    public static void sortSubArray(int[] arr1, int[] arr2, int low, int high){
        if (high <= low + CUTOFF) { // Low = start High = end.
            insertionSort(arr1, low, high);
        return;
        }
            int mid = low + (high - low) / 2; // 0 + (8-0)/2 = 4 --- 5(which is mid + 1) + (8-5)/2 = 6 --- 6 is the mid of 5-8
            sortSubArray(arr1, arr2, low, mid);
            sortSubArray(arr1, arr2, mid + 1, high);
            merge(arr1, arr2, low, mid ,high);
        }

    /**
     * Creates a new array and calls the sortSubArray method
     * @param arr1 the given array
     * @param givenCUTOFF jump to insertionsort when the array reaches this size
     */
    public static void sort(int[] arr1, int givenCUTOFF){
        CUTOFF = givenCUTOFF;
        int[] arr2 = new int[arr1.length];
        sortSubArray(arr1, arr2, 0, arr1.length-1);
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
     * Sorting an array using insertion sort
     * @param arr the array to be sorted
     * @param start the starting position
     * @param end the ending position
     */
    public static void insertionSort(int[] arr, int start, int end){
        for (int i = start; i <= end; i++) {
            for (int j = i; j > start && j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

}
