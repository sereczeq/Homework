package tut8;

public class Circle implements Shape {
    float radius;

    public Circle(float radius)
    {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public int numberOfEdges() {
        return 1;
    }

    @Override
    public int numberOfVertices() {
        return 0;
    }

    @Override
    public int numberOfDiagonals() {
        return 1;
    }

    /**
     * @return diagonal is circle diameter
     */
    @Override
    public double diagonalLength() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return diagonalLength();
    }

    @Override
    public double getWidth() {
        return diagonalLength();
    }
}
