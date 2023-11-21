package DOAN.java;
public class Sach {
    private String tenSach;
    public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	private String tacGia;
    private int namXuatBan;

    // Constructor
    public Sach(String tenSach, String tacGia, int namXuatBan) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
    }

	public Sach() {
		super();
	}

    
}

