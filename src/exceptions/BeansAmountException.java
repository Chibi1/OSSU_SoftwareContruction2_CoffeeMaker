package exceptions;

public class BeansAmountException extends Exception {
    private double beans;

    public BeansAmountException(double beans) {
        super(beans + " not the right amount of beans.");
    }

    protected BeansAmountException(double beans, String message) {
        super(beans + message);
        this.beans = beans;
    }

    public double getBeans() { return this.beans; }
}
