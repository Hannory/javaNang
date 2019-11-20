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

import model.vo.Recipe;

public class RecipePage2 extends JPanel {
	
	private MainFrame mf;
	private ChangePanel cp;
	private JPanel rp2;
	
	public RecipePage2(MainFrame mf, Recipe rc) {
		
		this.mf = mf;
		rp2 = this;
		
		this.setSize(445, 770);
		this.setLayout(null);
		
		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(445, 70);
		bar.setLayout(null);
		bar.setBackground(new Color(52, 152, 219));
		
		Font font = new Font("MD��Ʈü", Font.BOLD, 25);
		Font font2 = new Font("MD��Ʈü", Font.BOLD, 20);
		Font font3 = new Font("MD��Ʈü", Font.BOLD, 15);
		
		JLabel barTitle = new JLabel(rc.getRecipeName());
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
				cp.changePanel(mf, rp2, new Recommend(mf));
				
			}
			
		});
		
		Image person = new ImageIcon("images/park/person in blue.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setLocation(380, 10);
		logIn.setSize(50, 50);
		
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, rp2, new MyFridge(mf));
				
			}
			
		});
		
		//���� �г�
		JPanel panel = new JPanel();
		panel.setLocation(0, 70);
		panel.setSize(445, 307);
		panel.setLayout(null);
		
		Image photo = new ImageIcon(rc.getRecipePicAdr()).getImage().getScaledInstance(445, 307, 0);
		JLabel label = new JLabel(new ImageIcon(photo));
		label.setSize(445, 307);
		
		//�Ծ���� ��ư
		JButton ate = new JButton("�Ծ����");
		ate.setSize(145, 50);
		ate.setLocation(150, 377);
		ate.setFont(font2);
		
		//������ ����
		JLabel recipeCont = new JLabel(rc.getRecipeCont());
		recipeCont.setSize(345, 200);
		recipeCont.setLocation(50, 427);
		recipeCont.setFont(font3);
		
		//add ����
		bar.add(barTitle);
		bar.add(back);
		bar.add(logIn);
		
		panel.add(label);
		
		this.add(bar);
		this.add(panel);
		this.add(ate);
		this.add(recipeCont);
		
		mf.add(this);
	}

}
