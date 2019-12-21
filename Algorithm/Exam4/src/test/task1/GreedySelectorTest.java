package task1;

import org.junit.Test;

import static java.lang.System.out;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Dragon1573
 */
public class GreedySelectorTest {
    @Test
    public void selectorTest() {
        final int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        final int[] f = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        boolean[] a = new boolean[s.length];
        final int result = GreedySelector.selector(s, f, a);
        assertArrayEquals(
            new boolean[] {false, true, false, true, false, false, false, true, false,
                false, true}, a);
        out.println("Result is: " + result);
        assertEquals(4, result);
        for (int i = 0; i < s.length; i++) {
            if (a[i]) {
                out.println("第" + i + "活动被选中，其开始时间为：" + s[i] + "，结束时间为：" + f[i]);
            }
        }
    }
}
