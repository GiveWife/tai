package tests;

import h1.algorithms.Combination;

public class CombinationTest extends TestBase {

    public CombinationTest() {
        super("Combination");
    }

    @Override
    public void test() {

        Combination b = new Combination(3, 3);
        int check = (3*2) / (3);
        testValue(b.values(), check, b.getSolution());

        b = new Combination(4,3);
        check = (4*3*2) / (3*2);
        testValue(b.values(), check, b.getSolution());

        b = new Combination(5,3);
        check = (5*4*3*2) / (3*2);
        testValue(b.values(), check, b.getSolution());

        b = new Combination(2,3);
        check = -1;
        testValue(b.values(), check, b.getSolution());


        evaluate();

    }

}
