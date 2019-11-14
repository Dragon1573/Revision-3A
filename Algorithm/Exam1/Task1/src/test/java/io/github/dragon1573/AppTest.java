package io.github.dragon1573;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for The Algorithm
 *
 * @author Dragon1573
 */
public class AppTest {
    private static final int DECIMAL = 96;

    /**
     * The test function.
     */
    @Test
    public void dec2Hex() {
        String result = App.dec2Any(DECIMAL, 16);
        System.out.println("十进制的96转换为十六进制是：" + result);
        Assert.assertEquals("Base transformation failed!", "60", result);
    }

    @Test
    public void dec2Oct() {
        String result = App.dec2Any(DECIMAL, 8);
        System.out.println("十进制的96转换为八进制是：" + result);
        Assert.assertEquals("Transformation failed!", "140", result);
    }

    @Test
    public void dec2Bin() {
        String result = App.dec2Any(DECIMAL, 2);
        System.out.println("十进制的96转换为二进制是：" + result);
        Assert.assertEquals("Transformation failed!", "1100000", result);
    }
}
