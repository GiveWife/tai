package algorithms;

import algorithms.Algorithm;
import util.Translater;
import util.Printer;

public abstract class Cipher extends Algorithm {

    /**
     * Original message
     */
    private final String message;
    /**
     * Encrypted message
     */
    private String encrypted_message;
    private int[] numeric_start, numeric_encrypted;
    public final Translater translater = new Translater();
    // We need child access
    protected Printer printer;

    public Cipher(String message, String name) {
        super(name);
        // Checks if the message contains valid characters
        for(int i = 0; i < message.length(); i++)
            if(translater.getIndexForChar(message.toCharArray()[i]) == -1) {
                System.out.println("Invalid character at position: " + i + ". Object not valid.");
                message = "invalid";
            }

        // Printer
        printer = new Printer("Caesar Additive");
        this.message = message;
    }

    @Override
    public void run() {
        this.numeric_start = translater.getNumeric(message);
        this.numeric_encrypted = encrypt(numeric_start);

        this.encrypted_message = translater.getAlphabetic(numeric_encrypted);
    }

    /**
     * Package access only. Initializes this object
     */
    private void init() {
        this.numeric_start = translater.getNumeric(message);
        this.numeric_encrypted = encrypt(numeric_start);

        this.encrypted_message = translater.getAlphabetic(numeric_encrypted);
    }

    public int[] getNumeric() {
        return this.numeric_start;
    }

    public int[] getEncryptedNumeric() {
        return this.numeric_encrypted;
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
