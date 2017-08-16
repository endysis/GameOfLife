import static java.lang.System.in;

/**
 * Created by osheadouglas on 14/08/2017.
 */
public class GameStateImpl implements GameState {

    private int row;
    private int col;
    private Cell[][] grid;

    public GameStateImpl(String input) {
        grid = createGrid(input);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String returnGridString() { // Return the grid as a string
        String output = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j].cellAlive() == true) {
                    output = output + "*";
                } else {
                    output = output + ".";
                }
            }
            if (i != (row - 1)) {
                output = output + "\n";
            }
        }

        return output;
    }

    public void setCellState(boolean b, int i, int j) {
        grid[i][j].switchCellState(b); // Set sell state to alive or dead
    }

    public boolean pixelIsAlive(int r, int c) {
        if (grid[r][c].cellAlive()) {
            return true;
        } else
            return false;
    }

    public int numberofLivingNeighbours(int r, int c) {
        int neighbourCount = 0;

        if (c != 0) { // Should we pass the boundary condition (To avoid reading Null values)
            if (grid[r][c - 1].cellAlive()) { // Left of the cell
                neighbourCount++;
                //System.out.println("Left of the cell");
            }
        }

        if (c != (col - 1)) {
            if (grid[r][c + 1].cellAlive()) { // Right of the cell
                neighbourCount++;
                //System.out.println("Right of the cell");
            }
        }

        if (r != 0) {
            if (grid[r - 1][c].cellAlive()) { // On top of the cell
                neighbourCount++;
                //System.out.println("On top of the cell");
            }
        }

        if (r != (row - 1)) {
            if (grid[r + 1][c].cellAlive()) { // Below the cell
                neighbourCount++;
                //System.out.println("Below the cell");
            }
        }

        if (r != 0 && c != 0) {
            if (grid[r - 1][c - 1].cellAlive()) { // Top Left diagonal of the cell
                neighbourCount++;
                //System.out.println("Top Left diagonal of the cell");
            }
        }

        if (r != 0 && c != (col - 1)) {
            if (grid[r - 1][c + 1].cellAlive()) { // Top Right diagonal of the cell
                neighbourCount++;
                //System.out.println("Top Right diagonal of the cell");
            }
        }

        if (r != (row - 1) && c != 0) {
            if (grid[r + 1][c - 1].cellAlive()) { // Bottom Left diagonal of the cell
                neighbourCount++;
                //System.out.println("Bottom Left diagonal of the cell");
            }
        }

        if (r != (row - 1) && c != (col - 1)) {
            if (grid[r + 1][c + 1].cellAlive()) { // Bottom Right diagonal of the cell
                neighbourCount++;
                //System.out.println("Bottom Right diagonal of the cell");
            }
        }

        //System.out.println("Neighbour Count = " + neighbourCount);
        return neighbourCount;
    }

    public Cell[][] createGrid(String input) { // Create Grid
        int breakCount = 0; // Counts the number of breaks in the input string
        boolean colFound = false; //
        int actualLength; // Actual length of the grid - (breaks '\n')

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '*' && input.charAt(i) != '.') { // Then must be a break
                breakCount++; // Add 1 to the break counter
                if (colFound == false) { // If we meet a break, we then know the number of columns within the grid
                    col = i; // Set columns in the array
                    colFound = true;
                }
            }
        }
        actualLength = input.length() - breakCount; // Find the actual 1D length of the 2D grid
        row = actualLength / col; // X = Actual Rows of the input string
        input = input.replace("\n", "");

        Cell[][] grid = new Cell[row][col];
        Cell c;

        for (int i = 0; i < row; i++) { // Fill grid dependant on the input string
            for (int j = 0; j < col; j++) {
                c = new Cell();
                if (input.charAt((i * col) + j) == '*') {
                    c.switchCellState(true);
                    grid[i][j] = c;
                } else {
                    c.switchCellState(false);
                    grid[i][j] = c;
                }
            }
        }
        return grid; // Return set grid
    }





}