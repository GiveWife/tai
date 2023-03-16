package algorithms;

public class XsBinary extends Algorithm {

    private final int modulo, power;
    private final int number;
    public XsBinary(int number, int power, int modulo) {
        super("Xs Binary");
        this.modulo = modulo;
        this.number = number;
        this.power = power;

        run();
    }

    public XsBinary(int number, int power, int modulo, String source) {
        super("Xs Binary");
        this.modulo = modulo;
        this.number = number;
        this.power = power;

        System.out.println("    Trying: " + number + "^" + power + " % " + modulo);
        run();
    }

    @Override
    public boolean isPossible() {
        return modulo > 0;
    }

    @Override
    public void run() {

        // We use this variable to multiply with our results.
        int we = 1;

        int[] binaryform = binary(power);
        int i = 0;
        int[] part_i = new int[binaryform.length];

        while(i < binaryform.length) {

            if(binaryform[i] != 0) {
                part_i[i] = calculate_mod(i);
                we *= part_i[i];
                we %= modulo;
            }

            i++;
        }

        setSolutionIndexes(new int[] {0});
        setSolutionSet(new int[] {we});
        setSolution(we);
        setSolutionString(Integer.toString(we));

        toggleRun();
    }

    /**
     * Calculates modulo of number depending on i:
     *
     * n ^ (2 ^ (i) )
     *
     * We will do i times: n^2. Between each step we take the modulo and resume.
     */
    private int calculate_mod(int i) {

        // Save local instance of number
        int loc_num = number;
        int it = 0;

        while(it < i) {

            loc_num *= loc_num;
            loc_num %= modulo;

            it++;
        }

        return loc_num;

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
        return (new StringBuilder()
                .append(Integer.toString(number))
                .append("^")
                .append(Integer.toString(power))
                .append(" mod ")
                .append(Integer.toString(modulo))
        ).toString();
    }

    @Override
    public void uitleg() {
        print("Uitvoeren van a^m mod m via het XS algoritme");
    }

}
