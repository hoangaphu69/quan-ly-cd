package entity;

import java.util.Date;

public class CDEntity {
	
	private String maCD;
	private String tenCD;
	private Date ngayPhatHanh;
	private double gia;
	private int soluong;
	private String phienban;
	private int phanMemEntity;
	
	public CDEntity() {
		super();
	}

	public CDEntity(String maCD, String tenCD, Date ngayPhatHanh, double gia, int soluong, String phienban,
			int phanMemEntity) {
		super();
		this.maCD = maCD;
		this.tenCD = tenCD;
		this.ngayPhatHanh = ngayPhatHanh;
		this.gia = gia;
		this.soluong = soluong;
		this.phienban = phienban;
		this.phanMemEntity = phanMemEntity;
	}

	public String getMaCD() {
		return maCD;
	}

	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}

	public String getTenCD() {
		return tenCD;
	}

	public void setTenCD(String tenCD) {
		this.tenCD = tenCD;
	}

	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(Date ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getPhienban() {
		return phienban;
	}

	public void setPhienban(String phienban) {
		this.phienban = phienban;
	}

	public int getPhanMemEntity() {
		return phanMemEntity;
	}

	public void setPhanMemEntity(int phanMemEntity) {
		this.phanMemEntity = phanMemEntity;
	}
	
}
