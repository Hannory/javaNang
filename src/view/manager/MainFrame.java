package view.manager;

import javax.swing.JFrame;
//
public class MainFrame extends JFrame {
	
	public MainFrame() {
		  
		setBounds(100,100,450,800);
			this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		new MainPage(this);

	}

}
