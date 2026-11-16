import java.util.Locale;

public class Line implements Shape {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        setStart(start);
        setEnd(end);
    }

    public Point getStart() {
        return new Point(start.getX(), start.getY());
    }

    public void setStart(Point start) {
        if (start == null) {
            throw new IllegalArgumentException("Điểm đầu không được để trống.");
        }
        this.start = new Point(start.getX(), start.getY());
    }

    public Point getEnd() {
        return new Point(end.getX(), end.getY());
    }

    public void setEnd(Point end) {
        if (end == null) {
            throw new IllegalArgumentException("Điểm cuối không được để trống.");
        }
        this.end = new Point(end.getX(), end.getY());
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return start.distance(end);
    }

    @Override
    public double getCenterX() {
        return (start.getX() + end.getX()) / 2;
    }

    @Override
    public double getCenterY() {
        return (start.getY() + end.getY()) / 2;
    }

    @Override
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    @Override
    public void rotate(double degrees) {
        start.rotate(degrees);
        end.rotate(degrees);
    }

    @Override
    public void zoom(double ratio) {
        start.zoom(ratio);
        end.zoom(ratio);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Line(đầu=(%.2f, %.2f), cuối=(%.2f, %.2f))",
                start.getX(), start.getY(), end.getX(), end.getY());
    }
}
