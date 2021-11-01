package vin.cco.search;

/**
 * 这是一个二分查找
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/23 16:19
 **/

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8, 10, 16,56,60,87,89};
        int binarySearch = binarySearch(arr, 0, arr.length -1, 11);
        System.out.println(binarySearch);
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        int middleIndex = (left + right) / 2;
        int middle = arr[middleIndex];

        if (left > right) {
            return -1;
        }

        if (value > middle) {
            //在右边进行查找
            return binarySearch(arr, middleIndex + 1,right,value);
        }else if (value < middle) {
            return binarySearch(arr, left,middleIndex - 1,value);
        }else {
            return middleIndex;
        }
    }
}
