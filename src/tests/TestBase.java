package tests;

import util.Printer;

public abstract class TestBase {

    private Printer printer = new Printer();

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

    /**
     * Tests if values match & prints message according to result
     */
    public final void testValue(String test, int a, int b) {
        if(a != b) fail(test, Integer.toString(a), Integer.toString(b));
        else pass(test, Integer.toString(a), Integer.toString(b));
    }

    /**
     * Tests if values match & prints message according to result
     */
    public final void testValue(String test, boolean a, boolean b) {
        if(a != b) fail(test, Boolean.toString(a), Boolean.toString(b));
        else pass(test, Boolean.toString(a), Boolean.toString(b));
    }

    /**
     * Tests if values match & prints message according to result
     */
    public final void testValue(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) print("Test invalid: " + printer.arrString(arr1) + " - " + printer.arrString(arr2) + ". Array lengths do not match.");
        boolean equal = true;
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) equal = false;
        }
        if(equal) match(printer.arrString(arr1), printer.arrString(arr2));
    }

    private void match(String value1, String value2) {
        print("Test passed: " + value1 + " and " + value2 + " match.");
    }

    private void nonmatch(String value1, String value2) {
        print("Test failed: " + value1 + " and " + value2 + " don't match.");
    }

    private void fail(String values, String expected, String calculated) {
        print("Test failed: " + values + " -> expected: " + expected + " ; calculated: " + calculated);
    }

    private void pass(String values, String expected, String calculated) {
        print("Test passed: " + values + " -> expected: " + expected + " ; calculated: " + calculated);
    }

    protected void print(String s) {
        printer.print(s);
    }

}
