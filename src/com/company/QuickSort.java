package com.company;
public class QuickSort {
    public static void quick_sort(int[] arr, int from_Index, int to_Index){
        if(from_Index < to_Index){
            int[] p = partition(arr, from_Index, to_Index);
            //System.out.printf("_ %d %d %d %d \n",from_Index, p, p + 1, to_Index);
            //System.out.println(arr[0]);
            int lt = p[0];
            int gt = p[1];
            //System.out.printf(" %d %d \n", lt, gt);
            quick_sort(arr, from_Index, lt);
            quick_sort(arr, gt + 1, to_Index);
        }
    }
    private static void median_of_three(int[] arr, int from_Index, int to_Index){
        int mid = from_Index + (to_Index - from_Index)/2;
        if(arr[mid] < arr[from_Index]) {
            int tmp = arr[from_Index];
            arr[from_Index] = arr[mid];
            arr[mid] = tmp;
        }
        if (arr[from_Index] < arr[to_Index - 1]){
            int tmp = arr[from_Index];
            arr[from_Index] = arr[to_Index - 1];
            arr[to_Index - 1] = tmp;
        }
        if(arr[mid] < arr[to_Index - 1]){
            int tmp = arr[mid];
            arr[mid] = arr[to_Index - 1];
            arr[to_Index -1] = tmp;
        }
        int tmp = arr[to_Index - 1]; arr[to_Index - 1] = arr[from_Index]; arr[from_Index] = tmp;
    }
    private static int[] partition(int[] arr, int from_Index, int to_Index){
       // System.out.println("this is from index");
        //System.out.println(from_Index);
        median_of_three(arr, from_Index, to_Index);
        int pivot = arr[from_Index];
        int i = from_Index + 1, lt = from_Index + 1, gt = to_Index - 1;
        while(i <= gt){
            if(arr[i] < pivot){
                int tmp = arr[i]; arr[i] = arr[lt]; arr[lt] = tmp;
                lt++; i++;
            }
            else if(arr[i] > pivot){
                //System.out.println(gt);
                int tmp = arr[i]; arr[i] = arr[gt]; arr[gt] = tmp;
                gt--;
            }
            else
                i++;
        }
        lt--;
       // System.out.println("This is lt");
        //System.out.println(lt);
        int tmp = arr[from_Index]; arr[from_Index] = arr[lt]; arr[lt] = tmp;
        int[] output = {lt, gt};

        return output;
    }
}
