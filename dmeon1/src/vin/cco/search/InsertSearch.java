package vin.cco.search;

/**
 * 这是一个差值查找的代码演示
 *
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/23 19:01
 **/

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int findValue = 10;
        int insertSearch = insertSearch(arr, 0, arr.length - 1, findValue);
        int binarySearch = binarySearch(arr, 0, arr.length - 1, findValue);
        System.out.println("差值查找: " + insertSearch);
        System.out.println("传统二分查找: " + binarySearch);

    }

    public static int insertSearch(int[] arr, int left, int right, int value) {
        System.out.println("----差值查找----");
        if (left > right || value < arr[0] || value > arr[arr.length -1]) {
            //如果需要查找的值，比最小还小或者是比最大还大，那么直接返回
            return -1;
        }

        //这是获取下标
        int middleIndex = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int middleValue = arr[middleIndex];

        if (value > middleValue) {
            //往右边进行查找
            return insertSearch(arr,left + 1,right,value);
        }else if (value < middleValue) {
            //往左边进行查找
            return insertSearch(arr,left,right - 1,value);
        }else {
            //查找到这个值
            return middleIndex;
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {

        System.out.println("----传统二分查找----");
        if (left > right || value < arr[0] || value > arr[arr.length -1]) {
            return -1;
        }

        int middleIndex = (left + right) / 2;
        int middle = arr[middleIndex];

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
