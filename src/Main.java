import java.util.Scanner;

public class Main {

    // Main entry point to our game
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        TicTacToe game = new TicTacToe();
        game.setCurrentPlayer('X');
        System.out.println("Welcome to TicTacToe game");
        while (!game.hasFinished()) {
            // Each turn we print the current state of the board
            // and ask the player to input the coordinates of the cell he would to
            // put his mark on
            // The coordinates are Row number ([0..2]) and Column number ([0..2])
            game.printBoard();
            char currentPlayer = game.getCurrentPlayer(); // x or an o
            System.out.println("Player " + currentPlayer + " is currently playing. Where do you place your mark?");
            int row = console.nextInt();
            console.nextLine();
            int col = console.nextInt();
            console.nextLine();

            game.putMark(row, col);

            game.switchPlayer();
            game.checkBoard();
            if (game.isWin()) {
                System.out.println("You have won!");
            } else if (game.isDraw()) {
                System.out.println("It's a draw!");
            }
        }
        System.out.println("Game finished, see you again!");
    }
}
