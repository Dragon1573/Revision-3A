package io.github.dragon1573;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 主程序
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class App {
    /**
     * 原始棋盘
     */
    private static int[][] board = null;

    /**
     * L型骨牌编号
     */
    private static int TILE = 0;

    /**
     * 初始化棋盘
     *
     * @param size
     *     棋盘大小
     */
    static void initialize(int size) {
        board = new int[size][size];
    }

    /**
     * 展示棋盘
     */
    static void style() {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 棋盘覆盖算法
     *
     * @param tr
     *     子棋盘左上角行号
     * @param tc
     *     子棋盘左上角列号
     * @param dr
     *     特殊方格在原棋盘中的行号
     * @param dc
     *     特殊方格在原棋盘中的列号
     * @param size
     *     棋盘大小
     */
    static void chessBoard(int tr, int tc, int dr, int dc, int size) {
        // 只有 1×1 的棋盘时，不存在覆盖问题
        if (size == 1) {
            return;
        }
        // 确定骨牌编号并分割棋盘
        int t = TILE++, s = size / 2;
        // 递归覆盖左上角棋盘
        if (dr < tr + s && dc < tc + s) {
            // 特殊方格在此子棋盘中
            chessBoard(tr, tc, dr, dc, s);
        } else {
            // 特殊方格不在此子棋盘中
            // 使用t号L型骨牌覆盖右下角
            board[tr + s - 1][tc + s - 1] = t;
            // 覆盖其余空格
            chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        // 右上角
        if (dr < tr + size && dc >= tc + size) {
            chessBoard(tr, tc + s, dr, dc, s);
        } else {
            board[tr + s - 1][tc + s] = t;
            chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        // 左下角
        if (dr >= tr + s && dc < tc + s) {
            chessBoard(tr + s, tc, dr, dc, s);
        } else {
            board[tr + s][tc + s - 1] = t;
            chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        // 右下角
        if (dr >= tr + s && dc >= tc + s) {
            chessBoard(tr + s, tc + s, dr, dc, s);
        } else {
            board[tr + s][tc + s] = t;
            chessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) {
        int size, row, column;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入棋盘大小：");
            size = scanner.nextInt();
            System.out.print("请输入特殊方格的横坐标：");
            row = scanner.nextInt();
            System.out.print("请输入特殊方格的纵坐标：");
            column = scanner.nextInt();
        }
        initialize(size);
        System.out.println("初始棋盘样式为：");
        style();
        chessBoard(0, 0, row, column, size);
        System.out.println("覆盖后的棋盘样式为：");
        style();
    }
}
