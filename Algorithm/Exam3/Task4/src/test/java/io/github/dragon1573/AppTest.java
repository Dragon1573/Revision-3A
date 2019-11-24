package io.github.dragon1573;

import org.junit.Test;

import static java.lang.System.out;

import static org.junit.Assert.assertEquals;

import static io.github.dragon1573.App.optimalBinarySearchTree;
import static io.github.dragon1573.App.traceBack;

/**
 * 测试类
 */
public class AppTest {
    @Test
    public void test() {
        double[] a = {0.15, 0.1, 0.05, 0.05};
        double[] b = {0, 0.5, 0.1, 0.05};
        int n = a.length - 1;
        double[][] m = new double[n + 2][n + 2];
        int[][] s = new int[n + 2][n + 2];
        double[][] w = new double[n + 2][n + 2];
        optimalBinarySearchTree(a, b, m, s, w);
        out.println("二叉搜索树的最小平均路长为：" + m[1][n]);
        assertEquals("最小平均路长错误！", 1.5, m[1][n], 1e-6);
        traceBack(s, n, 1, n, 0, "root");
    }
}
