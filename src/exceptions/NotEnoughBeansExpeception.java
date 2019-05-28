package exceptions;

public class NotEnoughBeansExpeception extends BeansAmountException {
    private static String message = " is too few beans.";

    public NotEnoughBeansExpeception(double beans) {
        super(beans, message);
    }
}
