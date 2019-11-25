package view.manager;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import model.vo.User;
import view.ChangePanel;
import view.LoginPage;
import view.MainFrame;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class SecondPage__2 extends JPanel {

	MainFrame mf;
	SecondPage__2 mp;
	private JTextField textField;
	


	public SecondPage__2(MainFrame mf) {

		//ÇÊµå°ª ÃÊ±âÈ­ 
		this.mf=mf;
		this.mp=this;


		//ÀüÃ¼ ÆÐ³Î ±âº» ¼³Á¤ 
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		setSize(445,770);  
		mf.getContentPane().add(mp);

		//»ó´ÜÆÐ³Î ¼³Á¤
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setBounds(0, 0, 445, 70);
		this.add(panel_1);
		panel_1.setLayout(null);

		//ÇÏ´Ü ÆÐ³Î ¼³Á¤
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0,70,445,700);
		mp.add(panel_2);
		panel_2.setLayout(null);


		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(102, 204, 204));
		textArea.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		textArea.setText("\uD68C\uC6D0 \uC81C\uC7AC");
		textArea.setBounds(145, 13, 153, 47);
		panel_1.add(textArea);
		textArea.setLayout(null);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(130, 33, 208, 41);
		panel_2.add(textArea_1);
		textArea_1.setBackground(new Color(255, 255, 255));
		textArea_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		textArea_1.setText("\uD68C\uC6D0\uC81C\uC7AC\uB300\uC0C1");


		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(14, 186, 113, 32);
		panel_2.add(textArea_2);
		textArea_2.setBackground(new Color(255, 255, 255));
		textArea_2.setText("\uC81C\uC7AC \uC0AC\uC720");
		textArea_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));


		JTextArea txtrId = new JTextArea();
		txtrId.setBounds(39, 108, 42, 32);
		panel_2.add(txtrId);
		txtrId.setBackground(new Color(255, 255, 255));
		txtrId.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
		txtrId.setText("ID");


		JButton button_1 = new JButton("\u2190");
		button_1.setBackground(new Color(72, 209, 204));
		button_1.setBounds(14, 14, 53, 48);
		panel_1.add(button_1);

		JButton btnNewButton = new JButton("\uC81C\uC7AC \uB4F1\uB85D");
		btnNewButton.setBounds(151, 642, 148, 27);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));

		JTextField textField = new JTextField();
		textField.setBounds(126, 112, 245, 31);
		panel_2.add(textField);
		textField.setColumns(10);


		JCheckBox checkBox = new JCheckBox("\uC6F9\uD558\uB4DC \uC544\uC774\uB514 \uD64D\uBCF4 ");
		checkBox.setBackground(Color.WHITE);
		checkBox.setForeground(Color.BLACK);
		checkBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		checkBox.setBounds(130, 234, 230, 27);
		panel_2.add(checkBox);

		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC131\uC778\uC790\uB8CC \uD64D\uBCF4");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setForeground(Color.BLACK);
		chckbxNewCheckBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		chckbxNewCheckBox.setBounds(130, 289, 169, 27);
		panel_2.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uBE44\uBC29 \uBC0F \uC695\uC124 \uAC8C\uC2DC\uBB3C");
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setForeground(Color.BLACK);
		chckbxNewCheckBox_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		chckbxNewCheckBox_1.setBounds(130, 347, 251, 27);
		panel_2.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("\uCD94\uCC9C \uC870\uC791");
		chckbxNewCheckBox_3.setBackground(Color.WHITE);
		chckbxNewCheckBox_3.setForeground(Color.BLACK);
		chckbxNewCheckBox_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		chckbxNewCheckBox_3.setBounds(130, 403, 142, 27);
		panel_2.add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("\uC74C\uB780 \uAC8C\uC2DC\uBB3C");
		chckbxNewCheckBox_4.setBackground(Color.WHITE);
		chckbxNewCheckBox_4.setForeground(Color.BLACK);
		chckbxNewCheckBox_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		chckbxNewCheckBox_4.setBounds(130, 460, 230, 27);
		panel_2.add(chckbxNewCheckBox_4);

		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("\uAD11\uACE0 \uAC8C\uC2DC\uBB3C");
		chckbxNewCheckBox_5.setBackground(Color.WHITE);
		chckbxNewCheckBox_5.setForeground(Color.BLACK);
		chckbxNewCheckBox_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		chckbxNewCheckBox_5.setBounds(130, 516, 187, 27);
		panel_2.add(chckbxNewCheckBox_5);

		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("\uAE30\uD0C0 \uC0AC\uC720");
		chckbxNewCheckBox_6.setBackground(Color.WHITE);
		chckbxNewCheckBox_6.setForeground(Color.BLACK);
		chckbxNewCheckBox_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 21));
		chckbxNewCheckBox_6.setBounds(130, 575, 131, 27);
		panel_2.add(chckbxNewCheckBox_6);




		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased (MouseEvent e) {

				HashMap asds = new HashMap();

				ObjectInputStream objIn = null;

				try {
					objIn = new ObjectInputStream(new FileInputStream("userList.dat"));

					try {
						asds = (HashMap) objIn.readObject();
						System.out.println("asds : " + asds);
						User u1 = (User) asds.get(textField.getText());
						System.out.println("u1 : " + u1);
						System.out.println("textField : " + textField.getText());
						System.out.println("asds.containsKey(textField)" + asds.containsKey(textField));

						if(/*u1.getUserId().equals(textField)*/asds.containsKey(textField.getText())) {
							u1.setUserId(null);
							u1.setUserPw(null);
							u1.setNickname(null);
							u1.setEmail(null);

							asds.put(textField, u1);
							JOptionPane.showMessageDialog(null, "È¸¿ø Á¦Àç°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
						}else {
							JOptionPane.showMessageDialog(null, "Á¸ÀçÇÏ´Â È¸¿øÀÇ ¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
						}


					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} 
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						objIn.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				try {
					ObjectOutputStream oosOut = new ObjectOutputStream(new FileOutputStream("userList.dat"));
					oosOut.writeObject(asds);
					oosOut.flush();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});



		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf,mp, new MainPage(mf));
			}
		});


	}
}