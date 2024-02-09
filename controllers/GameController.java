package snakeAndLadder.controllers;

import snakeAndLadder.models.Game;
import snakeAndLadder.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players, int currPlayerInd){
        //we can also use builder DP to check game parameters
        Game game = new Game(dimension, players, currPlayerInd);
        return game;
    }
    public void printBoard(Game game){
        game.printBoard();
    }
    public void makeMove(Game game){
        game.makeMove();
    }
}
