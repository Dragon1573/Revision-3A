package task2;

import org.junit.Test;

/**
 * @author Dragon1573
 */
public class SymbolTriangleTest {
    @Test
    public void computeTest() {
        final long counter = SymbolTriangle.compute(7);
        System.out.println("7层符号三角形共有" + counter + "种异构，使 + 和 - 符号数量相同");
    }
}
