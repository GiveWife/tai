import algorithms.*;
import backtracking.SudokuSolver;
import util.OperationTime;
import util.Printer;

public class Main {
    public static void main(String[] args) {

        RsaEncrypter rsa = new RsaEncrypter(3,11, 7, "abcdefghijklmnopqrstuvwxyz");
        rsa.run();
        rsa.printsolution();




    }

    final Printer p = new Printer();

    public Main() {

    }

    private void test() {

        AlgorithmEuclid e = new AlgorithmEuclid();


        p.print(Integer.toString(e.getOrder(5, 27)));

    }

}