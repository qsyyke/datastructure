package vin.cco.stack;

import java.util.Scanner;

/**
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/17 22:37
 **/

public class StackDemo {
    public static void main(String[] args) {
        StackArray stack = new StackArray(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 遍历");
            System.out.println("exit: 退出");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");

            key = scanner.next();

            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请放入一个数字");
                    int value = scanner.nextInt();
                    try {
                        stack.push(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈数字为 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("已经退出");
    }

}

class StackArray {
    private int stackMaxSize;

    private int[] stack;
    private int top = -1;

    public StackArray(int stackMaxSize) {
        this.stackMaxSize = stackMaxSize;
        stack = new int[stackMaxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        // 如果top值和stackMaxSize - 1相等，那么就是栈满
        return stackMaxSize -1 == top;
    }

    public void push(int value) {
        if (stack == null || isFull()) {
            throw new RuntimeException("栈为空或者是栈已经满了");
        }

        //栈不空
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty() || stack == null) {
            throw new RuntimeException("栈为空");
        }

        int value = stack[top];
        top --;
        return value;
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
