package task1;

import java.util.Scanner;

/**
 * 装载问题
 *
 * @author Dragon1573
 */
public class Loading {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入质量数组：");
            final String string = scanner.nextLine();
            final String[] strings = string.split(" ");
            int[] weight = new int[strings.length];
            for (int i = 0; i < weight.length; i++) {
                weight[i] = Integer.parseInt(strings[i]);
            }
            System.out.println("请输入最大载荷：");
            final int capacity = scanner.nextInt();
            int[] best = new int[weight.length];
            System.out.println("最佳载荷为：" + maxLoading(weight, capacity, best));
        }
    }

    /**
     * 迭代回溯
     *
     * @param w
     *     集装箱质量数组
     * @param c
     *     首船最大载荷量
     * @param bestX
     *     当前最优解数组
     *
     * @return 首船最优载荷量
     */
    public static int maxLoading(final int[] w, final int c, final int[] bestX) {
        int result = 0;
        boolean finished = false;
        // 当前层
        int i = 1;
        final int n = w.length - 1;
        // x[1:(i-1)]为当前路径
        final int[] x = new int[n + 1];
        // 当前最优载荷、当前载荷、剩余载荷
        int bestW = 0, cW = 0, r = 0;
        for (int j = 1; j <= n; j++) {
            r += w[j];
        }

        // 搜索子树
        do {
            while (i <= n && cW + w[i] <= c) {
                // 左子树
                r -= w[i];
                cW += w[i];
                x[i] = 1;
                i++;
            }
            if (i > n) {
                // 到达叶子
                if (n >= 0) {
                    System.arraycopy(x, 1, bestX, 1, n);
                }
                bestW = cW;
            } else {
                // 右子树
                r -= w[i];
                x[i] = 0;
                i++;
            }
            while (cW + r <= bestW) {
                // 剪枝回溯
                i--;
                while (i > 0 && x[i] == 0) {
                    // 从右子树返回
                    r += w[i];
                    i--;
                }
                if (i == 0) {
                    result = bestW;
                    finished = true;
                    break;
                }
                // 进入右子树
                x[i] = 0;
                cW -= w[i];
                i++;
            }
        } while (!finished);
        return result;
    }
}
