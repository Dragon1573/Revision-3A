import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 最优装载问题
 *
 * @author Dragon1573
 */
public class BestLoading {
    /**
     * 子集空间树结点
     */
    private static class TreeNode {
        public TreeNode parent;
        public boolean leftChild;

        public TreeNode(final TreeNode parent, final boolean leftChild) {
            this.parent = parent;
            this.leftChild = leftChild;
        }
    }

    /**
     * 最大优先队列结点
     */
    public static class HeapNode implements Comparable {
        public TreeNode liveNode;
        public int uWeight;
        public int level;

        public HeapNode(final TreeNode node, final int up, final int level) {
            this.liveNode = node;
            this.uWeight = up;
            this.level = level;
        }

        @Override
        public int compareTo(final Object o) {
            final int up = ((HeapNode)o).uWeight;
            return Float.compare(this.uWeight, up);
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj.getClass() == this.getClass()) {
                return this.uWeight == ((HeapNode)obj).uWeight;
            } else {
                return false;
            }
        }
    }

    private LinkedList<HeapNode> heap;

    public void addLiveNode(
        final int up, final int level, final TreeNode parent, final boolean child
    ) {
        TreeNode b = new TreeNode(parent, child);
        HeapNode node = new HeapNode(b, up, level);
        this.heap.add(node);
        Collections.sort(this.heap);
    }

    public int maxLoading(final int[] w, final int c, final int[] best) {
        this.heap = new LinkedList<>();
        int n = w.length - 1;
        TreeNode e = null;
        int i = 1;
        int ew = 0;
        int[] r = new int[n + 1];
        for (int j = n - 1; j > 0; j--) {
            r[j] = r[j + 1] + w[j + 1];
        }
        while (i != n + 1) {
            if (ew + w[i] <= c) {
                addLiveNode(ew + w[i] + r[i], i + 1, e, true);
            }
            addLiveNode(ew + r[i], i + 1, e, false);
            HeapNode node = heap.pollLast();
            assert node != null;
            i = node.level;
            e = node.liveNode;
            ew = node.uWeight - r[i - 1];
        }
        for (int j = n; j > 0; j--) {
            best[j] = (e.leftChild ? 1 : 0);
            System.out.print(best[j] + " ");
            e = e.parent;
        }
        System.out.println();
        return ew;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入物品数量：");
            final int n = scanner.nextInt();
            System.out.print("请输入最大载荷：");
            final int c = scanner.nextInt();
            System.out.println("请输入物品质量：");
            int[] w = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                w[i] = scanner.nextInt();
            }
            int[] best = new int[n + 1];
            BestLoading b = new BestLoading();
            System.out.println("最优装载顺序为：");
            int ew = b.maxLoading(w, c, best);
            System.out.println("最优装载重量为：" + ew);
        }
    }
}
