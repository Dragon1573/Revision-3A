package io.github.dragon1573;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 使用二维数组非递归的方法求解0/1背包问题
 *
 * @author 举棋不定ok
 * @author Dragon1573
 */
public class App {
    /**
     * 物品质量（索引从1开始）
     */
    private int[] weight;
    /**
     * 物品价值（索引从1开始）
     */
    private int[] value;
    /**
     * 最大价值矩阵
     */
    private int[][] m;
    /**
     * 物体数量
     */
    private int n;
    /**
     * 最大载荷
     */
    private int c;

    /**
     * @param n
     *     物品数量
     * @param c
     *     最大载荷
     * @param weight
     *     物品质量
     * @param value
     *     物品价值
     */
    App(final int n, final int c, final int[] weight, final int[] value) {
        this.n = n;
        this.c = c;
        this.weight = weight;
        this.value = value;
        this.m = new int[n + 1][c + 1];
    }

    public static void main(String[] args) {
        int n, c;
        int[] weight, values;
        try (Scanner scanner = new Scanner(in)) {
            out.print("请输入物品数量：");
            n = scanner.nextInt();
            out.print("请输入最大载荷：");
            c = scanner.nextInt();
            weight = new int[n + 1];
            out.print("请输入物品质量：");
            for (int i = 1; i <= n; ++i) {
                weight[i] = scanner.nextInt();
            }
            values = new int[n + 1];
            out.print("请输入物品价值：");
            for (int i = 1; i <= n; ++i) {
                values[i] = scanner.nextInt();
            }
        }
        App app = new App(n, c, weight, values);
        out.println("背包最大价值为：" + app.knapsack());
        out.println("背包装载方案为：" + app.traceBack());
    }

    /**
     * 使用非递归方式，求解F[0 .. N][0 .. V]，即for循环从下至上求解
     */
    int knapsack() {
        //对二维数组F进行初始化
        for (int j = 0; j <= c; j++) {
            m[0][j] = 0;
        }

        //注意边界问题，i是从1开始的，j是从0开始的
        //因为F[i - 1][j]中i要减1
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                //如果容量为j的背包放得下第i个物体
                if (j >= weight[i]) {
                    m[i][j] = Math.max(m[i - 1][j - weight[i]] + value[i], m[i - 1][j]);
                } else {
                    //放不下，只能选择不放第i个物体
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        return m[n][c];
    }

    /**
     * 求解F[n][m]这个最优值具体选取哪几样物品能获得最大价值，但只会输出一种情况
     */
    String traceBack() {
        boolean[] isAdd = new boolean[n + 1];
        for (int i = n; i >= 1; i--) {
            if (m[i][c] == m[i - 1][c]) {
                isAdd[i] = false;
            } else {
                isAdd[i] = true;
                c -= weight[i];
            }
        }
        return Arrays.toString(isAdd);
    }
}
