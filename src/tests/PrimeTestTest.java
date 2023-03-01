package tests;

import algorithms.PrimeTest;

public class PrimeTestTest extends TestBase {

    public PrimeTestTest() {
        super("Prime Test");
    }

    @Override
    public void test() {

        PrimeTest t = new PrimeTest(919, 2);

        t.run();


    }

}
