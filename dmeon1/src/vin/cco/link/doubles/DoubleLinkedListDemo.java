package vin.cco.link.doubles;

/**
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/17 11:17
 **/

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        //双向链表的增删改查
        HeroNode heroNode1 = new HeroNode("name1",1,"nickName1");
        HeroNode heroNode2 = new HeroNode("name2",2,"nickName2");
        HeroNode heroNode3 = new HeroNode("name3",3,"nickName3");
        HeroNode heroNode4 = new HeroNode("name4",4,"nickName4");
        HeroNode heroNode5 = new HeroNode("name5",5,"nickName5");

        DoubleLink doubleLink = new DoubleLink();

        //增操作
        doubleLink.addNode(heroNode1);
        doubleLink.addNode(heroNode2);
        doubleLink.addNode(heroNode3);
        doubleLink.addNode(heroNode4);

        doubleLink.showSingleLink();

        System.out.println("----------------------------");
        //删除操作
        doubleLink.deleteNode(new HeroNode("nameDel",3,""));

        doubleLink.showSingleLink();

    }
}

