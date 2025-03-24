package p1;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class P1Test {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(10);

	Color[][] B = {
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
	};
	
	Color[][] B_move_a = {
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
	};
	
	Color[][] B_move_d = {
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
	};
	
	Color[][] B_move_a2 = {
			{Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
	};
	
	Color[][] B_move_d5 = {
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET}
	};
	
	Color[][] B_move_b13c3b = {
			{Display.BLUE, Display.RED, Display.RED, Display.GREEN, Display.YELLOW, Display.GREEN},
			{Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.VIOLET}
	};
	
	Color[][] b = new Color[2][];
	Color[][] b_move_a = new Color[2][];	
	Color[][] b_move_d = new Color[2][];
	Color[][] b_move_a2 = new Color[2][];
	Color[][] b_move_d5 = new Color[2][];	
	Color[][] b_move_b13c3b = new Color[2][];
	

	
	@Before
	public void beforeEachTest() {
		b[0] = Arrays.copyOf(B[0], 6);
		b[1] = Arrays.copyOf(B[1], 6);
		
		b_move_a[0] = Arrays.copyOf(B_move_a[0], 6);
		b_move_a[1] = Arrays.copyOf(B_move_a[1], 6);

		b_move_d[0] = Arrays.copyOf(B_move_d[0], 6);
		b_move_d[1] = Arrays.copyOf(B_move_d[1], 6);
		
		b_move_a2[0] = Arrays.copyOf(B_move_a2[0], 6);
		b_move_a2[1] = Arrays.copyOf(B_move_a2[1], 6);
		
		b_move_d5[0] = Arrays.copyOf(B_move_d5[0], 6);
		b_move_d5[1] = Arrays.copyOf(B_move_d5[1], 6);
		
		b_move_b13c3b[0] = Arrays.copyOf(B_move_b13c3b[0], 6);
		b_move_b13c3b[1] = Arrays.copyOf(B_move_b13c3b[1], 6);
	}
	
	
	/*
	 * The CrossBoard should not modify the array parameter used to construct the
	 * CrossBoard.  If this test fails, moves on the board are affecting the external
	 * array.
	 */
	

	@Test
	public void test02_move_DoesntModifyExternalArray() {
		/*
		Color[][] b_move_COPY = new Color[2][];
		Color[][] b_move_a_move_COPY = new Color[2][];	
		Color[][] b_move_d_move_COPY = new Color[2][];
		Color[][] b_move_a2_move_COPY = new Color[2][];
		Color[][] b_move_d5_move_COPY = new Color[2][];	
		Color[][] b_move_b13c3b_move_COPY = new Color[2][];

		b_move_COPY[0] = Arrays.copyOf(B[0], 6);
		b_move_COPY[1] = Arrays.copyOf(B[1], 6);
		
		b_move_a_move_COPY[0] = Arrays.copyOf(B_move_a[0], 6);
		b_move_a_move_COPY[1] = Arrays.copyOf(B_move_a[1], 6);

		b_move_d_move_COPY[0] = Arrays.copyOf(B_move_d[0], 6);
		b_move_d_move_COPY[1] = Arrays.copyOf(B_move_d[1], 6);
		
		b_move_a2_move_COPY[0] = Arrays.copyOf(B_move_a2[0], 6);
		b_move_a2_move_COPY[1] = Arrays.copyOf(B_move_a2[1], 6);
		
		b_move_d5_move_COPY[0] = Arrays.copyOf(B_move_d5[0], 6);
		b_move_d5_move_COPY[1] = Arrays.copyOf(B_move_d5[1], 6);
		
		b_move_b13c3b_move_COPY[0] = Arrays.copyOf(B_move_b13c3b[0], 6);
		b_move_b13c3b_move_COPY[1] = Arrays.copyOf(B_move_b13c3b[1], 6);
		*/
		
		Board board1 = new Board(b);
		Board board2 = new Board(b_move_b13c3b);
		board1.move('a');
		board2.move('a');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('b');
		board2.move('b');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('c');
		board2.move('c');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('d');
		board2.move('d');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('1');
		board2.move('1');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('2');
		board2.move('2');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('3');
		board2.move('3');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('4');
		board2.move('4');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('5');
		board2.move('5');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
		board1.move('6');
		board2.move('6');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(b[i][j], B[i][j]);
				assertEquals(b_move_b13c3b[i][j], B_move_b13c3b[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_a() {
		Board board = new Board(b);
		Board board_move_b13c3b = new Board(b_move_b13c3b);
		
		board.move('a');
		board_move_b13c3b.move('a');
		
		Color[][] actual = board.getGrid();
		Color[][] actual_move_b13c3b = board_move_b13c3b.getGrid();
		
		Color[][] expected = {
				{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};
		
		Color[][] expected_move_b13c3b = {
				{Display.RED, Display.RED, Display.GREEN, Display.YELLOW, Display.GREEN, Display.BLUE},
				{Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.VIOLET}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected[i][j], actual[i][j]);
				assertEquals(expected_move_b13c3b[i][j], actual_move_b13c3b[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_b() {
		Board board = new Board(b);
		Board board_move_b13c3b = new Board(b_move_b13c3b);
		
		board.move('b');
		board_move_b13c3b.move('b');
		
		Color[][] actual = board.getGrid();
		Color[][] actual_move_b13c3b = board_move_b13c3b.getGrid();
		
		Color[][] expected = {
				{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};
		
		Color[][] expected_move_b13c3b = {
				{Display.GREEN, Display.BLUE, Display.RED, Display.RED, Display.GREEN, Display.YELLOW},
				{Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.VIOLET}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected[i][j], actual[i][j]);
				assertEquals(expected_move_b13c3b[i][j], actual_move_b13c3b[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_c() {
		Board board = new Board(b);
		Board board_move_b13c3b = new Board(b_move_b13c3b);
		
		board.move('c');
		board_move_b13c3b.move('c');
		
		Color[][] actual = board.getGrid();
		Color[][] actual_move_b13c3b = board_move_b13c3b.getGrid();
		
		Color[][] expected = {
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
				{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};
		
		Color[][] expected_move_b13c3b = {
				{Display.BLUE, Display.RED, Display.RED, Display.GREEN, Display.YELLOW, Display.GREEN},
				{Display.ORANGE, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.VIOLET, Display.ORANGE}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected[i][j], actual[i][j]);
				assertEquals(expected_move_b13c3b[i][j], actual_move_b13c3b[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_d() {
		Board board = new Board(b);
		Board board_move_b13c3b = new Board(b_move_b13c3b);
		
		board.move('d');
		board_move_b13c3b.move('d');
		
		Color[][] actual = board.getGrid();
		Color[][] actual_move_b13c3b = board_move_b13c3b.getGrid();
		
		Color[][] expected = {
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
				{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};
		
		Color[][] expected_move_b13c3b = {
				{Display.BLUE, Display.RED, Display.RED, Display.GREEN, Display.YELLOW, Display.GREEN},
				{Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.VIOLET}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected[i][j], actual[i][j]);
				assertEquals(expected_move_b13c3b[i][j], actual_move_b13c3b[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_1() {
		Board board_move_a = new Board(b_move_a);
		Board board_move_d = new Board(b_move_d);
		
		board_move_a.move('1');
		board_move_d.move('1');
		
		Color[][] actual_move_a = board_move_a.getGrid();
		Color[][] actual_move_d = board_move_d.getGrid();
		
		Color[][] expected_move_a = {
				{Display.RED, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
				{Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};
		
		Color[][] expected_move_d = {
				{Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
				{Display.RED, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected_move_a[i][j], actual_move_a[i][j]);
				assertEquals(expected_move_d[i][j], actual_move_d[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_2() {
		Board board_move_a = new Board(b_move_a);
		Board board_move_d = new Board(b_move_d);
		
		board_move_a.move('2');
		board_move_d.move('2');
		
		Color[][] actual_move_a = board_move_a.getGrid();
		Color[][] actual_move_d = board_move_d.getGrid();
		
		Color[][] expected_move_a = {
				{Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
				{Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};
		
		Color[][] expected_move_d = {
				{Display.RED, Display.RED, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
				{Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected_move_a[i][j], actual_move_a[i][j]);
				assertEquals(expected_move_d[i][j], actual_move_d[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_3() {
		Board board_move_a = new Board(b_move_a);
		Board board_move_d = new Board(b_move_d);
		
		board_move_a.move('3');
		board_move_d.move('3');
		
		Color[][] actual_move_a = board_move_a.getGrid();
		Color[][] actual_move_d = board_move_d.getGrid();
		
		Color[][] expected_move_a = {
				{Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.RED},
				{Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE, Display.VIOLET}
		};
		
		Color[][] expected_move_d = {
				{Display.RED, Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET},
				{Display.VIOLET, Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected_move_a[i][j], actual_move_a[i][j]);
				assertEquals(expected_move_d[i][j], actual_move_d[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_4() {
		Board board_move_a = new Board(b_move_a);
		Board board_move_d = new Board(b_move_d);
		
		board_move_a.move('4');
		board_move_d.move('4');
		
		Color[][] actual_move_a = board_move_a.getGrid();
		Color[][] actual_move_d = board_move_d.getGrid();
		
		Color[][] expected_move_a = {
				{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.VIOLET, Display.RED},
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.BLUE, Display.VIOLET}
		};
		
		Color[][] expected_move_d = {
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET},
				{Display.VIOLET, Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected_move_a[i][j], actual_move_a[i][j]);
				assertEquals(expected_move_d[i][j], actual_move_d[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_5() {
		Board board_move_a = new Board(b_move_a);
		Board board_move_d = new Board(b_move_d);
		
		board_move_a.move('5');
		board_move_d.move('5');
		
		Color[][] actual_move_a = board_move_a.getGrid();
		Color[][] actual_move_d = board_move_d.getGrid();
		
		Color[][] expected_move_a = {
				{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE, Display.RED},
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET, Display.VIOLET}
		};
		
		Color[][] expected_move_d = {
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.VIOLET},
				{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.BLUE}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected_move_a[i][j], actual_move_a[i][j]);
				assertEquals(expected_move_d[i][j], actual_move_d[i][j]);
			}
		}
	}
	
	@Test
	public void test01_move_6() {
		Board board_move_a = new Board(b_move_a);
		Board board_move_d = new Board(b_move_d);
		
		board_move_a.move('6');
		board_move_d.move('6');
		
		Color[][] actual_move_a = board_move_a.getGrid();
		Color[][] actual_move_d = board_move_d.getGrid();
		
		Color[][] expected_move_a = {
				{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.VIOLET},
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.RED}
		};
		
		Color[][] expected_move_d = {
				{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE},
				{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET}
		};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected_move_a[i][j], actual_move_a[i][j]);
				assertEquals(expected_move_d[i][j], actual_move_d[i][j]);
			}
		}
	}
	
	@Test
	public void test02_move_sequence() {
		Board board= new Board(b);
		board.move('b');
		board.move('1');
		board.move('3');
		board.move('c');
		board.move('3');
		board.move('b');
		board.move('2');	
		Color[][] actual = board.getGrid();
		
		Color[][] expected = {
				{Display.BLUE, Display.ORANGE, Display.RED, Display.GREEN, Display.YELLOW, Display.GREEN},
				{Display.ORANGE, Display.RED, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.VIOLET}
		};
		
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				assertEquals(expected[i][j], actual[i][j]);
			}
		}
	}
	
	@Test
	public void test01_isSolved() {
		Board board = new Board(b);
		Board board_move_a = new Board(b_move_a);
		Board board_move_b13c3b = new Board(b_move_b13c3b);
		
		assertTrue(board.isSolved());
		assertFalse(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
		
		board_move_a.move('b');
		
		assertTrue(board.isSolved());
		assertTrue(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
		
		board_move_b13c3b.move('a');
		board_move_b13c3b.move('3');
		board_move_b13c3b.move('d');
		
		assertTrue(board.isSolved());
		assertTrue(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
		
		board_move_b13c3b.move('3');
		board_move_b13c3b.move('1');
		board_move_b13c3b.move('a');
		
		assertTrue(board.isSolved());
		assertTrue(board_move_a.isSolved());
		assertTrue(board_move_b13c3b.isSolved());
		
		board_move_b13c3b.move('a');
		
		assertTrue(board.isSolved());
		assertTrue(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
		
		board_move_a.move('a');
		
		assertTrue(board.isSolved());
		assertFalse(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
		
		board.move('a');
		
		assertFalse(board.isSolved());
		assertFalse(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
		
		board.move('b');
		
		assertTrue(board.isSolved());
		assertFalse(board_move_a.isSolved());
		assertFalse(board_move_b13c3b.isSolved());
	}
}
