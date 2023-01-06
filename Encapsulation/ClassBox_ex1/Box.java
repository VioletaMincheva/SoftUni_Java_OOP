package Encapsulation.ClassBox_ex1;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }

    public double calculateSurfaceArea() {
        //Surface Area = 2lw + 2lh + 2wh
        return 2 * getLength() * getWidth() + 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
    }

    public double calculateLateralSurfaceArea() {
        //Lateral Surface Area = 2lh + 2wh
        return 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
    }

    public double calculateVolume() {
        //Volume = lwh
        return getLength() * getWidth() * getHeight();
    }
}
