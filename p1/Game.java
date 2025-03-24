package p1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Game {
    public static void main(String[] args) {
 
        StdOut.println("Enter difficulty level (1-6): ");
        int difficulty = StdIn.readInt();

    
        Board board = new Board(difficulty);
        Display display = new Display();
        display.drawBoard(board.getGrid());

  
        Map<String, Boolean> seenBoards = new HashMap<>();
        seenBoards.put(boardToString(board), true);

     
        while (true) {
     
            StdOut.println("Enter your move (1-6 to swap, a-d to shift): ");
            char move = display.getKeyStroke(); 
            board.move(move); 
            display.drawBoard(board.getGrid()); 

          
            if (board.isSolved()) {
                StdOut.println("You win!");
                break;
            }

         
            String boardState = boardToString(board);

 
            if (seenBoards.containsKey(boardState)) {
                StdOut.println("Game over! You repeated a board state.");
                break;
            }
            
         
            seenBoards.put(boardState, true);
        }
    }

    private static char colorToChar(Color c) {
        if (c.equals(Display.RED)) return 'R';
        if (c.equals(Display.ORANGE)) return 'O';
        if (c.equals(Display.YELLOW)) return 'Y';
        if (c.equals(Display.GREEN)) return 'G';
        if (c.equals(Display.BLUE)) return 'B';
        if (c.equals(Display.VIOLET)) return 'V';
        return '?';
    }
    
    private static String boardToString(Board board) {
        StringBuilder sb = new StringBuilder();
        for (Color[] row : board.getGrid()) {
            for (Color cell : row) {
                sb.append(colorToChar(cell));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
