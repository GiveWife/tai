package tests;

import algorithms.Algorithm;
import algorithms.AlgorithmEuclid;

public class OrdeTest extends TestBase {

    public OrdeTest() {
        super("Orde");
    }

    @Override
    public void test() {

        AlgorithmEuclid e = new AlgorithmEuclid();

        testValue(values(5,27), 18, e.getOrder(5,27));


    }

    private String values(int a, int b) {
        StringBuilder builder = new StringBuilder();
        return builder.append(Integer.toString(a)).append("^x mod ").append(Integer.toString(b)).toString();
    }

}
