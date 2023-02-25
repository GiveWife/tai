import h1.*;
import tests.BezoutTest;
import tests.EuclidTest;
import tests.TaiTest;
import util.Printer;

public class Main {
    public static void main(String[] args) {

        //TaiTest.runTests();

        BezoutIdentity b = new BezoutIdentity(4, 7, 26);
        //b.run();

        BezoutIdentity b2;

        int i = 2;
        while(i < 26) {
            //Printer.prints("7, 10, " + i);
            b2 = new BezoutIdentity(4, 7, i);
            //b2.run();
            i++;
        }
        TaiTest.runTests();

    }

}