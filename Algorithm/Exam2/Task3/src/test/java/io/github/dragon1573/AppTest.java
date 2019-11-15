package io.github.dragon1573;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试类
 */
public class AppTest {
    /* 课本第30页测试用例 */
    @Test
    public void test() {
        Comparable<Integer>[] array = new Comparable[] {4, 8, 3, 7, 1, 5, 6, 2};
        System.out.println("输入的源数组为：" + Arrays.toString(array));
        App.mergeSort(array);
        System.out.println("排序后的数组为：" + Arrays.toString(array));
        assertArrayEquals("排序错误！", new Comparable[] {1, 2, 3, 4, 5, 6, 7, 8}, array);
    }
}
