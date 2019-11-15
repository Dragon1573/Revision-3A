package io.github.dragon1573;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit测试类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class AppTest {
    /**
     * 奇数个元素的二分搜索
     */
    @Test
    public void oddElements() {
        final int[] array = {2, 4, 6, 8, 10};
        final int target = 8;
        final int result = App.binarySearch(array, target);
        System.out.println(target + "在数组" + Arrays.toString(array) + "中的下表索引为：" + result);
        assertEquals("搜索结果错误！", 3, result);
    }

    /**
     * 偶数个元素的二分查找
     */
    @Test
    public void evenElements() {
        final int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        final int target = 11;
        final int result = App.binarySearch(array, target);
        System.out.println(target + "在数组" + Arrays.toString(array) + "中的下标索引为：" + result);
        assertEquals("搜索错误！", 5, result);
    }

    /**
     * 不存在的查找
     */
    @Test
    public void noSuchElements() {
        final int[] array = {-3, -1, 1, 3};
        final int target = 0;
        final int result = App.binarySearch(array, target);
        System.out.println(target + "在数组" + Arrays.toString(array) + "中的下标索引为：" + result);
        assertEquals("搜索结果错误！", -1, result);
    }
}
