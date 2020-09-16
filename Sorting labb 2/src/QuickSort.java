public class QuickSort {

    static boolean medianOfThree = false; //Is used to decide if the algorithm should use median-of-three or not

    /**
     * sets the medianOfThree value to thegiven on and calls the sortSubArray method
     * @param arr the given array
     * @param MoT a boolean deciding if the algorithm should use median-of-three or not
     */
    public static void sort (int[] arr, boolean MoT){
        medianOfThree = MoT;
        sortSubArray(arr, 0, arr.length - 1 );
    }

    /**
     * Dividing the array into smaller sub arrays and calling the partition method
     * @param arr the array/subarray to sort
     * @param low the starting point
     * @param high the ending point
     */
    public static void sortSubArray(int[] arr, int low, int high){
        if(high <= low){
            return;
        }
        int pivotPosition = partition(arr, low, high);
        sortSubArray(arr, low, pivotPosition - 1);
        sortSubArray(arr, pivotPosition + 1, high);
    }

    /**
     * TODO comment this
     * @param
     * @return
     */
    public static int partition(int[] arr, int low, int high){
        int beginningPointer = low;
        int endPointer = high + 1;
        int pivot;
        if(medianOfThree) {
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
        } else {
            pivot = arr[low];
        }

        while(true){
            while(arr[++beginningPointer] < pivot){
                if(beginningPointer == high){
                    break;
                }
            }

            while(pivot < arr[--endPointer]){
                if(endPointer == low){
                    break;
                }
            }

            if(beginningPointer >= endPointer){
                break;
            }

            int temp = arr[beginningPointer];
            arr[beginningPointer] = arr[endPointer];
            arr[endPointer] = temp;
        }

        int temp = arr[low];
        arr[low] = arr[endPointer];
        arr[endPointer] = temp;

        return endPointer;

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
