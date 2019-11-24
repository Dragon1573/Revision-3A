package io.github.dragon1573;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 最长公共子序列
 *
 * @author Jason.F
 * @author Dragon1573
 * @date 2016/07/19 11:08:43
 * @date 2019/11/23
 */
public class App {
    /**
     * @param str1
     *     字符串A
     * @param str2
     *     字符串B
     *
     * @return 最长公共子串的长度矩阵
     */
    static int[][] longestCommonSubsequence(final String str1, final String str2) {
        // 建立矩阵
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        // 初始化边界条件
        for (int i = 0; i <= str1.length(); ++i) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i <= str2.length(); ++i) {
            matrix[0][i] = 0;
        }
        // 填充矩阵
        for (int i = 1; i <= str1.length(); ++i) {
            for (int j = 1; j <= str2.length(); ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = (Math.max(matrix[i - 1][j], matrix[i][j - 1]));
                }
            }
        }
        return matrix;
    }

    /**
     * 输出最长公共子序列
     *
     * @param matrix
     *     最长公共子序列长度矩阵
     * @param str1
     *     字符串A
     * @param str2
     *     字符串B
     * @param length1
     *     字符串A的长度
     * @param length2
     *     字符串B的长度
     *
     * @return 最长公共子序列
     */
    static String print(final int[][] matrix, final String str1, final String str2, final int length1, final int length2) {
        if (length1 == 0 || length2 == 0) {
            return "";
        }
        String string = null;
        if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
            string = print(matrix, str1, str2, length1 - 1, length2 - 1);
            string += str1.charAt(length1 - 1);
        } else if (matrix[length1 - 1][length2] >= matrix[length1][length2]) {
            string = print(matrix, str1, str2, length1 - 1, length2);
        } else {
            string = print(matrix, str1, str2, length1, length2 - 1);
        }
        return string;
    }

    public static void main(String[] args) {
        String string1, string2;
        try (Scanner scanner = new Scanner(in)) {
            out.print("请输入字符串A：");
            string1 = scanner.nextLine();
            out.print("请输入字符串B：");
            string2 = scanner.nextLine();
        }
        out.println("最长公共子串为：" + print(
            longestCommonSubsequence(string1, string2), string1,
            string2, string1.length(), string2.length()
        ));
    }
}
