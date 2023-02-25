package h1.algorithms;

import util.Printer;

public abstract class Algorithm {

    private final String name;
    private boolean hasRun = false;
    public Printer printer;

    public Algorithm(String id) {
        this.name = id;
        this.printer = new Printer(id);
    }

    public void toggleRun() {
        this.hasRun = true;
    }

    public boolean hasRun() {
        return this.hasRun;
    }

    public abstract void run();

    public abstract String values();

    public String getName() {
        return name;
    }

    public abstract void uitleg();

    protected void print(String s) {
        printer.print(s);
    }

}
