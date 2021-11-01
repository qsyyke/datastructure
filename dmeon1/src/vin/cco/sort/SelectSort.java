package vin.cco.sort;

import java.util.Arrays;

/**
 * 这是一个选择排序的demo
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/19 15:10
 **/

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101,34,341,345,5678932,456562,1,145,2,678,19,1};
        selectSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //范围内最小的一个数
            int small = arr[i];
            int index = i;
            //获取最小的一个数
            for (int j = i; j < arr.length; j++) {
                if (small > arr[j]) {
                    small = arr[j];
                    index = j;
                }
            }
            int origin = arr[i];
            arr[i] = small;
            arr[index] = origin;
        }
    }
}
