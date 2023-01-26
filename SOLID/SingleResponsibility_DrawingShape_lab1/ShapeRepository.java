package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeRepository implements DrawingRepository {
    private List<Shape> shapes = new ArrayList<>();

    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void drawAll() {
        for (Shape shape : this.shapes) {
                shape.draw();
        }
    }
}
