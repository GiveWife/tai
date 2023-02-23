package h1;

import util.LeerstofModule;
import util.Printer;

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
public class BezoutIdentity extends Algorithm implements LeerstofModule {

    private final int a, b, c;
    private final AlgorithmEuclid euclid;

    // ax + by = c
    // ax == c mod(b)
    public BezoutIdentity(int a, int b, int c) {
        super("Bezout");
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public void run() {

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
