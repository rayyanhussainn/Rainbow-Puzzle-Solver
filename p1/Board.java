package p1;

import java.awt.Color;
import java.util.Random;

public class Board {
	private Color[][] grid;
	private static final Color[] RAINBOW_ORDER = {
			Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET
	};
	

	/**
	 * Creates a new Board that is <code> count </code> moves away from a solved board.
	 * Furthermore, the sequence of moves does not repeat any board configurations.
	 * For example, the sequence of moves a11c would not be a valid sequence of 4 moves
	 * for this constructor because the board configuration after "a" is identical to the
	 * board configuration after "a11".
	 * 
	 * @param count the number of moves to make starting from the solved board
	 */
	public Board(int count) {
        this(createSolvedBoard());
        scramble(count);
    }

	
	
	/**
	 * Creates a Board whose colors are arranged as they appear in a given grid.
	 * 
	 * @param grid the arrangement of colors for the board to be created.
	 */
	public Board(Color[][] grid) {
        this.grid = new Color[2][6];
        for (int i = 0; i < 2; i++) {
            System.arraycopy(grid[i], 0, this.grid[i], 0, 6);
        }
    }
	
	/**
	 * Updates the board to reflect a move being performed.
	 * 
	 * @param c the move to be performed
	 */
	public void move(char c) {
        switch (c) {
            case '1': case '2': case '3': case '4': case '5': case '6':
                swapColumns(c - '1');
                break;
            case 'a':
                shiftRowLeft(0);
                break;
            case 'b':
                shiftRowRight(0);
                break;
            case 'c':
                shiftRowLeft(1);
                break;
            case 'd':
                shiftRowRight(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid move: " + c);
        }
    }
	

	/**
	 * Determines if the board is in the solved configuration.  The board is solved
	 * if the two cells in the same column contain the same color and the colors
	 * appear in "rainbow order" from left to right (red, orange, yello, green, blue, violet)
	 * 
	 * @return <code>true</code> if the board is solved.  
	 */
	public boolean isSolved() {
        for (int i = 0; i < 6; i++) {
            if (!grid[0][i].equals(grid[1][i]) || !grid[0][i].equals(RAINBOW_ORDER[i])) {
                return false;
            }
        }
        return true;
    }
	

	/**
	 * Returns the arrangement of the colors on the board as a 2 by 6
	 * array of Color.
	 * 
	 * @return the arrangement of the colors on the board
	 */
	public Color[][] getGrid() {
        return grid;
    }
	
	private void scramble(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            char randomMove = getRandomMove(rand);
            move(randomMove);
        }
    }
	
	private char getRandomMove(Random rand) {
        char[] moves = {'a', 'b', 'c', 'd', '1', '2', '3', '4', '5', '6'};
        return moves[rand.nextInt(moves.length)];
    }
	
	private static Color[][] createSolvedBoard() {
        Color[][] solved = new Color[2][6];
        for (int i = 0; i < 6; i++) {
            solved[0][i] = RAINBOW_ORDER[i];
            solved[1][i] = RAINBOW_ORDER[i];
        }
        return solved;
    }
	
	private void swapColumns(int col) {
        Color temp = grid[0][col];
        grid[0][col] = grid[1][col];
        grid[1][col] = temp;
    }
	
	
	private void shiftRowLeft(int row) {
        Color temp = grid[row][0];
        for (int i = 0; i < 5; i++) {
            grid[row][i] = grid[row][i + 1];
        }
        grid[row][5] = temp;
    }
	
	private void shiftRowRight(int row) {
		Color temp = grid[row][5];
		for (int i = 5; i > 0; i--) {
			grid[row][i] = grid[row][i-1];
		}
		grid[row][0] = temp;
	}
	
}
