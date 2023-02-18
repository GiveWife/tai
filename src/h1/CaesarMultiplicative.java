package h1;

public class CaesarMultiplicative extends Cipher {

    private final int shift;

    public CaesarMultiplicative(String message, int shift) {
        super(message);
        this.shift = shift;
    }

    @Override
    public int[] encrypt(int[] numericTranslation) {

        for(int i = 0; i < numericTranslation.length; i++) {
            numericTranslation[i] = (numericTranslation[i] * shift) % translater.alphabet.length;
        }

        return numericTranslation;

    }

    @Override
    public int[] decrypt(int[] numericEncryption) {

        // Time our operation, since it is relatively costly
        OperationTime time = new OperationTime();

        // Helper variables
        int length = translater.alphabet.length;
        int decryptKey = shift;

        // Start timing
        time.start();

        // Find the decryption key with modulo. We search until shift cubed.
        for(int i = 1; i < shift*shift*shift; i++) {

            int check = (shift*i) % length;
            if(check == 1) {
                System.out.println("DecryptKey: " + decryptKey);
                decryptKey = i;
                continue;
            }

        }

        // Stop timing
        time.stop();

        // Replace the given array with new numeric values that will provide the original message
        for(int i = 0; i < numericEncryption.length; i++) {

            numericEncryption[i] = (numericEncryption[i] * decryptKey) % length;

        }

        // Log our time
        System.out.println("The operation took " + time.getSeconds());

        // Return the decrypted numeric array
        return numericEncryption;

    }

}
