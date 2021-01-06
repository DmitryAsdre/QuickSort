package com.company;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Random;
import java.util.Arrays;
import java.lang.AssertionError;
public class Main {
    public static void tests_1(){

        //Test 1
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] check = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        QuickSort.quick_sort(array, 0, 10, new IntComparator());
        Arrays.sort(check);
        assert Arrays.equals(array, check) : "Test 1 failed";
        System.out.println("Test 1 passed");


        //Test 2
        array = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        check = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort.quick_sort(array, 0, 10, new IntComparator());
        Arrays.sort(check);
        assert Arrays.equals(array, check) : "Test 2 failed";
        System.out.println("Test 2 passed");

        //Test 3
        array = new Integer[]{1};
        check = new Integer[]{1};
        QuickSort.quick_sort(array, 0, 1, new IntComparator());
        Arrays.sort(check);
        assert Arrays.equals(array, check) : "Test 3 failed";
        System.out.println("Test 3 passed");

        //Test 4
        array = new Integer[]{10, -10, 10};
        check = new Integer[]{10, -10, 10};
        QuickSort.quick_sort(array, 0, 3, new IntComparator());
        Arrays.sort(check);
        assert Arrays.equals(array, check) : "Test 4 failed";
        System.out.println("Test 4 passed");

        //Test 5
        array = new Integer[]{3, -10};
        check = new Integer[]{3, -10};
        QuickSort.quick_sort(array, 0, 2, new IntComparator());
        Arrays.sort(check);
        assert Arrays.equals(array, check) : "Test 5 failed";
        System.out.println("Test 5 passed");

        //Test 6 Random Len, Random Arrays

        final Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            int size = 1 + random.nextInt(1000);
            array = new Integer[size];
            check = new Integer[size];
            for(int j = 0; j < size; j++) {
                array[j] = random.nextInt(1000);
                check[j] = array[j];
            }
            QuickSort.quick_sort(array, 0, size, new IntComparator());
            Arrays.sort(check);
            assert Arrays.equals(array, check) : "Test 6 failed";
        }
        System.out.println("Test 6 passed");
    }

    public static void insertion_median_test(){
        final Random random = new Random();

        // Test Sorted Array
        Integer[] array = new Integer[1000];
        IntComparator cmp = new IntComparator();
        for(int i = 0; i < 1000; i++){
            array[i] = i;
        }
        System.out.println("For sorted array");
        cmp.setZero();
        QuickSort.quick_sort_median_three(Arrays.copyOf(array, 1000), 0, 1000, cmp);
        System.out.printf("With median three %d; ", cmp.getCounter());
        cmp.setZero();
        QuickSort.quick_sort_insertion_sort(Arrays.copyOf(array, 1000), 0, 1000, cmp);
        System.out.printf("With insertion sort %d; ", cmp.getCounter());
        cmp.setZero();
        QuickSort.quick_sort_dummy(Arrays.copyOf(array, 1000), 0, 1000, cmp);
        System.out.printf("Dummy realization %d; ", cmp.getCounter());
        cmp.setZero();
        Arrays.sort(Arrays.copyOf(array, 1000), cmp);
        System.out.printf("Java realization %d; ", cmp.getCounter());
        cmp.setZero();
        QuickSort.quick_sort(Arrays.copyOf(array, 1000), 0, 1000, cmp);
        System.out.printf("QuickSort median_three and insertion sort %d; \n", cmp.getCounter());

        //Random arrays
        double quick_sort=0.0,quick_sort_median_three=0.0, quick_sort_insertion_sort=0.0, quick_sort_dummy=0.0, java_sort=0.0;
        for(int i = 0; i < 10000; i++){
            for(int j = 0; j < 1000; j++){
                array[j] = random.nextInt(1000);
            }
            cmp.setZero();
            QuickSort.quick_sort_median_three(Arrays.copyOf(array, 1000), 0, 1000, cmp);
            quick_sort_median_three += cmp.getCounter();
            cmp.setZero();
            QuickSort.quick_sort_insertion_sort(Arrays.copyOf(array, 1000), 0, 1000, cmp);
            quick_sort_insertion_sort += cmp.getCounter();
            cmp.setZero();
            QuickSort.quick_sort_dummy(Arrays.copyOf(array, 1000), 0, 1000, cmp);
            quick_sort_dummy += cmp.getCounter();
            cmp.setZero();
            Arrays.sort(Arrays.copyOf(array, 1000), cmp);
            java_sort += cmp.getCounter();
            cmp.setZero();
            QuickSort.quick_sort(Arrays.copyOf(array, 1000), 0, 1000, cmp);
            quick_sort += cmp.getCounter();
        }
        System.out.println("Mean for 10000 runs with random arrays:");
        System.out.printf("With median three %f; ", quick_sort_median_three/10000);
        System.out.printf("With insertion sort %f; ", quick_sort_insertion_sort/10000);
        System.out.printf("Dummy realization %f; ", quick_sort_dummy/10000);
        System.out.printf("Java realiztion  %f; ", java_sort/10000);
        System.out.printf("QuickSort median_three and insertion sort %f; ", quick_sort/10000);

    }
    public static void main(String[] args) {
        //Tests
        tests_1();
        insertion_median_test();
    }
}
