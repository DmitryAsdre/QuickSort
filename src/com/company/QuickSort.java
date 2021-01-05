package com.company;
public class QuickSort {
    public static void quick_sort(int[] arr, int from_Index, int to_Index){
        if(from_Index < to_Index){
            int p = partition(arr, from_Index, to_Index);
            //System.out.printf("_ %d %d %d %d _",from_Index, p, p + 1, to_Index);
            //System.out.println(arr[0]);
            quick_sort(arr, from_Index, p);
            quick_sort(arr, p + 1, to_Index);
        }
    }
    private static int partition(int[] arr, int from_Index, int to_Index){
        int pivot = arr[to_Index - 1];
        //System.out.println(pivot);
        int i = from_Index;
        for (int j = from_Index; j < to_Index; j++){
            if(arr[j] < pivot){
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
                i += 1;
            }
        }
        int tmp = arr[i]; arr[i] = arr[to_Index - 1]; arr[to_Index - 1] = tmp;
        //System.out.printf("%d %d", pivot, i);
        return i;
    }
}
