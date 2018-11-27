/**
 * Class responsible for the TicTacToe game Handles player switching, marking on
 * a grid etc.. Has a Board member which takes cares of the details of creating
 * the grid, checking bounds etc..
 */
public class TicTacToe {
    private char currentPlayer; // Current player's mark. Can be X or O
    private Board board; // Reference to the board of the game
    private boolean boardChecked; // Stores the result of board check

    /**
     * Default constructor of the TicTacToe class
     */
    TicTacToe() {
        currentPlayer = '-'; // A value other than X or O to begin with (not important)
        board = new Board(); // Create a new Board
        boardChecked = false; // This line is not really necessary as booleans have false as default value in
                              // Java
    }

    /**
     * Sets the mark of the current player Does not check if one of [-, X, O]
     * 
     * @param player Mark of the new player
     */
    public void setCurrentPlayer(char player) {
        currentPlayer = player;
    }

    /**
     * Gets the mark of the current player
     */
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Prints the board on the screen
     */
    public void printBoard() {
        board.printBoard();
    }

    /**
     * Puts the mark on the given row and col
     * 
     * @param row Row
     * @param col Column
     */
    public void putMark(int row, int col) {
        board.putMark(row, col, currentPlayer);
    }

    /**
     * Checks if the game ended with a win
     * 
     * @return true if won false otherwise
     */
    public boolean isWin() {
        return boardChecked;
    }

    /**
     * Checks if the game ended with a draw (none of the player winning)
     * 
     * @return true if draw, false otherwise
     */
    public boolean isDraw() {
        return !boardChecked && board.isFull();
    }

    /**
     * Checks if someone won and caches the result
     */
    public void checkBoard() {
        boardChecked = board.checkBoard();
    }

    /**
     * Checks if the game came to a stop whether due to a win or a draw
     * 
     * @return true if the game stopped because of win or draw, false otherwise
     */
    public boolean hasFinished() {
        return isDraw() || isWin();
    }

    /**
     * Switches the current player
     */
    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}
