package view.manager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MainFrame;
//
public class ChangePanel  {
	
	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
		mf.remove(op);  
		mf.add(np);
		mf.repaint();
	}

}
