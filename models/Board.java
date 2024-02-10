package snakeAndLadder.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;

    }

    public int getDimension() {
        return dimension;
    }

    public void currPositionPlayersListDimension(int dimension) {
        this.dimension = dimension;
    }

    public void printBoard(List<Player> playersList) {
        int row = (int)Math.sqrt(dimension);
        for(int i =0;i<dimension;i++){
            if(i % row == 0)System.out.println();
            List<Player> currPositionPlayersList = new ArrayList<>();
            for(Player player:playersList){
                if(player.getPosition() == i){
                    currPositionPlayersList.add(player);
                }
            }
            if(currPositionPlayersList.isEmpty()){
                System.out.print("|   |");
            }
            else if(currPositionPlayersList.size() == 1){
                System.out.print("| " +currPositionPlayersList.get(0).getSymbol()+ " |");
            }
            else{
                System.out.print("|@" + currPositionPlayersList.size() + " |");
            }
        }
        System.out.println();
    }
}
