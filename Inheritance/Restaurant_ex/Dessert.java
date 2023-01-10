package Inheritance.Restaurant_ex5;

import java.math.BigDecimal;

public class Dessert extends Food {
    protected double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.setCalories(calories);
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
