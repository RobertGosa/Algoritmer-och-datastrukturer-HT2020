public class QuickSort {

    public static void sort (int[] arr){
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
        int pivot = arr[low];
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
