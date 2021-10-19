package vin.cco.link.josephus;

/**
 * 这是一个约瑟夫问题
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/17 13:46
 **/

public class JosephusLinkedDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //circleSingleLinkedList.showNode();

        circleSingleLinkedList.addChild(5);
        circleSingleLinkedList.showNode();

        System.out.println("-----------出圈-----------");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

/**
 * 这是约瑟夫问题的节点操作方法
 * @author qsyyke
 * @blog https://blog.cco.vin
 * @date 2021/10/17
 **/
class CircleSingleLinkedList {
    private Boy firstBoyNode;


    /**
     * @Author qsyyke
     * @Date 2021/10/17
     * @description
     * @param null null
     * @Return null
     **/
    public void addChild(int childNum) {
        //使用循环的方式增加节点
        if (childNum < 1) {
            System.out.println("子节点个数不能为0");
            return;
        }

        Boy tempNode = null;
        //节点个数不为0
        for (int i = 1; i <= childNum; i++) {

            Boy boyNode = new Boy(i);
            if (i == 1) {
                firstBoyNode = boyNode;
                tempNode = firstBoyNode;
            }else {
                tempNode.setNext(boyNode);
                boyNode.setNext(firstBoyNode);
                tempNode = boyNode;
            }
        }
    }


    public void showNode() {
        Boy tempNode = firstBoyNode;

        while (true) {
            if (firstBoyNode == null || tempNode.getNext() == null) {
                System.out.println("节点为空");
                break;
            }

            //节点不为空
            System.out.println("节点id为: " + tempNode.getId());

            //判断是否为最后一个
            if (tempNode.getNext() == firstBoyNode) {
                break;
            }

            tempNode = tempNode.getNext();
        }
    }

    /**
     * @Author qsyyke
     * @Date 2021/10/17
     * @description
     * @param startNum startNum 从哪个位置开始数数
     * @param countNum countNum 一次数几个数
     * @param totalNum totalNum 循环链表的总节点数
     * @Return void
     **/
    public void countBoy(int startNum, int countNum, int totalNum) {

        //判断参数是否合法
        if (startNum > totalNum || firstBoyNode == null || countNum > totalNum) {
            System.out.println("参数不合法");
            return;
        }

        Boy helperNode = firstBoyNode;
        //设置一个帮助指针，最初该帮助指针指向循环链表的最后一个位置，firstBoyNode指向循环链表头
        //开始计数之后，帮助指针和firstBoyNode都需要移动startNum -1个位置

        while (true) {
            if (helperNode.getNext() == firstBoyNode) {
                //在循环链表的最后
                break;
            }

            helperNode = helperNode.getNext();
        }

        //帮助指针和firstBoyNode都移动startNum -1个位置
        for (int i = 0; i < startNum - 1; i++) {
            firstBoyNode = firstBoyNode.getNext();
            helperNode = helperNode.getNext();
        }

        //循环出圈
        while (true) {
            if (helperNode == firstBoyNode) {
                //同一个节点，链表中，只剩下一个节点
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                firstBoyNode = firstBoyNode.getNext();
                helperNode = helperNode.getNext();
            }

            //firstBoyNode移动到需要出圈的节点了

            System.out.println("出圈节点ID = " + firstBoyNode.getId());
            firstBoyNode = firstBoyNode.getNext();
            helperNode.setNext(firstBoyNode);
        }

        //最后一个
        System.out.println("最后一个节点 = " + helperNode.getId());
    }

}


class Boy {
    /** 这是一个孩子节点 **/
    private int id;

    /** 这是孩子节点的写一个节点 **/
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }
}
