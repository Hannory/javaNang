package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class History extends JPanel {

	private MainFrame mf;
	private ChangePanel cp;
	private JPanel history;
	
	public History(MainFrame mf) {
		
		this.mf = mf;
		history = this;
		
		
		this.setSize(445, 770);
		this.setLayout(null);
		
		//맨 위 바 영억
		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(445, 70);
		bar.setLayout(null);
		bar.setBackground(new Color(52, 152, 219));
		
		Font font = new Font("MD아트체", Font.BOLD, 25);
		Font font2 = new Font("MD아트체", Font.BOLD, 20);
		Font font3 = new Font("맑은 고딕", Font.ITALIC, 15);
		
		JLabel barTitle = new JLabel("히스토리");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);
		
		Image backImg = new ImageIcon("images/park/back blue.png").getImage().getScaledInstance(50,  50,  0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10, 10);
		back.setSize(50, 50);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, history, new MyFridge(mf));
				
			}
			
		});
		
		Image person = new ImageIcon("images/park/person in blue.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setLocation(380, 10);
		logIn.setSize(50, 50);
		
		//첫번째 히스토리
		JPanel panel1 = new JPanel();
		panel1.setLocation(0, 70);
		panel1.setSize(445, 175);
		
		Image photo1 = new ImageIcon("images/park/potato.jpg").getImage().getScaledInstance(225, 175, 0);
		JLabel photoLabel1 = new JLabel(new ImageIcon(photo1));
		photoLabel1.setLocation(220, 0);
		photoLabel1.setSize(225, 175);
		
		
		JLabel recipeName1 = new JLabel("# 감자당근볶음");
		recipeName1.setLocation(30, 59);
		recipeName1.setSize(200, 50);
		recipeName1.setFont(font2);

		//향후 Date 이용 해야할듯
		JLabel beforeDate1 = new JLabel("1일전");
		beforeDate1.setLocation(10, 25);
		beforeDate1.setSize(100, 50);
		beforeDate1.setFont(font3);
		beforeDate1.setForeground(Color.BLUE);

		//두번째 히스토리
		JPanel panel2 = new JPanel();
		panel2.setLocation(0, 245);
		panel2.setSize(445, 175);
		
		Image photo2 = new ImageIcon("images/park/cheeseBall.jpg").getImage().getScaledInstance(225, 175, 0);
		JLabel photoLabel2 = new JLabel(new ImageIcon(photo2));
		photoLabel2.setLocation(220, 0);
		photoLabel2.setSize(225, 175);
		
		
		JLabel recipeName2 = new JLabel("# 치즈볼");
		recipeName2.setLocation(30, 59);
		recipeName2.setSize(200, 50);
		recipeName2.setFont(font2);

		//향후 Date 이용 해야할듯
		JLabel beforeDate2 = new JLabel("2일전");
		beforeDate2.setLocation(10, 25);
		beforeDate2.setSize(100, 50);
		beforeDate2.setFont(font3);
		beforeDate2.setForeground(Color.BLUE);

		//세번째 히스토리
		JPanel panel3 = new JPanel();
		panel3.setLocation(0, 420);
		panel3.setSize(445, 175);
		
		Image photo3 = new ImageIcon("images/park/soup.jpg").getImage().getScaledInstance(225, 175, 0);
		JLabel photoLabel3 = new JLabel(new ImageIcon(photo3));
		photoLabel3.setLocation(220, 0);
		photoLabel3.setSize(225, 175);
		
		
		JLabel recipeName3 = new JLabel("# 소고기찌개");
		recipeName3.setLocation(30, 59);
		recipeName3.setSize(200, 50);
		recipeName3.setFont(font2);

		//향후 Date 이용 해야할듯
		JLabel beforeDate3 = new JLabel("4일전");
		beforeDate3.setLocation(10, 25);
		beforeDate3.setSize(100, 50);
		beforeDate3.setFont(font3);
		beforeDate3.setForeground(Color.BLUE);

		//네번째 히스토리
		JPanel panel4 = new JPanel();
		panel4.setLocation(0, 595);
		panel4.setSize(445, 175);
		
		Image photo4 = new ImageIcon("images/park/steamed potato.jpg").getImage().getScaledInstance(225, 175, 0);
		JLabel photoLabel4 = new JLabel(new ImageIcon(photo4));
		photoLabel4.setLocation(220, 0);
		photoLabel4.setSize(225, 175);
		
		
		JLabel recipeName4 = new JLabel("# 찐감자");
		recipeName4.setLocation(30, 59);
		recipeName4.setSize(200, 50);
		recipeName4.setFont(font2);

		//향후 Date 이용 해야할듯
		JLabel beforeDate4 = new JLabel("5일전");
		beforeDate4.setLocation(10, 25);
		beforeDate4.setSize(100, 50);
		beforeDate4.setFont(font3);
		beforeDate4.setForeground(Color.BLUE);
		
		
		bar.add(barTitle);
		bar.add(back);
		bar.add(logIn);
		
		panel1.add(photoLabel1);
		panel1.add(recipeName1);
		panel1.add(beforeDate1);
		
		panel2.add(photoLabel2);
		panel2.add(recipeName2);
		panel2.add(beforeDate2);
		
		panel3.add(photoLabel3);
		panel3.add(recipeName3);
		panel3.add(beforeDate3);
		
		panel4.add(photoLabel4);
		panel4.add(recipeName4);
		panel4.add(beforeDate4);
		
		this.add(bar);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		
		mf.add(this);
	}
	
}
