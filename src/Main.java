import h1.algorithms.BezoutIdentity;

public class Main {
    public static void main(String[] args) {

        //TaiTest.runTests();

        BezoutIdentity b = new BezoutIdentity(4, 6, 42);
        b.run();

        BezoutIdentity b2;

        int i = 27;
        while(i < 26) {
            //Printer.prints("7, 10, " + i);
            b2 = new BezoutIdentity(4, 7, i);
            //b2.run();
            i++;
        }
        //TaiTest.runTests();

    }

}