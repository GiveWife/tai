package util;

import algorithms.AlgorithmEuclid;

public class NumberTheory {

    public static final Printer printer = new Printer("NumberTheory ");

    /**
     * Determines if the given integer is a prime number
     */
    public static boolean isPrime(int i) {
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

    public static boolean isCoprime(int a, int b) {

        AlgorithmEuclid e = new AlgorithmEuclid();

        return e.getHighestDivider() == 1;
    }

    /**
     * Determines if the given float is an integer
     */
    public static boolean isInteger(float i) {
        // Example i = 5.06
        // 5.06 - 5 ?= 0?
        //System.out.println("  test " + i + " --> " + (i - (int) i));
        return i - (int) i == 0f;
    }

}
