package com.justtip.backend.exercises;

public class JustSorting {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {10,7,8,9,1,5};
        int n = arr.length;
        System.out.println("UNSorted Array");
        quickSort.printArray(arr,n);
        quickSort.sorting(arr,0,n-1);
        System.out.println("QUICK SORT Array");
        quickSort.printArray(arr,n);

        System.out.println("\n\n");

        MergeSort mergeSort = new MergeSort();
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        System.out.println("UNSorted Array");
        mergeSort.printArray(arr2);
        System.out.println("MERGE-SORT");
        mergeSort.sort(arr2,0,arr2.length - 1);
        mergeSort.printArray(arr2);
    }


}

class MergeSort{
    public void merge(int[] arr, int l, int m, int r){
        // find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy data to temp arrays
        for (int i=0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j=0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // merge the temp arrays
        // initial indexes of first and second subarrays
        int i = 0, j = 0;

        // initial index of merged subarray
        int k = l;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L[] if any
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void sort(int[] arr, int l, int r){
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public void printArray(int[] arr){
        int n = arr.length;
        for (int i=0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}


class QuickSort{

    // swap two components
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int low, int high){
        // start with getting pivot integer
        int pivot = arr[high];

        // index of smaller element and indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++){
            // if current element is smaller than the pivot
            if (arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i + 1, high);
        return (i + 1);
    }

    public void sorting(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr,low,high);
            // separately sort elements before partition and after partition
            sorting(arr,low,pi - 1);
            sorting(arr,pi + 1,high);
        }
    }

    public void printArray(int[] arr, int size){
        for (int i=0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
