package snakeAndLadder.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private Player winner;
    private Dice dice;
    private List<Move> moves;
    private int currPlayerInd;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Game(int dimension, List<Player> players, int currPlayerInd, List<Snake> snakes, List<Ladder> ladders) {
        this.board = new Board(dimension);
        this.players = players;
        this.currPlayerInd = currPlayerInd;
        this.gameStatus = GameStatus.RUNNING;
        moves =new ArrayList<>();
        dice = new Dice();
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrPlayerInd() {
        return currPlayerInd;
    }

    public void setCurrPlayerInd(int currPlayerInd) {
        this.currPlayerInd = currPlayerInd;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void printBoard() {
        board.printBoard(players);
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void makeMove() {
        Player currPlayer = players.get(currPlayerInd);
        Move currMove = new Move();
        currMove.setInitialPosition(currPlayer.getPosition());
        currMove.setPlayer(currPlayer);

        int newPosition = currPlayer.move(dice);

        if (checkWinner(currPlayer, newPosition)) return;

        if (checkOutOfBoard(newPosition)) return;

        newPosition = checkForLadder(newPosition);
        newPosition = checkForSnake(newPosition);

        currPlayer.setPosition(newPosition);
        currMove.setFinalPosition(newPosition);
        moves.add(currMove);
        currPlayerInd = (currPlayerInd+1)%players.size();
    }

    private int checkForSnake(int newPosition) {
        for(Snake snake:snakes){
            if(snake.getHead() == newPosition){
                System.out.println("-------------------Oops! Snake bit-------------------");
                newPosition = snake.getTail();
            }
        }
        return newPosition;
    }

    private int checkForLadder(int newPosition) {
        for(Ladder ladder:ladders){
            if(ladder.getLadderEntry() == newPosition){
                System.out.println("----------------Wow! You got a ladder----------------");
                newPosition = ladder.getLadderExit();
            }
        }
        return newPosition;
    }

    private boolean checkOutOfBoard(int newPosition) {
        if(newPosition > 99){
            System.out.println("Out of board");
            currPlayerInd = (currPlayerInd+1)%players.size();
            return true;
        }
        return false;
    }

    private boolean checkWinner(Player currPlayer, int newPosition) {
        if(newPosition == 99){
            winner = currPlayer;
            currPlayer.setPosition(newPosition);
            gameStatus = GameStatus.COMPLETED;
            return true;
        }
        return false;
    }
}
