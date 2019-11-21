package view;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.vo.Recipe;

public class LoadingPage extends JPanel {
	
	MainFrame mf;
	JPanel lp;

	
	public LoadingPage(MainFrame mf) {
		
		
		this.mf = mf;
		this.lp = this;
		
		
		this.setSize(445,770);
		
		mf.add(this);
		setLayout(null);
		
		Image icon = new ImageIcon("images/won/intro.gif").getImage().getScaledInstance(445	, 770, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(445,770);
		
		
		
		lp.add(label);
		mf.repaint();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new AllRecipe(mf, this);

	}
	

}
