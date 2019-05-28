package exceptions;

public class WaterException extends Exception {
    private double amountOfWater;

    public WaterException() {
        super("Not enough water in the machine.");
    }
}
