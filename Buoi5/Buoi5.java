import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Buoi5 {
    private static final int SO_HINH = 10;

    public static void main(String[] args) {
        List<Shape> danhSachHinh = taoDanhSachHinhNgauNhien();

        System.out.println("Danh sách hình được tạo ngẫu nhiên:");
        hienThiDanhSach(danhSachHinh);
        System.out.printf(Locale.US, "%nTổng diện tích: %.2f%n", tongDienTich(danhSachHinh));
        System.out.printf(Locale.US, "Tổng chu vi: %.2f%n", tongChuVi(danhSachHinh));

        Shape hinhLonNhat = danhSachHinh.get(0);
        Shape hinhNhoNhat = danhSachHinh.get(0);
        for (Shape hinh : danhSachHinh) {
            if (hinh.area() > hinhLonNhat.area()) {
                hinhLonNhat = hinh;
            }
            if (hinh.area() < hinhNhoNhat.area()) {
                hinhNhoNhat = hinh;
            }
        }
        System.out.printf(Locale.US, "Hình có diện tích lớn nhất (%.2f): %s%n",
                hinhLonNhat.area(), hinhLonNhat);
        System.out.printf(Locale.US, "Hình có diện tích nhỏ nhất (%.2f): %s%n",
                hinhNhoNhat.area(), hinhNhoNhat);
        System.out.printf(Locale.US, "Khoảng cách tâm/trọng tâm hai hình đầu tiên: %.2f%n",
                danhSachHinh.get(0).distance(danhSachHinh.get(1)));

        try (Scanner scanner = new Scanner(System.in)) {
            double tiLe = nhapTiLeZoom(scanner);
            for (Shape hinh : danhSachHinh) {
                hinh.zoom(tiLe);
            }

            System.out.printf(Locale.US, "%nDanh sách hình sau khi zoom tỉ lệ %.2f:%n", tiLe);
            hienThiDanhSach(danhSachHinh);
        }
    }

    private static List<Shape> taoDanhSachHinhNgauNhien() {
        Random random = new Random();
        List<Shape> danhSach = new ArrayList<>();

        // Năm hình đầu bảo đảm danh sách có đủ các kiểu hình yêu cầu.
        for (int loai = 0; loai < 5; loai++) {
            danhSach.add(taoHinhNgauNhien(random, loai));
        }
        while (danhSach.size() < SO_HINH) {
            danhSach.add(taoHinhNgauNhien(random, random.nextInt(5)));
        }
        return danhSach;
    }

    private static Shape taoHinhNgauNhien(Random random, int loai) {
        return switch (loai) {
            case 0 -> new Point(soNgauNhien(random, -10, 10), soNgauNhien(random, -10, 10));
            case 1 -> new Circle(soNgauNhien(random, -10, 10), soNgauNhien(random, -10, 10),
                    soNgauNhien(random, 0.5, 5));
            case 2 -> new Line(taoDiemNgauNhien(random), taoDiemNgauNhien(random));
            case 3 -> new Triangle(taoDiemNgauNhien(random), taoDiemNgauNhien(random),
                    taoDiemNgauNhien(random));
            case 4 -> new Rectangle(soNgauNhien(random, -10, 10), soNgauNhien(random, -10, 10),
                    soNgauNhien(random, 1, 10), soNgauNhien(random, 1, 10));
            default -> throw new IllegalArgumentException("Loại hình không hợp lệ: " + loai);
        };
    }

    private static Point taoDiemNgauNhien(Random random) {
        return new Point(soNgauNhien(random, -10, 10), soNgauNhien(random, -10, 10));
    }

    private static double soNgauNhien(Random random, double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    private static double tongDienTich(List<Shape> danhSach) {
        return danhSach.stream().mapToDouble(Shape::area).sum();
    }

    private static double tongChuVi(List<Shape> danhSach) {
        return danhSach.stream().mapToDouble(Shape::perimeter).sum();
    }

    private static void hienThiDanhSach(List<Shape> danhSach) {
        for (int i = 0; i < danhSach.size(); i++) {
            Shape hinh = danhSach.get(i);
            System.out.printf(Locale.US, "%2d. %-70s diện tích=%8.2f | chu vi=%8.2f%n",
                    i + 1, hinh, hinh.area(), hinh.perimeter());
        }
    }

    private static double nhapTiLeZoom(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tỉ lệ zoom lớn hơn 0: ");
            String giaTri = scanner.nextLine().trim();
            try {
                double tiLe = Double.parseDouble(giaTri);
                if (Double.isFinite(tiLe) && tiLe > 0) {
                    return tiLe;
                }
            } catch (NumberFormatException ignored) {
                // Báo lỗi chung bên dưới rồi cho nhập lại.
            }
            System.out.println("Tỉ lệ không hợp lệ. Hãy nhập một số hữu hạn lớn hơn 0.");
        }
    }
}
