package h1.algorithms;

public class Combination extends Algorithm {

    private final int n, k;
    private int solution;

    public Combination(int n, int k) {
        super("Combination");
        this.n = n;
        this.k = k;
        if(n < 0 || k < 0) {

        }
    }

    @Override
    public void run() {

        solution = factorial(n) / (factorial(k) * factorial(n-k));
        solutionString += Integer.toString(solution);

        solution();
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
        return null;
    }

    @Override
    public void uitleg() {
        print("");
    }

}
