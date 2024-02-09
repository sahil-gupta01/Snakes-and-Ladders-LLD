package snakeAndLadder.app;

import snakeAndLadder.controllers.GameController;
import snakeAndLadder.models.Game;
import snakeAndLadder.models.GameStatus;
import snakeAndLadder.models.Player;

import java.util.ArrayList;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) {
        System.out.println("-----------------Snakes & Ladders-----------------");
        GameController gameController = new GameController();
        int dimension = 100;
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Player1",1L, '*'));
        playerList.add(new Player("Player2", 2L, '#'));

        Game game = gameController.createGame(dimension, playerList, 0);
        while(GameStatus.RUNNING.equals(game.getGameStatus())){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }
        System.out.println("Congrats "+game.getWinner().getName()+" is the winner !!!!!!!");
        System.out.println(game.getMoves());
    }
}
