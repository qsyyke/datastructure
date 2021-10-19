package vin.cco.link.single;

/**
 * @author 青衫烟雨客 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/09/23 19:49
 **/

public class SingleLinkDemo {
    public static void main(String[] args) {
        //创建四个结点
        HeroNode hero1 = new HeroNode("宋江", 1,"及时雨");
        HeroNode hero4 = new HeroNode("林冲", 4,"豹子头");
        HeroNode hero2 = new HeroNode("卢俊义",3, "玉麒麟");
        HeroNode hero3 = new HeroNode("吴用", 2,"智多星");

        SingleLink singleLink = new SingleLink();
        /*singleLink.addNode(hero1);
        singleLink.addNode(hero2);
        singleLink.addNode(hero3);
        singleLink.addNode(hero4);*/

        singleLink.addOrderBy(hero1);
        singleLink.addOrderBy(hero2);
        singleLink.addOrderBy(hero3);
        singleLink.addOrderBy(hero4);

        singleLink.showSingleLink();

        System.out.println("修改no为3的节点信息");
        // singleLink.updateNode(new HeroNode("qsyyke",5,"chuchen"));

        System.out.println("执行删除no为4的节点信息");
        // singleLink.deleteNode(hero4);
        singleLink.deleteNode(new HeroNode("",5,""));
        singleLink.showSingleLink();
    }
}
