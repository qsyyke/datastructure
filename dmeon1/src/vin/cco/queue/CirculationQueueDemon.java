package vin.cco.queue;

import java.util.Scanner;

/**
 * @author 青衫烟雨客 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/09/23 10:15
 **/

public class CirculationQueueDemon {
    public static void main(String[] args) {
        // 因为为了判断方便，会牺牲一个存储空间，所以这里传入的是4，那么有效空间只有3个
        CirculationQueueDemon queue = new CirculationQueueDemon(4);
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
                default:
                    System.out.println("default");
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
    public CirculationQueueDemon(int maxSize) {
        this.maxSize = maxSize;
        front = rear = 0;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        // 队列满的条件尾(rear + 1) % maxSize == front
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        // 为空的条件就是头尾指针相等
        return rear == front;
    }

    public void addQueue(int index) {
        // 向队列中放入数据
        if (isFull()) {
            throw new RuntimeException("队列已经满了...");
        }
        // 队列未满 放入数据 需要设置指针后移
        arr[rear] = index;
        rear = (rear + 1) % maxSize;
    }

    // 出队操作
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        // 队列未空，拿数据
        int value = arr[front];
        arr[front] = 0;
        front = (front + 1) % maxSize;
        return value;
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

        // 有效长度
        int virtualSize = (rear + maxSize - front) % maxSize;
        for (int i = 0; i < front + virtualSize; i++) {
            /*
            * 因为如果数据为0时，其实无效的值，
            * 真正有入队的元素个数为front + (rear + maxSize - front) % maxsize
            * 而i就是front依次往上移动的值，因为front永远小于maxSize，所以就可以通过模运算取出有效值
            * */
            System.out.printf("arr[%d]=%d\n",i % maxSize ,arr[i % maxSize]);
        }
    }
}
