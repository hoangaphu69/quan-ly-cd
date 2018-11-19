//package action;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JTextField;
//
//import guiCD.GUI;
//import guiCD.GuiAddPhanMem;
//import guiCD.GuiAddTacGia;
//import guiCD.GuiAddTinhNang;
//
//public class AddThemAction implements ActionListener {
//	
//	JButton btn_addPM;
//	JTextField txt_add;
//	
//	public AddThemAction(JButton btn_addPM) {
//		super();
//		this.btn_addPM = btn_addPM;
//		this.txt_add = txt_add;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object object = e.getSource();
//		if(object.equals(btn_addPM)) {
//			//guiAddPhanMem.setVisible(true);
//			System.out.println("lai1");
//			new GuiAddPhanMem().setVisible(true);
//			System.out.println("lai2");
//		}
//		if(object.equals(btn_addTG)) {
//			//guiAddPhanMem.setVisible(true);
//			System.out.println("lai1");
//			//new GuiAddTacGia().setV;
//			System.out.println("lai2");
//		}
//		if(object.equals(btn_addTN)) {
//			//guiAddPhanMem.setVisible(true);
//			System.out.println("lai1");
//			new GuiAddTinhNang().setVisible(true);
//			System.out.println("lai2");
//		}
//		
//		
//	}
//	
//}
