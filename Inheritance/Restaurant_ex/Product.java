package Inheritance.Restaurant_ex5;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
