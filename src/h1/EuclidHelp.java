package h1;

public class EuclidHelp {

    public EuclidHelp() {}

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
    

    public boolean isInteger(float i) {
        // Example i = 5.06
        // 5.06 - 5 ?= 0?
        //System.out.println("  test " + i + " --> " + (i - (int) i));
        return i - (int) i == 0f;
    }

}
