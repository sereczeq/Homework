package tut8;

public class Triangle implements Shape {
    float a;
    float b;
    float c;

    public Triangle(float side1, float side2, float side3) {
        this.a = side1;
        this.b = side2;
        this.c = side3;
    }

    @Override
    public double area() {
        float p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public int numberOfEdges() {
        return 3;
    }

    @Override
    public int numberOfVertices() {
        return 3;
    }

    @Override
    public int numberOfDiagonals() {
        return 3;
    }

    @Override
    public double diagonalLength() {
        return -1;
    }

    @Override
    public double getHeight() {
        return area() / Math.min(Math.min(a, b), c) * 2;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(a, b), c);
    }
}
