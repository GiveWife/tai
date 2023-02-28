package h1.algorithms;

public class Bellaso extends Cipher {

    private final String key;
    private final int[] keyNumeric;

    public Bellaso(String key, String text) {
        super(text, "Bellaso");
        this.key = key;
        keyNumeric = this.translater.getNumeric(key);
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {

        int[] encrypted = new int[numericTranslation.length];

        // We loop over our original numeric
        for(int i = 0; i < numericTranslation.length; i++) {

            // We find our shift via position i
            int shift = keyNumeric[i % keyNumeric.length];

            encrypted[i] = (numericTranslation[i] + shift) % translater.alphabet.length;

        }

        return encrypted;
    }

    @Override
    public int[] decrypt(int[] numericEncryption) {

        int[] encrypted = new int[numericEncryption.length];

        // We loop over our original numeric
        for(int i = 0; i < numericEncryption.length; i++) {

            // We find our shift via position i
            int shift = keyNumeric[i % keyNumeric.length];

            if(numericEncryption[i] - shift < 0) numericEncryption[i] += translater.alphabet.length;
            encrypted[i] = (numericEncryption[i] - shift) % translater.alphabet.length;

        }

        return encrypted;

    }

    @Override
    public String values() {
        return "(key: " + key + ", start: " + getMessage() + ")";
    }

    @Override
    public void uitleg() {

    }
}
