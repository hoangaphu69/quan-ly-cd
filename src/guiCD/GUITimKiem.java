package guiCD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import action.TimKiemAction;
import dao.CDDAO;
import dao.PhanMemDAO;
import dao.TinhNangDAO;
import entity.CDEntity;
import entity.GiaTriFinal;
import entity.PhanMemEntity;
import entity.TinhNangPMEntity;

public class GUITimKiem extends JPanel{
	private JLabel lb_nhap;
	private JTextField txt_tim;
	private JPanel pn_nouth;
	private JButton btn_tim;
	private DefaultTableModel defaultTableModel;
	private JTable jtable;
	private JPanel pn_south;
	private JPanel pn_south_east;
	private JButton btn_xoa;
	private JButton btn_sua;
	private JLabel lb_timkiemphanloai;
	private JComboBox cbb_timkiemphanloai;
	private Border lineBorder = BorderFactory.createLineBorder(Color.blue);
    private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    private Border loweredBevel = BorderFactory.createLoweredBevelBorder();
	private JComboBox cbb_loaiPM;
	private JLabel lb_loaiPM;
	private JComboBox cbb_TinhNang;
	private JLabel lb_tinhNang;

	private CDDAO cddao = new CDDAO();
	private PhanMemDAO phanMemDAO =  new PhanMemDAO();
	private TinhNangDAO tinhNangDAO = new TinhNangDAO();
	private JPanel pn_nouth_west;
	private JPanel pn_nouth_center;
	private JLabel lb_phienban;
	private JTextField txt_phienban;
	

	public GUITimKiem() {
		setLayout(new BorderLayout());
		Border compound = BorderFactory.createCompoundBorder(raisedBevel,
                loweredBevel);
		
		Border titleBorder = BorderFactory.createTitledBorder(compound,
                "CAC CHUC NANG", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		
		pn_nouth = new JPanel();
		pn_nouth.setBorder(titleBorder);
		pn_nouth.setLayout(new BorderLayout());
		lb_nhap = new JLabel("nhap:");
		lb_timkiemphanloai  =  new JLabel("tim theo:");
		cbb_timkiemphanloai = new JComboBox<>();
		
		GiaTriFinal All = GiaTriFinal.All;
		GiaTriFinal tenCD = GiaTriFinal.TenCD;
		GiaTriFinal maCD = GiaTriFinal.MaCD;
		
		cbb_timkiemphanloai.addItem(All);
		cbb_timkiemphanloai.addItem(tenCD);
		cbb_timkiemphanloai.addItem(maCD);
		
		
		cbb_loaiPM = new JComboBox<>();
		cbb_loaiPM.setPreferredSize(new Dimension(220, 30));
		
		cbb_loaiPM.addItem(GiaTriFinal.All);
		
		List<PhanMemEntity> phanMemEntities =phanMemDAO.getAll();
		for(PhanMemEntity phanMemEntity : phanMemEntities) {
			cbb_loaiPM.addItem(phanMemEntity.getTenPM());
		}
		
		
		lb_loaiPM = new JLabel("LoaiPM:");
		
		
		cbb_TinhNang = new JComboBox<>();
		cbb_TinhNang.setPreferredSize(new Dimension(220, 30));
		cbb_TinhNang.addItem(GiaTriFinal.All);
		
		List<TinhNangPMEntity> tinhNangPMEntities =tinhNangDAO.getAll();
		for(TinhNangPMEntity tinhNangPMEntity : tinhNangPMEntities) {
			cbb_TinhNang.addItem(tinhNangPMEntity.getTinhnang());
		}
		
		lb_tinhNang = new JLabel("Tinh Nang PM:");
		
		
		
		txt_tim = new JTextField(20);
		btn_tim = new JButton("Tim");
		
		lb_phienban = new JLabel("phien ban:");
		txt_phienban =  new JTextField(20);
		
		//pn_nouth.add(cbb_TinhNang);
		
		
		// pn_nouth_est
		
		pn_nouth_west = new JPanel();
		pn_nouth_west.setLayout(new GridBagLayout());
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 10, 20, 0);
		pn_nouth_west.add(lb_timkiemphanloai, bagConstraints);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 10, 20, 0);
		pn_nouth_west.add(cbb_timkiemphanloai, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 10, 20, 20);
		pn_nouth_west.add(lb_nhap, bagConstraints);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 10, 20, 0);
		pn_nouth_west.add(txt_tim, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(0, 10, 20, 0);
		pn_nouth_west.add(btn_tim, bagConstraints);
		
		
		pn_nouth.add(pn_nouth_west, BorderLayout.WEST);
		
		
		pn_nouth_center = new JPanel();
		pn_nouth_center.setLayout(new GridBagLayout());
		GridBagConstraints bagConstraints2 = new GridBagConstraints();
		bagConstraints2.gridx = 0;
		bagConstraints2.gridy = 0;
		bagConstraints2.insets = new Insets(5, 10, 20, 50);
		pn_nouth_center.add(lb_loaiPM, bagConstraints2);
		bagConstraints2.gridx = 1;
		bagConstraints2.gridy = 0;
		bagConstraints2.insets = new Insets(5, 10, 20, 250);
		pn_nouth_center.add(cbb_loaiPM, bagConstraints2);
		
		bagConstraints2.gridx = 0;
		bagConstraints2.gridy = 1;
		bagConstraints2.insets = new Insets(0, 10, 20, 20);
		pn_nouth_center.add(lb_tinhNang, bagConstraints2);
		bagConstraints2.gridx = 1;
		bagConstraints2.gridy = 1;
		bagConstraints2.insets = new Insets(0, 10, 20, 250);
		pn_nouth_center.add(cbb_TinhNang, bagConstraints2);
		
		bagConstraints2.gridx = 0;
		bagConstraints2.gridy = 2;
		bagConstraints2.insets = new Insets(0, 10, 20, 40);
		pn_nouth_center.add(lb_phienban, bagConstraints2);
		bagConstraints2.gridx = 1;
		bagConstraints2.gridy = 2;
		bagConstraints2.insets = new Insets(0, 10, 20, 250);
		pn_nouth_center.add(txt_phienban, bagConstraints2);
		
		
		pn_nouth.add(pn_nouth_center,BorderLayout.CENTER);
		
		this.add(pn_nouth,BorderLayout.NORTH);
		
		
		
		
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
		
		
		jtable = new JTable(defaultTableModel);
		
		JScrollPane jScrollPane = new JScrollPane(jtable);
		
		List<CDEntity> cdEntities = cddao.getAll();
		for(CDEntity cdEntity : cdEntities) {
			PhanMemEntity phanMemEntity = phanMemDAO.findOne(cdEntity.getPhanMemEntity());
			defaultTableModel.addRow(new Object[] {cdEntity.getMaCD(),cdEntity.getTenCD(),phanMemEntity.getTenPM(),cdEntity.getSoluong(),cdEntity.getGia(),cdEntity.getNgayPhatHanh(),phanMemEntity.getTinhNangPMEntity(),cdEntity.getPhienban(),phanMemEntity.getTacGiaEntity()});
		}
		
		this.add(jScrollPane,BorderLayout.CENTER);
		
		pn_south = new JPanel();
		pn_south.setLayout(new BorderLayout());
		pn_south.setBorder(titleBorder);
		pn_south_east = new JPanel();
		
		btn_xoa = new JButton("Xoa");
		btn_sua = new JButton("Sua");
		btn_xoa.setPreferredSize(new Dimension(100, 40));
		btn_sua.setPreferredSize(new Dimension(100, 40));
		btn_tim.setPreferredSize(new Dimension(220, 30));
		cbb_timkiemphanloai.setPreferredSize(new Dimension(220, 30));
		txt_tim.setPreferredSize(new Dimension(200, 30));
		txt_phienban.setPreferredSize(new Dimension(200, 30));
		
		pn_south_east.add(btn_xoa);
		pn_south_east.add(btn_sua);
		pn_south.add(pn_south_east,BorderLayout.EAST);
		add(pn_south,BorderLayout.SOUTH);
		
		
		TimKiemAction timKiemAction = new TimKiemAction(cbb_loaiPM, cbb_TinhNang, cbb_timkiemphanloai, txt_tim, txt_phienban, defaultTableModel);
		btn_tim.addActionListener(timKiemAction);
		
		
	}
}
