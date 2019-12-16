import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 单源最短路径算法
 *
 * @author Dragon1573
 */
public class ShortestPath {
    public static class Node implements Comparable {
        int id;
        float length;

        public Node(int id, float length) {
            this.id = id;
            this.length = length;
        }

        @Override
        public int compareTo(final Object o) {
            final float length = ((Node)o).length;
            return Float.compare(this.length, length);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入图顶点个数：");
            int n = scanner.nextInt();
            System.out.println("请输入图的路径长度：");
            final float[][] a = new float[n + 1][n + 1];
            float[] dist = new float[n + 1];
            int[] prev = new int[n + 1];
            for (int i = 0; i < n; i++) {
                final String line = scanner.nextLine();
                String[] digits = line.split(",");
                for (int j = 0; j < digits.length; j++) {
                    a[i + 1][j + 1] = Float.parseFloat(digits[j]);
                }
            }
            int v = 1;
            shortest(a, v, dist, prev);
        }
    }

    public static void shortest(
        final float[][] a, final int v, float[] dist, int[] p
    ) {
        final int n = p.length - 1;
        LinkedList<Node> nodes = new LinkedList<>();
        Node node = new Node(v, 0);
        for (int i = 1; i <= n; i++) {
            dist[i] = Float.MAX_VALUE;
        }
        while (true) {
            for (int i = 1; i <= n; i++) {
                if (a[node.id][i] != -1 && node.length + a[node.id][i] < dist[i]) {
                    dist[i] = node.length + a[node.id][i];
                    p[i] = node.id;
                    Node node1 = new Node(i, dist[i]);
                    nodes.add(node1);
                    Collections.sort(nodes);
                }
            }
            if (nodes.isEmpty()) {
                break;
            } else {
                node = (Node)nodes.poll();
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(i + "节点的最短路径为" + dist[i] + "；前驱节点为：" + p[i]);
        }
    }
}
