package vin.cco.sort;

import java.util.Arrays;

/**
 * 这是希尔排序的代码实现
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/23 08:50
 **/

public class DonaldShellSort {
    public static void main(String[] args) {

        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shell(arr);
        shellMove(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void shell(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    temp = arr[j];
                    if (arr[j] > arr[j + gap]) {
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                if (arr[i] < arr[i - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
