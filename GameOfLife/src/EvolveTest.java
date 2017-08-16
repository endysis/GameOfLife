/**
 * Created by osheadouglas on 15/08/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class EvolveTest {

    public EvolveTest(){

    }

    @Test
    public void testEmptyGrid() { // Scenario 5
        String emptyStateInput = "...\n...\n...";
        Evolution testEvolution = new Evolution();
        GameState emptyState = new GameStateImpl(emptyStateInput);
        assertEquals("An empty grid should stay the same", emptyStateInput, testEvolution.iterateEvolution(emptyState).returnGridString());
    }

    @Test
    public void testRowState() { // Scenario 6
        String rowInput = "...\n***\n...";
        String expectedOutput = ".*.\n.*.\n.*.";
        Evolution testEvolution = new Evolution();
        GameState state = new GameStateImpl(rowInput);
        assertEquals("An grid with an adjacent row of live cells should output a vertical adjacent column of live cells ", expectedOutput, testEvolution.iterateEvolution(state).returnGridString());
    }

    @Test
    public void testColState() { // Scenario 6 Vise Versa
        String rowInput = ".*.\n.*.\n.*.";
        String expectedOutput = "...\n***\n...";
        Evolution testEvolution = new Evolution();
        GameState state = new GameStateImpl(rowInput);
        assertEquals("An grid with an adjacent columns of live cells should output a horizontal row of adjacent live cells ", expectedOutput, testEvolution.iterateEvolution(state).returnGridString());
    }

}
