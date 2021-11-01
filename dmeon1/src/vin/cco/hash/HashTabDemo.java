package vin.cco.hash;

import java.util.Scanner;

/**
 * 这是一个哈希表的代码演示
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/11/01 13:12
 **/

public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  a");
            System.out.println("list: l");
            System.out.println("find: f");
            System.out.println("exit: e");

            key = scanner.next();
            switch (key) {
                case "a":
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    EmpNode emp = new EmpNode(name,id);
                    hashTable.add(emp);
                    break;
                case "l":
                    hashTable.show();
                    break;
                case "f":
                    System.out.println("id");
                    id = scanner.nextInt();
                    //hashTable.findEmpById(id);
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

/**
 * 这是一个哈希数组链表
 * */
class HashTable {
    /** 哈希表的最大长度 **/
    public int maxSize;

    /** 这是一个哈希数组 **/
    public EmpLinkList[] empLinkLists;


    public HashTable(int maxSize) {
        this.maxSize = maxSize;
        empLinkLists = new EmpLinkList[maxSize];

        for (int i = 0; i < maxSize; i++) {
            empLinkLists[i] = new EmpLinkList();
        }
    }

    public void add(EmpNode empNode) {
        empLinkLists[hashFun(empNode)].add(empNode);
    }

    public void show() {
        for (int i = 0; i < empLinkLists.length; i++) {
            empLinkLists[i].show(i);
        }
    }

    private int hashFun(EmpNode empNode) {
        return empNode.id % maxSize;
    }
}

/**
 * 这是一个员工数据的节点
 * */
class EmpNode {

    /** 姓名 **/
    public String name;
    public int id;

    /** 指向下一个节点 **/
    public EmpNode next;

    public EmpNode(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

/**
 * 这是一个单链表
 * */
class EmpLinkList {
    /** 这是一个头指针 **/
    public EmpNode head;

    public void add(EmpNode empNode) {
        //向链表中，插入节点
        if (head == null) {
            head = empNode;
            return;
        }

        EmpNode tempNode = head;
        //链表不为空
        while (true) {
            if (tempNode.next == null) {
                break;
            }

            tempNode = tempNode.next;
        }

        //找到最后一个节点
        tempNode.next = empNode;
    }

    public void show(int id) {
        //遍历链表
        EmpNode temNode = head;
        if (temNode == null) {
            System.out.println(id + "号链表为空");
            return;
        }

        while (true) {
            System.out.printf(id + "号链表信息: ");
            System.out.printf("===> {"+ temNode.name + "," + temNode.id +"}");

            if (temNode.next == null) {
                break;
            }
            temNode = temNode.next;
        }

        System.out.println();
    }
}