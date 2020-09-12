public class MergeSort {

    static int CUTOFF;

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

    public static void sort(int[] arr1, int givenCUTOFF){
        CUTOFF = givenCUTOFF;
        int[] arr2 = new int[arr1.length];
        sortSubArray(arr1, arr2, 0, arr1.length-1);
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

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
