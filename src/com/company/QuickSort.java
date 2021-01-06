package com.company;

import java.util.Comparator;

public class QuickSort {


    public static <T> void quick_sort_median_three(T[] arr, int from_Index, int to_Index, Comparator<T> cmp){
        quick_sort(arr, from_Index, to_Index, cmp, true, false);
    }
    public static <T> void quick_sort_insertion_sort(T[] arr, int from_Index, int to_Index, Comparator<T> cmp){
        quick_sort(arr, from_Index, to_Index, cmp, false, true);
    }
    public static <T> void quick_sort(T[] arr, int from_Index, int to_Index, Comparator<T> cmp){
        quick_sort(arr, from_Index, to_Index, cmp, true, true);
    }
    public static <T> void quick_sort_dummy(T[] arr, int from_Index, int to_Index, Comparator<T> cmp){
        quick_sort(arr, from_Index, to_Index, cmp, false, false);
    }


    private static <T> void quick_sort(T[] arr, int from_Index, int to_Index, Comparator<T> cmp, boolean median_three, boolean insertion_sort){
        if(from_Index < to_Index){
            if (to_Index - from_Index  < 11 && insertion_sort){
                insertion_sort(arr, from_Index, to_Index, cmp);
            } else if(from_Index < to_Index) {
                int[] p = partition(arr, from_Index, to_Index, cmp, median_three);
                int lt = p[0];
                int gt = p[1];
                quick_sort(arr, from_Index, lt, cmp, median_three, insertion_sort);
                quick_sort(arr, gt + 1, to_Index, cmp, median_three, insertion_sort);
            }
        }
    }
    private static <T> void insertion_sort(T[] arr, int from_Index, int to_Index, Comparator<T> cmp){
        for(int i = from_Index + 1; i < to_Index; i++){
            int j = i - 1;
            while(j >= from_Index && cmp.compare(arr[j], arr[j + 1]) > 0){
                T tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                j--;
            }
        }
    }
    private static <T> void median_of_three(T[] arr, int from_Index, int to_Index, Comparator<T> cmp){
        int mid = from_Index + (to_Index - from_Index)/2;
        if(cmp.compare(arr[mid], arr[from_Index]) < 0) {
            T tmp = arr[from_Index];
            arr[from_Index] = arr[mid];
            arr[mid] = tmp;
        }
        if (cmp.compare(arr[from_Index], arr[to_Index - 1]) > 0){
            T tmp = arr[from_Index];
            arr[from_Index] = arr[to_Index - 1];
            arr[to_Index - 1] = tmp;
        }
        if(cmp.compare(arr[mid], arr[to_Index - 1]) < 0){
            T tmp = arr[mid];
            arr[mid] = arr[to_Index - 1];
            arr[to_Index -1] = tmp;
        }
        T tmp = arr[to_Index - 1]; arr[to_Index - 1] = arr[from_Index]; arr[from_Index] = tmp;
    }
    private static<T> int[] partition(T[] arr, int from_Index, int to_Index, Comparator<T> cmp, boolean median_three){
        if(median_three)
            median_of_three(arr, from_Index, to_Index, cmp);
        T pivot = arr[from_Index];
        int i = from_Index + 1, lt = from_Index + 1, gt = to_Index - 1;
        while(i <= gt){
            if(cmp.compare(arr[i], pivot) < 0){
                T tmp = arr[i]; arr[i] = arr[lt]; arr[lt] = tmp;
                lt++; i++;
            }
            else if(cmp.compare(arr[i], pivot) > 0){
                T tmp = arr[i]; arr[i] = arr[gt]; arr[gt] = tmp;
                gt--;
            }
            else
                i++;
        }
        lt--;
        T tmp = arr[from_Index]; arr[from_Index] = arr[lt]; arr[lt] = tmp;
        int[] output = {lt, gt};

        return output;
    }
}
