package tests;

import algorithms.AlgorithmEuclid;
import algorithms.PrimeTest;
import util.NumberTheory;

public class PrimeTestTest extends TestBase {

    public PrimeTestTest() {
        super("Prime Test");
    }

    @Override
    public void test() {

        PrimeTest t = new PrimeTest(919);
        t.run();
        testValue(t.values(), true, t.isPrime());

        t = new PrimeTest(18);
        t.run();
        testValue(t.values(), false, t.isPrime());

        t = new PrimeTest(19);
        t.run();
        testValue(t.values(), true, t.isPrime());

        t = new PrimeTest(2465);
        t.run();
        testValue(t.values(), true, t.isPrime());

        for(int i = 2; i < 10000; i++) {
            t = new PrimeTest(i);
            t.run();
            AlgorithmEuclid e = new AlgorithmEuclid(1,1);
            testValue(t.values(), NumberTheory.isPrime(i), t.isPrime());
        }

        evaluate();
    }

}
