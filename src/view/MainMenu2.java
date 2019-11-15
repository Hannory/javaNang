package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu2 extends JPanel {
	
	private MainFrame mf;
	private ChangePanel cp;
	private JPanel mainMenu;
	
	public MainMenu2(MainFrame mf) {

		this.mf = mf;
		mainMenu = this;
		
		this.setSize(432, 770);
		this.setLayout(null);
		
		//맨 위 바 영억
		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(450, 100);
		bar.setLayout(null);
		bar.setBackground(Color.BLACK);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		
		JLabel barTitle = new JLabel("메인 메뉴");
		barTitle.setLocation(80, 25);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);
		
		JButton recipeReco = new JButton("요리 추천");
		recipeReco.setLocation(120, 300);
		recipeReco.setSize(210, 100);
		recipeReco.setFont(font2);
		
		recipeReco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, mainMenu, new Recommend(mf));
				
			}
		});
		
		JButton hisBtn = new JButton("My.히스토리");
		hisBtn.setLocation(120, 450);
		hisBtn.setSize(210, 100);
		hisBtn.setFont(font2);

		hisBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, mainMenu, new History(mf));
				
			}
		});
		
		bar.add(barTitle);
		
		this.add(bar);
		this.add(recipeReco);
		this.add(hisBtn);
		
		mf.add(this);
	}
}
