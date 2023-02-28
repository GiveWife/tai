package backtracking;

import util.OperationTime;
import util.Printer;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    private final int size;
    private Printer printer = new Printer();
    private int limit = 20;
    private int counter = 0;
    private List<Board> solutions = new ArrayList<Board>();
    private int[][] start;

    public SudokuSolver(int size) {
        this.size = size;
        int[][] board = fill();
        this.start = board;
        OperationTime time = new OperationTime();
        time.start();
        this.solve(template());
        time.stop();
        solution();
        time.evaluation();
    }

    private int[][] template() {
        return new int[][]{

                {-1, 2, 3, -1, -1, -1},
                {4, -1, 5, -1, -1, -1},
                {-1, 5, -1, 2, -1, -1},
                {-1, -1, 4, -1, 1, -1},
                {-1, -1, -1, 4, -1, 1},
                {-1, -1, -1, 6, 3, -1}

        };
    }

    public void solution() {
        for(int i = 0; i < solutions.size(); i++) {

            solutions.get(i).print();
            printer.print("\n");

        }
    }

    private boolean isCopy(int[][] lista, int[][] listb) {
        for(int i = 0; i < lista.length; i++) {
            for(int j = 0; j < lista.length; j++) {
                if(lista[i][j] != listb[i][j]) return false;
            }
        }
        return true;
    }

    private int[][] fill() {
        int[][] board = new int[size][size];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = -1;
            }
        }
        return board;
    }

    public int[][][] getCopies(int[][] original) {
        int[][][] copies = new int[size][size][size];

        for(int i = 0; i < copies.length; i++) {
            int[][] deepCopy = new int[size][size];

            // Copy element by element;
            for(int x = 0; x < original.length; x++)
                for(int y = 0; y < original.length; y++)
                    deepCopy[x][y] = original[x][y];

            copies[i] = deepCopy;
        }

        return copies;
    }

    public boolean examine(int[][] board) {

        //printer.print("Checking board: " + printer.doubleArrString(board));
        // Row
        List<Integer> rowtest = new ArrayList<Integer>();
        List<Integer> columntest = new ArrayList<Integer>();
        int column = 0;

        for(int i = 0; i < size*board.length; i++) {

            // Test row ; only when i < board.length
            for(int j = 0; i < board.length && j < board[i].length; j++) {
                int entry = board[i][j];
                //printer.print("Row: Checking (" + i + ", " + j + "): " + entry);

                if(!rowtest.contains(entry) || entry == -1) {
                    rowtest.add(entry);
                } else {
                    //printer.print("Testing board: ", printer.doubleArrString(board));
                    //printer.print("Testing row: " + printer.arrString(board[i]) + " -> entry: " + entry + " conflicts with array: " + printer.listString(rowtest));
                    //printer.print("Rows are invalid: ", printer.listString(rowtest));
                    return false;
                }
            }

            if(i < size) rowtest.clear();

            // Testing columns
            for(int j = column; j < column+1 && j < size; j++) {
                int entry = board[i%(size)][j];
                //printer.print("Column: Checking (" + (i%size) + ", " + j + "): " + entry);
                if(!columntest.contains(entry) || entry == -1)
                    columntest.add(entry);
                else {
                    //printer.print("Testing board: ", printer.doubleArrString(board));
                    //printer.print("Testing column: " + printer.arrString(board[i%size]) + " -> entry: " + entry + " conflicts with array: " + printer.listString(columntest));
                    //printer.print("Columns are invalid: ", printer.listString(columntest));
                    return false;
                }
            }

            // Clear list after every 3 iterations
            // Try to intercept i == size - 1, we need to increase it for next iteration.
            if(i != 0 && (i+1) % size == 0) {
                columntest.clear();
                column++;
            }

        }

        return true;
    }

    public int[][][] expand(int[][] original) {

        int[][][] copies = getCopies(original);
        boolean innerBreak = false;

        for(int x = 0; x < copies.length; x++) {

            int[][] board = copies[x];

            for (int i = 0; i < board.length && !innerBreak; i++) {
                for (int j = 0; j < board[i].length; j++) {

                    // When we find a spot that has -1 == not initialized ; we can generate all possible boards
                    if (board[i][j] == -1) {

                        board[i][j] = x+1;
                        innerBreak = true;
                        break;

                    }

                }

            }

            innerBreak = false;
        }

        return copies;

    }

    public void solve(int[][] board) {

        if(!shouldExpand(board) && examine(board)) {
            for(int i = 0; i < solutions.size(); i++) {
                if(isCopy(solutions.get(i).getBoard(), board)) printer.print("Equivalent solutions!");
            }
            printer.print("Solution found: ", printer.doubleArrString(board));
            //printer.print(Printer.GREEN_BOLD_BRIGHT, "Solution: ", Printer.WHITE_BOLD_BRIGHT, printer.doubleArrString(board), Printer.ANSI_RESET);
            solutions.add(new Board(board));
        }

        // If the board is valid, we expand to all possible solutions
        else if(examine(board)) {

            int[][][] expansions = expand(board);

            for(int i = 0; i < expansions.length; i++) {


                solve(expansions[i]);


            }

        }

    }

    private void result(int[][] board) {
        printer.print("Solution: " + Printer.WHITE_BOLD_BRIGHT + printer.doubleArrString(board));
    }

    private boolean shouldExpand(int[][] board) {

        for(int i = 0; i < board.length; i++) {

            for(int j = 0; j < board[i].length; j++) {

                if(board[i][j] == -1) return true;

            }

        }


        return false;

    }

    public static class Board {

        private final int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        public void print() {
            Printer p = new Printer();
            for(int i = 0; i < board.length; i++) {
                p.print(p.arrString(board[i]));
            }
        }

        public int[][] getBoard() {
            return board;
        }

    }

}
