package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;


public class Agree extends JPanel{
	MainFrame mf;
	JPanel agree;
	private JCheckBox button1;
	private JCheckBox button2;
	private JButton btn1;
	private JButton btn2;

	
	
	
	public Agree(MainFrame mf) {
		
		this.mf = mf;
		this.agree = this;
		
		this.setSize(450, 800);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 0);
		panel.setSize(450, 80);
		panel.setBackground(new Color(39, 50, 56));
		
		JLabel label = new JLabel("이용약관 동의");
		label.setLocation(90, 27);
		label.setSize(100, 30);
		label.setForeground(Color.white);
		
		JButton button = new JButton("<");
		button.setLocation(15, 17);
		button.setSize(50, 50);
		
		JLabel terms = new JLabel("회원약관");
		terms.setLocation(40, 110);
		terms.setSize(180, 20);
		
		
		final JPanel terms2 = new JPanel();
		JTextPane tp = new JTextPane();
		TextFromFile(tp);
		terms2.setLayout(null);
		tp.setLocation(40, 140);
		tp.setPreferredSize(new Dimension(360, 170));
		final JScrollPane scrollPane = new JScrollPane(tp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 140, 360, 170);
		this.add(scrollPane);
		scrollPane.setVisible(true);
		
		
		
		
		button1 = new JCheckBox("(필수) 이용약관에 동의합니다.");
		button1.setLocation(45, 320);
		button1.setSize(250, 40);
		
		
		JLabel pterms = new JLabel("개인정보 수집 및 이용 동의");
		pterms.setLocation(38, 370);
		pterms.setSize(180, 20);

		
	
		
		final JPanel pterms2 = new JPanel();
		JTextPane tp2 = new JTextPane();
		TextFromFile2(tp2);
		pterms2.setLayout(null);
		tp2.setLocation(40, 400);
		tp2.setPreferredSize(new Dimension(360, 170));
		final JScrollPane scrollPane2 = new JScrollPane(tp2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(40, 400, 360, 170);
		this.add(scrollPane2);
		scrollPane2.setVisible(true);
		
	
		
		
		button2 = new JCheckBox("(필수) 개인정보 수집 · 이용약관에 동의합니다.");
		button2.setLocation(45, 580);
		button2.setSize(300, 50);
		
		
		btn1 = new JButton("동의함");
		btn1.setLocation(95, 650);
		btn1.setSize(110, 50);
		
		btn2 = new JButton("동의안함");
		btn2.setLocation(225, 650);
		btn2.setSize(110, 50);
		
		
		this.add(panel);
		panel.add(label);
		panel.add(button);
		
		this.add(terms);
		this.add(terms2);
		this.add(button1);
		
		this.add(pterms);
		this.add(pterms2);
		this.add(button2);
		
		this.add(btn1);
		this.add(btn2);
		
		
		button.addMouseListener(new MyMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, agree, new LoginPage(mf));
			}
		});
		
		
		
		button1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		button2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		
		
		
		btn1.addMouseListener(new MyMouseAdapter());
		btn2.addMouseListener(new MyMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, agree, new LoginPage(mf));
			}
		});
		
		
		
		
		mf.add(this);
	}
	


	private void TextFromFile(JTextPane tp) {
		FileReader fr = null;
		try {
			String terms3 = "terms.txt";
			File file = new File(terms3);
			fr = new FileReader(terms3);
			while(fr.read() != -1) {
				tp.read(fr, null);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
		
	}
	
	private void TextFromFile2(JTextPane tp2) {
		FileReader fr = null;
		try {
			String pterms3 = "pterms.txt";
			File file = new File(pterms3);
			fr = new FileReader(pterms3);
			while(fr.read() != -1) {
				tp2.read(fr, null);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr != null)
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(button1.isSelected() && button2.isSelected()) {
				if(e.getSource() == btn1) {
					ChangePanel.changePanel(mf, agree, new SignUp(mf));

				}
			}else {
				if(e.getSource() == btn1) {
					JOptionPane.showMessageDialog(null, "모두 동의하셔야 가입이 가능합니다.");
				}
			}
		}



	}

}
