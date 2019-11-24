package io.github.dragon1573;

import org.junit.Test;

import static java.lang.System.out;

import static org.junit.Assert.assertEquals;

/**
 * 测试类
 */
public class AppTest {
    @Test
    public void test() {
        App app = new App(5, 10, new int[] {0, 2, 2, 6, 5, 4}, new int[] {0, 6, 3, 5, 4, 6});
        int maxValue = app.knapsack();
        assertEquals("价值计算错误！", 15, maxValue);
        out.println("背包最大价值为：" + maxValue);
        String solution = app.traceBack();
        assertEquals("分配方案错误！", "[false, true, true, false, false, true]", solution);
        out.println("物品放置方案为：" + solution);
    }
}
