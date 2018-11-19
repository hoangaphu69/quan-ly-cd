package guiCD;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIDefould extends JPanel{

		private JLabel lb;

		public GUIDefould() {
			this.setLayout(new BorderLayout());
			lb = new JLabel(new ImageIcon("/home/quanglai/javaSwing/CD/src/images/a.gif"));
			
			this.add(lb,BorderLayout.CENTER);//this.add(new JLabel("ok"));
		}
}
