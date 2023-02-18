package util;

public class Printer {

    private String origin;
    private boolean printOrigin = false;

    public Printer() {
        origin = "unnamed origin";
    }

    public Printer(String origin) {
        this.origin = origin;
        printOrigin = true;
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void printArr(int[] arr) {
        print(arrString(arr));
    }

    public String arrString(int[] arr) {
        String s = "";
        for(int i = 0; i < arr.length; i++) {
            s += arr[i];
            if(i < arr.length) s += ", ";
        }
        return s;
    }

    public void debug(String s) {
        System.out.println("[" + origin + "] " + s);
    }

}
