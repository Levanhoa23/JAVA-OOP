package DOAN.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyThuVien {
    private ArrayList<Sach> danhSachSach = new ArrayList<>();

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }
//====================================xoa=======================================
    public void xoaSach(String tenSach) {
        Sach sachCanXoa = null;
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equals(tenSach)) {
                sachCanXoa = sach;
                break;
            }
        }
        if (sachCanXoa != null) {
            danhSachSach.remove(sachCanXoa);
            System.out.println("Sách đã được xóa khỏi thư viện.");
        } else {
            System.out.println("Không tìm thấy sách có tên " + tenSach + " để xóa.");
        }
    }
  //===============================sua============================================
    public void suaThongTinSach(String tenSach, String tenMoi, String tacGiaMoi, int namXuatBanMoi) {
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equals(tenSach)) {
                sach.setTenSach(tenMoi);
                sach.setTacGia(tacGiaMoi);
                sach.setNamXuatBan(namXuatBanMoi);
                System.out.println("Thông tin sách đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách có tên " + tenSach);
    }
  //===================================search========================================
    public void timKiemSach(String tenSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equals(tenSach)) {
                System.out.println("Thông tin sách tìm kiếm thấy:");
                System.out.println("Tên sách " + sach.getTenSach() + "\tTác giả " + sach.getTacGia() + "\tNăm xuất bản " + sach.getNamXuatBan());
        	    System.out.println("-------------------------------------------------------------------------------------------------");
               
                return;
            }
        }
        System.out.println("Không tìm thấy sách có tên " + tenSach);
    }
  //===============================sapxep============================================
    public void sapNamXuatBan() {
    	danhSachSach.sort(Comparator.comparingInt(Sach::getNamXuatBan).reversed());
        System.out.println("Danh sách sách đã được sắp xếp theo năm xuất bản.");
    }
  //===========================hienthi================================================
    public void hienThiDanhSachSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Hiện không có sách nào trong thư viện.");
        } else {
        	System.out.println("\t\t\t\t\t\t\tDanh sách sách trong thư viện:");
        	for (Sach sach : danhSachSach) {
        	    System.out.println("Tên sách " + sach.getTenSach() + "\tTác giả " + sach.getTacGia() + "\tNăm xuất bản " + sach.getNamXuatBan());
        	    System.out.println("-------------------------------------------------------------------------------------------------");
        	}  
        }
    }
  //===========================================================================
   
    public void luuVaoTep(String tenTep) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenTep))) {
            oos.writeObject(danhSachSach);
            System.out.println("Dữ liệu đã được lưu vào " + tenTep);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu vào tệp: " + e.getMessage());
        }
    }

    // Đọc dữ liệu từ tệp
    @SuppressWarnings("unchecked")
    public void docTuTep(String tenTep) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenTep))) {
            danhSachSach = (ArrayList<Sach>) ois.readObject();
            System.out.println("Dữ liệu đã được đọc từ " + tenTep);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ tệp: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        QuanLyThuVien libraryManager = new QuanLyThuVien();
        
        // ... Các chức năng khác của chương trình

        // Lưu dữ liệu vào tệp
        libraryManager.luuVaoTep("danhSachSach.dat");

        // Đọc dữ liệu từ tệp
        libraryManager.docTuTep("danhSachSach.dat");
    }

	public void copyData(QuanLyThuVien loadedData) {
		// TODO Auto-generated method stub
		
	}
}

   


