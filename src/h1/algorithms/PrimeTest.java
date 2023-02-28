package h1.algorithms;

public class PrimeTest extends Algorithm {

    public PrimeTest() {
        super("Prime Test");
    }

    @Override
    public void run() {

    }

    /**
     * XS: schrijf alles in een binaire vorm
     */
    public int[] binary(int number) {

        // Kleinste macht van twee zodat nummer kleiner is dat 2^i
        int i = 0;

        // Eerst vinden we hoeveel plaats onze array moet zijn
        while(number >= Math.pow(2,i))
            i++;

        // Maak array
        int[] binary = new int[i];
        i = 0;

        while(i < binary.length) {
            if(Math.floor(((float) number / (Math.pow(2,i) ))) % 2 == 0) binary[i] = 0;
            else binary[i] = 1;
            i++;
        }

        return binary;

    }

    @Override
    public String values() {
        return null;
    }

    @Override
    public void uitleg() {

    }
}
