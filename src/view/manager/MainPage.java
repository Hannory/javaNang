package view.manager;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainPage extends JPanel {
//
	JFrame mf;
	JPanel mp; 


	public MainPage(JFrame mf) {

		//필드값 초기화
		this.mf = mf;
		this.mp = this;

		//전체 패널 기본 설정 
		this.setSize(445, 770);
		this.setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		
		
		mf.getContentPane().add(this);

		//상단 패널 설정
		JPanel toppanel = new JPanel();
		toppanel.setBackground(new Color(63,141,197));
		toppanel.setBounds(0,0,445,70);
		mp.add(toppanel);
		toppanel.setLayout(null);
		
				JPanel panel_3 = new JPanel();
				panel_3.setBounds(0, 0, 432, 77);
				toppanel.add(panel_3);
				panel_3.setBackground(new Color(70, 130, 180));
				panel_3.setLayout(null);
				
				JTextArea textArea = new JTextArea();
				textArea.setBounds(117, 12, 197, 48);
				panel_3.add(textArea);
				textArea.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 32));
				textArea.setBackground(new Color(70, 130, 180));
				textArea.setText("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
				textArea.setLayout(null);
		
		//하단 패널 설정
		JPanel bottpanel = new JPanel();
		bottpanel.setBackground(Color.WHITE);
		bottpanel.setBounds(0,70,445,700);
		mp.add(bottpanel);
		bottpanel.setLayout(null);
	
		
		
		
		JButton btnNewButton = new JButton("\uB808\uC2DC\uD53C \uC2B9\uC778");
		btnNewButton.setBounds(126, 157, 174, 58);
		bottpanel.add(btnNewButton);
		btnNewButton.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));
		//mp.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uC81C\uC7AC");
		btnNewButton_1.setBounds(126, 374, 174, 58);
		bottpanel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));



		btnNewButton.addMouseListener(new MyItem());
		btnNewButton_1.addMouseListener(new MyItem2());
	
		mf.repaint();


	}

	class MyItem extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new SecondPage_1(mf));


		}

	}

	class MyItem2 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new SecondPage__2(mf));
		}
	}
}

