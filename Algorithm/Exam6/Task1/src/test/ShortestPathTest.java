import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author Dragon1573
 */
public class ShortestPathTest {
    @Test
    void shortestTest() {
        final int n = 5;
        System.out.println("顶点个数为：" + n);
        final float[][]
            a =
            {{-1, -1, -1, -1, -1, -1},
                {-1, -1, 10, -1, 30, 100},
                {-1, -1, -1, 50, -1, -1},
                {-1, -1, -1, -1, -1, 10},
                {-1, -1, -1, 20, -1, 60},
                {-1, -1, -1, -1, -1, -1}};
        System.out.println("邻接矩阵为：");
        for (float[] row : a) {
            System.out.println(Arrays.toString(row));
        }
        float[] dist = new float[n + 1];
        int[] prev = new int[n + 1];
        int v = 1;
        ShortestPath.shortest(a, v, dist, prev);
    }
}
