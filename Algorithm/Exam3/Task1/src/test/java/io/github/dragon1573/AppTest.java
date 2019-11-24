package io.github.dragon1573;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 测试类
 */
public class AppTest {
    @Test
    public void test() {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] s = new int[p.length][p.length];
        int[][] m = new int[p.length][p.length];
        App.matrixChain(p, m, s);
        System.out.println("最优计算次序为：");
        assertEquals("次序错误！", "((A1(A2A3))((A4A5)A6))", App.traceBack(s, 1, 6));
    }
}
