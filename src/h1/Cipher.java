package h1;

public abstract class Cipher {

    private final String toEncrypt;
    public static final char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();

    public Cipher(String message) {
        // Checks if the message contains valid characters
        for(int i = 0; i < message.length(); i++)
            if(getIndexForChar(message.toCharArray()[i]) == -1) {
                System.out.println("Invalid character at position: " + i + ". Object not valid.");
                message = "invalid";
            }
        // Initialisation
        this.toEncrypt = message;
    }

    /**
     * Transfers the string to a integer array.
     */
    public int[] getNumeric() {
        int[] numeric = new int[getMessage().length()];
        char[] charMessage = toEncrypt.toCharArray();
        for(int i = 0; i < charMessage.length; i++) {
            numeric[i] = getIndexForChar(charMessage[i]);
        }
        return numeric;
    }

    public int getIndexForChar(char s) {
        for(int i = 0; i < alphabet.length; i++) {
            if(s == alphabet[i]) return i;
        }
        return -1;
    }

    public char getCharForIndex(int s) {
        if(s < alphabet.length) return alphabet[s];
        else {
            System.out.println("False index for alphabet array: " + s);
            return 1;
        }
    }

    public String getMessage() {
        return toEncrypt;
    }

    public String getEncrypted() {
        return this.construct(encrypt(getNumeric()));
    }

    public String getDecrypted() {
        return this.construct(decrypt(encrypt(getNumeric())));
    }

    /**
     * Construct the encrypted message using the changed numeric values of the string
     */
    public String construct(int[] encryptedNumeric) {
        char[] encrypted = new char[encryptedNumeric.length];
        for(int i = 0; i < encryptedNumeric.length; i++) {
            encrypted[i] = getCharForIndex(encryptedNumeric[i]);
        }
        return charToString(encrypted);
    }

    public String charToString(char[] arr) {
        String s = "";
        for(int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

    /**
     * Creates the numeric change from the original message
     */
    public abstract int[] encrypt(int[] numericTranslation);

    public abstract int[] decrypt(int[] numericEncryption);

}
