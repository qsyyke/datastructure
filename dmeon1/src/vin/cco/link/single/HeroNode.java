package vin.cco.link.single;

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

    public HeroNode(String name, int no, String nickName) {
        this.name = name;
        this.no = no;
        this.nickName = nickName;
    }

    public HeroNode(String name, int no, String nickName, HeroNode next) {
        this.name = name;
        this.no = no;
        this.nickName = nickName;
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "name='" + name + '\'' + ", no=" + no + ", nickName='" + nickName + '\'' + ", next=" + next + '}';
    }

    public String get(String str1,String str2) {
        return str1 + str2;
    }
}
