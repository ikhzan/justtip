package com.justtip.backend.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeapSearch {

    public static void main(String[] args) {
        System.out.println("the max heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is "
                            + maxHeap.extractMax());

        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort heapSort = new HeapSort();
        System.out.println("NOT Sorted array is");
        heapSort.print(arr);

        heapSort.sort(arr);
        System.out.println("Sorted array is");
        heapSort.print(arr);

        System.out.println("Find 3 largest integer in array");
        Integer[] kArr = new Integer[] {1,23,12,20,2,50,9};
        int k = 3;
        kLargest(kArr,k);


        int[] prim_array = {1,23,12,20,2,50,9};
        System.out.println(kLargest(prim_array,k));

    }

    // K largest elements in an array
    public static void kLargest(Integer[] arr, int k){
        // sort the given array arr in reverse order
        // the method doesn't work primitive data
        // so instead of int, integer type array will be used
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static ArrayList<Integer> kLargest(int[] arr, int k){
        // convert using stream
        Integer[] obj_array = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        Arrays.sort(obj_array, Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>(k);

        for (int i = 0; i < k; i++)
            list.add(obj_array[i]);

        return list;
    }
}

class HeapSort{

    public void sort(int[] arr){
        int n = arr.length;

        // build heap (rearrange array)
        for (int i=n/2-1; i>=0; i--){
            heapify(arr,n,i);
        }

        // one by one extract an element from heap
        for (int i = n - 1; i>0; i--){
            // move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // left
        int r = 2 * i + 2; // right

        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }

        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // recursively heapify the affected
            heapify(arr,n,largest);
        }
    }

    public void print(int[] arr){
        int n = arr.length;
        for (int i=0; i < n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class MaxHeap{
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    // return position of parent
    private int parent(int pos){return pos / 2;}

    // return left and right children
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }
    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    // return tru if given node is leaf
    private boolean isLeaf(int pos){
        if (pos > (size / 2) && pos <= size){
            return true;
        }
        return false;
    }

    // swap
    private void swap(int fpos, int spos){
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // recursive function to max heapify  the given subtree
    // this function assumes that the left and right subtrees are already heapified,
    // to fix the root
    private void maxHeapify(int pos){
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
            || Heap[pos] < Heap[rightChild(pos)]){

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                swap(pos,leftChild(pos));
                maxHeapify(leftChild(pos));
            }else{
                swap(pos,rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // insert a new element to max heap
    public void insert(int element){
        Heap[++size] = element;
        // traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    // to print
    public void print(){
        for (int i = 1; i <= size / 2; i++ ){
            System.out.print(
                    "   PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD : " + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int extractMax(){
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

}
