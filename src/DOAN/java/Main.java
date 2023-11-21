package DOAN.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		QuanLyThuVien quanLyThuVien = new QuanLyThuVien();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n\t\t\t\t\t============= CHƯƠNG TRÌNH QUẢN LÝ SÁCH ==============");
			System.out.println("\t\t\t\t\t=****             1.Thêm sách                    ****=");
			System.out.println("\t\t\t\t\t=*******          2.Xóa sách (theo tên)         *****=");
			System.out.println("\t\t\t\t\t=**********       3.Sửa thông tin sách         ******=");
			System.out.println("\t\t\t\t\t=*************    4.Tìm kiếm sách (theo tên)  *******=");
			System.out.println("\t\t\t\t\t=**********       5.Sắp xếp sách năm xuất bản  ******=");
			System.out.println("\t\t\t\t\t=*******          6.Hiển thị thông tin sách     *****=");
			System.out.println("\t\t\t\t\t=****             0. Thoát                       ****=");
			System.out.println("\t\t\t\t\t======================================================");
			System.out.print("\t\t\t\t\tNhập lựa chọn của bạn: ");
			int luaChon = scanner.nextInt();
			scanner.nextLine(); // Đọc dòng trống

			switch (luaChon) {
			case 1:
				System.out.print("Nhập số lượng sách cần thêm: ");
				int soLuongSachCanThem = scanner.nextInt();
				scanner.nextLine(); // Đọc dòng trống

				for (int i = 0; i < soLuongSachCanThem; i++) {
					System.out.println("Nhập thông tin cho cuốn sách thứ " + (i + 1) + ":");
					System.out.print("Tên sách: ");
					String tenSach = scanner.nextLine();
					System.out.print("Tác giả: ");
					String tacGia = scanner.nextLine();
					System.out.print("Năm xuất bản: ");
					int namXuatBan = scanner.nextInt();
					scanner.nextLine(); // Đọc dòng trống

					Sach sachMoi = new Sach(tenSach, tacGia, namXuatBan);
					quanLyThuVien.themSach(sachMoi);
				}
				quanLyThuVien.hienThiDanhSachSach();
				break;

			case 2:
				System.out.print("Nhập tên sách cần xóa: ");
				String tenSachCanXoa = scanner.nextLine();
				quanLyThuVien.xoaSach(tenSachCanXoa);
				quanLyThuVien.hienThiDanhSachSach();
				break;

			case 3:
				System.out.print("Nhập tên sách cần sửa thông tin: ");
				String tenSachCanSua = scanner.nextLine();
				System.out.print("Nhập thông tin mới - Tên sách: ");
				String tenMoi = scanner.nextLine();
				System.out.print("Nhập thông tin mới - Tác giả: ");
				String tacGiaMoi = scanner.nextLine();
				System.out.print("Nhập thông tin mới - Năm xuất bản: ");
				int namXuatBanMoi = scanner.nextInt();
				scanner.nextLine(); // Đọc dòng trống
				quanLyThuVien.suaThongTinSach(tenSachCanSua, tenMoi, tacGiaMoi, namXuatBanMoi);
				quanLyThuVien.hienThiDanhSachSach();
				break;

			case 4:
				System.out.print("Nhập tên sách cần tìm: ");
				String tenSachCanTim = scanner.nextLine();
				quanLyThuVien.timKiemSach(tenSachCanTim);
				break;

			case 5:
				quanLyThuVien.sapNamXuatBan();
				quanLyThuVien.hienThiDanhSachSach();
				break;

			case 6:
				quanLyThuVien.hienThiDanhSachSach();
				break;

			case 0:
				saveDataToFile(quanLyThuVien);
				System.out.println("Đã thoát chương trình.");
				System.exit(0);
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ.");
				break;
			}
		}
	}

//Save data to file
	private static void saveDataToFile(QuanLyThuVien quanLyThuVien) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library_data.dat"))) {
			oos.writeObject(quanLyThuVien);
			System.out.println("Dữ liệu đã được lưu vào file.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Lỗi khi lưu dữ liệu vào file.");
		}
	}

// Load data from file
	private static void loadDataFromFile(QuanLyThuVien quanLyThuVien) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library_data.dat"))) {
			QuanLyThuVien loadedData = (QuanLyThuVien) ois.readObject();
			quanLyThuVien.copyData(loadedData);
			System.out.println("Dữ liệu đã được tải từ file.");
		} catch (FileNotFoundException e) {
			System.out.println("File không tồn tại. Tạo mới dữ liệu.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Lỗi khi tải dữ liệu từ file.");
		}
	}
}
