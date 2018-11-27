
/**
 * Class responsible for creating the grid, properly displaying it, placing a
 * player's mark on the given coordinates and checking for bounds etc...
 */
public class Board {
    /**
     * 2 dimensional array that represents current state of the grid
     */
    private Cell[][] grid;

    /**
     * Default constructor of the Board class, used to initialize the board
     */
    Board() {
        grid = new Cell[3][3]; // first [] is row, second [] is col
        initBoard();
    }

    /**
     * Sets all cells to empty
     */
    public void initBoard() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                grid[y][x] = '-';
            }
        }
    }

    /**
     * Pritns the board on the screen
     */
    public void printBoard() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(grid[y][x] + " "); // current cell
            }
            // i am at the end of the current row (y)
            System.out.println();
        }
    }

    /**
     * Checks if the given coordinates are within the bounds of the 3x3 grid
     * 
     * @param row Row coordinate
     * @param col Column coordinate
     * @return true if inside bound, false otherwise
     */
    public boolean insideBound(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    /**
     * Puts the mark in the given coordinates, fails silently if coordinates outside
     * of grid bounds
     * 
     * @param row  Row coordinate
     * @param col  Column coordinate
     * @param mark Mark of the player
     */
    public void putMark(int row, int col, char mark) {
        if (insideBound(row, col)) {
            grid[row][col] = mark;
        }
    }

    /**
     * Checks if the current player one by checking if there is any 3 celled aligned
     * combination of same player marks That is rows, columns and diagonals
     * 
     * @return true if won, false otherwise
     */
    public boolean checkBoard() {
        for (int y = 0; y < 3; y++) {
            if (checkRow(y)) {
                return true; // early return
            }
        }

        for (int x = 0; x < 3; x++) {
            if (checkColumn(x)) {
                return true;// early return
            }
        }

        if (checkDiagonals()) {
            return true;// early return
        }

        return false;
    }

    /**
     * Checks if the y'th row contains a winning combination
     * 
     * @param y Row index
     * @return true if winning combination, false otherwise
     */
    private boolean checkRow(int y) {
        return grid[y][0] != '-' && grid[y][0] == grid[y][1] && grid[y][1] == grid[y][2];
    }

    /**
     * Checks if the x'th column contains a winning combination
     * 
     * @param x Column index
     * @return true if winning combination, false otherwise
     */
    private boolean checkColumn(int x) {
        return grid[0][x] != '-' && grid[0][x] == grid[1][x] && grid[1][x] == grid[2][x];
    }

    /**
     * Checks if the diagonal or antidiagonal contains a winning combination
     * 
     * @return true if winning combination, false otherwise
     */
    private boolean checkDiagonals() {
        // diagonal going down from top left corner
        return (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
                || (grid[2][0] != '-' && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2]);
    }

    /**
     * Checks if the board is full (no empty cell left) Useful for checking for a
     * draw
     * 
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (grid[y][x] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}
