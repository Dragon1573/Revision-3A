package task2;

import org.junit.Test;

import static task2.Dijkstra.dijkstra;

/**
 * @author Dragon1573
 */
public class DijkstraTest {

    @Test
    public void dijkstraTest() {
        final float s = Float.MAX_VALUE;
        final float[][] a =
            {{s, s, s, s, s, s}, {s, s, 10, s, 30, 100}, {s, 10, s, 50, s, s},
                {s, s, 50, s, 20, 10}, {s, s, s, 20, s, 60}, {s, 100, s, 10, 60, s}};
        float[] dist = new float[a.length + 1];
        int[] prev = new int[a.length + 1];
        final int v = 1;
        dijkstra(v, a, dist, prev);
    }
}
