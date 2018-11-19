package entity;
import java.util.List;


public class TacGiaEntity {
	
	private String diachiTG;
	private int id;
	private String phoneTG;
	private String tenTG;
	private List<PhanMemEntity> phanMemEntitieList;
	
	public TacGiaEntity() {
		super();
	}
	
	public TacGiaEntity(String diachiTG, int maTG, String phoneTG, String tenTG, List<PhanMemEntity> phanMemEntitieList) {
		super();
		this.diachiTG = diachiTG;
		this.id = maTG;
		this.phoneTG = phoneTG;
		this.tenTG = tenTG;
		this.phanMemEntitieList = phanMemEntitieList;
	}
	public String getDiachiTG() {
		return diachiTG;
	}
	public void setDiachiTG(String diachiTG) {
		this.diachiTG = diachiTG;
	}
	public int getMaTG() {
		return id;
	}
	public void setMaTG(int maTG) {
		this.id = maTG;
	}
	public String getPhoneTG() {
		return phoneTG;
	}
	public void setPhoneTG(String phoneTG) {
		this.phoneTG = phoneTG;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public List<PhanMemEntity> getPhanMemEntitieList() {
		return phanMemEntitieList;
	}
	public void setPhanMemEntitieList(List<PhanMemEntity> phanMemEntitieList) {
		this.phanMemEntitieList = phanMemEntitieList;
	}
	
	
}
