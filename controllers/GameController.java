package snakeAndLadder.controllers;

import snakeAndLadder.models.Game;
import snakeAndLadder.models.Ladder;
import snakeAndLadder.models.Player;
import snakeAndLadder.models.Snake;
import snakeAndLadder.services.SnakesAndLaddersService;

import java.util.List;

public class GameController {

    private SnakesAndLaddersService snakesAndLaddersService;

    public GameController() {
        this.snakesAndLaddersService = new SnakesAndLaddersService();
    }

    public Game createGame(int dimension, List<Player> players, int currPlayerInd, int snakeCount, int laddersCount){
        //we can also use builder DP to check game parameters

        List<Snake> snakesList = snakesAndLaddersService.getSnakesList(snakeCount, dimension);
        List<Ladder> ladderList = snakesAndLaddersService.getLaddersList(laddersCount, dimension);

        return new Game(dimension, players, currPlayerInd, snakesList, ladderList);
    }
    public void printBoard(Game game){
        game.printBoard();
    }
    public void makeMove(Game game){
        game.makeMove();
    }
}
