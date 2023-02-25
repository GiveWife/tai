package util;

public class Printer {

    /**
     * Source: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println/5762502#5762502
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    private String origin;
    private boolean printOrigin = false;

    public Printer() {
        origin = "unnamed origin";
    }

    public Printer(String origin) {
        this.origin = origin;
        printOrigin = true;
    }

    public static void prints(String s) {
        System.out.println(s);
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void printo(String s) {
        print(origin + " " + s);
    }

    public void printArr(int[] arr) {
        print(arrString(arr));
    }

    public String arrString(int[] arr) {
        String s = "[";
        for(int i = 0; i < arr.length; i++) {
            s += arr[i];
            if(i < arr.length-1) s += ", ";
        }
        s += "]";
        return s;
    }

    public void debug(String s) {
        System.out.println("[" + origin + "] " + s);
    }

}
