package util;

/**
 * Class that handles vector operations
 */
public class VectorOperation {

    private final Printer printer = new Printer("[Vector Operation]");

    public VectorOperation() {

    }

    /**
     * Does following instruction:
     *
     *      vec1 = vec1 - x*vec2
     */
    public int[] subtract(int[] vec1, int[] vec2, int x) {

        if(vec1.length != vec2.length) printer.print("Vector lengths do not match. Vec1: " + printer.arrString(vec1) + " ; Vec2: " + printer.arrString(vec2));

        int[] result = new int[vec1.length];

        for(int i = 0; i < result.length; i++) {

            result[i] = vec1[i] - (x*vec2[i]);

        }

        return result;

    }

    public int[] add(int[] vec1, int[] vec2, int x) {

        if(vec1.length != vec2.length) printer.print("Vector lengths do not match. Vec1: " + printer.arrString(vec1) + " ; Vec2: " + printer.arrString(vec2));

        int[] result = new int[vec1.length];

        for(int i = 0; i < result.length; i++) {

            result[i] = vec1[i] + (x*vec2[i]);

        }

        return result;

    }

    public int[] multiply(int[] vec1, int x) {

        int[] result = new int[vec1.length];

        for(int i = 0; i < result.length; i++) {

            result[i] = x*vec1[i];

        }

        return result;

    }


}
