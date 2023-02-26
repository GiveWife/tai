package h1.algorithms;

import util.Printer;

public abstract class Algorithm {

    private final String name;
    private boolean hasRun = false;
    public Printer printer;
    protected String solutionString;

    public Algorithm(String id) {
        this.name = id;
        this.printer = new Printer(id);
    }

    /**
     * Prints the solution of this object.
     */
    public void solution() {
        StringBuilder b = new StringBuilder();
        b.append(Printer.RED_BOLD_BRIGHT);
        b.append("[");
        b.append(Printer.REDD);
        b.append(getName());
        b.append(Printer.RED_BOLD_BRIGHT);
        b.append("] ");
        b.append(Printer.WHITE_BOLD_BRIGHT);
        b.append("Solution of ");
        b.append(Printer.BLUE_BOLD_BRIGHT);
        b.append(values());
        b.append(Printer.WHITE_BOLD_BRIGHT);
        b.append(" is: ");
        b.append(Printer.GREEN_BOLD_BRIGHT);
        b.append(solutionString);
        b.append(Printer.ANSI_RESET);
        print(b.toString());
    }

    /**
     * This sets this object as completed.
     */
    public final void toggleRun() {
        this.hasRun = true;
    }

    /**
     * Returns if this object has already ran
     */
    public final boolean hasRun() {
        return this.hasRun;
    }

    /**
     * The method that runs the algorithm
     */
    public abstract void run();

    /**
     * A string representation of the problem.
     */
    public abstract String values();

    /**
     * Returns the name of this algorithm
     */
    public String getName() {
        return name;
    }

    /**
     * Prints out an explanation behind this specific algorithm.
     */
    public abstract void uitleg();

    /**
     * Package & subpackage access to {@link Printer} object.
     *
     * Essentially, the child classes can either access the parent printer, or create a local printer
     */
    protected void print(String s) {
        printer.print(s);
    }

}
