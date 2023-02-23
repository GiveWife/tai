package h1;


public class CaesarMultiplicative extends Cipher {

    private final int shift;

    public CaesarMultiplicative(String message, int shift) {
        super(message);
        this.shift = shift;
        this.init();
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

    private void decryptBezout() {
        BezoutIdentity b = new BezoutIdentity(shift, Translater.alphabet.length, 1);
    }

    public void uitleg() {
        StringBuilder b = new StringBuilder();
        b.append("De Caesar Multiplictive doet dezelfde stappen als Caesar Additive. Bij het versleutelen zal de shift vermenigvuldigt\n");
        b.append("worden met de numerieke waarden. Bij het ontcijferen moet er een sleutel gevonden worden zodat de vergelijking: \n");
        b.append("    d * e (mod 27) = 1     e == encryptiesleutel\n");
        b.append("geldt.\n\n");
        b.append("Versleuteling van waarde w gaat als volgt: \n");
        b.append("    w * e (mod 27) = v \n\n");
        b.append("De waarde v is versleuteld. Wanneer we dan een waarde d vinden zodat: \n\n");
        b.append("    d * e (mod 27) = 1     e == encryptiesleutel\n\n");
        b.append("Dan kunnen we herschrijven: \n\n");
        b.append("    v                  * d (mod 27) = w   == ONTSLEUTELING\n");
        b.append("    ( w * e (mod 27) ) * d (mod 27) = w   == VERPLAATSEN\n");
        b.append("    w ( e * d (mod 27) ) * (mod 27) = w   == ASSOCIATIVITEIT\n");
        b.append("    w ( 1 )              * (mod 27) = w\n\n");
        b.append("Bij hele grote waarden van het alfabet of numerieke waarden van de letters is dit moeilijk om het te vinden.\n");
        b.append("Het is dus beter om Bezout Identity te gebruiken hiervoor.\n\n");

        print(b.toString());
        Algorithm bezout = new BezoutIdentity(1, 2, 3);
        bezout.uitleg();

    }

}
