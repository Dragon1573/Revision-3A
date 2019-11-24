package io.github.dragon1573;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 最优二叉树算法
 *
 * @author Dragon1573
 * @date 2019/12/24
 */
public class App {
    /**
     * 计算最优二叉树元信息
     *
     * @param a
     *     存取概率分布（找到相应元素）
     * @param b
     *     存取概率分布（确定所在区间）
     * @param m
     *     二叉树最优值矩阵
     * @param s
     *     最优子树矩阵
     * @param w
     *     存取概率求和
     */
    static void optimalBinarySearchTree(
        final double[] a, final double[] b, double[][] m, int[][] s, double[][] w
    ) {
        int n = a.length - 1;
        for (int i = 0; i <= n; ++i) {
            w[i + 1][i] = a[i];
            m[i + 1][i] = 0;
            s[i + 1][i] = 0;
        }
        for (int r = 0; r < n; ++r) {
            for (int i = 1; i <= n - r; ++i) {
                int j = i + r, iMax = Math.max(s[i][j - 1], i),
                    jMax = (s[i + 1][j] > i ? s[i + 1][j] : j);
                w[i][j] = w[i][j - 1] + a[j] + b[j];
                m[i][j] = m[i][iMax - 1] + m[iMax + 1][j];
                s[i][j] = iMax;
                for (int k = iMax + 1; k <= jMax; ++k) {
                    double t = m[i][k - 1] + m[k + 1][j];
                    if (t <= m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
                m[i][j] += w[i][j];
            }
        }
    }

    /**
     * 回溯获得问题解
     *
     * @param s 元信息矩阵
     * @param n 物品数量
     * @param i 区间起点
     * @param j 区间终点
     * @param p 二叉树层索引
     * @param str 子树名称
     */
    static void traceBack(int[][] s, int n, int i, int j, int p, String str) {
        int k = s[i][j];
        if (k > 0) {
            if (p == 0) {
                out.println("The " + str + " node is: " + k);
            } else {
                out.println(str + " subtree of " + p + " is " + k + " and (i:j) is (" + i + ":" + j + ")");
            }
            int t = k - 1;
            if (t >= i && t <= n) {
                traceBack(s, n, i, t, k, "Left");
            }
            t = k + 1;
            if (t <= j) {
                traceBack(s, n, t, j, k, "Right");
            }
        }
    }

    public static void main(String[] args) {
        int n;
        double[] a, b;
        try (Scanner scanner = new Scanner(in)) {
            out.print("请输入元素数量：");
            n = scanner.nextInt();
            a = new double[n];
            out.println("请输入找到相应元素的存取分布概率：");
            for (int i = 0; i < a.length; ++i) {
                a[i] = scanner.nextDouble();
            }
            b = new double[n];
            out.println("请输入确定元素区间的存取概率：");
            for (int i = 0; i < a.length; ++i) {
                b[i] = scanner.nextDouble();
            }
        }
        double[][] m = new double[n + 1][n + 1];
        double[][] w = new double[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        optimalBinarySearchTree(a, b, m, s, w);
        out.println("二叉搜索树的最小平均路长为：" + m[1][n - 1]);
        traceBack(s, n - 1, 1, n - 1, 0, "root");
    }
}
