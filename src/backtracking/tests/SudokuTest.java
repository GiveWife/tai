package backtracking.tests;

import backtracking.SudokuSolver;
import tests.TestBase;

public class SudokuTest extends TestBase {

    public SudokuTest() {
        super("Sudoku Test");
    }

    @Override
    public void test() {
        SudokuSolver s = new SudokuSolver(3);

        int[][] board = new int[][] {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };

        testValue(doubleArrString(board), true, s.examine(board));

        board = new int[][] {
                {2, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };

        testValue(doubleArrString(board), false, s.examine(board));

        board = new int[][] {
                {1, 3, 2},
                {1, 2, 3},
                {2, 1, 3}
        };

        testValue(doubleArrString(board), false, s.examine(board));

    }
}
