import h1.*;

public class Main {
    public static void main(String[] args) {

        CaesarAdditive caesarAdditive = new CaesarAdditive("sofie maakt de slaping", 6);
        print(caesarAdditive.getEncrypted());
        print(caesarAdditive.getDecrypted());
        caesarAdditive.uitleg();

        CaesarMultiplicative caesarMultiplicative = new CaesarMultiplicative("sofie maakt de slaping", 20);
        caesarMultiplicative.uitleg();

    }

    public static void print(String s) {
        System.out.println(s);
    }


}