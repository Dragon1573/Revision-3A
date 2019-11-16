package io.github.dragon1573;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <b>主类</b>
 *
 * <p>
 * 版权声明：本文为博主原创文章，遵循<a href="http://creativecommons.org/licenses/by-sa/4.0/">CC 4.0 BY-SA</a>版权协议。原文链接：<a href="https://blog.csdn.net/likunkun__/article/details/80149445">分治算法——附棋盘覆盖问题的java代码实现</a>。
 * </p>
 *
 * @author likunhong01
 * @date 2018/04/30
 *
 * @author Dragon1573
 * @date 2019/11/16
 */
public class App {
    /**
     * 棋盘
     */
    private int[][] board;
    /**
     * 骨牌编号
     */
    private int number = 0;

    App(final int size) {
        this.board = new int[size][size];
    }

    /**
     * 棋盘覆盖算法
     *
     * @param dr
     *     特殊方块行索引
     * @param dc
     *     特殊方块列索引
     * @param tr
     *     子棋盘左上角行索引
     * @param tc
     *     子棋盘左上角列索引
     * @param size
     *     棋盘大小
     */
    void chessBoard(final int dr, final int dc, final int tr, final int tc, final int size) {
        if (1 == size) {
            return;
        }

        final int subSize = size / 2;
        this.number++;
        // 注意这里一定要将number存在当前的递归层次里，否则进入下一层递归全局变量会发生改变
        final int n = this.number;

        // 假设特殊点在左上角区域
        if (dr < tr + subSize && dc < tc + subSize) {
            chessBoard(dr, dc, tr, tc, subSize);
        } else {
            // 不在左上角，设左上角矩阵的右下角就是特殊点（和别的一起放置L形）
            this.board[tr + subSize - 1][tc + subSize - 1] = n;
            chessBoard(tr + subSize - 1, tc + subSize - 1, tr, tc, subSize);
        }

        // 假设特殊点在右上方
        if (dr < tr + subSize && dc >= tc + subSize) {
            chessBoard(dr, dc, tr, tc + subSize, subSize);
        } else {
            // 不在右上方，设右上方矩阵的左下角就是特殊点（和别的一起放置L形）
            this.board[tr + subSize - 1][tc + subSize] = n;
            chessBoard(tr + subSize - 1, tc + subSize, tr, tc + subSize, subSize);
        }

        // 特殊点在左下方
        if (dr >= tr + subSize && dc < tc + subSize) {
            chessBoard(dr, dc, tr + subSize, tc, subSize);
        } else {
            // 不在左下方，设左下方矩阵的右上角就是特殊点（和别的一起放置L形）
            this.board[tr + subSize][tc + subSize - 1] = n;
            chessBoard(tr + subSize, tc + subSize - 1, tr + subSize, tc, subSize);
        }

        // 特殊点在右下角
        if (dr >= tr + subSize && dc >= tc + subSize) {
            chessBoard(dr, dc, tr + subSize, tc + subSize, subSize);
        } else {
            // 不在右下角，设右下角矩阵的左上就是特殊点（和别的一起放置L形）
            this.board[tr + subSize][tc + subSize] = n;
            chessBoard(tr + subSize, tc + subSize, tr + subSize, tc + subSize, subSize);
        }
    }

    /**
     * 展示棋盘
     *
     * @param debug 测试模式
     * @return 棋盘
     */
    int[][] style(boolean debug) {
        if (!debug) {
            for (int[] row : this.board) {
                System.out.println(Arrays.toString(row));
            }
        }
        return board;
    }

    /**
     * 主函数
     *
     * @param args 命令行参数
     */
    public static void main(final String[] args) {
        int size, row, column;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入棋盘大小：");
            size = scanner.nextInt();
            System.out.print("请输入特殊方块的行索引：");
            row = scanner.nextInt();
            System.out.print("请输入特殊方块的列索引：");
            column = scanner.nextInt();
        }
        App app = new App(size);
        System.out.println("初始棋盘为：");
        app.style(false);
        app.chessBoard(row, column, 0, 0, size);
        System.out.println("覆盖后的棋盘为：");
        app.style(false);
    }
}
