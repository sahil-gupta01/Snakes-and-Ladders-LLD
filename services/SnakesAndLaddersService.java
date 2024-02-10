package snakeAndLadder.services;

import snakeAndLadder.models.Ladder;
import snakeAndLadder.models.Snake;

import java.util.*;
public class SnakesAndLaddersService {
    private Set<String> components;
    private Random random;

    public SnakesAndLaddersService() {
        this.components = new HashSet<>();
        this.random = new Random();
    }

    public List<Snake> getSnakesList(int snakeCount, int dimension) {
        List<Snake> snakes = new ArrayList<>();
        for(int i =1;i<=snakeCount;i++){
            while(true){
                int snakeMouth = 1 + random.nextInt(98);
                int snakeTail = 1 + random.nextInt(98);
                if (snakeTail >= snakeMouth) {
                    continue;
                }
                else{
                    String position = snakeMouth +" "+ snakeTail;
                    if(!components.contains(position)){
                        components.add(position);
                        snakes.add(new Snake(snakeMouth, snakeTail));
                        break;
                    }
                }
            }
        }
        return snakes;
    }

    public List<Ladder> getLaddersList(int laddersCount, int dimension) {
        List<Ladder> ladders = new ArrayList<>();
        for(int i=1;i<=laddersCount;i++){
            while(true){
                int ladderEntry = 1 + random.nextInt(98);
                int ladderExit = 1 + random.nextInt(98);
                if(ladderExit <= ladderEntry)continue;
                else{
                    String position = ladderEntry + " " + ladderExit;
                    if (!components.contains(position)) {
                        components.add(position);
                        ladders.add(new Ladder(ladderEntry, ladderExit));
                        break;
                    }
                }
            }
        }
        return ladders;
    }
}
