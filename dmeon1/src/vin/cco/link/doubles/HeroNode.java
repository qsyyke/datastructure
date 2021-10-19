package vin.cco.link.doubles;

/**
 * @author 青衫烟雨客 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/09/23 19:50
 **/

public class HeroNode {
    // 数据域
    public String name;
    public int no;
    public String nickName;

    // 指针域
    public HeroNode next;

    //前一个节点的指针域
    public HeroNode pre;

    public HeroNode(String name, int no, String nickName) {
        this.name = name;
        this.no = no;
        this.nickName = nickName;
    }

    public HeroNode(String name, int no, String nickName, HeroNode next, HeroNode pre) {
        this.name = name;
        this.no = no;
        this.nickName = nickName;
        this.next = next;
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}
