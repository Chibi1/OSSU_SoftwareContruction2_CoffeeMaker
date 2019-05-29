package test;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;

    @Before
    public void setUp(){
        // TODO: instantiate your test objects here
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    public void tooManyBeans() {
        try {
            coffeeMaker.brew(80, 30);
            fail("Too many beans exception not caught");
        } catch (BeansAmountException e) {
            System.out.println(e);
        }
    }

    @Test
    public void tooFewBeans() {
        try {
            coffeeMaker.brew(-5, 30);
            fail("Too few beans exception not caught");
        } catch (BeansAmountException e) {
            System.out.println(e);
        }
    }

    @Test
    public void notEnoughCups() {
        try {
            coffeeMaker.brew(20, 50);
            for (int i = 0; i < 30; i++) {
                System.out.println("Pouring coffee");
                coffeeMaker.pourCoffee();
            }
            fail("Not enough cups exception not caught");
        } catch (BeansAmountException e) {
            //do nothing
        } catch (NoCupsRemainingException e) {
            System.out.println(e);

        } catch (StaleCoffeeException e) {
            //do nothing
        }
    }

    @Test
    public void staleCoffee() {
        try {
            coffeeMaker.setTimeSinceLastBrew(80);
            coffeeMaker.pourCoffee();
            fail("Stale coffee exception not caught");
        } catch (BeansAmountException e) {
            //do nothing
        } catch (StaleCoffeeException e) {
            System.out.println(e);
        } catch (NoCupsRemainingException e) {
            //do nothing
        }
    }


}
