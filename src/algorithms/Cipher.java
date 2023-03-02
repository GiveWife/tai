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
    private int[] numeric_start, numeric_encrypted, decrypted_message;
    public final Translater translater = new Translater();
    // We need child access
    protected Printer printer;

    public Cipher(String message, String name) {
        super(name);
        // Checks if the message contains valid characters
        for(int i = 0; i < message.length(); i++)
            if(translater.getIndexForChar(message.toCharArray()[i]) == -1) {
                System.out.println("Invalid character at position: " + i + ". Object not valid for string: " + message);
                message = "invalid";
            }

        // Printer
        printer = new Printer("Caesar Additive");
        this.message = message;
    }

    /**
     * This will return an empty list since this solution is alphabetic
     */
    @Override
    public int[] solution() {
        return new int[]{};
    }

    protected void setNumericDecrypted(int[] decrypted) {
        this.decrypted_message = decrypted;
    }

    @Override
    public void run() {
        this.numeric_start = translater.getNumeric(message);
        this.numeric_encrypted = encrypt(numeric_start);
        this.decrypted_message = decrypt(numeric_encrypted);

        this.encrypted_message = translater.getAlphabetic(numeric_encrypted);
    }

    @Override
    public void printsolution() {
        StringBuilder b = new StringBuilder();
        b.append(Printer.RED_BOLD_BRIGHT);
        b.append("[");
        b.append(Printer.REDD);
        b.append(getName());
        b.append(Printer.RED_BOLD_BRIGHT);
        b.append("] ");
        b.append(Printer.WHITE_BOLD_BRIGHT);
        b.append("Encrypted: ");
        b.append(Printer.GREEN_BOLD_BRIGHT);
        b.append(this.getEncrypted());
        b.append(Printer.WHITE_BOLD_BRIGHT);
        b.append(" ; Decrypted: ");
        b.append(Printer.GREEN_BOLD_BRIGHT);
        b.append(translater.getAlphabetic(decrypted_message));
        b.append(Printer.ANSI_RESET);
        print(b.toString());
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
