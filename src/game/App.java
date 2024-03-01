package game;

import java.util.Scanner;

public class App {

    private final Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isOver;
    private final Scanner scanner;

    public App() {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
        this.isOver = false;
    }

    public void play(int pins) {
        board.setPins(pins);
        System.out.println("Play a game of TakePins! Press Y to begin, or N to quit!");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Y")) {

            setupPlayers();

            System.out.println("The game has begun.");
            System.out.println("The board has " + board.getPins() + " pins.");

            while (!isOver) {

                System.out.println("It is " + currentPlayer.getName() + "'s turn!");
                if (currentPlayer instanceof HumanPlayer) {
                    System.out.println("How many pins would you like to take? 1 or 2?");
                    userInput();

                } else {
                    int pinsToTake = ((ComputerPlayer) currentPlayer).generateRandomNumber();
                    if (pinsToTake == 1) {
                        currentPlayer.take1Pin(board);
                    } else {
                        currentPlayer.take2Pins(board);
                    }
                    System.out.println(currentPlayer.getName() + " took " + pinsToTake + " pins!");
                }
                System.out.println("\nThe board has " + board.getPins() + " pins!");

                checkIfBoardIsEmpty();
            }

        } else if (input.equalsIgnoreCase("N")) {
            System.out.println("Goodbye then. Fucking tease.");
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void checkIfBoardIsEmpty() {
        if (board.isEmpty()) {
            Player winner = currentPlayer;
            Player loser = (currentPlayer == player1) ? player2 : player1;
            isOver = true;
            System.out
                    .println("Game over! " + winner.getName() + " wins! \n" + "Yous a loser " + loser.getName() + "!");
        } else {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    public void setupPlayers() {
        System.out
                .println(
                        "\nWelcome to TakePins! The game where you take pins from the board until there are none left.");
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        this.player1 = new HumanPlayer(name);
        this.player2 = new ComputerPlayer("SKYNET");
        System.out.println("\nWelcome, " + name + "!" + "\n");
        System.out.println(
                "You will be playing against the computer," + " The computer's name is " + player2.getName() + "!");
        this.currentPlayer = player1;
    }

    public void userInput() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("1")) {
            currentPlayer.take1Pin(board);
        } else if (input.equalsIgnoreCase("2")) {
            currentPlayer.take2Pins(board);
        } else {
            System.out.println("Invalid input. Please try again.");
            userInput();
        }
    }

    public static void main(String[] args) {
        App game = new App();
        game.play(10);
    }
}