package com.KarthikNimma;


public class MaxHeap {
    int[] heap;
    int current=0;


    public MaxHeap(){
        heap = new int[5];
    }
    public MaxHeap(int n){
        heap = new int[n+1];
    }


    public int parent(int child){
        return (child - 1) / 2;
    }
    public int leftChild(int parent){
        return 2 * parent + 1;
    }
    public int rightChild(int parent){
        return 2 * parent + 2;
    }
// INSERT CHECKS IF THE HEAP IS FULL AND THEN INSERTS A NEW VALUE BY INCREMENTING LOGICAL SIZE OF HEAP
//    INSERTION IS DONE AT THE LEAF AND WE HEAPIFY UP
    public void insert(int v){
        if(current == heap.length){
            System.out.println("Heap is full!");
        }
        heap[current++] = v;
        heapifyUp(current-1);

    }
//    THIS METHOD CONSTANTLY CHECKS IF THE VALUE AT INPUT INDEX IF GREATER THAN IT'S PARENT
//    IF NOT SWAPS IT WITH PARENT
    public void heapifyUp(int i){
        int temp = heap[i];
        while (heap[i] > heap[parent(i)]  && i>0){
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    public void printHeap(){
        System.out.print("Heap: ");
        for(int i=0;i<current;i++){
            System.out.print(heap[i]+" ");
        }
    }
// DELETE SWAPS THE LAST ELEMENT WITH THE INPUT INDEX AND THEN DECREASES THE LOGICAL SIZE

    public void delete(int v){
        heap[v] = heap[current-1];
        current--;
        heapifyDown(v);
        System.out.println("\nDeleted element at index: "+v);
    }

//  HEAPIFY DOWN ENSURES THAT THE CHILD OF EACH PARENT IS SMALLER THAN IT'S PARENT TO RETAIN THE MAXHEAP PROPERTY
    public void heapifyDown(int i){

        while (heap[i] < heap[leftChild(i)] || heap[i] < heap[rightChild(i)]){
            if(leftChild(i) == current || rightChild(i) == current){
                break;
            }

          if(heap[i] < heap[leftChild(i)]){
              int temp = heap[i];
              heap[i] = heap[leftChild(i)];
              heap[leftChild(i)] = temp;
          }
          if(heap[i] < heap[rightChild(i)]){
            int temp = heap[i];
            heap[i] = heap[rightChild(i)];
            heap[rightChild(i)] = temp;
          }
        }

    }
}
