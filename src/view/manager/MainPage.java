package view.manager;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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

import view.LoginPage;
import view.MainFrame;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainPage extends JPanel {
	////
	MainFrame mf;
	JPanel mp; 


	public MainPage(MainFrame mf) {

		//필드값 초기화 
		this.mf = mf;
		this.mp = this;

		//전체 패널 기본 설정 
		this.setSize(445, 770);
		this.setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);


		mf.getContentPane().add(this);

		//하단 패널 설정
		JPanel bottpanel = new JPanel();
		bottpanel.setBackground(Color.WHITE);
		bottpanel.setBounds(0,70,445,700);
		mp.add(bottpanel);
		bottpanel.setLayout(null);




		JButton btnNewButton = new JButton("\uB808\uC2DC\uD53C \uC2B9\uC778");
		btnNewButton.setBounds(126, 157, 174, 58);
		bottpanel.add(btnNewButton);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		//mp.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uC81C\uC7AC");
		btnNewButton_1.setBounds(126, 374, 174, 58);
		bottpanel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 23));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 445, 77);
		add(panel_3);
		panel_3.setBackground(new Color(72, 209, 204));
		panel_3.setLayout(null);

		JLabel textArea = new JLabel();
		textArea.setForeground(Color.WHITE);
		textArea.setBounds(117, 12, 197, 48);
		panel_3.add(textArea);
		textArea.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		textArea.setBackground(new Color(72, 209, 204));
		textArea.setText("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		textArea.setLayout(null);

        Image logoutImg = new ImageIcon("images/logout char.png").getImage().getScaledInstance(79, 34, 0);
        JButton logout = new JButton(new ImageIcon(logoutImg));
        logout.setLocation(360,20);
        logout.setSize(79,34);
        logout.addMouseListener(new MyItem3());
		panel_3.add(logout);
		
        this.add(panel_3);
		  
		
		btnNewButton.addMouseListener(new MyItem());
		btnNewButton_1.addMouseListener(new MyItem2());

		mf.repaint();


	}

	class MyItem extends MouseAdapter{
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new SecondPage_1(mf));


		}

	}

	class MyItem2 extends MouseAdapter{
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new SecondPage__2(mf));
		}
	}
 
	class MyItem3 extends MouseAdapter{
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new LoginPage(mf));
		}
	}
    
	
}

