package exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSinceLastBrew;

    public StaleCoffeeException() {
        super("The coffee is stale.");
    }
}
