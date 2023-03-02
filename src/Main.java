import algorithms.PrimeTest;
import algorithms.XsBinary;
import util.OperationTime;
import util.Printer;

public class Main {
    public static void main(String[] args) {

        Main m = new Main();
        m.test();

    }

    public Main() {

    }

    private void test() {


        OperationTime time = new OperationTime();

        int w = 12;
        int e = 9103;
        int mod = 24;

        XsBinary b = new XsBinary(2, 9103, 17);

        time.start();
        b.run();
        b.printsolution();
        time.stop();

        time.evaluation();

    }

}