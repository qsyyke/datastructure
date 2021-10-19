package vin.cco.recursion;

/**
 * 这是一个迷宫问题的解法
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/18 21:01
 **/

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("初始化的地图");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map,1,1);

        System.out.println("最后的地图");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *  i,j都是从哪个位置开始走，最初从[1][1]的位置开始走
     *  如果小球能到[6][5]位置，说明通过可以找到
     *  约定：当map[i][j]为0表示该点没有走过(默认值),当为1时，表示是墙，2表示通路可以走，3表示该点已经走过，
     *  但是走不通，
     *  在走迷宫时，需要确定一个策略，下右上左，如果该点走不通，再回溯
     *
     * @param map map 地图
     * @param i i i和j都是一个坐标，表示从哪个位置开始走
     * @param j j
     * @Return boolean 如果找到路，返回TRUE，否则返回FALSE
     **/
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //找到路了
            return true;
        }else {
            if (map[i][j] == 0) {
                //可以走 使用策略的方式
                map[i][j] = 2;
                if (setWay(map,i + 1,j)) {
                    return true;
                }else if (setWay(map, i, j + 1)) {
                    return true;
                }else if(setWay(map,i - 1, j)) {
                    return true;
                }else if (setWay(map,i,j - 1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
