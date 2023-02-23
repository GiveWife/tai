package tests;

import util.Printer;

public abstract class TestBase extends Printer {

    private final String name;

    public TestBase(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Runs all tests for the implementation
     */
    public abstract void test();

}
