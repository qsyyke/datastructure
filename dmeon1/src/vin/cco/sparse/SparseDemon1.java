package vin.cco.sparse;

/**
 * @author 青衫烟雨客 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/09/22 21:28
 **/

public class SparseDemon1 {

    public static void main(String[] args) {
        //这是一个稀疏数组的测试
        int[][] sparseArr1 = new int[11][11];
        sparseArr1[1][6] = 1;
        sparseArr1[3][2] = 2;
        int allDataNum = 0;

        for (int[] chars : sparseArr1) {
            for (int data : chars) {
                // data是每一个元素
                if (data != 0) {
                    allDataNum += 1;
                }
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转换成稀疏数组
        System.out.println("allDataNum = " + allDataNum);
        int[][] sparseArr2 = new int[allDataNum + 1][3];

        sparseArr2[0][0] = sparseArr1.length;
        sparseArr2[0][1] = sparseArr1[0].length;
        sparseArr2[0][2] = allDataNum;
        
        //依次去除二维数组中的有效值放入稀疏数组中
        int count = 0;
        for (int i = 0; i < sparseArr1.length; i++) {
            for (int j = 0; j < sparseArr1[i].length; j++) {
                int data = sparseArr1[i][j];
                if (data != 0) {
                    // 是真实值 将其放入稀疏数组中

                    // 设置行数据
                    sparseArr2[count + 1][0] = i;
                    // 设置列数据
                    sparseArr2[count + 1][1] = j;

                    // 设置值
                    sparseArr2[count + 1][2] = data;

                    //保存完成一个数据，count加1
                    count +=1;
                }
            }
        }

        System.out.println("---------------输出稀疏数组-------------");
        for (int[] ints : sparseArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        System.out.println("----------------将稀疏数组转换成二维数组-------------");
        int[][] spareArr3 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        /*for (int i = 0; i < spareArr3.length; i++) {
            for (int j = 0; j < spareArr3[i].length; j++) {
                for (int k = 0; k < sparseArr2.length; k++) {
                    if (i == sparseArr2[k][0] && j == sparseArr2[k][1]) {
                        // 新二维数组的下标和稀疏数组的0号位下标一样
                        spareArr3[i][j] = sparseArr2[k][2];
                    }
                }
            }
        }*/

        for (int i = 1; i < sparseArr2.length; i++) {
            // 获取稀疏数组中，每一行的行列值，赋值给arr3
            spareArr3[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        for (int[] chars : spareArr3) {
            for (int data : chars) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
