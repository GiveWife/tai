package algorithms;

public class PrimeTest extends Algorithm {

    private boolean isPrime = false;
    private final int mod;

    public PrimeTest(int mod) {
        super("Prime Test");
        this.mod = mod;
    }

    /**
     * Returns a boolean that determines if the given modulo is a prime number.
     */
    public final boolean isPrime() {
        return hasRun() && isPrime;
    }


    @Override
    public boolean isPossible() {
        return mod > 0;
    }

    @Override
    public void run() {
        // a^(m-1) == 1 mod m -> dan priem. We kiezen voor a == 2
        XsBinary binary = new XsBinary(2, mod-1, mod);

        // Set solution set
        this.setSolutionSet(binary.solution());

        // Set indexes for client classes
        this.setSolutionIndexes(binary.getSolutionIndexes());

        // Set solution string:
        this.setSolutionString(printer.build(Integer.toString(solution()[0])));

        // Mark as finished
        toggleRun();
    }

    @Override
    public String values() {
        return (new StringBuilder()
                .append(Integer.toString(2))
                .append("^")
                .append(Integer.toString(mod-1))
                .append(" mod ")
                .append(Integer.toString(mod))
        ).toString();
    }

    @Override
    public void uitleg() {
        print("Volgens fermat geldt: a^(m-1) mod m = 1  als m priem");
    }

}
