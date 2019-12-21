package task2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 单源最短路径算法（迪杰斯特拉算法）
 *
 * @author Dragon1573
 */
public class Dijkstra {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入源结点：");
            final int v = scanner.nextInt();
            System.out.println("请输入距离矩阵（第一行决定矩阵大小）：");
            final String string = scanner.nextLine();
            final String[] firstRow = string.split(" ");
            // 矩阵初始化
            float[][] a = new float[firstRow.length + 1][firstRow.length + 1];
            for (float[] floats : a) {
                Arrays.fill(floats, Float.MAX_VALUE);
            }
            for (int i = 1; i < a[1].length; i++) {
                a[1][i] = Float.parseFloat(firstRow[i - 1]);
            }
            for (int i = 2; i < a.length; i++) {
                for (int j = 1; j < a[i].length; j++) {
                    a[i][j] = scanner.nextFloat();
                }
            }
        }
    }

    public static void dijkstra(
        final int v, final float[][] a, float[] dist, int[] prev
    ) {
        final int n = dist.length - 1;
        if (v < 1 || v > n) {
            return;
        }
        boolean[] s = new boolean[n + 1];

        // 矩阵初始化
        for (int i = 1; i < n; i++) {
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i] == Float.MAX_VALUE) {
                prev[i] = 0;
            } else {
                prev[i] = v;
            }
        }
        dist[v] = 0;
        s[v] = true;
        for (int i = 1; i < n; i++) {
            float temp = Float.MAX_VALUE;
            int u = v;
            for (int j = 1; j < n; j++) {
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;
                    temp = dist[j];
                }
            }
            s[u] = true;
            for (int j = 1; j < n; j++) {
                if ((!s[j]) && (a[u][j] < Float.MAX_VALUE)) {
                    float newDist = dist[u] + a[u][j];
                    if (newDist < dist[j]) {
                        // 距离刷新
                        dist[j] = newDist;
                        prev[j] = u;
                    }
                }
            }
        }
        System.out.println("源结点为：" + v);
        System.out.println("距离矩阵为：");
        for (final float[] row : a) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("最短距离为：");
        System.out.println(Arrays.toString(dist));
        System.out.println("前序结点为：");
        System.out.println(Arrays.toString(prev));
    }
}
