package tests;

import h1.AlgorithmEuclid;

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

    }

}
