/**
 * Created by osheadouglas on 15/08/2017.
 */
public class Evolution {

    public Evolution(){

    }

    public GameStateImpl iterateEvolution(GameState gameState){

        String newInput = gameState.returnGridString().replace("*",".");

        GameStateImpl newGameState = new GameStateImpl(newInput); // Create new gamestate and compare with the old.

        for(int i = 0; i < gameState.getRow(); i++){
            for(int j = 0; j < gameState.getCol(); j++){

                int livingCount = gameState.numberofLivingNeighbours(i,j);

                if(!gameState.pixelIsAlive(i,j) && livingCount == 0){ // No Interactions
                    newGameState.setCellState(false,i,j);
                }
                if(gameState.pixelIsAlive(i,j) && livingCount < 2){ // Underpopulation
                    newGameState.setCellState(false,i,j);
                }
                if(gameState.pixelIsAlive(i,j) && livingCount > 3){ // Overcrowding
                    newGameState.setCellState(false,i,j);
                }
                if(gameState.pixelIsAlive(i,j) && (livingCount == 2 || livingCount == 3)){ // Survival
                    newGameState.setCellState(true,i,j);
                }
                if(!gameState.pixelIsAlive(i,j) && livingCount == 3){ // Creation of Life
                    newGameState.setCellState(true,i,j);
                }
            }
        }
        return newGameState;
    }
}
