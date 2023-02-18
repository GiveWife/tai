package h1;

import util.Printer;

public class Translater extends Printer {

    public Translater() {

    }

    //public static final char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
    public static final char[] alphabet = " abcdefghijklmnopqrstuvwxyz".toCharArray();

    public int[] getNumeric(String toEncrypt) {
        int[] numeric = new int[toEncrypt.length()];
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

    public String getAlphabetic(int[] arr) {
        String s = "";
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < alphabet.length) s += alphabet[arr[i]];
        }
        return s;
    }

    public char getCharForIndex(int s) {
        if(s < alphabet.length) return alphabet[s];
        else {
            System.out.println("False index for alphabet array: " + s);
            return 1;
        }
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


}
