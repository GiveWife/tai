package algorithms;

import algorithms.Algorithm;
import algorithms.AlgorithmEuclid;
import util.NumberTheory;

public class RsaEncrypter extends Cipher {

    private final int p, q, phi, e,d;
    private int[] encrypted_numeric_nonmod;

    public RsaEncrypter(int p, int q, int e, String message) {
        super(message, "Rsa");
        if(!NumberTheory.isPrime(p) || !NumberTheory.isPrime(q))
            print("Incorrect parameters p & q for this object");
        this.p = p; // prime 1
        this.q = q; // prime 2
        this.e = e; // public key
        this.phi = (p-1) * (q-1); // totient
        BezoutIdentity bezoutIdentity = new BezoutIdentity(e, phi, 1);
        bezoutIdentity.run();
        this.d = bezoutIdentity.solution()[0];
    }

    @Override
    public boolean isPossible() {
        AlgorithmEuclid e = new AlgorithmEuclid(p, q);
        return true;
    }

    /**
     * The decryption needs to happen with the untouched encrypted numeric
     */
    @Override
    public void run() {
        super.run();
        // The numeric of our begin, will be encrypted WITHOUT modulating.
        // An error occurs when using the smaller numbers.
        // We decrypt safely (hopefully)
        setNumericDecrypted(decrypt(generateEncrypted(getNumeric())));
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {

        numericTranslation = generateEncrypted(numericTranslation);

        for(int i = 0; i < numericTranslation.length; i++) {
            numericTranslation[i] %= translater.alphabet.length;
        }

        return numericTranslation;
    }

    /**
     * Generates the encrypted array without modulating on length of alphabet
     */
    private int[] generateEncrypted(int[] numericTranslation) {

        int[] encrypted = new int[numericTranslation.length];

        // We loop over our original numeric
        for(int i = 0; i < numericTranslation.length; i++) {

            // We find our shift via position i
            XsBinary xsBinary = new XsBinary(numericTranslation[i], e, p*q);
            xsBinary.run();
            encrypted[i] = (xsBinary.getSolution());

        }

        printer.print("Encrypted: " + printer.arrString(encrypted));
        return encrypted;

    }

    @Override
    public int[] decrypt(int[] numericEncryption) {
        int[] decrypted = new int[numericEncryption.length];

        // We loop over our original numeric
        for(int i = 0; i < numericEncryption.length; i++) {

            // We find our shift via position
            XsBinary xsBinary = new XsBinary(numericEncryption[i], d, p*q);
            xsBinary.run();
            if(i == 2) print("DECRYPT Trying " + numericEncryption[i] + "^" + d + " mod " + (p*q) + " = " + (xsBinary.getSolution() % translater.alphabet.length) + " ( binary: " + xsBinary.getSolution() + ")");

            decrypted[i] = (xsBinary.getSolution()) % translater.alphabet.length;


        }

        printer.print("Decrypted: " + printer.arrString(decrypted));

        return decrypted;
    }

    @Override
    public String values() {
        return null;
    }

    @Override
    public void uitleg() {

    }

}
