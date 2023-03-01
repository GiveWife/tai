package algorithms;

import algorithms.Algorithm;
import util.Printer;

public class Combination extends Algorithm {

    private final int n, k;
    private int solution;

    public Combination(int n, int k) {
        super("Combination");
        this.n = n;
        this.k = k;
        if(n < 0 || k < 0 || n < k)
            print(printer.build(Printer.RED_BOLD_BRIGHT, "Invalid parameters for ", Printer.WHITE_BOLD_BRIGHT, "Combination ", values()));
    }

    @Override
    public boolean isPossible() {
        return n < 0 || k < 0 || n < k;
    }

    /**
     * Returns the solution of this combination
     */
    public int getSolution() {
        return solution;
    }

    @Override
    public void run() {

        solution = factorial(n) / (factorial(k) * factorial(n-k));
        solutionString += Integer.toString(solution);

        printsolution();
        toggleRun();

    }

    private int factorial(int n) {
        int fac = 1;
        for(int i = 0; i < n; i++) {
            fac *= n-i;
        }
        return fac;
    }

    @Override
    public String values() {
        return this.n + " C " + this.k;
    }

    @Override
    public void uitleg() {
        print("");
    }

}
