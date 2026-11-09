import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Diem2D {
    private double x;
    private double y;

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double khoangCach(Diem2D diemKhac) {
        if (diemKhac == null) {
            throw new IllegalArgumentException("Điểm cần tính khoảng cách không được để trống.");
        }
        return Math.hypot(x - diemKhac.x, y - diemKhac.y);
    }

    public Diem2D doiXungQuaGocToaDo() {
        return new Diem2D(-x, -y);
    }

    public void tinhTien(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "2D(%.2f, %.2f)",
                x == 0.0 ? 0.0 : x,
                y == 0.0 ? 0.0 : y);
    }
}

class Diem3D extends Diem2D {
    private double z;

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double khoangCach(Diem3D diemKhac) {
        if (diemKhac == null) {
            throw new IllegalArgumentException("Điểm cần tính khoảng cách không được để trống.");
        }
        double dx = getX() - diemKhac.getX();
        double dy = getY() - diemKhac.getY();
        return Math.hypot(Math.hypot(dx, dy), z - diemKhac.z);
    }

    @Override
    public Diem3D doiXungQuaGocToaDo() {
        return new Diem3D(-getX(), -getY(), -z);
    }

    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        z += dz;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "3D(%.2f, %.2f, %.2f)",
                getX() == 0.0 ? 0.0 : getX(),
                getY() == 0.0 ? 0.0 : getY(),
                z == 0.0 ? 0.0 : z);
    }
}

public class Bai2_Diem2D3D {
    public static void main(String[] args) {
        List<Diem2D> danhSachDiem = new ArrayList<>(List.of(
                new Diem2D(0, 0),
                new Diem2D(3, 0),
                new Diem2D(0, 4),
                new Diem3D(0, 0, 0),
                new Diem3D(1, 2, 2),
                new Diem3D(2, 0, 0)
        ));

        List<Diem2D> diem2D = new ArrayList<>();
        List<Diem3D> diem3D = new ArrayList<>();
        for (Diem2D diem : danhSachDiem) {
            if (diem instanceof Diem3D diemBaChieu) {
                diem3D.add(diemBaChieu);
            } else {
                diem2D.add(diem);
            }
        }

        System.out.printf("Tổng khoảng cách mọi cặp điểm 2D: %.2f%n", tongKhoangCach2D(diem2D));
        System.out.printf("Tổng khoảng cách mọi cặp điểm 3D: %.2f%n", tongKhoangCach3D(diem3D));

        int soDiemBanDau = danhSachDiem.size();
        for (int i = 0; i < soDiemBanDau; i++) {
            danhSachDiem.add(danhSachDiem.get(i).doiXungQuaGocToaDo());
        }

        System.out.println("\nDanh sách điểm sau khi thêm các điểm đối xứng:");
        for (int i = 0; i < danhSachDiem.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, danhSachDiem.get(i));
        }
    }

    private static double tongKhoangCach2D(List<Diem2D> danhSach) {
        double tong = 0;
        for (int i = 0; i < danhSach.size(); i++) {
            for (int j = i + 1; j < danhSach.size(); j++) {
                tong += danhSach.get(i).khoangCach(danhSach.get(j));
            }
        }
        return tong;
    }

    private static double tongKhoangCach3D(List<Diem3D> danhSach) {
        double tong = 0;
        for (int i = 0; i < danhSach.size(); i++) {
            for (int j = i + 1; j < danhSach.size(); j++) {
                tong += danhSach.get(i).khoangCach(danhSach.get(j));
            }
        }
        return tong;
    }
}
