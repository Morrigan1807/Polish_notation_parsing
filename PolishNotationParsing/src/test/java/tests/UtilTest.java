package tests;

import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {

    @Test
    public void testGetOperatorPositionOperatorNotFoundCase() {
        assertThrows(IllegalArgumentException.class, () -> Util.getNextOperatorPosition("^"));
    }

    @Test
    public void testGetNextDivisionOperatorPositionNotFoundCase() {
        assertEquals(-1, Util.getNextDivisionOperatorPosition("2 * 2"));
    }

    @Test
    public void testGetNextDivisionOperatorPositionIncorrectParenthesesCase() {
        assertEquals(-1, Util.getNextDivisionOperatorPosition("2 * 2"));
    }
}
