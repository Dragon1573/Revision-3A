package io.github.dragon1573;

import java.util.Scanner;

/**
 * 矩阵连乘问题
 *
 * @author Dragon1573
 * @date 2019/11/22
 */
public class App {
    /**
     * 动态规划求最优完全加括号
     *
     * @param p
     *     矩阵维度链
     * @param m
     *     最优值数组
     * @param s
     *     最优断开位置数组
     */
    static void matrixChain(int[] p, int[][] m, int[][] s) {
        // 连乘矩阵数量
        int n = p.length - 1;
        // 初始化最优值矩阵
        for (int i = 1; i <= n; ++i) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; ++r) {
            for (int i = 1; i <= n - r + 1; ++i) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; ++k) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    /**
     * 根据断点矩阵获得最佳计算次序
     *
     * @param s
     *     断点矩阵
     * @param i
     *     起始矩阵
     * @param j
     *     终点矩阵
     */
    static String traceBack(int[][] s, int i, int j) {
        if (i == j) {
            return "A" + i;
        }
        String part1 = traceBack(s, i, s[i][j]);
        String part2 = traceBack(s, s[i][j] + 1, j);
        System.out.println("Multiply A(" + i + ", " + s[i][j] + ") and A(" + (s[i][j] + 1) + ", " + j + ")");
        return "(" + part1 + part2 + ")";
    }

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) {
        int length;
        int[] p;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入矩阵数量：");
            length = scanner.nextInt();
            p = new int[length + 1];
            System.out.println("请输入矩阵维度：");
            for (int i = 0; i < p.length; ++i) {
                p[i] = scanner.nextInt();
            }
        }
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length][p.length];
        matrixChain(p, m, s);
        System.out.println("最佳计算次序为：");
        traceBack(s, 1, length);
    }
}
