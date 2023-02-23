import h1.*;
import tests.EuclidTest;
import tests.TaiTest;

public class Main {
    public static void main(String[] args) {

        TaiTest tests = new TaiTest(
                new EuclidTest()
        );
        tests.run();

    }

    public static void print(String s) {
        System.out.println(s);
    }


}