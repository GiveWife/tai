package h1.algorithms;

import util.NumberTheory;

public class AlgorithmEuclid extends Algorithm {

    private final int a1, b1;
    private int highestDivider = -1;

    public AlgorithmEuclid(int a, int b) { super("Euclid");
        this.a1 = a;
        this.b1 = b;
    }

    @Override
    public boolean isPossible() {
        return a1 > 0 && b1 > 0;
    }

    /**
     * Returns how many times a fits in b. The algorithm will make sure the integers get treated correctly:
     *  a > b : c+ (b*q) = a
     *  a < b : c+ (a*q) = bq
     *
     * Remainder can be calculated manually
     */
    public int fit(int a, int b) {
        // If variable a > b, then a would never fit in b. We change values
        if(a > b) {
            int c = b;
            b = a;
            a = c;
        }
        // Determine their quotient
        float i = b / a;
        // Floor it, so 5/4 = 1.2 ==> 1
        return (int) Math.floor(i);
    }

    /**
     * Returns a boolean value determining if a would divide b.
     */
    public boolean divide(int a, int b) {
        return NumberTheory.isInteger((float) b / a);
    }

    /**
     * Returns the highest divider of these two integers
     *
     * uses lemma 3.3:
     *
     */
    public int getHighestDivider() {
        // Check for negatives
        if(a1 <= 0 || b1 <= 0) return -1;

        // Trivial case
        if(a1 == b1) return 1;

        // Assign a and b. b = aq + c. Make sure a and b are assigned correctly
        int a = a1 > b1 ? b1 : a1;
        int b = a1 > b1 ? a1 : b1;

        // Get result from division
        int[] res = runEuclid(b, a);

        // We can keep executing euclid until our rest is 0
        while(res[2] != 0) {
            res = runEuclid(res[1], res[2]);
        }

        // If rest is 0, we can return latest a
        return res[2] == 0 ? res[1] : -1;

    }

    /**
     * Static access method to find greatest divider of a & b.
     */
    public static int highestdiv(int a, int b) {
        AlgorithmEuclid euclid = new AlgorithmEuclid(a, b);
        return euclid.getHighestDivider();
    }

    /**
     * note that parameters should be passed in a different order!
     *
     * b = aq + c
     *
     * returns: { q ; a ; REST }
     *
     * @pre | b > a
     */
    public int[] runEuclid(int b, int a) {
        // How much does a fit in b?
        float division = b / a;

        // Get minimal amount of a in b
        int q = (int) Math.floor(division);

        // c = b - aq
        return new int[] {q, a, b - (a*q)};
    }

    @Override
    public String values() {
        return "(" + a1 + "," + b1 + ")";
    }

    @Override
    public void run() {
        if(hasRun()) return;
        getHighestDivider();
        this.toggleRun();
    }

    @Override
    public void uitleg() {
        print("Met behulp van lemma 3.3 kunnen we euclidisch algoritme uitvoeren");
    }

}
