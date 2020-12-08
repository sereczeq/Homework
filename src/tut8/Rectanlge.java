package tut8;

public class Rectanlge implements Shape {
    float height;
    float width;

    public Rectanlge(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public int numberOfEdges() {
        return 4;
    }

    @Override
    public int numberOfVertices() {
        return 4;
    }

    @Override
    public int numberOfDiagonals() {
        return 2;
    }

    @Override
    public double diagonalLength() {
        return Math.sqrt((height*height + width * width));
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
