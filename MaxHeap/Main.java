package com.KarthikNimma;

public class Main {
    public static void main(String[] args) {
	// write your code here
        MaxHeap heap1 = new MaxHeap(10);
        heap1.insert(5);
        heap1.insert(6);
        heap1.insert(10);
        heap1.insert(20);
        heap1.printHeap();

        heap1.delete(0);
        heap1.printHeap();
        int[] array1 = new int[]{1,8,3,6,3,0};
        int[] array2 = new int[]{-1,5,2,0,3,9};

        sort(array1);
        sort(array2);
    }

//    THE BELOW CODE WAS MY ATTEMPT TO USE MAXHEAP CLASS TO SORT THE ARRAY
//    I ASSUMED THAT IF I CAN WRITE A MAX HEAP IN DESCENDING ORDER, I COULD GET A SORTED ARRAY
//    BUT IT TURNED OUT THE ARRAY IS PARTIALLY SORTED
//    I DID A LOT OF IMPROVISATION TO MAKE IT WORK, BUT NO USE
    public static void sort(int[] arr){
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for(int i=0;i<arr.length;i++){
            maxHeap.insert(arr[i]);
        }
        int i =0;
        for (int a = 0;a < maxHeap.current-3;a++){
            if(maxHeap.leftChild(a) < maxHeap.rightChild(a)){
                int temp = maxHeap.heap[maxHeap.leftChild(a)];
                maxHeap.heap[maxHeap.leftChild(a)] = maxHeap.heap[maxHeap.rightChild(a)];
                maxHeap.heap[maxHeap.rightChild(a)] = temp;
            }
        }
        for (int j = maxHeap.current-1; j >= 0; j--){
            arr[i] = maxHeap.heap[j] ;
            i++;
        }
//        Printing elements

        System.out.print("\nSorted Array: ");
        for(int x=0 ;x < arr.length; x++){
            System.out.print(" "+arr[x]);

        }
    }
}
