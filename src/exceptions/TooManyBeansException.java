package exceptions;

public class TooManyBeansException extends BeansAmountException {
    private static String message = " is too many beans.";

    public TooManyBeansException(double beans) {
        super(beans, message);
    }
}
