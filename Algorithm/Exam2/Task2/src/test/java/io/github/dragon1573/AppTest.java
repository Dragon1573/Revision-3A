package io.github.dragon1573;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 测试类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class AppTest {
    /**
     * <ul>
     *     <li>棋盘大小：2阶</li>
     *     <li>特殊方格坐标：(1, 0)</li>
     * </ul>
     */
    @Test
    public void sampleBoard2() {
        App app = new App(2);
        app.chessBoard(1, 0, 0, 0, 2);
        assertArrayEquals("覆盖错误！", new int[][] {{1, 1}, {0, 1}}, app.style(true));
    }

    /**
     * 课本第26页图2-4
     *
     * <ul>
     *     <li>棋盘大小：4阶</li>
     *     <li>特殊方格坐标：(0, 1)</li>
     * </ul>
     */
    @Test
    public void sampleBoard4() {
        App app = new App(4);
        System.out.println("初始棋盘样式为：");
        app.style(false);
        app.chessBoard(0, 1, 0, 0, 4);
        System.out.println("覆盖后的棋盘样式为：");
        final int[][] expected = new int[][] {{2, 0, 3, 3}, {2, 2, 1, 3}, {4, 1, 1, 5}, {4, 4, 5, 5}};
        assertArrayEquals("覆盖错误！", expected, app.style(false));
    }

    /**
     * <ul>
     *     <li>棋盘大小：8阶</li>
     *     <li>特殊方格坐标：(4, 3)</li>
     * </ul>
     */
    @Test
    public void sampleBoard8() {
        App app = new App(8);
        app.chessBoard(4, 3, 0, 0, 8);
        int[][] expected = new int[8][];
        expected[0] = new int[] {3, 3, 4, 4, 8, 8, 9, 9};
        expected[1] = new int[] {3, 2, 2, 4, 8, 7, 7, 9};
        expected[2] = new int[] {5, 2, 6, 6, 10, 10, 7, 11};
        expected[3] = new int[] {5, 5, 6, 1, 1, 10, 11, 11};
        expected[4] = new int[] {13, 13, 14, 0, 1, 18, 19, 19};
        expected[5] = new int[] {13, 12, 14, 14, 18, 18, 17, 19};
        expected[6] = new int[] {15, 12, 12, 16, 20, 17, 17, 21};
        expected[7] = new int[] {15, 15, 16, 16, 20, 20, 21, 21};
        assertArrayEquals("覆盖错误！", expected, app.style(true));
    }
}
