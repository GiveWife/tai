import h1.*;
import tests.BezoutTest;
import tests.EuclidTest;
import tests.TaiTest;

public class Main {
    public static void main(String[] args) {

        //TaiTest.runTests();

        BezoutIdentity b = new BezoutIdentity(3, 5, 4);
        //b.run();

        BezoutIdentity b2 = new BezoutIdentity(7, 10, 1);
        //b2.run();

        TaiTest.runTests();

    }

    public static void print(String s) {
        System.out.println(s);
    }


}