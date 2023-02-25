package tests;

import h1.algorithms.BezoutIdentity;

public class BezoutTest extends TestBase {

    public BezoutTest() {
        super("Bezout Identity");
    }

    @Override
    public void test() {

        print("Testing if Bezout Identity can be written.");
        BezoutIdentity t = new BezoutIdentity(5, 10, 1);
        testValue(t.values(), false, t.isPossible());

        t = new BezoutIdentity(5, 9, 1);
        testValue(t.values(), true, t.isPossible());

        t = new BezoutIdentity(5, 10, 5);
        testValue(t.values(), true, t.isPossible());

    }

}
