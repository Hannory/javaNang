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

import view.MainFrame;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JTextArea;

public class SecondPage_1 extends JPanel {

	MainFrame mf;
	JPanel mp;
	JTextArea recipeName;
	JTextArea recipeCont;
	JLabel recipefile;
	String str;
	String str2;

	public SecondPage_1(MainFrame mf) {

		//ÇÊµå°ª ÃÊ±âÈ­ 
		this.mf=mf;
		this.mp=this;

		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		setSize(445,770);
		mf.repaint();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 445, 769);
		add(panel);
		panel.setLayout(null);

		//»ó´Ü ÆÐ³Î ¼³Á¤
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 445, 70);
		panel.add(panel_1);
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setForeground(new Color(70, 130, 180));
		panel_1.setLayout(null);

		//ÇÏ´Ü ÆÐ³Î ¼³Á¤ 
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 70, 445, 699);
		panel.add(panel_3);
		panel_3.setLayout(null);

		

		JTextArea recipeName = new JTextArea((String) null);
		recipeName.setBounds(102, 360, 306, 35);
		panel_3.add(recipeName);
		recipeName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 23));

		
		JTextArea recipeCont = new JTextArea((String) null);
		recipeCont.setBounds(87, 426, 320, 290);
		panel_3.add(recipeCont);
		recipeCont.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));

		
		JLabel recipefile = new JLabel((Icon) null);
		recipefile.setBounds(107, 108, 300, 240);
		panel_3.add(recipefile);
		
		JButton btnNewButton_1 = new JButton("\uC2B9\uC778\uAC70\uBD80");
		btnNewButton_1.setBounds(242, 728, 105, 27);
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JButton btnNewButton = new JButton("\uC2B9\uC778");
		btnNewButton.setBounds(102, 728, 105, 27);
		panel_3.add(btnNewButton);
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JButton button = new JButton(">");
		button.setBounds(363, 728, 44, 27);
		panel_3.add(button);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(15, 360, 69, 35);
		panel_3.add(textPane_1);
		textPane_1.setText("\uC694\uB9AC\uBA85");
		textPane_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));

		JTextPane textPane = new JTextPane();
		textPane.setBounds(15, 103, 48, 35);
		panel_3.add(textPane);
		textPane.setText("\uC0AC\uC9C4");
		textPane.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));

		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.setBounds(39, 730, 44, 27);
		panel_3.add(btnNewButton_2);


		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(15, 419, 69, 35);
		panel_3.add(textPane_2);
		textPane_2.setText("\uB808\uC2DC\uD53C");
		textPane_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));
		
				
						JTextField textField = new JTextField();
						textField.setForeground(new Color(255, 255, 255));
						textField.setBackground(new Color(102, 204, 204));
						textField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
						textField.setText("\uB808\uC2DC\uD53C \uC2B9\uC778");
						textField.setBounds(155, 12, 162, 40);
						panel_1.add(textField);
						textField.setColumns(10);
						textField.setLayout(null);
						
								JButton button_1 = new JButton("\u2190");
								button_1.setForeground(SystemColor.window);
								button_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
								button_1.setBackground(new Color(102, 204, 204));
								button_1.setBounds(14, 7, 63, 58);
								panel_1.add(button_1);
								
								
								
										button_1.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseReleased(MouseEvent e) {
												ChangePanel.changePanel(mf,mp, new MainPage(mf));
											}
										});


		//½ÂÀÎ ´©¸¦¶§  ÆË¾÷Ã¢ ¶ç¿ì±â
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased (MouseEvent e) {

				JOptionPane.showMessageDialog(null, "½ÂÀÎÀÌ ¿Ï·á µÇ¾ú½À´Ï´Ù.");
			}
		});


		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased (MouseEvent e) {
				JOptionPane.showMessageDialog(null, "»ç¿ëÀÚ °Ô½Ã±Û ½ÂÀÎ °ÅºÎ°¡ ¿Ï·á µÇ¾ú½À´Ï´Ù.");
			}
		});


		mf.repaint();

	}
}

