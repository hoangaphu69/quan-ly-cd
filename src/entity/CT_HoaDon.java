package entity;

public class CT_HoaDon {
	
	private int soluong;
	private CDEntity cdEntity;
	private HoaDon hoaDon;
	
	public CT_HoaDon(int soluong, CDEntity cdEntity, HoaDon hoaDon) {
		super();
		this.soluong = soluong;
		this.cdEntity = cdEntity;
		this.hoaDon = hoaDon;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public CDEntity getCdEntity() {
		return cdEntity;
	}

	public void setCdEntity(CDEntity cdEntity) {
		this.cdEntity = cdEntity;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	
	
}
