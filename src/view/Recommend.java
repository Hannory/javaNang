package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class Recommend extends JPanel {
	
	private MainFrame mf;
	private ChangePanel cp;
	private JPanel imageTest;

	public Recommend(MainFrame mf) {		
		/*this.setTitle("java.냉");
		this.setSize(450, 800);
		this.setLayout(null);*/	
		
		this.mf = mf;
		imageTest = this;
		
		//바탕 패널
		this.setSize(432, 770);
		this.setLayout(null);
		
		//맨 위 바 영억
		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(450, 73);
		bar.setLayout(null);
		bar.setBackground(Color.BLACK);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		
		JLabel barTitle = new JLabel("요리 추천");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);
		
		JButton back = new JButton("←");
		back.setLocation(10, 25);
		back.setSize(50, 50);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, imageTest, new MainMenu(mf));
				
			}
			
		});
		
		Image person = new ImageIcon("images/park/person in black.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setLocation(370, 25);
		logIn.setSize(50, 50);
		
		//현재 재료로
		JPanel panel = new JPanel();
		panel.setLocation(0, 100);
		panel.setSize(450, 220);
		panel.setLayout(null);
		
		Image icon = new ImageIcon("images/park/potato.jpg").getImage().getScaledInstance(332, 225, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setLocation(50, 0);
		label.setSize(332, 220);
		
		JButton left = new JButton("◀");
		left.setSize(50, 220);
		left.setLocation(0, 0);
		
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Image icon = new ImageIcon("images/park/steamed potato.jpg").getImage().getScaledInstance(332, 225, 0);
				label.setIcon(new ImageIcon(icon));
				
			}
			
		});
		
		JButton right = new JButton("▶");
		right.setSize(50, 220);
		right.setLocation(382, 0);
		
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Image icon = new ImageIcon("images/park/potato.jpg").getImage().getScaledInstance(332,  225, 0);
				label.setIcon(new ImageIcon(icon));
				
			}
			
		});
		
		//추가 재료로
		JPanel panel2 = new JPanel();
		panel2.setLocation(0, 320);
		panel2.setSize(450, 220);
		panel2.setLayout(null);
		
		Image icon2 = new ImageIcon("images/park/soup.jpg").getImage().getScaledInstance(332, 225, 0);
		JLabel label2 = new JLabel(new ImageIcon(icon2));
		label2.setLocation(50, 0);
		label2.setSize(332, 220);
		
		JButton left2 = new JButton("◀");
		left2.setSize(50, 220);
		left2.setLocation(0, 0);
		
		left2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Image icon2 = new ImageIcon("images/park/soup.jpg").getImage().getScaledInstance(332, 225, 0);
				label2.setIcon(new ImageIcon(icon2));
				
			}
			
		});
		
		JButton right2 = new JButton("▶");
		right2.setSize(50, 220);
		right2.setLocation(382, 0);
		
		right2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Image icon2 = new ImageIcon("images/park/cheeseBall.jpg").getImage().getScaledInstance(332,  225, 0);
				label2.setIcon(new ImageIcon(icon2));
				
			}
			
		});
		
		//모든 레시피 패널
		JPanel panel3 = new JPanel();
		panel3.setLocation(0, 540);
		panel3.setSize(450, 220);
		panel3.setLayout(null);

		Image icon3 = new ImageIcon("images/park/allRecipePanel.png").getImage().getScaledInstance(450, 220, 0);
		JLabel label3 = new JLabel(new ImageIcon(icon3));
		label3.setSize(450, 220);
		label3.setLayout(null);
		
		JButton allBtn = new JButton("모든 레시피");
		allBtn.setLocation(175, 75);
		allBtn.setSize(160, 60);
		allBtn.setFont(font2);
		//allBtn.setVisible(false);
		
		//add 영역
		bar.add(barTitle);
		bar.add(back);
		bar.add(logIn);
		
		panel.add(left);
		panel.add(right);
		panel.add(label);
		
		panel2.add(left2);
		panel2.add(right2);
		panel2.add(label2);
		
		label3.add(allBtn);
		panel3.add(label3);
		
		this.add(bar);
		this.add(panel);
		this.add(panel2);
		this.add(panel3);
		
		mf.add(this);
	}
	
}
