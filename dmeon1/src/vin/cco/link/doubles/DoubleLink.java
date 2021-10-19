package vin.cco.link.doubles;

/**
 * 这是一个单链表
 * @author 青衫烟雨客 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/09/23 19:52
 **/

public class DoubleLink {
    // 这是一个头结点
    private HeroNode head = new HeroNode("",0,"");

    // 向单链表中，添加结点
    public void addNode(HeroNode node) {
        // 因为头结点不能够移动，所以创建一个临时直接，进行判断
        HeroNode tempNode = head;

        while (true) {
            //如果某个结点的直接后继为null，那么直接退出循环，在该结点后加入新节点
            if (tempNode.next == null) {
                break;
            }

            //运行到这里，说明该tempNode的直接后继不为null
            // 重新将tempNode的引用指向原来的tempNode的直接后继
            tempNode = tempNode.next;
        }

        //退出循环，说明该tempNode的直接后继为null，将node加入
        tempNode.next = node;
        node.pre = tempNode;
    }

    // 通过顺序的方式向单链表中插入数据 也就是通过结点的no进行判断的
    public void addOrderBy(HeroNode node) {
        HeroNode tempNode = head;
        // 设置标志点，如果为TRUE，表示该插入节点的no已经在单链表中存在
        boolean flag = false;

        while (true) {
            // 空链表
            if (tempNode.next == null) {
                break;
            }

            // 该tempNode存在直接后继结点
            if (tempNode.next.no > node.no) {
                // 说明node结点的no在tempNode前，位置找到
                break;
            }

            if (tempNode.next.no == node.no) {
                // no编号重合
                flag = true;
            }
            tempNode = tempNode.next;
        }

        if (flag) {
            System.out.println("该预插入节点" + node + "已经存在");
        }else {
            node.next = tempNode.next;
            tempNode.next = node;
        }
    }

    // 更新节点信息，更具no
    public void updateNode(HeroNode node) {
        // 判断链表中是否存在此no
        boolean flag = false;
        HeroNode tempNode = head;
        while (true) {
            // 空链表
            if (tempNode.next == null) {
                break;
            }

            if (tempNode.next.no == node.no) {
                flag = true;
                break;
            }

            tempNode = tempNode.next;
        }

        if (flag) {
            // 得到需要更改的节点信息，也就是tempNode.next
            tempNode.name = node.name;
            tempNode.nickName = node.nickName;

        }

    }

    // 删除某个单链表的信息，也是根据no进行删除
    public void deleteNode(HeroNode node) {
        // 判断是否存在此node，更具no
        boolean flag = false;
        HeroNode tempNode = head;
        while (true) {
            if (tempNode.next == null) {
                break;
            }

            if (tempNode.next.no == node.no) {
                //找到
                flag = true;
                break;
            }

            tempNode = tempNode.next;
        }

        if (flag) {
            tempNode.pre.next = tempNode.next;

            //如果该删除直接是最终一个，那么next就是为null
            if (tempNode.next != null) {
                tempNode.next.pre = tempNode.pre;
            }
        }else {
            System.out.println("未找到该结点: " + node + "的信息");
        }

    }

    // 展示该单链表的数据
    public void showSingleLink() {
        if (head.next == null) {
            System.out.println("该单链表为空");
        }

        HeroNode nextNode = head.next;
        while (true) {
            System.out.println(nextNode);
            if (nextNode.next == null) {
                //到达最后一个节点
                break;
            }
            nextNode = nextNode.next;
        }
    }
}
