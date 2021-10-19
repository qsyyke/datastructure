package vin.cco.queue;

import java.util.Scanner;

/**
 * @author 青衫烟雨客 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/09/23 10:15
 **/

public class ArrayQueueDemon {
    public static void main(String[] args) {
        ArrayQueueDemon queue = new ArrayQueueDemon(3);
        boolean status = true;
        Scanner scanner = new Scanner(System.in);

        while (status) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // 接收一个字符
            char charAt = scanner.next().charAt(0);
            switch (charAt) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    status = false;
                    break;
                case 'a':
                    int nextInt = scanner.nextInt();
                    try {
                        queue.addQueue(nextInt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    try {
                        int queueValue = queue.getQueue();
                        System.out.println("取出的数据为: " + queueValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int headQueue = queue.headQueue();
                        System.out.println("队列头的数据为 = " + headQueue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    /** 数组的最大容量 **/
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 模拟队列，是一个数组
    private int[] arr;

    /*
    * 初始化队列
    * 头指针和尾指针都是初始值-1
    * */
    public ArrayQueueDemon(int maxSize) {
        this.maxSize = maxSize;
        front = rear = -1;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        // 如果尾指针的值为最大值减一，那么就表示队列满了
        return rear == maxSize -1;
    }
    public boolean isEmpty() {
        // 为空的时候，头指针和尾指针相等，也就是等于-1
        return rear == front;
    }

    public void addQueue(int index) {
        // 向队列中放入数据
        if (isFull()) {
            throw new RuntimeException("队列已经满了...");
        }
        // 队列未满 放入数据 需要设置指针后移
        rear++;
        arr[rear] = index;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        // 队列未空，拿数据
        front++;
        return arr[front];
    }

    // 展示头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        return arr[rear];
    }

    // 遍历队列中的元素
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i ,arr[i]);
        }
    }
}
