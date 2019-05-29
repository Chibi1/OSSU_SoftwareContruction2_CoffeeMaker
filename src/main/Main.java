package main;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
        //successful brew
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        try {
            System.out.println("Brewing coffee");
            coffeeMaker.brew(10, 30);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Pouring coffee");
                coffeeMaker.pourCoffee();
            }
        } catch (NoCupsRemainingException e) {
            System.out.println(e);
        } catch (StaleCoffeeException e) {
            System.out.println(e);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }

        //unsuccessful brew - too many beans
        try {
            System.out.println("Brewing coffee");
            coffeeMaker.brew(80, 30);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Pouring coffee");
                coffeeMaker.pourCoffee();
            }
        } catch (NoCupsRemainingException e) {
            System.out.println(e);
        } catch (StaleCoffeeException e) {
            System.out.println(e);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }

        //unsuccessful brew - not enough cups
        try {
            System.out.println("Brewing coffee");
            coffeeMaker.brew(20, 50);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }
        try {
            for (int i = 0; i < 30; i++) {
                System.out.println("Pouring coffee");
                coffeeMaker.pourCoffee();
            }
        } catch (NoCupsRemainingException e) {
            System.out.println(e);
        } catch (StaleCoffeeException e) {
            System.out.println(e);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }

        //unsuccessful brew - stale coffee
        try {
            System.out.println("Setting time since last brew");
            coffeeMaker.setTimeSinceLastBrew(80);
            System.out.println("Brewing coffee");
            coffeeMaker.brew(20, 50);
        } catch (BeansAmountException e) {
            System.out.println(e);
        }
    }


}