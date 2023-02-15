package h1;

public class CaesarAdditive extends Cipher {

    private final int shift;
    public CaesarAdditive(String message, int a) {
        super(message);
        this.shift = a;
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {

        for(int i = 0; i < numericTranslation.length; i++) {
            numericTranslation[i] = (numericTranslation[i] + shift) % Cipher.alphabet.length;
        }

        return numericTranslation;

    }

    @Override
    public int[] decrypt(int[] numericEncryption) {

        for(int i = 0; i < numericEncryption.length; i++) {
            if(numericEncryption[i] - shift < 0) numericEncryption[i] += Cipher.alphabet.length;
            numericEncryption[i] = (numericEncryption[i] - shift) % Cipher.alphabet.length;
        }

        return numericEncryption;

    }

}
