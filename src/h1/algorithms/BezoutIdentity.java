package h1.algorithms;

import util.Color;
import util.Printer;
import util.VectorOperation;

/**
 * BezoutIdentity was relevant voor de multiplicatieve caesar cijfer.
 *
 * e = ax + by
 *
 * Caesar versleutelt met sleutel e, de numerieke waarde w, modulo 27
 *      e * w (mod 27) = v
 *
 * Om te ontsleutelen moet gelden:
 *      e * d (mod 27) = 1
 *
 * zodat:
 *      d * v (mod 27) = w
 *      d * (e * w (mod 27)) (mod 27) = w
 *      w * (e * d (mod 27)) (mod 27) = w
 *      w * (1)              (mod 27) = w
 *
 * Maar hoe vinden we een d zodat:
 *      e * d (mod 27) = 1
 *
 * We herschrijven:
 *      ed + 27y = 1
 *
 * Bezout Identiteit zegt dat ggd(5,27) het getal 1 moet kunnen delen.
 * We zien dus dat dit enkel 1 mag zijn. Sleutel 6 voor e zal bv geven:
 *      6 * w (mod 27) = v
 *      6d * 27y = 1 ?
 *      3 ( 2d * 9y ) = 1
 *
 * Dit kan niet omdat 3 * iets = 1 !
 *
 * 1) Bezout Identiteit helpt ons sleutels te schrappen die zeker niet werken voor lage modulo's.
 *
 * Hoe lossen we dit nu op?
 *
 *   5  = 1 * 5 + 0 * 27   ->  (5, 1, 0)  == A
 *   27 = 0 * 5 + 1 * 27   ->  (27, 0, 1) == B
 *
 * We zorgen voor een vector met (1, x, y)
 *
 *   B = B - 3A -> B: (2, -5, 1)
 *   A = A - 2B -> A: (1, 11, -2)
 *
 * En we zien dus dat:
 *
 *  1 = 11 * 5  +  (-2) * 27
 *
 */
public class BezoutIdentity extends Algorithm {

    // Original values
    private final int oa, ob, oc;
    private int a, b;
    private float c;
    private int[] solution;
    private final AlgorithmEuclid euclid;
    private String solutionString = "unsolved";
    // ax + by = c
    // ax == c mod(b)
    public BezoutIdentity(int a, int b, int c) {
        super("Bezout");
        // Copy of original
        this.oa = a;
        this.ob = b;
        this.oc = c;
        // Non final variables
        this.a = a;
        this.b = b;
        this.c = (float) c;
        euclid = new AlgorithmEuclid(a, b);
    }

    /**
     * Bezout identity zegt:
     *          e = ax + by
     *
     * Algemeen geldt dat: d = (a, b) moet e kunnen delen.
     */
    public boolean isPossible() {
        int divider = euclid.getHighestDivider();
        return euclid.isInteger(c / divider);
    }

    /**
     * Returns all other solutions if the modulo was simplified.
     */
    public int[] getMultipleSolutions() {
        // If b was simplified, return all other solutions
        if(b != ob) {
            int checkfit = euclid.fit(ob - solution[0], b);
            int count = 0;

            int[] mult = new int[checkfit];

            // Loop over how many times we can find a solution.
            while(count < checkfit) {

                // Alter this solution: add our current modulo to it.
                mult[count] = solution[0] + b;

                count++;
            }
            return mult;
        }
        // Return normal solution
        return new int[] {solution[0]};
    }

    /**
     * Returns the solution string for this object.
     */
    private String getSolutionString() {
        return solutionString;
    }

    /**
     * Prints the solution of this object.
     */
    public void solution() {
        print(Printer.WHITE_BOLD_BRIGHT + "Solution of " + Printer.BLUE_BOLD_BRIGHT + values() + Printer.WHITE_BOLD_BRIGHT + " is: " + Printer.GREEN_BOLD_BRIGHT + solutionString + Printer.ANSI_RESET);
    }

    /**
     * Solves Bezout Identity.
     *
     * Stores a solution vector
     */
    @Override
    public void run() {

        if(hasRun()) {
            solution();
            return;
        }

        if(!isPossible()) {
            print("Bezout Identity is not possible for the chosen combination of integers: a = " + a + ", b = " + b + ", c = " + c);
            return;
        }

        // Check for validity of operation once again.
        AlgorithmEuclid euclid = new AlgorithmEuclid(a, b);

        // If highest divider is 1, we have one solution.
        if(euclid.getHighestDivider() == 1) {

            // Check for possible simplifications to reduce computing power;
            euclid = new AlgorithmEuclid(a, (int) c);

            // ax == ay mod m -> x = y mod m. Simplify first
            if(euclid.getHighestDivider() != 1) {
                a = a / euclid.getHighestDivider();
                c = c / euclid.getHighestDivider();
                print("Simplified from: " + oa + "x + " + ob + "y = " + oc);
                print("To: " + a + "x + " + b + "y = " + c);
            }

            // Run solution
            calculate();

            // Set solution string, since sometimes multiple solutions are possible
            solutionString = printer.arrString(solution);
        }

        // If highest divider of a and b is not 1, we have multiple solutions.
        else {
            // Highest div is not 1, so we check if c is also dividable by our highest divider
            if(euclid.divide(euclid.getHighestDivider(), (int) c)) {

                print("c  = " + c + " is divisable by " + euclid.getHighestDivider());
                AlgorithmEuclid divider = new AlgorithmEuclid(euclid.getHighestDivider(), (int) c);
                print("c =" + c + " and " + euclid.getHighestDivider() + " can both be divided by: " + divider.getHighestDivider());

                a = a / divider.getHighestDivider();
                b = b / divider.getHighestDivider();
                c = c / divider.getHighestDivider();

                calculate();

                // if our solution for x == a
                // then we can add our new mod b to a until we reach ob

                // We subtract our solution x from our original modulo.
                // Then we see how many times our simplified modulo can be added to our solution
                int checkfit = euclid.fit(ob - solution[0], b);
                int count = 0;

                // Add our first solution first!
                solutionString = printer.arrString(solution);

                // Loop over how many times we can find a solution.
                while(count < checkfit) {

                    // Create new array from solution.
                    int[] temp_sol = solution;

                    // Alter this solution: add our current modulo to it.
                    temp_sol[0] += b;

                    // If ob = 6, x + b == 6, then our solution is actually 0.
                    if(temp_sol[0] % ob == 0) break;
                    solutionString += Color.white(" ,");

                    // Add the solution to our string
                    solutionString += Color.greenb(printer.arrString(temp_sol));

                    count++;
                }

            }
        }

        toggleRun();
        solution();

    }

    /**
     * This method calculates one solution of the bezout identity. This runs when gcd(a, b) == 1.
     * {@link BezoutIdentity#isPossible()} checks if this gcd divides c.
     *
     * We use {@link VectorOperation} to calculate the vectors of this problem:
     *  veca = (a, 1, 0)
     *  vecb = (b, 0, 1)
     *
     * We use {@link AlgorithmEuclid#fit(int, int)} to subtract vectors from eachother.
     * We will end on (1, x, y). The vector will be multiplied by c in the end to get:
     *
     * (c , cx, cy)
     *
     * So we have our identity: c = cx + cy
     * We downscale cx and cy via our value b.
     */
    private void calculate() {
        int it = 0;
        // Vector Operation handler
        VectorOperation op = new VectorOperation();

        // We will solve for 1; then scale up to c
        int[] veca = new int[] {a, 1, 0};
        int[] vecb = new int[] {b, 0, 1};

        // We subtract vectors from eachother. If a > b, we would subtract bx from a
        // 1 -> start with vecb
        int togg = a > b ? 1 : 0;

        //print("veca: " + printer.arrString(veca));
        //print("vecb: " + printer.arrString(vecb));

        while(veca[0] != 1 && vecb[0] != 1 && it < 10) {

            // Check the highest divider ; we need not worry about if a > b, the algorithm will detect that for us
            int highestDivider = euclid.fit(veca[0], vecb[0]);

            // Update vectors. Toggle == 1, subtract b from a;
            if(togg == 1) {

                // Subtract b from a
                veca = op.subtract(veca, vecb, highestDivider);

            }
            else {

                // Subtract a from b
                vecb = op.subtract(vecb, veca, highestDivider);

            }

            print("veca: " + printer.arrString(veca));
            print("vecb: " + printer.arrString(vecb));

            // Switch toggle value
            togg = togg == 1 ? 0 : 1;

            it++;

        }

        // Select latest edited row
        int[] res = togg == 1 ? vecb : veca;

        // Multiply so we have c = .. + ..
        res = op.multiply(res, (int) c);

        // We must now downscale our x in : ax + by = c
        // 3*8 + 5*(-4) = 4 -> 24-20 = 4
        // 3*3 + 5*(-1) = 4 -> 9 - 5 = 4
        // All solutions 3 + 5t = x
        int x = res[1] % b;

        // ax + by = c
        // if a*x > c, then we should decrease that number by y*b to get c.
        // calculate: ax - c = by ; normally we can divide left part by b!
        int y = x * a > c ? (int) ((x*a)-c) / (-b) : (int) ((x*a)-c) / (b);

        solution = new int[] {x, y};

    }

    @Override
    public String values() {
        return "(" + a + "," + b + "," + (int) c + ")";
    }

    /**
     * En we zien dus dat:
     *
     *  1 = 11 * 5  +  (-2) * 27
     *
     *  We vinden nu een oplossing voor de vgl
     *      e * d (mod 27) = 1
     *
     */
    @Override
    public void uitleg() {
        StringBuilder b = new StringBuilder();

        b.append("BezoutIdentity was relevant voor de multiplicatieve caesar cijfer.\n\n");
        b.append("     e = ax + by\n");
        b.append("     e = ax (mod b)\n\n");
        b.append("Caesar versleutelt met sleutel e, de numerieke waarde w, modulo 27\n");
        b.append("     e * w (mod 27) = v\n\n");
        b.append("Om te ontsleutelen moet gelden:\n");
        b.append("     e * d (mod 27) = 1\n\n");
        b.append("zodat:\n");
        b.append("     d * v (mod 27) = w\n");
        b.append("     d * (e * w (mod 27)) (mod 27) = w\n");
        b.append("     w * (e * d (mod 27)) (mod 27) = w\n");
        b.append("     w * (1)              (mod 27) = w\n\n");
        b.append("Maar hoe vinden we een d zodat:\n");
        b.append("     e * d (mod 27) = 1\n\n");
        b.append("We herschrijven:\n");
        b.append("     ed + 27y = 1\n\n");
        b.append("Bezout Identiteit zegt dat ggd(5,27) het getal 1 moet kunnen delen.\nWe zien dus dat ggd enkel 1 mag zijn. Sleutel 6 voor e zal bv geven:\n");
        b.append("     6 * w (mod 27) = v\n");
        b.append("     6d * 27y = 1 ?\n");
        b.append("     3 ( 2d * 9y ) = 1\n\n");
        b.append("Dit kan niet omdat 3 * iets != 1 !\n\n");
        b.append("1) Bezout Identiteit helpt ons sleutels te schrappen die zeker niet werken voor lage modulo's.\n\n");
        b.append("Hoe lossen we dit nu op?\n\n");
        b.append("  5  = 1 * 5 + 0 * 27   ->  (5, 1, 0)  == A\n");
        b.append("  27 = 0 * 5 + 1 * 27   ->  (27, 0, 1) == B\n\n");
        b.append("We zorgen voor een vector met (1, x, y)\n\n");
        b.append("  B = B - 3A -> B: (2, -5, 1)\n");
        b.append("  A = A - 2B -> A: (1, 11, -2)\n\n");
        b.append("En we zien dus dat:\n\n");
        b.append("  1 = 11 * 5  +  (-2) * 27\n\n");
        b.append("We vinden nu een oplossing voor de vgl\n");
        b.append("  e * d (mod 27) = 1");

        print(b.toString());

    }

}
