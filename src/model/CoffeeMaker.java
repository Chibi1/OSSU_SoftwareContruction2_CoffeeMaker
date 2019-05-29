package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int timeSinceLastBrew;
    private int cupsRemainging;
    private boolean areCupsRemaining;
    private boolean isStale;
    private double beans;
    private double water;

    public CoffeeMaker() {
        this.areCupsRemaining = true;
    }

    // getters
    public int getTimeSinceLastBrew() { return this.timeSinceLastBrew; }
    public int getCupsRemaining() { return this.cupsRemainging; }
    public boolean getIsStale() { return this.isStale; }
    public double getBeans() { return this.beans; }
    public double getWater() { return this.water; }

    //EFFECTS: returns true if cups are remaining
    public boolean areCupsRemaining() {
        if (!(cupsRemainging > 0)) {
            this.areCupsRemaining = false;
        } else {
            this.areCupsRemaining = true;
        }
        return this.areCupsRemaining;
    }

    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        this.timeSinceLastBrew = time;
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws BeansAmountException {
        if (beans <= 0) {
            throw new NotEnoughBeansExpeception(beans);
        } else if (beans > 60) {
            throw new TooManyBeansException(beans);
        }
        this.beans = beans;
        this.water = water;
        this.cupsRemainging = 20;
        this.timeSinceLastBrew = 0;
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException, BeansAmountException {
        if (!areCupsRemaining()) {
            throw new NoCupsRemainingException();
        }
        if (this.timeSinceLastBrew > 60) {
            throw new StaleCoffeeException();
        }
        if (beans <= 0 || beans > 60) {
            throw new BeansAmountException(beans);
        }
        this.cupsRemainging--;
        this.beans -= 5;
        this.water -= 10;
    }

}
