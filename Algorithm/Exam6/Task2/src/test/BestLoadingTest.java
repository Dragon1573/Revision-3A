import org.junit.jupiter.api.Test;

/**
 * @author Dragon1573
 */
class BestLoadingTest {
    @Test
    void maxLoadingTest() {
        final int n = 4;
        final int c = 70;
        System.out.println("请输入物品质量：");
        int[] w = {0, 20, 10, 26, 15};
        int[] best = new int[n + 1];
        BestLoading b = new BestLoading();
        System.out.println("最优装载顺序为：");
        int ew = b.maxLoading(w, c, best);
        System.out.println("最优装载重量为：" + ew);
    }
}
