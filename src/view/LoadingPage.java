package view;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingPage extends JPanel {
	
	MainFrame mf;
	JPanel lp;

	
	public LoadingPage(MainFrame mf) {
		
		
		this.mf = mf;
		this.lp = this;
		
		
		this.setSize(432,750);
		
		mf.add(this);
		setLayout(null);
		
		Image icon = new ImageIcon("images/won/intro.gif").getImage().getScaledInstance(450	, 800, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(432,753);
		
		
		
		lp.add(label);
		mf.repaint();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new AllRecipe(mf, this);
		//new MainPage(mf, this);

	}
	

}
