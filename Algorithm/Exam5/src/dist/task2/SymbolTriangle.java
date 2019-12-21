package task2;

import java.util.Scanner;

/**
 * 符号三角形
 *
 * @author Dragon1573
 */
public class SymbolTriangle {
    /** 首行符号个数 */
    private static int n;
    /** n * (n + 1) / 4 */
    private static int half;
    /** 当前 + 的个数 */
    private static int count;
    /** 符号三角形矩阵 */
    private static int[][] p;
    /** 已找到的符号三角形数量 */
    private static long sum;

    /**
     * 实现回溯
     *
     * @param t
     *     子树层编号
     */
    private static void backtrack(int t) {
        if ((count > half) || (t * (t - 1) / 2 - count > half)) {
            return;
        }
        if (t > n) {
            sum++;
        } else {
            for (int i = 0; i < 2; i++) {
                p[1][t] = i;
                count += i;
                for (int j = 2; j <= t; j++) {
                    p[j][t - j + 1] = p[j - 1][t - j + 1] ^ p[j - 1][t - j + 2];
                    count += p[j][t - j + 1];
                }
                backtrack(t + 1);
                for (int j = 2; j <= t; j++) {
                    count -= p[j][t - j + 1];
                }
                count -= i;
            }
        }
    }

    /**
     * @param nLevel
     *     首行符号个数
     *
     * @return 异构符号三角形数量
     */
    public static long compute(final int nLevel) {
        n = nLevel;
        count = 0;
        sum = 0;
        half = n * (n + 1) / 2;
        if (half % 2 == 1) {
            return 0;
        }
        half /= 2;
        p = new int[n + 1][n + 1];
        backtrack(1);
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入符号三角形的层数：");
            final int level = scanner.nextInt();
            System.out.println(
                level + "层的符号三角形共有" + compute(level) + "种异构，使 + 和 - " + "数量相同。");
        }
    }
}
