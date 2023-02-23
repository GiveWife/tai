package h1;

public class AlgorithmEuclid extends Algorithm {

    private final int a1, b1;

    public AlgorithmEuclid(int a, int b) { super("Euclid");
        this.a1 = a;
        this.b1 = b;
    }

    /**
     * Determines if the given integer is a prime number
     */
    public boolean isPrime(int i) {
        if(i == 2 || i == 3 || i == 5 || i == 7) return true;
        int possibleDivisions = 0;
        for(int x = 1; x <= i; x++) {
            if(isInteger((float) i/x)) {
                //System.out.println("Division of " + i + " by " + x + " is an integer. ");
                possibleDivisions++;
            }
        }
        return possibleDivisions == 2;
    }

    /**
     * Determines if the given float is an integer
     */
    public boolean isInteger(float i) {
        // Example i = 5.06
        // 5.06 - 5 ?= 0?
        //System.out.println("  test " + i + " --> " + (i - (int) i));
        return i - (int) i == 0f;
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
        // We should make sure that
        while(res[1] != 0 && res[0] >= 1 && res[1] >= 1) {

            res = runEuclid(res[2], res[1]);

        }

        return res[1] == 0 ? res[2] : -1;

    }

    public static int highestdiv(int a, int b) {
        AlgorithmEuclid euclid = new AlgorithmEuclid(a, b);
        return euclid.getHighestDivider();
    }

    /**
     * note that parameters should be passed in a different order!
     *
     * b = aq + c
     * @pre | b > a
     */
    public int[] runEuclid(int b, int a) {
        // How much does a fit in b?
        float division = b / a;

        // Get minimal amount of a in b
        int q = (int) Math.floor(division);

        // c = b - aq
        return new int[] {q, b - (a*q), a};
    }

    @Override
    public void run() {
        getHighestDivider();
    }

}
