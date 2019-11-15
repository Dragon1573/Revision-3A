package io.github.dragon1573;

import java.util.Scanner;

/**
 * 主程序
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class App {
    /**
     * 二分搜索算法
     *
     * @param array
     *     已经排好序的对象数组
     * @param target
     *     需要查找的目标对象
     *
     * @return {@link java.lang.Object}
     */
    static int binarySearch(int[] array, int target) {
        // 定义左搜索边界
        int left = 0;
        // 定义右搜索边界
        int right = array.length - 1;
        // 不断循环扫描，缩小搜索范围
        while (left <= right) {
            // 确定二分中点
            int middle = (left + right) / 2;
            // 缩小二分分支
            if (target == array[middle]) {
                return middle;
            } else if (target > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        // 数组中没有相应元素
        return -1;
    }

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) {
        int[] array;
        int target;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入数组长度：");
            int length = scanner.nextInt();
            array = new int[length];
            System.out.println("请输入数组元素：");
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.print("请输入目标元素：");
            target = scanner.nextInt();
        }
        int result = App.binarySearch(array, target);
        if (result == -1) {
            System.err.println("警告：数组中不存在此元素！");
        } else {
            System.out.println("目标元素的数组索引为：" + result);
        }
    }
}
