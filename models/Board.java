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

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void printBoard(List<Player> playersList) {
        int row = (int)Math.sqrt(dimension);
        for(int i =0;i<dimension;i++){
            if(i % row == 0)System.out.println();
            Set<Player> set = new HashSet<>();
            for(Player player:playersList){
                if(player.getPosition() == i){
                    set.add(player);
                }
            }
            if(set.size() == 0){
                System.out.print("|   |");
            }
            else if(set.size() == 1){
                char symbol = set.iterator().next().getSymbol();
                System.out.print("| " +symbol+ " |");
            }
            else{
                System.out.print("|@" + set.size() + " |");
            }
        }
        System.out.println();
    }
}
