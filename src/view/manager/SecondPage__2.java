package view.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.vo.User;
import view.AllRecipe;
import view.MainFrame;

public class SecondPage__2 extends JPanel {

	MainFrame mf;
	SecondPage__2 mp;
	HashMap hmap = new HashMap();
	private JTextField textField;
	private JPasswordField jpf1;
	private JTextField jtf1;
	
	

	public SecondPage__2(MainFrame mf) {
		
		//« µÂ∞™ √ ±‚»≠ 
		this.mf=mf;
		this.mp=this;
		
		String id = AllRecipe.loginId;
		//¿¸√º ∆–≥Œ ±‚∫ª º≥¡§ 
		
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		setSize(445,770);
		
		
		mf.getContentPane().add(mp);
		
		//ªÛ¥‹∆–≥Œ º≥¡§ 

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setBounds(0, 0, 445, 70);
		this.add(panel_1);
		panel_1.setLayout(null);

		//«œ¥‹ ∆–≥Œ º≥¡§
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0,70,445,700);
		mp.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(130, 33, 208, 41);
		panel_2.add(textArea_1);
		textArea_1.setBackground(new Color(255, 255, 255));
		textArea_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 32));
		textArea_1.setText("\uD68C\uC6D0\uC81C\uC7AC\uB300\uC0C1");
				
		JTextArea txtrId = new JTextArea();
		txtrId.setBounds(39, 108, 42, 32);
		panel_2.add(txtrId);
		txtrId.setBackground(new Color(255, 255, 255));
		txtrId.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 23));
		txtrId.setText("ID");
						
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(14, 186, 113, 32);
		panel_2.add(textArea_2);
		textArea_2.setBackground(new Color(255, 255, 255));
		textArea_2.setText("\uC81C\uC7AC \uC0AC\uC720");
		textArea_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 23));
								
		JButton btnNewButton = new JButton("\uC81C\uC7AC \uB4F1\uB85D");
		btnNewButton.setBounds(151, 642, 148, 27);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 23));
		//¡¶¡¶µÓ∑œ ∫Œ∫– 
		
										
		JRadioButton rdbtnNewRadioButton = new JRadioButton(" \uC6F9\uD558\uB4DC \uC544\uC774\uB514 \uD64D\uBCF4");
		rdbtnNewRadioButton.setBounds(126, 226, 245, 27);
		panel_2.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
												
		JRadioButton radioButton = new JRadioButton(" \uC131\uC778\uC790\uB8CC \uD64D\uBCF4");
		radioButton.setBounds(126, 281, 245, 27);
		panel_2.add(radioButton);
		radioButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		radioButton.setBackground(new Color(255, 255, 255));
														
		JRadioButton radioButton_1 = new JRadioButton(" \uBE44\uBC29 \uBC0F \uC695\uC124 \uAC8C\uC2DC\uBB3C");
		radioButton_1.setBounds(126, 335, 245, 27);
		panel_2.add(radioButton_1);
		radioButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		radioButton_1.setBackground(new Color(255, 255, 255));
																
		JRadioButton radioButton_2 = new JRadioButton(" \uC74C\uB780 \uAC8C\uC2DC\uBB3C");
		radioButton_2.setBounds(126, 452, 192, 27);
		panel_2.add(radioButton_2);
		radioButton_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		radioButton_2.setBackground(new Color(255, 255, 255));
																		
		JRadioButton radioButton_3 = new JRadioButton(" \uAD11\uACE0 \uAC8C\uC2DC\uBB3C");
		radioButton_3.setBounds(127, 517, 202, 27);
		panel_2.add(radioButton_3);
		radioButton_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		radioButton_3.setBackground(new Color(255, 255, 255));
																				
		JRadioButton radioButton_4 = new JRadioButton(" \uAE30\uD0C0 \uC0AC\uC720");
		radioButton_4.setBounds(126, 575, 164, 27);
		panel_2.add(radioButton_4);
		radioButton_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		radioButton_4.setBackground(new Color(255, 255, 255));
																						
		JRadioButton radioButton_5 = new JRadioButton(" \uCD94\uCC9C \uC870\uC791");
		radioButton_5.setBounds(126, 395, 139, 27);
		panel_2.add(radioButton_5);
		radioButton_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 21));
		radioButton_5.setBackground(new Color(255, 255, 255));
		
		textField = new JTextField();
		textField.setBounds(126, 112, 245, 31);
		panel_2.add(textField);
		textField.setColumns(10);
										
		JLabel textArea = new JLabel();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(102, 204, 204));
		textArea.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 27));
		textArea.setText("\uD68C\uC6D0 \uC81C\uC7AC");
		textArea.setBounds(145, 13, 153, 47);
		panel_1.add(textArea);
		textArea.setLayout(null);
		
		JButton button_1 = new JButton("\u2190");
		button_1.setBackground(new Color(72, 209, 204));
		button_1.setBounds(14, 14, 53, 48);
		panel_1.add(button_1);
		 
	
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf,mp, new MainPage(mf));
			}
		});

		//¡¶¡¶ µÓ∑œ ¥©∏¶∂ß ªË¡¶ ±‚¥…¿ª √ﬂ∞° ∏¯«“ Ω√ ∆Àæ˜√¢¿Ã∂Ûµµ ∂ÁøÏ±‚
		btnNewButton.addMouseListener(new MouseAdapter() {
			
		/*	@Override
			public void mouseReleased(MouseEvent e) {
				HashMap asds = new HashMap();
				ObjectInputStream objIn = null;
				
				try {
					objIn = new ObjectInputStream(new FileInputStream("userList.dat"));
					try {
						asds = (HashMap)objIn.readObject();
						User u1 = (User)asds.get(id);
					
					int ans = JOptionPane.showConfirmDialog(null, "¡§∏ª∑Œ ¡¶¡¶µÓ∑œ «œΩ√ÅŸΩ¿¥œ±Ó?", "¡¶¡¶µÓ∑œ");
					
					
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
			*/
			
			@Override
			public void mouseReleased (MouseEvent e) {
				JOptionPane.showMessageDialog(null, "¡¶¡¶ µÓ∑œ¿Ã øœ∑· µ«æ˙Ω¿¥œ¥Ÿ.");
			}
		});

		mf.repaint();

	}
}