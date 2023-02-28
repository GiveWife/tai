package tests;

import util.NumberTheory;

public class NumberTheoryTest extends TestBase {

    public NumberTheoryTest() {
        super("Number Theory");
    }

    @Override
    public void test() {

        print("Checking if coprimes are detected: ");
        testValue("(2, 3)", true, NumberTheory.isCoprime(2, 3));
        testValue("(3, 5)", true, NumberTheory.isCoprime(3, 5));
        testValue("(5, 7)", true, NumberTheory.isCoprime(5, 7));
        testValue("(7, 11)", true, NumberTheory.isCoprime(7, 11));
        testValue("(5, 10)", false, NumberTheory.isCoprime(5, 10));
        testValue("(9, 18)", false, NumberTheory.isCoprime(9, 18));

        evaluate();
    }



}
