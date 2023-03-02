package backtracking;

import util.Printer;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    private final int size;
    private final Printer printer = new Printer();
    private List<Board> solutions = new ArrayList<>();
    private final int[][] start;
    private boolean hasRun = false;

    /**
     * The template can be incorrect.
     */
    public SudokuSolver(int[][] template) {
        if(template.length <= 0 || template[0].length != template.length) {
            printer.print("Invalid template. Dimensions are invalid");
            this.size = 3;
            this.start = fill();
        } else {
            this.size = template.length;
            this.start = template;
        }
    }
    public SudokuSolver(int size) {
        this.size = size;
        this.start = fill();
    }


    /**
     * Prints out the solution
     */
    public void solution() {
        if(!hasRun) return;
        for(int i = 0; i < solutions.size(); i++) {

            // Print individual board
            for(int j = 0; j < solutions.get(i).board.length; j++) {
                printer.print(arrString(solutions.get(i).getBoard()));
                printer.print("\n");
            }

            printer.print("\n");
        }
    }

    /**
     * Highlights the preset values in the solution
     */
    private String arrString(int[][] print) {
        if(print.length != start.length || print[0].length != start[0].length) return "Invalid arrays";
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < print.length; i++) {
            b.append("[");
            for(int j = 0; j < print[i].length; j++) {
                if(start[i][j] != -1) b.append(printer.build(Printer.WHITE_BOLD_BRIGHT, Integer.toString(print[i][j]), Printer.ANSI_RESET));
                else b.append(print[i][j]);
                if (j < print[i].length - 1) b.append(", ");
            }
            if(i < print.length-1) b.append("]\n");
            else b.append("]");
        }
        return b.toString();
    }

    private boolean isCopy(int[][] lista, int[][] listb) {
        for(int i = 0; i < lista.length; i++) {
            for(int j = 0; j < lista.length; j++) {
                if(lista[i][j] != listb[i][j]) return false;
            }
        }
        return true;
    }

    /**
     * Creates a new board using {@link SudokuSolver#size}.
     */
    private int[][] fill() {
        int[][] board = new int[size][size];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = -1;
            }
        }
        return board;
    }

    /**
     * Returns a list of copies of the given board. It will always return {@link SudokuSolver#size} copies.
     */
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

    /**
     * Examines the board and returns if we should continue expanding this board
     */
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

    /**
     * Expands the given board with all possible values. Then returns a list of those boards.
     * Uses {@link SudokuSolver#getCopies(int[][])}
     */
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

    /**
     * Solve will get a list of expansions from {@link SudokuSolver#expand(int[][])}. Then it will
     * examine each element of the list via {@link SudokuSolver#expand(int[][])}. The board that
     * should expand further will again be expanded and examined
     */
    private void solve(int[][] board) {

        if(!shouldExpand(board) && examine(board)) {
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

    /**
     * Starts the algorithm to solve this puzzle
     */
    public void solve() {
        solve(start);
        hasRun = true;
    }

    /**
     * In {@link SudokuSolver#solve(int[][])}, we will also check if the board is full & correct.
     * If both are okay, we will return false in this method.
     */
    private boolean shouldExpand(int[][] board) {

        for(int i = 0; i < board.length; i++) {

            for(int j = 0; j < board[i].length; j++) {

                if(board[i][j] == -1) return true;

            }

        }


        return false;

    }

    /**
     * Helper class that holds an int[][] object. The class {@link SudokuSolver} holds a list of
     * Board objects as solutions.
     */
    public static class Board {

        private final int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        @Deprecated
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
