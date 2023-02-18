package h1;

import util.Printer;

public abstract class Cipher extends Translater {

    private final String message, encrypted_message;
    private final int[] numeric_start, numeric_encrypted;
    public final Translater translater = new Translater();
    private Printer printer;

    public Cipher(String message) {
        // Checks if the message contains valid characters
        for(int i = 0; i < message.length(); i++)
            if(getIndexForChar(message.toCharArray()[i]) == -1) {
                System.out.println("Invalid character at position: " + i + ". Object not valid.");
                message = "invalid";
            }

        // Printer
        printer = new Printer("Caesar Additive");

        // Numeric arrays:
        this.numeric_start = translater.getNumeric(message);
        printer.printArr(numeric_start);
        this.numeric_encrypted = encrypt(numeric_start);
        printer.printArr(numeric_encrypted);

        this.message = message;
        this.encrypted_message = translater.getAlphabetic(numeric_encrypted);
    }

    public String getMessage() {
        return message;
    }

    public String getEncrypted() {
        return encrypted_message;
    }

    /**
     * Used to check if the algorithm decrypts correctly
     */
    public String getDecrypted() {
        return translater.getAlphabetic(this.decrypt(numeric_encrypted));
    }


    /**
     * Creates the numeric change from the original message
     */
    public abstract int[] encrypt(int[] numericTranslation);

    public abstract int[] decrypt(int[] numericEncryption);

}
