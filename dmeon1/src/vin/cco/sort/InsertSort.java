package vin.cco.sort;

import java.util.Arrays;

/**
 * 这是一个插入排序
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/19 22:26
 **/

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2,1,14,7,4,23,10,22,6,4,3,2};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        //insertSort(arr);

    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //使用for循环，进行比较 maxNum为最大值
            int maxNum = arr[i];

            //insertIndex为插入的下标
            int insertIndex = i - 1;

            //使用循环的方式移动下标，当插入的值，小于已排序的最大的一个的时候
            while (insertIndex >= 0 && maxNum < arr[insertIndex]) {
                //已排序的进行移动
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //退出while循环的，可能是insertIndex < 0，也可能是该需插入的数，已经在找到合适的位置了
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = maxNum;
            }
        }
    }

    public static void insertSort1(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
