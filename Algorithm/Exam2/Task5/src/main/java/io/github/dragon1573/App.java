package io.github.dragon1573;

import java.util.Scanner;

/**
 * 主类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class App {
    /**
     * 贝尔数
     *
     * @param n
     *     元素数量
     * @param m
     *     划分数量
     *
     * @return {@link java.lang.Integer}
     */
    static int bell(int n, int m) {
        if (m >= n || m == 1) {
            return 1;
        } else {
            return bell(n - 1, m - 1) + m * bell(n - 1, m);
        }
    }

    public static void main(String[] args) {
        int elements, sets;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入元素数量：");
            elements = scanner.nextInt();
            System.out.print("请输入划分数量：");
            sets = scanner.nextInt();
        }
        System.out.println(elements + "个元素的集合可以划分为" + bell(elements, sets) + "个不同的、由" + sets + "个非空子集组成的集合");
    }
}
