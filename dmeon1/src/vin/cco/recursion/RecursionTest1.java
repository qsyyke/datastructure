package vin.cco.recursion;

/**
 * @author Administrator 程钦义
 * @blog https://blog.cco.vin
 * @date 2021/10/18 20:41
 **/

public class RecursionTest1 {
    public static void main(String[] args) {
        test(3);
    }
    public static void test(int n) {
        if (n > 2) {
            test(n + 1);
        }
    }
}
