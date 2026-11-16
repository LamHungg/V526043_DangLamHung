/** Giao diện chung cho các hình hai chiều trong bài Buổi 5. */
public interface Shape {
    double area();

    double perimeter();

    double getCenterX();

    double getCenterY();

    void move(double dx, double dy);

    void rotate(double degrees);

    void zoom(double ratio);

    /** Khoảng cách giữa tâm hình hoặc trọng tâm của hai hình. */
    default double distance(Shape other) {
        if (other == null) {
            throw new IllegalArgumentException("Hình cần tính khoảng cách không được để trống.");
        }
        return Math.hypot(getCenterX() - other.getCenterX(), getCenterY() - other.getCenterY());
    }

    static void requireFinite(double value, String name) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(name + " phải là số hữu hạn.");
        }
    }

    static void requirePositive(double value, String name) {
        requireFinite(value, name);
        if (value <= 0) {
            throw new IllegalArgumentException(name + " phải lớn hơn 0.");
        }
    }

    static double rotatedX(double x, double y, double degrees) {
        double radians = Math.toRadians(degrees);
        return x * Math.cos(radians) - y * Math.sin(radians);
    }

    static double rotatedY(double x, double y, double degrees) {
        double radians = Math.toRadians(degrees);
        return x * Math.sin(radians) + y * Math.cos(radians);
    }
}
