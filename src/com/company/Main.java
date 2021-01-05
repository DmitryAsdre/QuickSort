package com.company;
import java.util.Random;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
	// write your code here
        int size = 21;
        int[] array = new int[size];
        int[] check = new int[size];
        final Random random = new Random();
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            check[i] = array[i];
        }

        System.out.println(Arrays.toString(array));
        QuickSort.quick_sort(array, 0, size);
        System.out.println(Arrays.toString(array));
        Arrays.sort(check);
        System.out.println(Arrays.toString(check));
    }
}
