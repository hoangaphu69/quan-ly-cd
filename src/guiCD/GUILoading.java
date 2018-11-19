package guiCD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class GUILoading  extends JFrame{
	private JProgressBar pb;

	public GUILoading() {
		pb = new JProgressBar();
		pb.setBounds(0, 535, 800, 30);
		pb.setValue(0);
		pb.setStringPainted(true);
		this.add(pb);
		this.setSize(800, 600);
		setLocation(300, 00);
		this.setLayout(new BorderLayout());
		
		this.add(new JLabel(new ImageIcon("C:\\Users\\hoangaphu\\eclipse-workspace\\CD\\images\\imCD.jpg")));
		
	}
	public void run() {
		int i=0;
		while (i<100) {
			pb.setValue(i);
			i = i + 1;
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.getMessage();
			}
		}
		if(i>=100) {
			GUILogin guiLogin = new GUILogin();
			guiLogin.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		GUILoading loading =  new GUILoading();
		loading.setVisible(true);
		loading.run();
	}
}
