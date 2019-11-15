package io.github.dragon1573;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 测试类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class AppTest {
    /**
     * 3个元素，1个子集
     */
    @Test
    public void bell31() {
        int result = App.bell(3, 1);
        System.out.println("3个元素的集合可以划分为" + result + "个不同的、由1个非空子集组成的集合");
        assertEquals("划分错误！", 1, result);
    }

    /**
     * 3个元素，2个子集
     */
    @Test
    public void bell32() {
        int result = App.bell(3, 2);
        System.out.println("3个元素的集合可以划分为" + result + "个不同的、由2个非空子集组成的集合");
        assertEquals("划分错误！", 3, result);
    }

    /**
     * 3个元素，3个子集
     */
    @Test
    public void bell33() {
        int result = App.bell(3, 3);
        System.out.println("3个元素的集合可以划分为" + result + "个不同的、由3个非空子集组成的集合");
        assertEquals("划分错误！", 1, result);
    }

    /**
     * 4个元素，1个子集
     */
    @Test
    public void bell41() {
        int result = App.bell(4, 1);
        System.out.println("4个元素的集合可以划分为" + result + "个不同的、由1个非空子集组成的集合");
        assertEquals("划分错误！", 1, result);
    }

    /**
     * 4个元素，2个子集
     */
    @Test
    public void bell42() {
        int result = App.bell(4, 2);
        System.out.println("4个元素的集合可以划分为" + result + "个不同的、由2个非空子集组成的集合");
        assertEquals("划分错误！", 7, result);
    }

    /**
     * 4个元素，3个子集
     */
    @Test
    public void bell43() {
        int result = App.bell(4, 3);
        System.out.println("4个元素的集合可以划分为" + result + "个不同的、由3个非空子集组成的集合");
        assertEquals("划分错误！", 6, result);
    }

    /**
     * 4个元素，4个子集
     */
    @Test
    public void bell44() {
        int result = App.bell(4, 4);
        System.out.println("4个元素的集合可以划分为" + result + "个不同的、由4个非空子集组成的集合");
        assertEquals("划分错误！", 1, result);
    }
}
