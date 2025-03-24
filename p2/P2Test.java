package p2;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.rules.Timeout;


import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class P2Test {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(90);
	
	

	private char[] answerArray;
	private static Color[][] copy;
	private static Solver solver;
	private static final int ROW_COUNT = 2;
	private static final int COL_COUNT = 6;
	private static final Color[] SOLVED_ROW = {Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET};

	@BeforeClass
	public static void setUpClass() {
		solver = new Solver();
		copy = new Color[ROW_COUNT][COL_COUNT];
	}


	private boolean checkSolution(Color[][] board, char[] moves) {
		for (char m : moves) {
			if (m >= '1' && m <= '6') {
				int col = (int) (m - '1');
				Color temp = board[0][col];
				board[0][col] = board[1][col];
				board[1][col] = temp;
			} else if (m >= 'a' && m <= 'd') {
				int num = (int)(m - 'a');
				int row = num / 2;
				if (num % 2 == 0) {
					Color temp = board[row][0];
					for(int i = 0; i < 5; i++)
						board[row][i] = board[row][i+1];
					board[row][5] = temp;
				} else {
					Color temp = board[row][5];
					for(int i = 5; i > 0; i--)
						board[row][i] = board[row][i-1];
					board[row][0] = temp;
				}
			} else {
					throw new IllegalArgumentException("Solution contains: " + m);
			}
		}
		return Arrays.equals(board[0], SOLVED_ROW) && Arrays.equals(board[1], SOLVED_ROW);
	}

	
	@Test
	public void test00Moves_4() {
		/********** 1 **********/
		Color[][] b_1 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1[1], COL_COUNT);
		answerArray = solver.solve(b_1);
		assertTrue(answerArray.length <= 0);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1 **********/
	}
	
	
	@Test
	public void test01Moves_4() {

		/********** 1 **********/
		Color[][] b_1 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1[1], COL_COUNT);
		answerArray = solver.solve(b_1);
		assertTrue(answerArray.length <= 1);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1 **********/
		
		/********** 2 **********/
		Color[][] b_2 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_2[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_2[1], COL_COUNT);
		answerArray = solver.solve(b_2);
		assertTrue(answerArray.length <= 1);
		assertTrue(checkSolution(copy, answerArray));
		/********** 2 **********/

		/********** 3 **********/
		Color[][] b_3 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_3[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_3[1], COL_COUNT);
		answerArray = solver.solve(b_3);
		assertTrue(answerArray.length <= 1);
		assertTrue(checkSolution(copy, answerArray));
		/********** 3 **********/

		/********** 4 **********/
		Color[][] b_4 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_4[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_4[1], COL_COUNT);
		answerArray = solver.solve(b_4);
		assertTrue(answerArray.length <= 1);
		assertTrue(checkSolution(copy, answerArray));
		/********** 4 **********/

	}
	
	@Test
	public void test02Moves_4() {
		/********** 1 **********/
		Color[][] b_1 = 
		{
			{Display.RED, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1[1], COL_COUNT);
		answerArray = solver.solve(b_1);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1 **********/

		/********** 2 **********/
		Color[][] b_2 = 
		{
			{Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_2[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_2[1], COL_COUNT);
		answerArray = solver.solve(b_2);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 2 **********/

		/********** 3 **********/
		Color[][] b_3 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_3[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_3[1], COL_COUNT);
		answerArray = solver.solve(b_3);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 3 **********/

		/********** 4 **********/
		Color[][] b_4 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.VIOLET, Display.RED},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_4[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_4[1], COL_COUNT);
		answerArray = solver.solve(b_4);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 4 **********/

		/********** 5 **********/
		Color[][] b_5 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE, Display.RED},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_5[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_5[1], COL_COUNT);
		answerArray = solver.solve(b_5);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 5 **********/

		/********** 6 **********/
		Color[][] b_6 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.VIOLET},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_6[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_6[1], COL_COUNT);
		answerArray = solver.solve(b_6);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 6 **********/

		/********** 7 **********/
		Color[][] b_7 = 
		{
			{Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_7[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_7[1], COL_COUNT);
		answerArray = solver.solve(b_7);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 7 **********/

		/********** 8 **********/
		Color[][] b_8 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_8[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_8[1], COL_COUNT);
		answerArray = solver.solve(b_8);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 8 **********/

		/********** 9 **********/
		Color[][] b_9 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_9[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_9[1], COL_COUNT);
		answerArray = solver.solve(b_9);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 9 **********/

		/********** 10 **********/
		Color[][] b_10 = 
		{
			{Display.RED, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_10[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_10[1], COL_COUNT);
		answerArray = solver.solve(b_10);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 10 **********/

		/********** 11 **********/
		Color[][] b_11 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.RED, Display.RED, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_11[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_11[1], COL_COUNT);
		answerArray = solver.solve(b_11);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 11 **********/

		/********** 12 **********/
		Color[][] b_12 = 
		{
			{Display.VIOLET, Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.RED, Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_12[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_12[1], COL_COUNT);
		answerArray = solver.solve(b_12);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 12 **********/

		/********** 13 **********/
		Color[][] b_13 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_13[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_13[1], COL_COUNT);
		answerArray = solver.solve(b_13);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 13 **********/

		/********** 14 **********/
		Color[][] b_14 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.BLUE},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_14[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_14[1], COL_COUNT);
		answerArray = solver.solve(b_14);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 14 **********/

		/********** 15 **********/
		Color[][] b_15 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_15[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_15[1], COL_COUNT);
		answerArray = solver.solve(b_15);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 15 **********/

		/********** 16 **********/
		Color[][] b_16 = 
		{
			{Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN},
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_16[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_16[1], COL_COUNT);
		answerArray = solver.solve(b_16);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 16 **********/

		/********** 17 **********/
		Color[][] b_17 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_17[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_17[1], COL_COUNT);
		answerArray = solver.solve(b_17);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 17 **********/

		/********** 18 **********/
		Color[][] b_18 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_18[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_18[1], COL_COUNT);
		answerArray = solver.solve(b_18);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 18 **********/

		/********** 19 **********/
		Color[][] b_19 = 
		{
			{Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_19[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_19[1], COL_COUNT);
		answerArray = solver.solve(b_19);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 19 **********/

		/********** 20 **********/
		Color[][] b_20 = 
		{
			{Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_20[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_20[1], COL_COUNT);
		answerArray = solver.solve(b_20);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 20 **********/

		/********** 21 **********/
		Color[][] b_21 = 
		{
			{Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_21[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_21[1], COL_COUNT);
		answerArray = solver.solve(b_21);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 21 **********/

		/********** 22 **********/
		Color[][] b_22 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.BLUE, Display.VIOLET},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_22[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_22[1], COL_COUNT);
		answerArray = solver.solve(b_22);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 22 **********/

		/********** 23 **********/
		Color[][] b_23 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET, Display.VIOLET},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_23[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_23[1], COL_COUNT);
		answerArray = solver.solve(b_23);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 23 **********/

		/********** 24 **********/
		Color[][] b_24 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.RED},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_24[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_24[1], COL_COUNT);
		answerArray = solver.solve(b_24);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 24 **********/

		/********** 25 **********/
		Color[][] b_25 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_25[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_25[1], COL_COUNT);
		answerArray = solver.solve(b_25);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 25 **********/

		/********** 26 **********/
		Color[][] b_26 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_26[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_26[1], COL_COUNT);
		answerArray = solver.solve(b_26);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 26 **********/

		/********** 27 **********/
		Color[][] b_27 = 
		{
			{Display.RED, Display.RED, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_27[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_27[1], COL_COUNT);
		answerArray = solver.solve(b_27);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 27 **********/

		/********** 28 **********/
		Color[][] b_28 = 
		{
			{Display.RED, Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.VIOLET, Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_28[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_28[1], COL_COUNT);
		answerArray = solver.solve(b_28);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 28 **********/

		/********** 29 **********/
		Color[][] b_29 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_29[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_29[1], COL_COUNT);
		answerArray = solver.solve(b_29);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 29 **********/

		/********** 30 **********/
		Color[][] b_30 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.VIOLET},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.BLUE, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_30[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_30[1], COL_COUNT);
		answerArray = solver.solve(b_30);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 30 **********/

		/********** 31 **********/
		Color[][] b_31 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.BLUE},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_31[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_31[1], COL_COUNT);
		answerArray = solver.solve(b_31);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 31 **********/

		/********** 32 **********/
		Color[][] b_32 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN}
		};

		copy[0] = Arrays.copyOf(b_32[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_32[1], COL_COUNT);
		answerArray = solver.solve(b_32);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(copy, answerArray));
		/********** 32 **********/
	}
	
	@Test
	public void test03Moves_4() {
		/********** 21 **********/
		Color[][] b_21 = 
		{
			{Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE},
			{Display.RED, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_21[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_21[1], COL_COUNT);
		answerArray = solver.solve(b_21);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 21 **********/
		
		/********** 66 **********/
		Color[][] b_66 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.RED, Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_66[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_66[1], COL_COUNT);
		answerArray = solver.solve(b_66);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 66 **********/
		
		/********** 107 **********/
		Color[][] b_107 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_107[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_107[1], COL_COUNT);
		answerArray = solver.solve(b_107);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 107 **********/

		/********** 108 **********/
		Color[][] b_108 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.VIOLET, Display.BLUE},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.GREEN, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_108[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_108[1], COL_COUNT);
		answerArray = solver.solve(b_108);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 108 **********/

		/********** 109 **********/
		Color[][] b_109 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.RED},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_109[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_109[1], COL_COUNT);
		answerArray = solver.solve(b_109);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 109 **********/

		/********** 110 **********/
		Color[][] b_110 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_110[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_110[1], COL_COUNT);
		answerArray = solver.solve(b_110);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 110 **********/

		/********** 111 **********/
		Color[][] b_111 = 
		{
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.BLUE, Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN}
		};

		copy[0] = Arrays.copyOf(b_111[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_111[1], COL_COUNT);
		answerArray = solver.solve(b_111);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 111 **********/

		/********** 112 **********/
		Color[][] b_112 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_112[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_112[1], COL_COUNT);
		answerArray = solver.solve(b_112);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 112 **********/
		
		/********** 141 **********/
		Color[][] b_141 = 
		{
			{Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.YELLOW, Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_141[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_141[1], COL_COUNT);
		answerArray = solver.solve(b_141);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(copy, answerArray));
		/********** 141 **********/
	}
	
	@Test
	public void test04Moves_4() {
		/********** 159 **********/
		Color[][] b_159 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.BLUE, Display.GREEN, Display.VIOLET, Display.RED},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_159[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_159[1], COL_COUNT);
		answerArray = solver.solve(b_159);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 159 **********/
		
		/********** 368 **********/
		Color[][] b_368 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_368[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_368[1], COL_COUNT);
		answerArray = solver.solve(b_368);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 368 **********/
		
		/********** 369 **********/
		Color[][] b_369 = 
		{
			{Display.BLUE, Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.GREEN},
			{Display.RED, Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_369[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_369[1], COL_COUNT);
		answerArray = solver.solve(b_369);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 369 **********/

		/********** 370 **********/
		Color[][] b_370 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_370[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_370[1], COL_COUNT);
		answerArray = solver.solve(b_370);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 370 **********/

		/********** 371 **********/
		Color[][] b_371 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.BLUE},
			{Display.VIOLET, Display.RED, Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_371[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_371[1], COL_COUNT);
		answerArray = solver.solve(b_371);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 371 **********/

		/********** 372 **********/
		Color[][] b_372 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.BLUE},
			{Display.RED, Display.RED, Display.YELLOW, Display.YELLOW, Display.GREEN, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_372[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_372[1], COL_COUNT);
		answerArray = solver.solve(b_372);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 372 **********/

		/********** 373 **********/
		Color[][] b_373 = 
		{
			{Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.GREEN, Display.GREEN, Display.VIOLET},
			{Display.RED, Display.RED, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_373[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_373[1], COL_COUNT);
		answerArray = solver.solve(b_373);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 373 **********/

		/********** 374 **********/
		Color[][] b_374 = 
		{
			{Display.ORANGE, Display.ORANGE, Display.GREEN, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.RED, Display.RED, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_374[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_374[1], COL_COUNT);
		answerArray = solver.solve(b_374);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 374 **********/

		/********** 375 **********/
		Color[][] b_375 = 
		{
			{Display.BLUE, Display.VIOLET, Display.ORANGE, Display.ORANGE, Display.GREEN, Display.GREEN},
			{Display.RED, Display.RED, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_375[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_375[1], COL_COUNT);
		answerArray = solver.solve(b_375);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 375 **********/
		
		/********** 629 **********/
		Color[][] b_629 = 
		{
			{Display.YELLOW, Display.YELLOW, Display.GREEN, Display.VIOLET, Display.VIOLET, Display.RED},
			{Display.ORANGE, Display.ORANGE, Display.GREEN, Display.BLUE, Display.BLUE, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_629[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_629[1], COL_COUNT);
		answerArray = solver.solve(b_629);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 629 **********/
		
		/********** 773 **********/
		Color[][] b_773 = 
		{
			{Display.RED, Display.ORANGE, Display.RED, Display.YELLOW, Display.BLUE, Display.VIOLET},
			{Display.BLUE, Display.VIOLET, Display.YELLOW, Display.ORANGE, Display.GREEN, Display.GREEN}
		};

		copy[0] = Arrays.copyOf(b_773[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_773[1], COL_COUNT);
		answerArray = solver.solve(b_773);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(copy, answerArray));
		/********** 773 **********/
	}
	
	@Test
	public void test05Moves_4() {
		/********** 5 **********/
		Color[][] b_5 = 
		{
			{Display.ORANGE, Display.GREEN, Display.GREEN, Display.VIOLET, Display.RED, Display.RED},
			{Display.ORANGE, Display.YELLOW, Display.YELLOW, Display.BLUE, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_5[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_5[1], COL_COUNT);
		answerArray = solver.solve(b_5);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 5 **********/
		
		/********** 1303 **********/
		Color[][] b_1303 = 
		{
			{Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED, Display.VIOLET, Display.YELLOW},
			{Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_1303[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1303[1], COL_COUNT);
		answerArray = solver.solve(b_1303);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1303 **********/
		
		/********** 1304 **********/
		Color[][] b_1304 = 
		{
			{Display.VIOLET, Display.YELLOW, Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED},
			{Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_1304[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1304[1], COL_COUNT);
		answerArray = solver.solve(b_1304);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1304 **********/

		/********** 1305 **********/
		Color[][] b_1305 = 
		{
			{Display.YELLOW, Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED, Display.VIOLET},
			{Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE, Display.ORANGE, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_1305[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1305[1], COL_COUNT);
		answerArray = solver.solve(b_1305);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1305 **********/

		/********** 1306 **********/
		Color[][] b_1306 = 
		{
			{Display.YELLOW, Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED, Display.VIOLET},
			{Display.ORANGE, Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_1306[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1306[1], COL_COUNT);
		answerArray = solver.solve(b_1306);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1306 **********/

		/********** 1307 **********/
		Color[][] b_1307 = 
		{
			{Display.RED, Display.YELLOW, Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW},
			{Display.GREEN, Display.ORANGE, Display.BLUE, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1307[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1307[1], COL_COUNT);
		answerArray = solver.solve(b_1307);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1307 **********/

		/********** 1308 **********/
		Color[][] b_1308 = 
		{
			{Display.GREEN, Display.ORANGE, Display.VIOLET, Display.RED, Display.ORANGE, Display.YELLOW},
			{Display.RED, Display.YELLOW, Display.BLUE, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1308[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1308[1], COL_COUNT);
		answerArray = solver.solve(b_1308);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1308 **********/

		/********** 1309 **********/
		Color[][] b_1309 = 
		{
			{Display.GREEN, Display.YELLOW, Display.BLUE, Display.RED, Display.ORANGE, Display.YELLOW},
			{Display.RED, Display.ORANGE, Display.VIOLET, Display.GREEN, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1309[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1309[1], COL_COUNT);
		answerArray = solver.solve(b_1309);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1309 **********/

		/********** 1310 **********/
		Color[][] b_1310 = 
		{
			{Display.GREEN, Display.YELLOW, Display.VIOLET, Display.GREEN, Display.ORANGE, Display.YELLOW},
			{Display.RED, Display.ORANGE, Display.BLUE, Display.RED, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1310[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1310[1], COL_COUNT);
		answerArray = solver.solve(b_1310);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1310 **********/

		/********** 1311 **********/
		Color[][] b_1311 = 
		{
			{Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED, Display.BLUE, Display.YELLOW},
			{Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.ORANGE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_1311[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_1311[1], COL_COUNT);
		answerArray = solver.solve(b_1311);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 1311 **********/
		
		/********** 2783 **********/
		Color[][] b_2783 = 
		{
			{Display.RED, Display.VIOLET, Display.RED, Display.GREEN, Display.BLUE, Display.GREEN},
			{Display.BLUE, Display.ORANGE, Display.YELLOW, Display.ORANGE, Display.YELLOW, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_2783[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_2783[1], COL_COUNT);
		answerArray = solver.solve(b_2783);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 2783 **********/
		
		/********** 4014 **********/
		Color[][] b_4014 = 
		{
			{Display.RED, Display.ORANGE, Display.RED, Display.ORANGE, Display.GREEN, Display.VIOLET},
			{Display.BLUE, Display.VIOLET, Display.YELLOW, Display.GREEN, Display.YELLOW, Display.BLUE}
		};

		copy[0] = Arrays.copyOf(b_4014[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_4014[1], COL_COUNT);
		answerArray = solver.solve(b_4014);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(copy, answerArray));
		/********** 4014 **********/
	}
	
	@Test
	public void test06Moves_4() {
		/********** 11 **********/
		Color[][] b_11 = 
		{
			{Display.RED, Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.VIOLET},
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.YELLOW, Display.BLUE, Display.VIOLET}
		};

		copy[0] = Arrays.copyOf(b_11[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_11[1], COL_COUNT);
		answerArray = solver.solve(b_11);
		assertTrue(answerArray.length <= 6);
		assertTrue(checkSolution(copy, answerArray));
		/********** 11 **********/
		
		/********** 6655 **********/
		Color[][] b_6655 = 
		{
			{Display.BLUE, Display.YELLOW, Display.GREEN, Display.YELLOW, Display.VIOLET, Display.RED},
			{Display.VIOLET, Display.RED, Display.ORANGE, Display.BLUE, Display.GREEN, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_6655[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_6655[1], COL_COUNT);
		answerArray = solver.solve(b_6655);
		assertTrue(answerArray.length <= 6);
		assertTrue(checkSolution(copy, answerArray));
		/********** 6655 **********/
		
		/********** 14979 **********/
		Color[][] b_14979 = 
		{
			{Display.ORANGE, Display.YELLOW, Display.GREEN, Display.GREEN, Display.RED, Display.VIOLET},
			{Display.YELLOW, Display.ORANGE, Display.BLUE, Display.VIOLET, Display.BLUE, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_14979[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_14979[1], COL_COUNT);
		answerArray = solver.solve(b_14979);
		assertTrue(answerArray.length <= 6);
		assertTrue(checkSolution(copy, answerArray));
		/********** 14979 **********/
		
		/********** 18469 **********/
		Color[][] b_18469 = 
		{
			{Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.ORANGE},
			{Display.YELLOW, Display.VIOLET, Display.BLUE, Display.VIOLET, Display.RED, Display.GREEN}
		};

		copy[0] = Arrays.copyOf(b_18469[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_18469[1], COL_COUNT);
		answerArray = solver.solve(b_18469);
		assertTrue(answerArray.length <= 6);
		assertTrue(checkSolution(copy, answerArray));
		/********** 18469 **********/
	}
	
	@Test
	public void test10Moves_4() {
		/********** 10 **********/
		Color[][] b_10 = 
		{
			{Display.YELLOW, Display.ORANGE, Display.VIOLET, Display.BLUE, Display.RED, Display.ORANGE},
			{Display.VIOLET, Display.GREEN, Display.YELLOW, Display.BLUE, Display.GREEN, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_10[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_10[1], COL_COUNT);
		answerArray = solver.solve(b_10);
		assertTrue(answerArray.length <= 10);
		assertTrue(checkSolution(copy, answerArray));
		/********** 10 **********/
				/********** 2609084 **********/

		Color[][] b_2609084 = 
		{
			{Display.RED, Display.ORANGE, Display.VIOLET, Display.BLUE, Display.BLUE, Display.ORANGE},
			{Display.GREEN, Display.YELLOW, Display.YELLOW, Display.VIOLET, Display.GREEN, Display.RED}
		};

		copy[0] = Arrays.copyOf(b_2609084[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_2609084[1], COL_COUNT);
		answerArray = solver.solve(b_2609084);
		assertTrue(answerArray.length <= 10);
		assertTrue(checkSolution(copy, answerArray));
		/********** 2609084 **********/
	}
	
	@Test
	public void test12Moves_4() {
		/********** 153871 **********/
		Color[][] b_153871 = 
		{
			{Display.ORANGE, Display.RED, Display.VIOLET, Display.YELLOW, Display.BLUE, Display.GREEN},
			{Display.YELLOW, Display.GREEN, Display.BLUE, Display.RED, Display.VIOLET, Display.ORANGE}
		};

		copy[0] = Arrays.copyOf(b_153871[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_153871[1], COL_COUNT);
		answerArray = solver.solve(b_153871);
		assertTrue(answerArray.length <= 12);
		assertTrue(checkSolution(copy, answerArray));
		/********** 153871 **********/
		
		/********** 430835 **********/
		Color[][] b_430835 = 
		{
			{Display.VIOLET, Display.GREEN, Display.RED, Display.VIOLET, Display.BLUE, Display.YELLOW},
			{Display.ORANGE, Display.RED, Display.ORANGE, Display.GREEN, Display.BLUE, Display.YELLOW}
		};

		copy[0] = Arrays.copyOf(b_430835[0], COL_COUNT);
		copy[1] = Arrays.copyOf(b_430835[1], COL_COUNT);
		answerArray = solver.solve(b_430835);
		assertTrue(answerArray.length <= 12);
		assertTrue(checkSolution(copy, answerArray));
		/********** 430835 **********/
	}
}
