package io.github.dragon1573;

import java.util.Scanner;

/**
 * 凸多边形最优三角剖分
 *
 * @author 走在冷风中_
 * @author Dragon1573
 * @date 2016/2/29
 * @date 2019/11/23
 */
public class App {
    /**
     * @param n
     *     顶点数量
     * @param t
     *     最小权重矩阵
     * @param s
     *     三角剖分回溯矩阵
     *
     * @return 最小剖分权值
     */
    static int minWeightTriangulation(final int[][] w, final int n, int[][] t, int[][] s) {
        for (int i = 1; i <= n; i++) {
            t[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                t[i][j] = t[i + 1][j] + weight(w, i - 1, i, j);
                s[i][j] = i;
                for (int k = i + 1; k < i + r - 1; k++) {
                    int u = t[i][k] + t[k + 1][j] + weight(w, i - 1, k, j);
                    if (u < t[i][j]) {
                        t[i][j] = u;
                        s[i][j] = k;
                    }
                }
            }
        }
        return t[1][n - 1];
    }

    /**
     * @param a
     *     顶点A
     * @param b
     *     顶点B
     * @param c
     *     顶点C
     *
     * @return 三角形权重值
     */
    private static int weight(final int[][] weights, final int a, final int b, final int c) {
        return weights[a][b] + weights[b][c] + weights[a][c];
    }

    /**
     * 剖分路径回溯
     *
     * @param i
     *     顶点A
     * @param j
     *     顶点B
     * @param s
     *     回溯矩阵
     */
    static void traceBack(int i, int j, int[][] s) {
        if (i == j) {
            return;
        }
        traceBack(i, s[i][j], s);
        traceBack(s[i][j] + 1, j, s);
        System.out.println("三角剖分顶点：(V" + (i - 1) + ", V" + j + ", V" + s[i][j] + ")");
    }

    public static void main(String[] args) {
        int n;
        int[][] w;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入顶点数量：");
            n = scanner.nextInt();
            w = new int[n][n];
            System.out.println("请输入权重值：");
            for (int i = 0; i < n; i++) {
                System.out.print("第" + i + "行：");
                for (int j = 0; j < n; j++) {
                    w[i][j] = scanner.nextInt();
                }
            }
        }
        int[][] s = new int[n + 1][n + 1];
        int[][] t = new int[n + 1][n + 1];
        System.out.println("最优三角剖分的权重值为："+ minWeightTriangulation(w, n - 1, t, s));
        traceBack(1, n - 1, s);
    }
}

