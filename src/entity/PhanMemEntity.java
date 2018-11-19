package entity;

import java.util.List;

public class PhanMemEntity {
	
	private int id;
	private String tenPM;
	private List<CDEntity> CDEntitylist;
	private String tacGiaEntity;
	private String tinhNangPMEntity;
	
	public PhanMemEntity() {
		super();
	}
	

	public PhanMemEntity(int id, String tenPM, List<CDEntity> cDEntitylist, String tacGiaEntity,
			String tinhNangPMEntity) {
		super();
		this.id = id;
		this.tenPM = tenPM;
		CDEntitylist = cDEntitylist;
		this.tacGiaEntity = tacGiaEntity;
		this.tinhNangPMEntity = tinhNangPMEntity;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTenPM() {
		return tenPM;
	}




	public void setTenPM(String tenPM) {
		this.tenPM = tenPM;
	}




	public List<CDEntity> getCDEntitylist() {
		return CDEntitylist;
	}




	public void setCDEntitylist(List<CDEntity> cDEntitylist) {
		CDEntitylist = cDEntitylist;
	}




	public String getTacGiaEntity() {
		return tacGiaEntity;
	}




	public void setTacGiaEntity(String tacGiaEntity) {
		this.tacGiaEntity = tacGiaEntity;
	}




	public String getTinhNangPMEntity() {
		return tinhNangPMEntity;
	}




	public void setTinhNangPMEntity(String tinhNangPMEntity) {
		this.tinhNangPMEntity = tinhNangPMEntity;
	}


	@Override
	public String toString() {
		return "PhanMemEntity [id=" + id + ", tenPM=" + tenPM + ", CDEntitylist=" + CDEntitylist + ", tacGiaEntity="
				+ tacGiaEntity + ", tinhNangPMEntity=" + tinhNangPMEntity + ", getId()=" + getId() + ", getTenPM()="
				+ getTenPM() + ", getCDEntitylist()=" + getCDEntitylist() + ", getTacGiaEntity()=" + getTacGiaEntity()
				+ ", getTinhNangPMEntity()=" + getTinhNangPMEntity() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
