import java.util.Locale;

public class Circle implements Shape {
    private double centerX;
    private double centerY;
    private double radius;

    public Circle(double centerX, double centerY, double radius) {
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        Shape.requirePositive(radius, "Bán kính");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        Shape.requireFinite(centerX, "Tọa độ tâm x");
        this.centerX = centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        Shape.requireFinite(centerY, "Tọa độ tâm y");
        this.centerY = centerY;
    }

    @Override
    public void move(double dx, double dy) {
        Shape.requireFinite(dx, "dx");
        Shape.requireFinite(dy, "dy");
        centerX += dx;
        centerY += dy;
    }

    @Override
    public void rotate(double degrees) {
        Shape.requireFinite(degrees, "Góc quay");
        double newX = Shape.rotatedX(centerX, centerY, degrees);
        double newY = Shape.rotatedY(centerX, centerY, degrees);
        centerX = newX;
        centerY = newY;
    }

    @Override
    public void zoom(double ratio) {
        Shape.requirePositive(ratio, "Tỉ lệ zoom");
        centerX *= ratio;
        centerY *= ratio;
        radius *= ratio;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Circle(tâm=(%.2f, %.2f), bán kính=%.2f)", centerX, centerY, radius);
    }
}
