package snakeAndLadder.models;

import java.util.Scanner;

public class Player {
    private String name;
    private Long playerId;
    private char symbol;
    private int position;
    private Scanner scanner;

    public Player(String name, Long playerId, char symbol) {
        this.name = name;
        this.playerId = playerId;
        this.symbol = symbol;
        scanner = new Scanner(System.in);
        position = 96;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int move(Dice dice){
        System.out.println(name + " its your turn, press r ot type roll to roll the dice");
        String input = scanner.next();
        while(!input.equalsIgnoreCase("roll") && !input.equalsIgnoreCase("r")){
            System.out.println("Wrong input, try again");
            input = scanner.next();
        }
        int value = dice.rollDice();
        return value + position;
    }
}
