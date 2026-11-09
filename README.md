# Bài tập Java 1–4

Các bài tập Java cơ bản về lớp và đối tượng, hình học, mảng số nguyên.

## Yêu cầu

- JDK 17 trở lên

## Biên dịch tất cả bài

Mở Terminal tại thư mục này rồi chạy:

```powershell
javac -encoding UTF-8 -d out *.java Buoi4/*.java
```

## Chạy từng bài

```powershell
java -cp out Bai1
java -cp out Bai2
java -cp out Bai3_1_TongMang
java -cp out Bai3_2_CongHaiMang
java -cp out Bai3_3_NhapChuoi
java -cp out Buoi4
java -cp out Bai2_Diem2D3D
```

`Bai1`, `Bai3_1_TongMang`, `Bai3_2_CongHaiMang` và `Bai3_3_NhapChuoi` yêu cầu nhập dữ liệu theo hướng dẫn trên màn hình. `Bai2` in kết quả của hai tam giác, hai hình chữ nhật và hai hình tròn đã khởi tạo sẵn.

`Buoi4` xây dựng lớp `Nguoi`, lớp `NhanVien` kế thừa từ `Nguoi`, tính lương nhân viên và in danh sách theo lương giảm dần.

`Bai2_Diem2D3D` minh họa lớp điểm 3D kế thừa điểm 2D, tính khoảng cách theo từng chiều, lấy điểm đối xứng qua gốc tọa độ và tịnh tiến điểm. Tổng khoảng cách được tính trên mọi cặp điểm cùng loại.
