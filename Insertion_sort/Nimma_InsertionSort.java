//This program sorts an array using insertion sort


public class Nimma_InsertionSort {
    public static void main(String[] args) {

//        Creating two array variables
        int[] unSortedArr1,unSortedArr2;
        unSortedArr1 = new int[]{3, 6, 1, 9, 0, 5};
        unSortedArr2 = new int[]{4, 1, 0, 34, 8, 2};

        System.out.print("Unsorted Array 1: ");
        printArray(unSortedArr1);
        System.out.print("Sorted Array 1: ");
        printArray(insertionSort(unSortedArr1));

        System.out.println();

        System.out.print("Unsorted Array 2: ");
        printArray(unSortedArr2);
        System.out.print("Sorted Array 2: ");
        printArray(insertionSort(unSortedArr2));
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] insertionSort(int[] unSortedArray) {
        int i,j,key;
        for (i = 1; i < unSortedArray.length; i++) {
            key = unSortedArray[i];
            j = i - 1;

            while (j >= 0 && unSortedArray[j] > key) {
                unSortedArray[j + 1] = unSortedArray[j];
                j = j - 1;
            }
            unSortedArray[j + 1] = key;
        }
        return unSortedArray;
    }
}


