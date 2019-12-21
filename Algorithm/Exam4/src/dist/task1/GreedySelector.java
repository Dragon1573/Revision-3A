package task1;

import java.util.Scanner;

/**
 * 活动安排问题
 *
 * @author Dragon1573
 */
public class GreedySelector {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入起始时间序列：");
            final int[] s = parseIntArray(scanner);
            System.out.println("请输入结束时间序列");
            final int[] f = parseIntArray(scanner);
            boolean[] a = new boolean[f.length];
            final int count = selector(s, f, a);
            System.out.println("共选择" + count + "项活动。");
            for (int i = 0; i < a.length; i++) {
                if (a[i]) {
                    System.out.println(
                        "第" + (i + 1) + "活动被选中，其开始时间为：" + s[i] + "，结束时间为：" + f[i]);
                }
            }
        }
    }

    /**
     * @param scanner
     *     字符输入流
     *
     * @return 解析得到的整数数组
     */
    private static int[] parseIntArray(final Scanner scanner) {
        final String string = scanner.nextLine();
        final String[] array = string.split(" ");
        int[] intArray = new int[array.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    /**
     * @param s
     *     开始时间序列
     * @param f
     *     结束时间序列
     * @param a
     *     复选数组
     *
     * @return 选中活动数量
     */
    public static int selector(final int[] s, final int[] f, final boolean[] a) {
        final int n = s.length - 1;
        a[1] = true;
        int j = 1;
        int count = 1;
        for (int i = 2; i <= n; i++) {
            if (s[i] >= f[j]) {
                a[i] = true;
                j = i;
                count++;
            } else {
                a[i] = false;
            }
        }
        return count;
    }
}
