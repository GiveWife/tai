import h1.*;

public class Main {
    public static void main(String[] args) {

        CaesarAdditive caesarAdditive = new CaesarAdditive("sofie maakt de slaping", 6);
        print(caesarAdditive.getEncrypted());
        print(caesarAdditive.getDecrypted());

        //Main.print(translation.toString(translation.getNumeric("ouiiyos upsorwcyit")));
        //Main.print(translation.getAlphabetic(new int[]{3,15,18,18,5,3,13,0,15,14,13,3,3,9,6,5,18,4}));

        BezoutIdentity b = new BezoutIdentity(22911, 9856, 1);
        print(b.isPossible() + " ??? ");

        //Cipher c = new CaesarMultiplicative("Hello world", 5);
        //Main.print(c.getMessage() + " -> " + c.getEncrypted().toString() + " -> " + c.getDecrypted().toString());
    }

    public static void print(String s) {
        System.out.println(s);
    }


}