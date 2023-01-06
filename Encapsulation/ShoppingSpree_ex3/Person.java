package Encapsulation.ShoppingSpree_ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
        } else {
            products.add(product);
            this.setMoney(this.getMoney() - product.getCost());
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder outputPerson = new StringBuilder();
        outputPerson.append(this.getName()).append(" - ");
        if (products.isEmpty()) {
            outputPerson.append("Nothing bought");
        } else {
            outputPerson.append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
        return outputPerson.toString();
    }
}
