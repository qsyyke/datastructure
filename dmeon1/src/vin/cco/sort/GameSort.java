package vin.cco.sort;

/**
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/19 21:01
 **/

public class GameSort {
    public static void main(String[] args) {
        int[] randomArr = new int[100000];
        int[] randomArr2 = new int[100000];
        int[] randomArr3 = new int[100000];
        int[] randomArr4 = new int[100000];
        int[] randomArr5 = new int[100000];

        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = (int) (Math.random() * 100000);
            randomArr2[i] = (int) (Math.random() * 100000);
            randomArr3[i] = (int) (Math.random() * 100000);
            randomArr4[i] = (int) (Math.random() * 100000);
            randomArr5[i] = (int) (Math.random() * 100000);
        }

        long startTime = System.currentTimeMillis();
        selectSort(randomArr);
        long endTime = System.currentTimeMillis();

        System.out.println("选择排序时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        sort(randomArr2);
        endTime = System.currentTimeMillis();

        System.out.println("冒泡排序时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        insertSort(randomArr3);
        endTime = System.currentTimeMillis();

        System.out.println("插入排序时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        shell(randomArr4);
        endTime = System.currentTimeMillis();

        System.out.println("希尔交换法时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        shellMove(randomArr5);
        endTime = System.currentTimeMillis();

        System.out.println("希尔移位法时间: " + (endTime - startTime));

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
            arr[insertIndex + 1] = maxNum;
        }
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

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int origin = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = origin;

                    flag = true;
                }
            }

            if (!flag) {
                //一次也进入到for循环中，则直接退出循环，因为数据已经是有效的了
                break;
            }
        }
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
