import java.util.Locale;

public class Triangle implements Shape {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        setA(a);
        setB(b);
        setC(c);
    }

    public Point getA() {
        return copy(a);
    }

    public void setA(Point a) {
        this.a = requirePoint(a, "A");
    }

    public Point getB() {
        return copy(b);
    }

    public void setB(Point b) {
        this.b = requirePoint(b, "B");
    }

    public Point getC() {
        return copy(c);
    }

    public void setC(Point c) {
        this.c = requirePoint(c, "C");
    }

    private static Point requirePoint(Point point, String name) {
        if (point == null) {
            throw new IllegalArgumentException("Đỉnh " + name + " không được để trống.");
        }
        return copy(point);
    }

    private static Point copy(Point point) {
        return new Point(point.getX(), point.getY());
    }

    @Override
    public double area() {
        return Math.abs(a.getX() * (b.getY() - c.getY())
                + b.getX() * (c.getY() - a.getY())
                + c.getX() * (a.getY() - b.getY())) / 2;
    }

    @Override
    public double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }

    @Override
    public double getCenterX() {
        return (a.getX() + b.getX() + c.getX()) / 3;
    }

    @Override
    public double getCenterY() {
        return (a.getY() + b.getY() + c.getY()) / 3;
    }

    @Override
    public void move(double dx, double dy) {
        a.move(dx, dy);
        b.move(dx, dy);
        c.move(dx, dy);
    }

    @Override
    public void rotate(double degrees) {
        a.rotate(degrees);
        b.rotate(degrees);
        c.rotate(degrees);
    }

    @Override
    public void zoom(double ratio) {
        a.zoom(ratio);
        b.zoom(ratio);
        c.zoom(ratio);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Triangle(A=%s, B=%s, C=%s)", a, b, c);
    }
}
