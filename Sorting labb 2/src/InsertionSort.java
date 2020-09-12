public class InsertionSort {

    static int swaps = 0;
    static int inversions;

    public static int sort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0 && array[j-1] > array[j]; j--){
                //printArray(array);
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                swaps++;
            }
        }
        return swaps;
    }

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

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printInversion(int i, int j, int valueI, int valueJ){
        System.out.println("[" + i + ", " + valueI + "] <-> [" + j + ", " + valueJ + "]");
    }

}
