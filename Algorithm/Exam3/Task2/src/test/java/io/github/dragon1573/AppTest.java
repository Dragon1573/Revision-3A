package io.github.dragon1573;

import java.util.Arrays;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * 测试类
 *
 * @author Dragon1573
 * @date 2019/11/23
 */
public class AppTest {
    private void test(
        final String string1, final String string2,
        final String expectedString, final int[][] expectedMatrix
    ) {
        int[][] matrix = App.longestCommonSubsequence(string1, string2);
        out.println("最长公共子序列长度矩阵为：");
        for (int[] row : matrix) {
            out.println(Arrays.toString(row));
        }
        assertArrayEquals("长度矩阵计算错误！", expectedMatrix, matrix);
        String maxPublicString = App.print(matrix, string1, string2, string1.length(), string2.length());
        out.println("最长公共子序列为：" + maxPublicString);
        assertEquals("子序列错误！", expectedString, maxPublicString);
        out.println();
    }

    @Test
    public void testCase1() {
        test("string", "str", "str", new int[][] {
            {0, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 2, 2},
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3}
        });
    }

    @Test
    public void testCase2() {
        test("string", "none", "n", new int[][] {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1}
        });
    }

    @Test
    public void testCase3() {
        test("string", "abc", "", new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
    }
}
