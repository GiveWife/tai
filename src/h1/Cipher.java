package h1;

import util.Printer;

public abstract class Cipher extends Translater {

    private final String message;
    private String encrypted_message;
    private int[] numeric_start, numeric_encrypted;
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
        this.message = message;
    }

    /**
     * Package access only. Initializes this object
     */
    void init() {
        this.numeric_start = translater.getNumeric(message);
        this.numeric_encrypted = encrypt(numeric_start);

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

    /**
     * Creates the numeric array that transforms it back to the original numeric message
     */
    public abstract int[] decrypt(int[] numericEncryption);

}
