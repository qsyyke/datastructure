package vin.cco.sort;

import java.util.Arrays;

/**
 * 这是一个冒泡排序的演示
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/19 13:22
 **/

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {3,9,-1,10,-2};
        //int[] arr = {3,9,12,15,20};

        sort(arr);

        //System.out.println("排序前的数据: " + Arrays.toString(arr));

        long startTime = System.currentTimeMillis();
        int[] randomArr = new int[100000];

        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = (int) (Math.random() * 100000);
        }

        //System.out.println(Arrays.toString(randomArr));

        //sort(randomArr);

        long endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(randomArr));

        System.out.println("排序时间: " + (endTime - startTime));

        //System.out.println("排序后的数据: " + Arrays.toString(arr));

    }

    /*public static void sort(int[] arr,int length) {
        for (int i = 0; i < arr.length - length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                //交换位置
                int origin = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = origin;
            }

            for (int i1 : arr) {
                System.out.printf(i1 + "\t");
            }
            System.out.println();
        }
    }*/
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("第" + (i + 1) + "趟排序");
            boolean flag = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int origin = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = origin;

                    flag = true;
                }
                System.out.printf("(" + (j + 1) + ")" + Arrays.toString(arr));
                System.out.println();
            }
            System.out.println();

            if (!flag) {
                //一次也进入到for循环中，则直接退出循环，因为数据已经是有效的了
                break;
            }
        }
    }
}
