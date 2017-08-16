/**
 * Created by osheadouglas on 15/08/2017.
 */
public interface GameState {

    int getRow();

    int getCol();

    void setCellState(boolean b, int i, int j); // Set sell state to alive or dead

    String returnGridString(); // Output Grid

    boolean pixelIsAlive(int r, int c);

    int numberofLivingNeighbours(int r, int c);

    Cell[][] createGrid(String input); // Create Grid
}
