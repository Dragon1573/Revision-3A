package io.github.dragon1573;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 测试类
 *
 * @author Dragon1573
 * @date 2019/11/24
 */
public class AppTest {
    @Test
    public void test() {
        int[][] s = new int[7][7];
        int[][] t = new int[7][7];
        int[][] weights = new int[][] {
            {0, 2, 2, 3, 1, 4},
            {2, 0, 1, 5, 2, 3},
            {2, 1, 0, 2, 1, 4},
            {3, 5, 2, 0, 6, 2},
            {1, 2, 1, 6, 0, 1},
            {4, 3, 4, 2, 1, 0}
        };
        int minWeight = App.minWeightTriangulation(weights, 5, t, s);
        assertEquals("权值错误！", 24, minWeight);
        System.out.println("此多边形的最优三角剖分值为：" + minWeight);
        App.traceBack(1, 5, s);
    }
}
