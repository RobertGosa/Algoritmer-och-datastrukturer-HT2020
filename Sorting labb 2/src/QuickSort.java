public class QuickSort {

    static boolean medianOfThree = false;

    public static void sort (int[] arr, boolean MoT){
        medianOfThree = MoT;
        sortSubArray(arr, 0, arr.length - 1 );
    }

    public static void sortSubArray(int[] arr, int low, int high){
        if(high <= low){
            return;
        }
        int pivotPosition = partition(arr, low, high);
        sortSubArray(arr, low, pivotPosition - 1);
        sortSubArray(arr, pivotPosition + 1, high);
    }

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

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
