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

        t = new BezoutIdentity(2, 1, 0);
        testValue(t.values(), true, t.isPossible());

        print("\nTesting if Bezout Identity solutions are correctly found");

        t = new BezoutIdentity(9, 6, 42);
        testValue(t.values(), true, t.isPossible());
        t.run();
        testValue(new int[] {0, 2, 4}, t.getSolutions());

        t = new BezoutIdentity(4, 7, 26);
        testValue(t.values(), true, t.isPossible());
        t.run();
        testValue(new int[] {3}, t.getSolutions());

        t = new BezoutIdentity(3, 5, 1);
        testValue(t.values(), true, t.isPossible());
        t.run();
        testValue(new int[] {2}, t.getSolutions());

        t = new BezoutIdentity(2, 5, 1);
        testValue(t.values(), true, t.isPossible());
        t.run();
        testValue(new int[] {3}, t.getSolutions());

        t = new BezoutIdentity(2, 17, 1);
        testValue(t.values(), true, t.isPossible());
        t.run();
        testValue(new int[] {9}, t.getSolutions());

        t = new BezoutIdentity(3, 17, 1);
        testValue(t.values(), true, t.isPossible());
        t.run();
        testValue(new int[] {6}, t.getSolutions());



        evaluate();
    }

}
