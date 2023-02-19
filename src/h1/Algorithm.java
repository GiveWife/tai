package h1;

import util.Printer;

public abstract class Algorithm extends Printer {

    private final String name;
    public Printer printer;

    public Algorithm(String id) {
        this.name = id;
        this.printer = new Printer(id);
    }

    public abstract void run();

    public String getName() {
        return name;
    }

}
