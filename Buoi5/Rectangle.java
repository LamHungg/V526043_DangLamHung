import java.util.Locale;

public class Rectangle implements Shape {
    private double centerX;
    private double centerY;
    private double width;
    private double height;
    private double rotationDegrees;

    public Rectangle(double centerX, double centerY, double width, double height) {
        setCenterX(centerX);
        setCenterY(centerY);
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        Shape.requirePositive(width, "Chiều rộng");
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        Shape.requirePositive(height, "Chiều cao");
        this.height = height;
    }

    public double getRotationDegrees() {
        return rotationDegrees;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
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
        rotationDegrees = (rotationDegrees + degrees) % 360;
    }

    @Override
    public void zoom(double ratio) {
        Shape.requirePositive(ratio, "Tỉ lệ zoom");
        centerX *= ratio;
        centerY *= ratio;
        width *= ratio;
        height *= ratio;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "Rectangle(tâm=(%.2f, %.2f), rộng=%.2f, cao=%.2f, góc=%.2f°)",
                centerX, centerY, width, height, rotationDegrees);
    }
}
