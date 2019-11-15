package io.github.dragon1573;

import org.junit.Test;

/**
 * 测试类
 *
 * @author Dragon1573
 * @date 2019/11/15
 */
public class AppTest {
    /* 课本第26页图2-4 */
    @Test
    public void sampleBoard() {
        int size = 4, row = 0, column = 1;
        App.initialize(size);
        System.out.println("初始棋盘样式为：");
        App.style();
        App.chessBoard(0, 0, row, column, size);
        System.out.println("覆盖后的棋盘样式为：");
        App.style();
    }
}
