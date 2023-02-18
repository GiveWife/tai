package h1;

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
public class BezoutIdentity {

    private final int a, b, c;
    private AlgorithmEuclid euclid = new AlgorithmEuclid();

    // ax + by = c
    // ax == c mod(b)
    public BezoutIdentity(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Bezout identity zegt:
     *          e = ax + by
     *
     * Algemeen geldt dat: d = (a, b) moet e kunnen delen.
     */
    public boolean isPossible() {
        int divider = euclid.getHighestDivider(22911, 9856);
        return euclid.isInteger(c / divider) ? true : false;
    }



}
