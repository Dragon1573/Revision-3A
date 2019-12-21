package task3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dragon1573
 */
public class DeleteDigitsTest {
    @Test
    public void deleteTest() {
        final String result = DeleteDigits.delete("64797541", 6);
        assertEquals("计算错误！", "41", result);
        System.out.println("最小数值为：" + result);
    }
}
