package task1;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Dragon1573
 */
public class LoadingTest {
    @Test
    public void maxLoadingTest() {
        final int[] weight = {30, 60, 50, 70, 100};
        final int capacity = 120;
        int[] best = new int[weight.length];
        System.out.println("质量：" + Arrays.toString(weight));
        System.out.println("最大载荷：" + capacity);
        System.out.println("最佳装载：" + Loading.maxLoading(weight, capacity, best));
    }
}
