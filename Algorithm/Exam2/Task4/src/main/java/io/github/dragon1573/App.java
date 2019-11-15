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
     * 待排序数组
     */
    private static Comparable<Integer>[] array = null;

    /**
     * 初始化数组
     *
     * @param length
     *     数组长度
     */
    static void initialize(int length) {
        array = new Comparable[length];
    }

    /**
     * 数组赋值
     *
     * @param array 实际数组
     */
    static void initialize(final Comparable<Integer>[] array) {
        App.array = array;
    }

    /**
     * 输出数组
     *
     * @return {@code Comparable<Integer>[]}
     */
    static Comparable<Integer>[] style() {
        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * 交换2个元素
     *
     * @param array
     *     源数组
     * @param i
     *     数组索引A
     * @param j
     *     数组索引B
     */
    private static void swap(Comparable<Integer>[] array, int i, int j) {
        Comparable<Integer> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 子序列划分
     *
     * @param p
     *     序列起点
     * @param r
     *     序列终点
     */
    private static int partition(int p, int r) {
        int i = p + 1, j = r;
        Comparable<Integer> x = array[p];
        while (true) {
            while (array[i].compareTo((Integer)x) < 0 && i < r) {
                ++i;
            }
            while (array[j].compareTo((Integer)x) > 0) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        array[p] = array[j];
        array[j] = x;
        return j;
    }

    /**
     * 快速排序
     *
     * @param p
     *     子序列起点
     * @param r
     *     子序列终点
     */
    static void qSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            qSort(p, q - 1);
            qSort(q + 1, r);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入数组长度：");
            initialize(scanner.nextInt());
            System.out.println("请输入数组元素：");
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
        }
        System.out.println("排序前的数组为：" + Arrays.toString(array));
        qSort(0, array.length - 1);
        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
