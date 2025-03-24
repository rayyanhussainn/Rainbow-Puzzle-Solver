package p2;

import java.awt.Color;

public class Board {
    private Color[][] grid;
    private static final int ROWS = 2;
    private static final int COLS = 6;

    // Constructs a Board by deep-copying the provided 2x6 Color grid.
    public Board(Color[][] grid) {
        this.grid = new Color[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                this.grid[r][c] = grid[r][c];
            }
        }
    }

    // Returns a deep copy of the board's grid.
    public Color[][] getGrid() {
        Color[][] gridCopy = new Color[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                gridCopy[r][c] = grid[r][c];
            }
        }
        return gridCopy;
    }

    // Applies a move to the board.
    // Moves '1'–'6' swap the two colors in the corresponding column.
    // 'a' shifts the top row left; 'b' shifts the top row right.
    // 'c' shifts the bottom row left; 'd' shifts the bottom row right.
    public void move(char action) {
        if (action >= '1' && action <= '6') {
            int colIndex = action - '1';
            Color temp = grid[0][colIndex];
            grid[0][colIndex] = grid[1][colIndex];
            grid[1][colIndex] = temp;
        } else if (action == 'a') {
            // Shift the top row left.
            Color first = grid[0][0];
            for (int i = 0; i < COLS - 1; i++) {
                grid[0][i] = grid[0][i + 1];
            }
            grid[0][COLS - 1] = first;
        } else if (action == 'b') {
            // Shift the top row right.
            Color last = grid[0][COLS - 1];
            for (int i = COLS - 1; i > 0; i--) {
                grid[0][i] = grid[0][i - 1];
            }
            grid[0][0] = last;
        } else if (action == 'c') {
            // Shift the bottom row left.
            Color first = grid[1][0];
            for (int i = 0; i < COLS - 1; i++) {
                grid[1][i] = grid[1][i + 1];
            }
            grid[1][COLS - 1] = first;
        } else if (action == 'd') {
            // Shift the bottom row right.
            Color last = grid[1][COLS - 1];
            for (int i = COLS - 1; i > 0; i--) {
                grid[1][i] = grid[1][i - 1];
            }
            grid[1][0] = last;
        }
    }

    // Computes a hash code for the board based on each cell's color.
    // Uses Color's getRGB() values combined with multiplication by 31.
    public long hash() {
        long hashValue = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                hashValue = hashValue * 31 + grid[r][c].getRGB();
            }
        }
        return hashValue;
    }

    // Provides a string representation of the board (for debugging).
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                sb.append(grid[r][c]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
