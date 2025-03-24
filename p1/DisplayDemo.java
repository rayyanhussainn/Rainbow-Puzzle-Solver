package p1;

import java.awt.Color;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DisplayDemo {
	public static void main(String[] args) {
		Display d = new Display();
		StdOut.print("First type something in here: ");
		String response = StdIn.readLine();	
		Color[][] grid =
			{
			 {Display.RED, Display.RED, Display.RED, Display.RED, Display.RED, Display.RED},
			 {Display.BLUE, Display.BLUE, Display.BLUE, Display.BLUE, Display.BLUE, Display.BLUE}
			};
		d.drawBoard(grid);
		StdOut.print("Now click on the new window and hit a key.");
		char c = d.getKeyStroke();
		grid[0][2] = Display.YELLOW;
		grid[1][2] = Display.GREEN;
		grid[0][3] = Display.VIOLET;
		grid[1][3] = Display.ORANGE;
		d.drawBoard(grid);
		StdOut.println("\nYour initial respones was: " + response);
		StdOut.println("The key you hit was: " + c);
		StdOut.println("Note that the display changed.  Hit another key to exit");
		c = d.getKeyStroke();
		System.exit(0);
	}
}
