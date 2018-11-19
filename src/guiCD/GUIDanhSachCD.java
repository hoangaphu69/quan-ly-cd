package guiCD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CDDAO;
import dao.GenericDAO;
import dao.PhanMemDAO;
import entity.CDEntity;
import entity.PhanMemEntity;

public class GUIDanhSachCD extends JPanel{
	
	private JPanel pn_nouth;
	private DefaultTableModel defaultTableModel;
	private JTable jtable;
	private JPanel pn_south;
	private JButton btn_xoa;
	private JButton btn_sua;
	private JComboBox cbb_loai;
	private JPanel pn_south_west;
	private JPanel pn_south_east;
	private Border lineBorder = BorderFactory.createLineBorder(Color.blue);
    private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    private Border loweredBevel = BorderFactory.createLoweredBevelBorder();
	private JLabel lb_nhap;
	private JLabel lb_timkiemphanloai;
	private JComboBox cbb_timkiemphanloai;
	private JTextField txt_tim;
	private JButton btn_tim;
	private JPanel pn_south_center;
	private CDDAO cddao = new CDDAO();
	private PhanMemDAO phanMemDAO =  new PhanMemDAO();
	public GUIDanhSachCD() {
		
		this.setLayout(new BorderLayout());
		
		pn_nouth = new JPanel();
		
		String[] titles = new String[] {"MaCD", "Ten CD", "Phan Mem", "So Luong CD", "Gia","Ngay phat hanh","Tinh Nang","Phien Ban","Tac Gia"};

		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn(titles[0]);
		defaultTableModel.addColumn(titles[1]);
		defaultTableModel.addColumn(titles[2]);
		defaultTableModel.addColumn(titles[3]);
		defaultTableModel.addColumn(titles[4]);
		defaultTableModel.addColumn(titles[5]);
		defaultTableModel.addColumn(titles[6]);
		defaultTableModel.addColumn(titles[7]);
		defaultTableModel.addColumn(titles[8]);
		
		List<CDEntity> cdEntities = cddao.getAll();
		for(CDEntity cdEntity : cdEntities) {
			PhanMemEntity phanMemEntity = phanMemDAO.findOne(cdEntity.getPhanMemEntity());
			defaultTableModel.addRow(new Object[] {cdEntity.getMaCD(),cdEntity.getTenCD(),phanMemEntity.getTenPM(),cdEntity.getSoluong(),cdEntity.getGia(),cdEntity.getNgayPhatHanh(),phanMemEntity.getTinhNangPMEntity(),cdEntity.getPhienban(),phanMemEntity.getTacGiaEntity()});
		}
		
		
		
		
//		defaultTableModel.addRow(new Object[] {"1","dan nguyen","windowns 7",3,"3000d"});
//		defaultTableModel.addRow(new Object[] {"1","hoai linh","windowns 8",5,"4000d"});
//		defaultTableModel.addRow(new Object[] {"1","ly hai","windowns 10",3,"8000d"});
//		defaultTableModel.addRow(new Object[] {"1","hoai lam","study php",3,"3000d"});
//		defaultTableModel.addRow(new Object[] {"1","bui anh tuan","study java",8,"3000d"});
//		
//		
		jtable = new JTable(defaultTableModel);
		
		JScrollPane jScrollPane = new JScrollPane(jtable);
		
		
		this.add(jScrollPane,BorderLayout.CENTER);
		
		pn_south = new JPanel();
		pn_south.setBorder(BorderFactory.createBevelBorder(ABORT));
		pn_south.setLayout(new BorderLayout());
		pn_south_east = new JPanel();
		
		btn_xoa = new JButton("Xoa");
		btn_sua = new JButton("Sua");
		
		pn_south_east.add(btn_xoa);
		pn_south_east.add(btn_sua);
		pn_south.add(pn_south_east,BorderLayout.EAST);
		
		pn_south_west = new JPanel();
		JLabel jLabel = new JLabel("phan loai:");
		
		cbb_loai = new JComboBox<>();
		
		List<PhanMemEntity> phanMemEntities =phanMemDAO.getAll();
		for(PhanMemEntity phanMemEntity : phanMemEntities) {
			cbb_loai.addItem(phanMemEntity.getTenPM());
		}
		
		pn_south_west.add(jLabel);
		pn_south_west.add(cbb_loai);
		Border compound = BorderFactory.createCompoundBorder(raisedBevel,
                loweredBevel);
		
		Border titleBorder = BorderFactory.createTitledBorder(compound,
                "CAC CHUC NANG", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pn_south.setBorder(titleBorder);
		pn_south.add(pn_south_west, BorderLayout.WEST);
		
		btn_xoa.setPreferredSize(new Dimension(100, 40));
		btn_sua.setPreferredSize(new Dimension(100, 40));
		cbb_loai.setPreferredSize(new Dimension(200, 30));
		
		
		
		this.add(pn_south,BorderLayout.SOUTH);
		

	}
	
	

}
