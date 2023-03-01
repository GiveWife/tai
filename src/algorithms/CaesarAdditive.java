package algorithms;


/**
 * Need only to create object and print the results
  */
public class CaesarAdditive extends Cipher {

    private final int shift;

    public CaesarAdditive(String message, int a) {
        super(message, "Caesar Additive");
        this.shift = a;
    }

    @Override
    public boolean isPossible() {
        return true;
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {

        for(int i = 0; i < numericTranslation.length; i++) {
            numericTranslation[i] = (numericTranslation[i] + shift) % translater.alphabet.length;
        }

        return numericTranslation;

    }

    @Override
    public int[] decrypt(int[] numericEncryption) {

        for(int i = 0; i < numericEncryption.length; i++) {
            if(numericEncryption[i] - shift < 0) numericEncryption[i] += translater.alphabet.length;
            numericEncryption[i] = (numericEncryption[i] - shift) % translater.alphabet.length;
        }

        return numericEncryption;

    }

    /**
     * Superclass handles run!
     * == init()
     */
    @Override
    public void run() {
        super.run();
    }

    @Override
    public String values() {
        return null;
    }

    public void uitleg() {

        printer.print("Caesar additive zal eerst een array omzetten naar numerieke waarden. Hiervoor wordt de klasse Translater voor gebruikt.");
        printer.print("De hoofdklasse zal dan in de init() de versleutelde array aanmaken en bewaren. De klasse staat dan toe om beide arrays en");
        printer.print("alfabetische versies uit te printen. De encrypt() en decrypt() kunnen dus ook private zijn.");

    }

}
