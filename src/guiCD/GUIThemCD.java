package guiCD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
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

import action.AddCDAction;
import dao.PhanMemDAO;
import dao.TacGiaDAO;
import dao.TinhNangDAO;
import entity.PhanMemEntity;

public class GUIThemCD extends JPanel{
	
	private JLabel lb_maCD;
	private JLabel lb_tenCD;
	private JLabel lb_phanloai;
	private JTextField txt_maCD;
	private JTextField txt_tenCD;
	private DefaultTableModel defaultTableModel;
	private JTable jtable;
	private JPanel pn_nouth;
	private JPanel pn_center;
	private JButton btn_them;
	private JButton btn_xoa;
	private JLabel lb_ngayphathanh;
	private JTextField txt_ngayphathanh;
	private JLabel lb_gia;
	private JTextField txt_gia;
	private JTextField txt_soluong;	
	private JLabel lb_soluong;
	private JLabel lb_loaiPM;
	private JComboBox cbb_PM;
	private JPanel pn_south;
    private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    private Border loweredBevel = BorderFactory.createLoweredBevelBorder();
	private JButton btn_sua;
	private JPanel pn_south_EAST;
	private JButton btn_themLoaiPM;
	private JLabel lb_phienban;
	private JTextField txt_phienban;
	private TinhNangDAO tinhNangDAO = new TinhNangDAO();
	private PhanMemDAO phanMemDAO = new PhanMemDAO();
	private TacGiaDAO tacGiaDAO = new TacGiaDAO();

	public GUIThemCD() {
		
		setLayout(new BorderLayout());
		
		pn_nouth = new JPanel();
		pn_nouth.setLayout(new GridBagLayout());
		
		
		GridBagConstraints bagConstraints = new GridBagConstraints();
		
		//private String maCD;
		//private String tenCD;
		//private Date ngayPhatHanh;
		//private double gia;
		//private int soluong;
		//private PhanMemEntity phanMemEntity;
		
		lb_maCD = new JLabel("ma CD   :");
		txt_maCD = new JTextField(30);
		lb_tenCD = new JLabel("ten CD   :");
		txt_tenCD = new JTextField(30);
		lb_ngayphathanh = new JLabel("ngay phat hanh :");
		txt_ngayphathanh = new JTextField(30);
		lb_gia = new JLabel("gia:");
		txt_gia = new JTextField(30);
		lb_soluong = new JLabel("so luong:");
		txt_soluong = new JTextField(30);
		lb_loaiPM = new JLabel("loai phan mem:");
		btn_them = new JButton("Them");
		btn_them.setPreferredSize(new Dimension(330, 30));
		btn_themLoaiPM = new JButton("Add");
		btn_themLoaiPM.setPreferredSize(new Dimension(70, 30));
		
		
		lb_phienban = new JLabel("phien ban");
		txt_phienban = new JTextField(30);
		
		
		
		cbb_PM = new JComboBox<>();
		cbb_PM.setPreferredSize(new Dimension(330, 30));
		List<PhanMemEntity> phanMemEntities =phanMemDAO.getAll();
		for(PhanMemEntity phanMemEntity : phanMemEntities) {
			cbb_PM.addItem(phanMemEntity.getTenPM());
		}
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 0, 0, 90);
		pn_nouth.add(lb_maCD,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(txt_maCD,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 90);
		pn_nouth.add(lb_tenCD,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(txt_tenCD,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 60);
		pn_nouth.add(lb_loaiPM,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(cbb_PM,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(btn_themLoaiPM,bagConstraints);
		
		
		//
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		bagConstraints.insets = new Insets(10, 0, 0, 56);
		pn_nouth.add(lb_ngayphathanh,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 4;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(txt_ngayphathanh,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 5;
		bagConstraints.insets = new Insets(10, 0, 0, 120);
		pn_nouth.add(lb_gia,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 5;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(txt_gia,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 6;
		bagConstraints.insets = new Insets(10, 0, 0, 90);
		pn_nouth.add(lb_soluong,bagConstraints);
		
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 6;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(txt_soluong,bagConstraints);
		
		//a
		
		//c
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 9;
		bagConstraints.insets = new Insets(10, 0, 0, 80);
		pn_nouth.add(lb_phienban,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 9;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(txt_phienban,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 10;
		bagConstraints.insets = new Insets(10, 0, 30, 0);
		pn_nouth.add(btn_them,bagConstraints);
		
		Border compound = BorderFactory.createCompoundBorder(raisedBevel,
                loweredBevel);
		Border titleBorder = BorderFactory.createTitledBorder(compound,
                "CAC CHUC NANG", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pn_nouth.setBorder(titleBorder);
		this.add(pn_nouth, BorderLayout.NORTH);
		
		pn_center = new JPanel();
	
		
		
		String[] titles = new String[] {"MaCD", "Ten CD", "Phan Mem", "So Luong CD", "Gia","Ngay phat hanh"};

		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn(titles[0]);
		defaultTableModel.addColumn(titles[1]);
		defaultTableModel.addColumn(titles[2]);
		defaultTableModel.addColumn(titles[3]);
		defaultTableModel.addColumn(titles[4]);
		defaultTableModel.addColumn(titles[5]);
		
		jtable = new JTable(defaultTableModel);
		
		JScrollPane jScrollPane = new JScrollPane(jtable);
		
		
		this.add(jScrollPane, BorderLayout.CENTER);
		
		
		this.add(pn_nouth, BorderLayout.NORTH);
		
		btn_xoa = new JButton("Xoa");
		btn_sua = new JButton("Sua");
		btn_sua.setPreferredSize(new Dimension(100, 40));
		btn_xoa.setPreferredSize(new Dimension(100, 40));
		//	pn_nouth.add(btn_them);
			pn_nouth.add(btn_xoa);
		pn_south = new JPanel();
		pn_south.setLayout(new BorderLayout());
		pn_south.setBorder(titleBorder);
		pn_south_EAST = new JPanel();
		pn_south_EAST.add(btn_xoa);
		pn_south_EAST.add(btn_sua);
		pn_south.add(pn_south_EAST, BorderLayout.EAST);
		
		this.add(pn_south, BorderLayout.SOUTH);
		
		//action them pM
		btn_themLoaiPM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new GuiAddPhanMem(cbb_PM).setVisible(true);
			
			}
		});
		AddCDAction addCDAction = new AddCDAction(txt_maCD, txt_tenCD, txt_ngayphathanh, txt_phienban, txt_soluong, txt_gia, cbb_PM);
				
		btn_them.addActionListener(addCDAction);
		
	}

}
