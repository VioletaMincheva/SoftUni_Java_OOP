package Polymorphism.Shapes_lab2;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        setArea(Math.PI * this.radius * this.radius);
    }
}
