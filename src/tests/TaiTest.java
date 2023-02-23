package tests;

/**
 * Class that runs all tests
 */
public class TaiTest {

    private final TestBase[] tests;

    public TaiTest(TestBase... tes) {
        tests = tes;
    }

    public void run() {

        for(TestBase t : tests) {
            t.test();
        }

    }

}
