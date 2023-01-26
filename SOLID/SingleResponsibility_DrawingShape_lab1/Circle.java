package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am circle");
    }
}
