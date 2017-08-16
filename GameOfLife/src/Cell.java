/**
 * Created by osheadouglas on 14/08/2017.
 */
public class Cell {
    private boolean isAlive = false; // Cell State

    public Cell(){

    }

    public boolean cellAlive(){
        return isAlive;
    }

    public void switchCellState(boolean state){
        isAlive = state;
    }

}
