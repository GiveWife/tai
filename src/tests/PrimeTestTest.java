package tests;

import h1.algorithms.PrimeTest;

public class PrimeTestTest extends TestBase {

    public PrimeTestTest() {
        super("Prime Test");
    }

    @Override
    public void test() {

        PrimeTest t = new PrimeTest();
        printArr(t.binary(13));


    }

}
