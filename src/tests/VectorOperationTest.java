package tests;

import util.VectorOperation;

public class VectorOperationTest extends TestBase {

    public VectorOperationTest() {
        super("Vector Operation");
    }

    @Override
    public void test() {

        VectorOperation op = new VectorOperation();
        int[] vec1 = new int[] {1, 1, 1};
        int[] vec2 = new int[] {2, 3, 4};

        testValue(op.subtract(vec1, vec1, 1), new int[] {0, 0, 0});


    }

}
