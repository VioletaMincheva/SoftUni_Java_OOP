package Inheritance.Restaurant_ex5;

import java.math.BigDecimal;

public class Beverage extends Product{
    protected double milliliters;
    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.setMilliliters(milliliters);
    }

    public double getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
