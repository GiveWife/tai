package tests;

import h1.algorithms.AlgorithmEuclid;

public class EuclidTest extends TestBase {

    public EuclidTest() {
        super("Euclid");
    }

    @Override
    public void test() {

        print("Testing euclid's algorithm: highest divider");

        AlgorithmEuclid e = new AlgorithmEuclid(17,3);
        testValue(e.values(), 1, e.getHighestDivider());

        e = new AlgorithmEuclid(5,15);
        testValue(e.values(), 5, e.getHighestDivider());

        e = new AlgorithmEuclid(7,15);
        testValue(e.values(), 1, e.getHighestDivider());

        e = new AlgorithmEuclid(90,15);
        testValue(e.values(), 15, e.getHighestDivider());

        e = new AlgorithmEuclid(7,10);
        testValue(e.values(), 1, e.getHighestDivider());

        print("\nTesting euclid's fit method");
        testValue("(9,4)", 2, e.fit(9,4));
        testValue("(4,9)", 2, e.fit(4,9));

        print("\nTesting euclid's divide method");
        testValue("(3,9)", true, e.divide(3,9));
        testValue("(9,3)", false, e.divide(9,3));
        testValue("(4,3)", false, e.divide(4,3));
        testValue("(3,4)", false, e.divide(3, 4));

        evaluate();

    }

}
