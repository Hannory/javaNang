package view.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import view.manager.MainPage.MyItem;
import view.manager.MainPage.MyItem2;
//
public class SecondPage_1 extends JPanel {

	JFrame mf;
	SecondPage_1 mp;



	public SecondPage_1(JFrame mf) {
		
		//필드값 초기화 
		this.mf=mf;
		this.mp=this;
		
		//
		
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		setSize(445,770);


		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setForeground(new Color(70, 130, 180));
		panel_1.setBounds(0, 0, 432, 84);
		this.add(panel_1);
		panel_1.setLayout(null);

		JTextField textField = new JTextField();
		textField.setBackground(new Color(70, 130, 180));
		textField.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 32));
		textField.setText("\uB808\uC2DC\uD53C \uC2B9\uC778");
		textField.setBounds(108, 32, 196, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setLayout(null);
		
		JButton button_1 = new JButton("<<");
		button_1.setBackground(new Color(70, 130, 180));
		button_1.setBounds(33, 32, 61, 40);
		panel_1.add(button_1);
		//뒤로가기 버튼 

		//안되면 이거로 바꾸기! 내가 추가한 부분 
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf,mp, new MainPage(mf));
			}
		});
		
		
		

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(14, 323, 404, 317);
		add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.setBounds(24, 662, 44, 27);
		add(btnNewButton_2);

		mf.repaint();

	

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(14, 112, 404, 199);
		add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uC81C\uC7AC");
		btnNewButton_1.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 15));
		btnNewButton_1.setBounds(220, 662, 105, 27);
		add(btnNewButton_1);

		JButton button = new JButton(">");
		button.setBounds(360, 662, 44, 27);
		add(button);

		JButton btnNewButton = new JButton("\uC2B9\uC778");
		btnNewButton.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 15));
		btnNewButton.setBounds(101, 662, 105, 27);
		add(btnNewButton);

		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				JOptionPane.showMessageDialog(null, "사용자 제제 등록이 완료 되었습니다.");
			}
		});

		mf.repaint();


	}

		
			}

	