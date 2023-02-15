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
            numericTranslation[i] = (numericTranslation[i] * shift) % Cipher.alphabet.length;
        }

        return numericTranslation;

    }

    @Override
    public int[] decrypt(int[] numericEncryption) {

        // Zoeken een key zodat
        // shift * decryptesleutel mod length = 1
        OperationTime time = new OperationTime();
        OperationTime[] perIteration = new OperationTime[shift*shift*shift];
        double secondCount = 0;
        int amountCounted = 0;

        int length = Cipher.alphabet.length;
        int decryptKey = shift;

        time.start();
        for(int i = 1; i < shift*shift*shift; i++) {

            perIteration[i] = new OperationTime();
            perIteration[i].start();
            int check = (shift*i) % length;
            if(check == 1) {
                System.out.println("DecryptKey: " + decryptKey);
                decryptKey = i;
                continue;
            }
            perIteration[i].stop();

            //Timer
            secondCount += perIteration[i].getNano();
            amountCounted++;

        }
        time.stop();

        for(int i = 0; i < numericEncryption.length; i++) {

            numericEncryption[i] = (numericEncryption[i] * decryptKey) % length;

        }

        System.out.println("The operation took " + time.getSeconds() + " seconds. Per iteration it took about " + secondCount/amountCounted + " nanoseconds");

        return numericEncryption;

    }

}
