package h1;

import util.Printer;

public class Algorithm extends Printer {

    private final String name;
    public Printer printer;

    public Algorithm(String id) {
        this.name = id;
        this.printer = new Printer(id);
    }

    public String getName() {
        return name;
    }

}
