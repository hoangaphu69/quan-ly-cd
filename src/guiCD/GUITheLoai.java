package guiCD;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GUITheLoai extends JPanel{
	private JComboBox cbb_the;
	private JComboBox cbb_theloai;
	private JLabel lb_theloai;
	private JPanel pn_nouth;
	private DefaultTableModel defaultTableModel;
	private JTable jtable;
	private JPanel pn_south;
	private JButton btn_xoa;

	public GUITheLoai() {
		setLayout(new BorderLayout());
		cbb_theloai = new JComboBox<>();
		cbb_theloai.addItem("tac gia");
		cbb_theloai.addItem("the loai");
		cbb_theloai.addItem("ma cd");
		cbb_theloai.addItem("ten");
		lb_theloai = new JLabel("chon the loai:");
		pn_nouth = new JPanel();
		pn_nouth.add(lb_theloai);
		pn_nouth.add(cbb_theloai);
		
		
		
		
		this.add(pn_nouth,BorderLayout.NORTH);
		
		

		String[] titles = new String[] {"MaCD", "Ten CD", "Phan Mem", "So Luong CD", "Gia","Ngay phat hanh"};

		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn(titles[0]);
		defaultTableModel.addColumn(titles[1]);
		defaultTableModel.addColumn(titles[2]);
		defaultTableModel.addColumn(titles[3]);
		defaultTableModel.addColumn(titles[4]);
		defaultTableModel.addColumn(titles[5]);
		
		JScrollPane jScrollPane = new JScrollPane(jtable);
		
		
		this.add(jScrollPane,BorderLayout.CENTER);
		
		
		pn_south = new JPanel();
		btn_xoa = new JButton("Xoa");
		pn_south.add(btn_xoa);
		
		this.add(pn_south, BorderLayout.SOUTH);
		
		
		
		
	}
}
