package guiCD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class GUITimKiemPhienBan extends JPanel{
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
	private Border lineBorder = BorderFactory.createLineBorder(Color.blue);
    private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    private Border loweredBevel = BorderFactory.createLoweredBevelBorder();

	public GUITimKiemPhienBan() {
		setLayout(new BorderLayout());
		Border compound = BorderFactory.createCompoundBorder(raisedBevel,
                loweredBevel);
		
		Border titleBorder = BorderFactory.createTitledBorder(compound,
                "CAC CHUC NANG", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		
		pn_nouth = new JPanel();
		pn_nouth.setBorder(titleBorder);
		lb_nhap = new JLabel("nhap ten:");
		
		txt_tim = new JTextField(20);
		btn_tim = new JButton("Tim");
		pn_nouth.add(lb_nhap);
		pn_nouth.add(txt_tim);
		pn_nouth.add(btn_tim);
		this.add(pn_nouth,BorderLayout.NORTH);
		
		
		
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
		
		
		this.add(jScrollPane,BorderLayout.CENTER);
		
		pn_south = new JPanel();
		pn_south.setLayout(new BorderLayout());
		pn_south.setBorder(titleBorder);
		pn_south_east = new JPanel();
		
		btn_xoa = new JButton("Xoa");
		btn_sua = new JButton("Sua");
		btn_xoa.setPreferredSize(new Dimension(100, 40));
		btn_sua.setPreferredSize(new Dimension(100, 40));
		btn_tim.setPreferredSize(new Dimension(100, 30));
		txt_tim.setPreferredSize(new Dimension(200, 30));
		
		pn_south_east.add(btn_xoa);
		pn_south_east.add(btn_sua);
		pn_south.add(pn_south_east,BorderLayout.EAST);
		add(pn_south,BorderLayout.SOUTH);
		

	}
}
