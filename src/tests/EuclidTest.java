package tests;

import h1.AlgorithmEuclid;

public class EuclidTest extends TestBase {

    public EuclidTest() {
        super("Euclid");
    }

    @Override
    public void test() {

        AlgorithmEuclid e = new AlgorithmEuclid(17,3);
        print(Integer.toString(e.getHighestDivider()));

    }

}
