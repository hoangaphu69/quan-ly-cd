package entity;

import java.util.List;

public class TinhNangPMEntity {
	
	private int id;
	private String tinhnang;
	private List<PhanMemEntity> phanMemEntitieList;
	
	public TinhNangPMEntity(int id, String tinhnang,List<PhanMemEntity> phanMemEntitieList) {
		super();
		this.id = id;
		this.tinhnang = tinhnang;
		this.phanMemEntitieList = phanMemEntitieList;
	}
	
	
	
	public TinhNangPMEntity() {
		super();
	}



	public List<PhanMemEntity> getPhanMemEntitieList() {
		return phanMemEntitieList;
	}

	public void setPhanMemEntitieList(List<PhanMemEntity> phanMemEntitieList) {
		this.phanMemEntitieList = phanMemEntitieList;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTinhnang() {
		return tinhnang;
	}
	public void setTinhnang(String tinhnang) {
		this.tinhnang = tinhnang;
	}
	
	

}
