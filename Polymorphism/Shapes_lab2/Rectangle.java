package Polymorphism.Shapes_lab2;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        calculatePerimeter();
        calculateArea();
    }

    public Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(this.height * this.width);
    }

    @Override
    public void calculateArea() {
        this.setArea(this.height * 2 + this.width * 2);
    }
}
