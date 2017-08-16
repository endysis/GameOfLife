/**
 * Created by osheadouglas on 14/08/2017.
 */
public class Game {
    public static void main(String [] args) {

        String x = ".*.\n.*.\n.*.";

        GameState g = new GameStateImpl(x);

        System.out.println(g.returnGridString()); // Print out original state

        Evolution e = new Evolution();
        g = e.iterateEvolution(g);

        System.out.println(g.returnGridString()); // Print out evolved state


        EvolveTest eT = new EvolveTest(); // Run Evolve Testing
        eT.testEmptyGrid();
        eT.testColState();
        eT.testRowState();


        GameStateTest gt = new GameStateTest(); // Run Game State Testing
        gt.testRowColCounts();
        gt.testParsing();
    }
}

