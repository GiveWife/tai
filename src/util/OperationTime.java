package util;

public class OperationTime {

    private long startTime, endTime;
    private double seconds;
    private boolean hasStartTime, hasEndTime, isDone = false;

    public OperationTime() {

    }

    public void start() {
        if(hasStartTime) return;
        startTime = System.nanoTime();
        hasStartTime = true;
    }

    public void stop() {
        if(hasEndTime || !hasStartTime) return;
        endTime = System.nanoTime();
        hasEndTime = true;
        isDone = true;
        seconds = (endTime-startTime)*(0.000000001);;
    }

    public void evaluation() {
        System.out.println("Operation took " + (endTime-startTime) + " nanoseconds or " + getSeconds() + " seconds");
    }

    public long getNano() {
        return endTime-startTime;
    }

    public double getSeconds() {
        return seconds;
    }

}
