package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		this.setTitle("java.³Ã");
		this.setSize(450, 800);
		this.setLayout(null);
		
		//new Recommend(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		new LoadingPage(this);
	}

}
