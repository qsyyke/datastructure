package vin.cco.sort;

import java.util.Arrays;

/**
 * 这是一个快速排序的算法实现
 *
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/23 10:37
 **/

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,70};
        System.out.println(Arrays.toString(arr));
        //quickSort(arr);
        quickSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while( l < r) {
            //退出的原因是在左边找到一个数，比基准值大或者相等
            while( arr[l] < pivot) {
                l += 1;
            }

            //退出的原因是在右边找到一个数，比基准值小或者相等
            while(arr[r] > pivot) {
                r -= 1;
            }

            if( l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[l] == pivot) {
                r -= 1;
            }
            if(arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if(left < r) {
            quickSort(arr, left, r);
        }
        if(right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void quickSort(int[] arr) {
        //使用数组中间的一个数作为比较值
        int flagValue = arr[arr.length / 2];

        //flagIndex是当前基准点的下标
        int flagIndex = arr.length / 2;
        for (int j = 0; j < arr.length / 2; j++) {
            if (arr[j] > flagValue) {
                int temp = arr[j];
                //左边的数，大于中间的数
                for (int i = j; i < arr.length / 2; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length /2] = temp;
                //重新设置一个flagIndex
                flagIndex -=1;
            }
        }

        //左边的已经排完了

        for (int j = flagIndex + 1; j > flagIndex; j++) {
            if (j == arr.length) {
                break;
            }
            if (arr[j] < flagValue) {
                int temp = arr[j];
                //右边的数，小于中间的数 基准点右移一个位置
                for (int i = j; i > flagIndex; i--) {
                    arr[i] = arr[i - 1];
                }

                arr[flagIndex] = temp;
            }
        }
    }
}
