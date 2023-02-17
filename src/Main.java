import h1.CaesarAdditive;
import h1.CaesarMultiplicative;
import h1.Cipher;
import h1.Translation;

public class Main {
    public static void main(String[] args) {
        Translation translation = new Translation();

        Main.print(translation.toString(translation.getNumeric("ouiiyos upsorwcyit")));
        Main.print(translation.getAlphabetic(new int[]{3,15,18,18,5,3,13,0,15,14,13,3,3,9,6,5,18,4}));

        Cipher c = new CaesarMultiplicative("Hello world", 5);
        Main.print(c.getMessage() + " -> " + c.getEncrypted().toString() + " -> " + c.getDecrypted().toString());
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static String toString(int[] arr) {
        String s = "";
        for(int i = 0; i < arr.length; i++) {
            s += Integer.toString(arr[i]);
            if(i != arr.length-1) s += ", ";
        }
        return s;
    }

}