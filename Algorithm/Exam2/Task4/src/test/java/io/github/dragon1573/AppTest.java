package io.github.dragon1573;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 测试类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class AppTest {
    /* 课本第30页测试样例 */
    @Test
    public void test() {
        App.initialize(new Comparable[] {4, 8, 3, 7, 1, 5, 6, 2});
        System.out.println("源数组为：");
        App.style();
        App.qSort(0, 7);
        System.out.println("排序后的数组为：");
        assertArrayEquals("排序错误！", new Comparable[] {1, 2, 3, 4, 5, 6, 7, 8}, App.style());
    }
}
