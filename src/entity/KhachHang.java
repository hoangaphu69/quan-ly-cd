package entity;

import java.util.ArrayList;
import java.util.List;

public class KhachHang {
	
	private String username;
	private String pwd;
	private List<HoaDon> hoaDons = new ArrayList<>();
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String username, String pwd, List<HoaDon> hoaDons) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.hoaDons = hoaDons;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}
	
	
	
	
	
}
