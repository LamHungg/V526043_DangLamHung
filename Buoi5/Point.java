import java.util.Locale;

public class Point implements Shape {
    private double x;
    private double y;

    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        Shape.requireFinite(x, "x");
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        Shape.requireFinite(y, "y");
        this.y = y;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double getCenterX() {
        return x;
    }

    @Override
    public double getCenterY() {
        return y;
    }

    @Override
    public void move(double dx, double dy) {
        Shape.requireFinite(dx, "dx");
        Shape.requireFinite(dy, "dy");
        x += dx;
        y += dy;
    }

    @Override
    public void rotate(double degrees) {
        Shape.requireFinite(degrees, "Góc quay");
        double newX = Shape.rotatedX(x, y, degrees);
        double newY = Shape.rotatedY(x, y, degrees);
        x = newX;
        y = newY;
    }

    @Override
    public void zoom(double ratio) {
        Shape.requirePositive(ratio, "Tỉ lệ zoom");
        x *= ratio;
        y *= ratio;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Point(x=%.2f, y=%.2f)", x, y);
    }
}
