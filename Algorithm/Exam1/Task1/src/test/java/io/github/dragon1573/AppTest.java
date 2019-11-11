package io.github.dragon1573;

import io.github.dragon1573.App;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for The Algorithm
 *
 * @author Dragon1573
 */
public class AppTest {
    /**
     * The test function.
     */
    @Test
    public void dec2Hex() {
        Assert.assertEquals(
            "Base transformation failed!",
            "60",
            App.dec2Any(96, 16)
        );
    }

    @Test
    public void dec2Oct() {
        Assert.assertEquals(
            "Transformation failed!",
            "140",
            App.dec2Any(96, 8)
        );
    }

    @Test
    public void dec2Bin() {
        Assert.assertEquals(
            "Transformation failed!",
            "1100000",
            App.dec2Any(96, 2)
        );
    }
}
