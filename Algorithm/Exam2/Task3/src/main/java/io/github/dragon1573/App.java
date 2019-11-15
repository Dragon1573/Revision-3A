package io.github.dragon1573;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 主类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class App {
    /**
     * 合并算法
     *
     * @param c
     *     源序列
     * @param d
     *     目标序列
     * @param l
     *     子序列开头
     * @param m
     *     子序列中点
     * @param r
     *     子序列结尾
     */
    public static void merge(Comparable<Integer>[] c, Comparable<Integer>[] d, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (c[i].compareTo((Integer)c[j]) <= 0) {
                d[k++] = c[i++];
            } else {
                d[k++] = c[j++];
            }
        }
        if (i > m) {
            for (int q = j; q <= r; q++) {
                d[k++] = c[q];
            }
        } else {
            for (int q = i; q <= m; q++) {
                d[k++] = c[q];
            }
        }
    }

    /**
     * 合并长度为s的相邻有序子序列
     *
     * @param x
     *     子序列A
     * @param y
     *     子序列B
     * @param s
     *     序列长度
     */
    public static void mergePass(Comparable<Integer>[] x, Comparable<Integer>[] y, int s) {
        int i = 0;
        while (i <= x.length - 2 * s) {
            merge(x, y, i, i + s - 1, i + 2 * s - 1);
            i += 2 * s;
        }
        if (i + s < x.length) {
            merge(x, y, i, i + s - 1, x.length - 1);
        } else {
            System.arraycopy(x, i, y, i, x.length - i);
        }
    }

    /**
     * 合并排序算法
     *
     * @param a
     *     待排序的序列
     */
    public static void mergeSort(Comparable<Integer>[] a) {
        Comparable<Integer>[] b = new Comparable[a.length];
        int s = 1;
        while (s < a.length) {
            mergePass(a, b, s);
            s += s;
            mergePass(b, a, s);
            s += s;
        }
    }

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) {
        int length;
        Comparable<Integer>[] array = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入数组长度：");
            length = scanner.nextInt();
            array = new Comparable[length];
            System.out.println("请输入数组元素：");
            for (int i = 0; i < length; i++) {
                array[i] = scanner.nextInt();
            }
        }
        System.out.println("源数组为：" + Arrays.toString(array));
        mergeSort(array);
        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
