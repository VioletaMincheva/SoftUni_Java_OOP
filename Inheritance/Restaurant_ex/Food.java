package Inheritance.Restaurant_ex5;

import java.math.BigDecimal;

public class Food extends Product{
    protected double grams;
    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.setGrams(grams);
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }
}
