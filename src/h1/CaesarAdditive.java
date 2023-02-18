package h1;

public class CaesarAdditive extends Cipher {

    private final int shift;

    public CaesarAdditive(String message, int a) {
        super(message);
        System.out.println("Shift: " + a);
        this.shift = a;
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {

        for(int i = 0; i < numericTranslation.length; i++) {
            print("shift: " + shift);
            print("Before: " + (numericTranslation[i] + shift) + ", " + (numericTranslation[i]+shift % translater.alphabet.length));
            numericTranslation[i] = (numericTranslation[i] + shift) % translater.alphabet.length;
            print("After: " + numericTranslation[i]);
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

}
