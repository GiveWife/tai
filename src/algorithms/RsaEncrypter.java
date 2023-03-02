package algorithms;

import algorithms.Algorithm;
import algorithms.AlgorithmEuclid;
import util.NumberTheory;

public class RsaEncrypter extends Cipher {

    private final int p, q, phi, e;

    public RsaEncrypter(int p, int q, int e, String message) {
        super("Rsa", message);
        if(!NumberTheory.isPrime(p) || !NumberTheory.isPrime(q))
            print("Incorrect parameters p & q for this object");
        this.p = p; // prime 1
        this.q = q; // prime 2
        this.e = e; // public key
        this.phi = (p-1) * (q-1); // totient
    }

    /**
     * Since this is valid:
     *
     * 2^15 mod 11 = (2^5 mod 11) * (2^5 mod 11) * (2^5 mod 11) mod 11
     */
    private void reduce(int numeric) {

        AlgorithmEuclid e = new AlgorithmEuclid();


    }

    @Override
    public boolean isPossible() {
        AlgorithmEuclid e = new AlgorithmEuclid(p, q);
        return true;
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {
        return new int[0];
    }

    @Override
    public int[] decrypt(int[] numericEncryption) {
        return new int[0];
    }

    @Override
    public String values() {
        return null;
    }

    @Override
    public void uitleg() {

    }

}
