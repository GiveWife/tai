package util;

/**
 * Helper class for cleaner output.
 */
public class Color {

    public static String white(String s) {
        return Printer.WHITE + s;
    }

    public static String green(String s) {
        return Printer.GREEN + s;
    }

    public static String blue(String s) {
        return Printer.BLUE + s;
    }

    public static String red(String s) {
        return Printer.RED + s;
    }

    public static String whiteb(String s) {
        return Printer.WHITE_BOLD_BRIGHT + s;
    }

    public static String greenb(String s) {
        return Printer.GREEN_BOLD_BRIGHT + s;
    }

    public static String blueb(String s) {
        return Printer.BLUE_BOLD_BRIGHT + s;
    }

    public static String redb(String s) {
        return Printer.RED_BOLD_BRIGHT + s;
    }

}
