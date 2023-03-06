import algorithms.*;
import backtracking.SudokuSolver;
import util.OperationTime;
import util.Printer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Give p: ");
        int p = scan.nextInt();
        System.out.println("\n");

        scan = new Scanner(System.in);
        System.out.println("Give q: ");
        int q = scan.nextInt();
        System.out.println("\n");

        scan = new Scanner(System.in);
        System.out.println("Give e: ");
        int e = scan.nextInt();
        System.out.println("\n");

        scan = new Scanner(System.in);
        System.out.println("Give message: ");
        String message = scan.next();
        System.out.println("\n");

        RsaEncrypter rsa = new RsaEncrypter(p,q, e, message);
        rsa.run();
        rsa.printsolution();

        main(args);


    }

    final Printer p = new Printer();

    public Main() {

    }

    private void test() {

        AlgorithmEuclid e = new AlgorithmEuclid();


        p.print(Integer.toString(e.getOrder(5, 27)));

    }

}