/**
 * Created by osheadouglas on 15/08/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;
public class GameStateTest {


    @Test
    public void testParsing() {
        String input = ".*.\n*.*\n...";
        GameStateImpl testState = new GameStateImpl(input);
        assertTrue("Row 0, col 1 should be alive",testState.pixelIsAlive(0,1));
        assertFalse("Row 2, col 0 should not be alive",testState.pixelIsAlive(2,0));
    }

    @Test
    public void testRowColCounts() {
        String input = "...\n***\n..*";
        GameStateImpl testState = new GameStateImpl(input);
        assertEquals("The game should have 3 columns", 3, testState.getCol());
        assertEquals("The game should have 3 rows", 3, testState.getRow());
    }

}
