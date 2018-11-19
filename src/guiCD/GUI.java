package guiCD;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GUI extends JFrame{
	private DefaultMutableTreeNode quanly,danhsachCD,timkiem;
	private JSplitPane jsp;
	private JTabbedPane jtp;
	private JTree jt;
	private JPanel pn;
	private DefaultMutableTreeNode sua;
	private DefaultMutableTreeNode them;
	private DefaultMutableTreeNode theloai;
	private DefaultMutableTreeNode danhmuc;
	private DefaultMutableTreeNode tim;
	private DefaultMutableTreeNode timPhienBan;
	private DefaultMutableTreeNode timTinhNang;
	public GUI() {
		setSize(2000, 700);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jtp = new JTabbedPane();
		jtp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pn = new JPanel(new BorderLayout());
		
		quanly = new DefaultMutableTreeNode("Quản lý");
		danhsachCD = new DefaultMutableTreeNode("Danh Sach CD");
		timkiem = new DefaultMutableTreeNode("Tim Kiem");
		theloai = new DefaultMutableTreeNode("Phan Mem");
		them = new DefaultMutableTreeNode("Them");
		timPhienBan = new DefaultMutableTreeNode("Tim Theo Phan Ban");
		timTinhNang = new DefaultMutableTreeNode("Tim Theo Tinh Nang");
		
		danhmuc = new DefaultMutableTreeNode("Danh Muc");
		tim = new DefaultMutableTreeNode("Tim");
		tim.add(timPhienBan);
		tim.add(timTinhNang);
		quanly.add(danhsachCD);
		quanly.add(timkiem);
		quanly.add(them);
		danhmuc.add(theloai);
		quanly.add(danhmuc);
		quanly.add(tim);
		jt = new JTree(quanly);
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jt,pn);
		
		add(jsp);
		
		jt.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				
				TreePath tp = e.getNewLeadSelectionPath();
				Object o = tp.getLastPathComponent();
				String st = o.toString();
				
				switch(st){
				case "Danh Sach CD" : 
					pn.removeAll();
					pn.add(new GUIDanhSachCD(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				case "Tim Kiem" :
					pn.removeAll();
					pn.add(new GUITimKiem(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				case "Them" :
					pn.removeAll();
					pn.add(new GUIThemCD(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				case "the loai" :
					pn.removeAll();
					pn.add(new GUITheLoai(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				case "Quản lý" :
					pn.removeAll();
					pn.add(new GUIDefould(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				case "Tim Theo Phan Ban" :
					pn.removeAll();
					pn.add(new GUITimKiemPhienBan(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				case "Tim Theo Tinh Nang" :
					pn.removeAll();
					pn.add(new GUITimKiemTinhNang(),BorderLayout.CENTER);
					pn.repaint();
					pn.updateUI();
					break;
				default : 
					pn.removeAll();
					pn.updateUI();
				}
			}
		});
	}
}