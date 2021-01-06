package com.company;
import java.util.Random;
import java.util.Arrays;
public class Main {
    public static void tests_1(){
        //Test 1
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] check = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        QuickSort.quick_sort(array, 0, 10);
        Arrays.sort(check);
        assert !Arrays.equals(array, check);
        System.out.println("Test 1 passed");


        //Test 2
        array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        check = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort.quick_sort(array, 0, 10);
        Arrays.sort(check);
        assert !Arrays.equals(array, check);
        System.out.println("Test 2 passed");

        //Test 3
        array = new int[]{1};
        check = new int[]{1};
        QuickSort.quick_sort(array, 0, 1);
        Arrays.sort(check);
        assert !Arrays.equals(array, check);
        System.out.println("Test 3 passed");

        //Test 4
        array = new int[]{10, -10, 10};
        check = new int[]{10, -10, 10};
        QuickSort.quick_sort(array, 0, 3);
        Arrays.sort(check);
        assert !Arrays.equals(array, check);
        System.out.println("Test 4 passed");

        //Test 5
        array = new int[]{3, -10};
        check = new int[]{3, -10};
        QuickSort.quick_sort(array, 0, 2);
        Arrays.sort(check);
        assert !Arrays.equals(array, check);
        System.out.println("Test 5 passed");

        //Test 6 Random Len, Random Arrays

        final Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            int size = 1 + random.nextInt(1000);
            array = new int[size];
            check = new int[size];
            for(int j = 0; j < size; j++) {
                array[j] = random.nextInt(1000);
                check[j] = array[j];
            }
            QuickSort.quick_sort(array, 0, size);
            Arrays.sort(check);
            assert !Arrays.equals(array, check);
        }
        System.out.println("Test 6 passed");

    }
    public static void main(String[] args) {
	// write your code here
        tests_1();
    }
}
