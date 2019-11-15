package view.manager;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class SecondPage__2 extends JPanel {

	JFrame mf;
	SecondPage__2 sp2;



	public SecondPage__2(JFrame mf) {
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		setSize(432,787);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(0, 0, 432, 83);
		this.add(panel_1);
		panel_1.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(70, 130, 180));
		textArea.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 32));
		textArea.setText("\uD68C\uC6D0 \uC81C\uC7AC");
		textArea.setBounds(146, 24, 153, 47);
		panel_1.add(textArea);
		
		JButton button_1 = new JButton("<<");
		button_1.setBackground(new Color(70, 130, 180));
		button_1.setBounds(27, 29, 61, 40);
		panel_1.add(button_1);
		//뒤로가기 버튼 
		
		//이부분 추가한 부분 
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf,sp2, new MainPage(mf));
			}
		});
		
		
		
		
		
		
		
		
		
		
		JButton button = new JButton("<");
		button.setBackground(new Color(70, 130, 180));
		button.setBounds(43, 24, 43, 40);
		this.add(button);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(UIManager.getColor("CheckBox.background"));
		textArea_1.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 32));
		textArea_1.setText("\uD68C\uC6D0\uC81C\uC7AC\uB300\uC0C1");
		textArea_1.setBounds(118, 116, 208, 41);
		this.add(textArea_1);

		JTextArea txtrId = new JTextArea();
		txtrId.setBackground(UIManager.getColor("CheckBox.background"));
		txtrId.setFont(new Font("돋움체", Font.BOLD, 23));
		txtrId.setText("ID");
		txtrId.setBounds(60, 209, 42, 32);
		this.add(txtrId);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(UIManager.getColor("CheckBox.background"));
		textArea_2.setText("\uC81C\uC7AC \uC0AC\uC720");
		textArea_2.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));
		textArea_2.setBounds(28, 293, 113, 32);
		this.add(textArea_2);

		JButton btnNewButton = new JButton("\uC81C\uC7AC \uB4F1\uB85D");
		btnNewButton.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));
		
		//방금 내가 //처리한부분
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.setBounds(153, 707, 148, 27);
		this.add(btnNewButton);

		JRadioButton rdbtnNewRadioButton = new JRadioButton(" \uC6F9\uD558\uB4DC \uC544\uC774\uB514 \uD64D\uBCF4");
		rdbtnNewRadioButton.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		rdbtnNewRadioButton.setBackground(UIManager.getColor("CheckBox.background"));
		rdbtnNewRadioButton.setBounds(162, 357, 245, 27);
		this.add(rdbtnNewRadioButton);

		JRadioButton radioButton = new JRadioButton(" \uC131\uC778\uC790\uB8CC \uD64D\uBCF4");
		radioButton.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		radioButton.setBackground(UIManager.getColor("CheckBox.background"));
		radioButton.setBounds(162, 414, 245, 27);
		this.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton(" \uBE44\uBC29 \uBC0F \uC695\uC124 \uAC8C\uC2DC\uBB3C");
		radioButton_1.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		radioButton_1.setBackground(UIManager.getColor("CheckBox.background"));
		radioButton_1.setBounds(162, 470, 245, 27);
		this.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton(" \uC74C\uB780 \uAC8C\uC2DC\uBB3C");
		radioButton_2.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		radioButton_2.setBackground(UIManager.getColor("CheckBox.background"));
		radioButton_2.setBounds(162, 527, 192, 27);
		this.add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton(" \uAD11\uACE0 \uAC8C\uC2DC\uBB3C");
		radioButton_3.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		radioButton_3.setBackground(UIManager.getColor("CheckBox.background"));
		radioButton_3.setBounds(162, 585, 202, 27);
		this.add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton(" \uAE30\uD0C0 \uC0AC\uC720");
		radioButton_4.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		radioButton_4.setBackground(UIManager.getColor("CheckBox.background"));
		radioButton_4.setBounds(162, 645, 164, 27);
		this.add(radioButton_4);

		JRadioButton radioButton_5 = new JRadioButton(" \uCD94\uCC9C \uC870\uC791");
		radioButton_5.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 21));
		radioButton_5.setBackground(UIManager.getColor("CheckBox.background"));
		radioButton_5.setBounds(162, 297, 139, 27);
		this.add(radioButton_5);



		mf.repaint();


	}




}