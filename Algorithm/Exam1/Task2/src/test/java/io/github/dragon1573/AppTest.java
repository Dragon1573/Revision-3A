package io.github.dragon1573;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * A test class of the application.
 */
public class AppTest {
    /**
     * Simulate business of a day.
     * <p>
     * Those customers is coming as follows: +2, -1, +3, -2, +1, -3
     */
    @Test
    public void simulation() {
        assertArrayEquals(new int[] {1, 0}, App.takeNumber());
        assertArrayEquals(new int[] {2, 1},App.takeNumber());
        assertEquals(1, App.callNumber());
        assertArrayEquals(new int[] {3, 1},App.takeNumber());
        assertArrayEquals(new int[] {4, 2},App.takeNumber());
        assertArrayEquals(new int[] {5, 3},App.takeNumber());
        assertEquals(2, App.callNumber());
        assertEquals(3, App.callNumber());
        assertArrayEquals(new int[] {6, 2}, App.takeNumber());
        assertEquals(4, App.callNumber());
        assertEquals(5, App.callNumber());
        assertEquals(6, App.callNumber());
    }
}
