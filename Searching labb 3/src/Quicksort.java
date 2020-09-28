public class Quicksort { //TODO fix swap method and comment this
    /**
     * Sort the given arrays
     * @param arr the given array
     * @param arr2 the given array
     */
    public static void sort (Integer[] arr, String[]arr2){
        sortSubArray(arr, arr2, 0, arr.length - 1 );
    }

    /**
     * Dividing the array into smaller sub arrays and calling the partition method
     * @param arr the array/subarray to sort
     * @param low the starting point
     * @param high the ending point
     */
    public static void sortSubArray(Integer[] arr, String[] arr2, int low, int high){
        if(high <= low){
            return;
        }
        int pivotPosition = partition(arr, arr2, low, high);
        sortSubArray(arr, arr2, low, pivotPosition - 1);
        sortSubArray(arr, arr2, pivotPosition + 1, high);
    }

    /**
     * Find the position of the pivot, put all the lower values to the left and higher to the right
     * @param arr the array to be sorted
     * @param low the starting point
     * @param high the ending point
     * @return
     */
    public static int partition(Integer[] arr, String[] arr2, int low, int high){
        int beginningPointer = low;
        int endPointer = high + 1;
        int pivot;

            int middle = (low + high) / 2;
            if (arr[middle] < arr[low] && arr[middle] > arr[high] || arr[middle] > arr[low] && arr[middle] < arr[high]) {
                pivot = arr[middle];
                int temp = arr[low];
                arr[low] = arr[middle];
                arr[middle] = temp;
            } else if (arr[high] < arr[low] && arr[high] > arr[middle] || arr[high] > arr[low] && arr[high] < arr[middle]) {
                pivot = arr[high];
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            } else {
                pivot = arr[low];
            }

        while(true){
            while(arr[++beginningPointer] < pivot){ //if the value is smaller than the pivot, increment the pointer and check if it came to the end of the array
                if(beginningPointer == high){
                    break;
                }
            }

            while(pivot < arr[--endPointer]){ //if the povot is smaller, move the pointer towards the beginning until it reaches the first position
                if(endPointer == low){
                    break;
                }
            }

            if(beginningPointer >= endPointer){ //if the pointers cross, break
                break;
            }

            swap(arr, arr2, beginningPointer, endPointer);
        }

        swap(arr, arr2, low, endPointer);

        return endPointer; //return the position where the pivot will be when the whole array is sorted

    }

    private static void swap(Integer[] a, String []b, int i, int j) {
        int swap = a[i];
        String swapb = b[i];

        a[i] = a[j];
        a[j] = swap;

        b[i] = b[j];
        b[j] = swapb;
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

}
