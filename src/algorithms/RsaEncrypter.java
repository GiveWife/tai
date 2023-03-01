package algorithms;

import algorithms.Algorithm;
import algorithms.AlgorithmEuclid;

public class RsaEncrypter extends Algorithm {

    private final int p, q;

    public RsaEncrypter(int p, int q, int b) {
        super("Rsa");
        this.p = p;
        this.q = q;
    }

    @Override
    public boolean isPossible() {
        AlgorithmEuclid e = new AlgorithmEuclid(p, q);
        return true;
    }

    @Override
    public void run() {

    }

    @Override
    public String values() {
        return null;
    }

    @Override
    public void uitleg() {

    }

}
