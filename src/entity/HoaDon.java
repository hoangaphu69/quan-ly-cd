package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDon {
	
	private Date ngaythanhlap;
	private List<CT_HoaDon> ct_HoaDons = new ArrayList<>();
	private KhachHang khachHang;
	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(Date ngaythanhlap, List<CT_HoaDon> ct_HoaDons, KhachHang khachHang) {
		super();
		this.ngaythanhlap = ngaythanhlap;
		this.ct_HoaDons = ct_HoaDons;
		this.khachHang = khachHang;
	}

	public Date getNgaythanhlap() {
		return ngaythanhlap;
	}

	public void setNgaythanhlap(Date ngaythanhlap) {
		this.ngaythanhlap = ngaythanhlap;
	}

	public List<CT_HoaDon> getCt_HoaDons() {
		return ct_HoaDons;
	}

	public void setCt_HoaDons(List<CT_HoaDon> ct_HoaDons) {
		this.ct_HoaDons = ct_HoaDons;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	
}
