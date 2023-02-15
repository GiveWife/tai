import h1.CaesarAdditive;
import h1.CaesarMultiplicative;
import h1.Cipher;

public class Main {
    public static void main(String[] args) {
        Cipher c = new CaesarMultiplicative("Hello world", 5);
        Main.print(c.getMessage() + " -> " + c.getEncrypted().toString() + " -> " + c.getDecrypted().toString());
    }

    public static void print(String s) {
        System.out.println(s);
    }

}