package tests;

import util.Printer;

public abstract class TestBase extends Printer {


    private final String name;
    private int tests = 0;
    private int fails = 0;

    public TestBase(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Gives an evaluation of the functionality of this class.
     */
    public final void evaluate() {
        print("\n" + Printer.GREEN_BOLD + "Test of " + getName() + " passed " + (tests-fails) + " of " + tests + " tests" + Printer.ANSI_RESET);
    }

    /**
     * Runs all tests for the implementation
     */
    public void test() {
        print("Tests for ", getName());

        evaluate();
    }

    /**
     * Tests if values match & prints message according to result
     */
    public final void testValue(String test, int a, int b) {
        tests++;
        if(a != b) {
            fails++;
            fail(test, Integer.toString(a), Integer.toString(b));
        }
        else pass(test, Integer.toString(a), Integer.toString(b));
    }

    /**
     * Tests if values match & prints message according to result
     */
    public final void testValue(String test, boolean a, boolean b) {
        tests++;
        if(a != b) {
            fail(test, Boolean.toString(a), Boolean.toString(b));
            fails++;
        }
        else pass(test, Boolean.toString(a), Boolean.toString(b));
    }

    /**
     * Tests if values match & prints message according to result
     */
    public final void testValue(int[] arr1, int[] arr2) {
        tests++;
        if(arr1.length != arr2.length) print("Test invalid: " + arrString(arr1) + " - " + arrString(arr2) + ". Array lengths do not match.");

        boolean equal = true;
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) equal = false;
        }
        if(equal) match(arrString(arr1), arrString(arr2));
        else {
            fails++;
            nonmatch(arrString(arr1), arrString(arr2));
        }
    }

    private void match(String value1, String value2) {
        print(passPrint(), value1, " and ", value2, " match.");
    }

    private void nonmatch(String value1, String value2) {
        //print(failPrint() + value1 + " and " + value2 + " don't match.");
        print(failPrint(), value1, " and ", value2, " don't match.");
    }

    private void fail(String values, String expected, String calculated) {
        //print(failPrint() + values + " -> expected: " + expected + " ; calculated: " + calculated);
        print(failPrint(), values, " -> expected: ", expected, " ; calculated: ", calculated);
    }

    private void pass(String values, String expected, String calculated) {
        //print(passPrint() + values + " -> expected: " + expected + " ; calculated: " + calculated);
        print(passPrint(), values, " -> expected: ", expected, " ; calculated: ", calculated);
    }

    private String failPrint() {
        return build("Test ", red("failed"), ": ");
        //return "Test " + red("failed") + ": ";
    }

    private String passPrint() {
        return build("Test ", green("passed"), ": ");
        //return "Test " + green("passed") + ": ";
    }

    /**
     * Makes given string red.
     */
    private String red(String s) {
        return Printer.RED_BOLD_BRIGHT + s + Printer.ANSI_RESET;
    }

    /**
     * Makes given string green
     */
    private String green(String s) {
        return Printer.GREEN_BOLD_BRIGHT + s + Printer.ANSI_RESET;
    }

}
