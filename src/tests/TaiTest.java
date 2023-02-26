package tests;

import java.util.Vector;

/**
 * Class that runs all tests
 */
public class TaiTest {

    private final TestBase[] tests;

    /**
     * Creates an instance
     */
    TaiTest() {
        tests = getTests();
    }

    /**
     * Runs the tests of this repository
     */
    public static void runTests() {
        (new TaiTest()).run();
    }

    /**
     * Handler class for this repositories' tests.
     */
    public void run() {

        for(TestBase t : tests) {
            t.test();
            t.print("\n\n");
        }

    }

    /**
     * Returns a set of tests for this repository
     */
    private TestBase[] getTests() {
        return new TestBase[] {
                //new EuclidTest(),
                new BezoutTest()
                //new VectorOperationTest(),
                //new CombinationTest()
        };
    }

}
