package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class Agree extends JPanel{
	MainFrame mf;                 
	JPanel agree;                     //약관동의 패널
	private JCheckBox button1;        //회원약관 동의 체크박스
	private JCheckBox button2;        //개인정보 수집 동의 체크박스
	private JButton btn1;             //동의함 버튼
	private JButton btn2;             //동의안함 버튼

	
	
	
	public Agree(MainFrame mf) {
		
		this.mf = mf;
		this.agree = this;
		
		this.setSize(445, 770);
		this.setLayout(null);
		
		//바 디자인 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setBackground(new Color(102, 204, 204));
		
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
	    Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		
		//바에 넣을 패널 제목
		JLabel label = new JLabel("이용약관 동의");
		label.setLocation(80, 10);
		label.setSize(200, 50);
		label.setForeground(Color.white);
		label.setFont(font);
		
		
		//바에 넣을 뒤로가기 버튼
		Image backImg = new ImageIcon("images/back sky.PNG").getImage().getScaledInstance(50, 50, 0);
		JButton button = new JButton(new ImageIcon(backImg));
		button.setLocation(10, 10);
		button.setSize(50, 50);
		
		//==========지금부터 내용==============
		//회원약관 제목
		JLabel terms = new JLabel("회원약관");
		terms.setLocation(40, 110);
		terms.setSize(180, 20);
		
		//약관 내용물
		final JPanel terms2 = new JPanel();
		JTextPane tp = new JTextPane();
		TextFromFile(tp);
		terms2.setLayout(null);
		tp.setLocation(40, 140);
		tp.setPreferredSize(new Dimension(360, 170));
		
		//스크롤바
		final JScrollPane scrollPane = new JScrollPane(tp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 140, 360, 170);
		this.add(scrollPane);
		scrollPane.setVisible(true);
		
		
		//회원약관 동의 체크박스
		button1 = new JCheckBox("(필수) 이용약관에 동의합니다.");
		button1.setLocation(45, 320);
		button1.setSize(250, 40);
		
		
		
		//개인정보 수집 약관 제목
		JLabel pterms = new JLabel("개인정보 수집 및 이용 동의");
		pterms.setLocation(38, 370);
		pterms.setSize(180, 20);

		
		//개인정보 수집 약관 내용
		final JPanel pterms2 = new JPanel();
		JTextPane tp2 = new JTextPane();
		TextFromFile2(tp2);
		pterms2.setLayout(null);
		tp2.setLocation(40, 400);
		tp2.setPreferredSize(new Dimension(360, 170));
		
		//스크롤바
		final JScrollPane scrollPane2 = new JScrollPane(tp2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(40, 400, 360, 170);
		this.add(scrollPane2);
		scrollPane2.setVisible(true);
		
	
		
		//개인정보 수집 약관 체크박스
		button2 = new JCheckBox("(필수) 개인정보 수집 · 이용약관에 동의합니다.");
		button2.setLocation(45, 580);
		button2.setSize(300, 50);
		
		//동의함 버튼
		btn1 = new JButton("동의함");
		btn1.setLocation(95, 650);
		btn1.setSize(110, 50);
		
		//동의안함 버튼 
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
		
		
		//뒤로가기 버튼 클릭시 로그인 패널로 이동
		button.addMouseListener(new MyMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, agree, new LoginPage(mf));
			}
		});
		
		
		//회원약관 체크박스 클릭
		button1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		//개인정보 수집 약관 체크박스 클릭
		button2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		
		
		//동의함 버튼(밑에 있는 클래스에 있음)
		btn1.addMouseListener(new MyMouseAdapter());
		
		//동의안함 버튼 클릭시 로그인 패널로 이동
		btn2.addMouseListener(new MyMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, agree, new LoginPage(mf));
			}
		});
		
		
		
		
		mf.add(this);
	}
	

	//회원약관 내용에 들어갈 텍스트 파일 불러오기
	private void TextFromFile(JTextPane tp) {
		FileReader fr = null;
		try {
			String terms3 = "documents/terms.txt";
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
	
	//개인정보 수집 약관 내용에 들어갈 텍스트파일 불러오기
	private void TextFromFile2(JTextPane tp2) {
		FileReader fr = null;
		try {
			String pterms3 = "documents/pterms.txt";
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
	
	//회원가입 패널로 넘어가기 위한...
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//약관 체크박스 두 개 다 누른 후 동의함 버튼을 눌러야 회원가입 패널로 이동
			if(button1.isSelected() && button2.isSelected()) {
				if(e.getSource() == btn1) {
					ChangePanel.changePanel(mf, agree, new SignUp(mf));

				}
			}else {//둘 중 하나라도 안 눌러지면 팝업창이 뜸
				if(e.getSource() == btn1) {
					JOptionPane.showMessageDialog(null, "모두 동의하셔야 가입이 가능합니다.");
				}
			}
		}



	}

}
