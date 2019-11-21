package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.AddIngred;

public class InputIngredBread extends JPanel {
	//(육류) 페이지

	MainFrame mf ;
	JPanel nowp ;

	public InputIngredBread(MainFrame mf) {

		//기본 패널 셋팅
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);

		//상단 바 패널 셋팅(고정)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);
		topP.setBackground(new Color(102, 204, 204));


		//상단 타이틀 셋팅
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
		JLabel barTitle = new JLabel(" <빵>");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);

		//상단 바 패널 꾸미기 //뒤로가기 버튼 셋팅
		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton btnBack = new JButton(new ImageIcon(backImg));
		btnBack.setBounds(10,10,50,50);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("뒤로가기 클릭");
				new ChangePanel().changePanel(mf, nowp, new InputIngred(mf));
			}
		}
				);

		//상단 바 우측 마이페이지 버튼 셋팅
		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setBounds(380,10,50,50);
		logIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("뒤로가기 클릭");
				new ChangePanel().changePanel(mf, nowp, new MyFridge(mf));
			}
		});


		//하단 패널 셋팅
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(5,75,432,680);





		/////////////////버튼 생성 및 바운드 설정, 버튼 이미지 준비 및 이미지 넣기, 마우스클릭드 이벤트 처리//////////////////////////
		Image imgBtn1 = new ImageIcon("images/sim/btnImg/5001.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn1 = new JButton(new ImageIcon(imgBtn1));
		btn1.setBounds(0,0,145,230);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5001);
			}
		}
				);


		Image imgBtn2 = new ImageIcon("images/sim/btnImg/5002.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn2 = new JButton(new ImageIcon(imgBtn2));
		btn2.setBounds(0,230,145,230);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5002);
			}
		}
				);
		btn2.setOpaque(false);




		Image imgBtn3 = new ImageIcon("images/sim/btnImg/5003.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn3 = new JButton(new ImageIcon(imgBtn3));
		btn3.setBounds(0,460,145,230);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼3 클릭");
				new AddIngred().makeTreeSet(5003);
			}
		}
				);
		btn3.setOpaque(false);




		Image imgBtn4 = new ImageIcon("images/sim/btnImg/5004.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn4 = new JButton(new ImageIcon(imgBtn4));
		btn4.setBounds(145,0,145,230);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5004);
			}
		}
				);
		btn4.setOpaque(false);





		Image imgBtn5 = new ImageIcon("images/sim/btnImg/5005.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn5 = new JButton(new ImageIcon(imgBtn5));
		btn5.setBounds(145,230,145,230);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5005);
			}
		}
				);
		btn5.setOpaque(false);




		Image imgBtn6 = new ImageIcon("images/sim/btnImg/5006.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn6 = new JButton(new ImageIcon(imgBtn6));
		btn6.setBounds(145,460,145,230);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5006);
			}
		}
				);
		btn6.setOpaque(false);




		Image imgBtn7 = new ImageIcon("images/sim/btnImg/5007.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn7 = new JButton(new ImageIcon(imgBtn7));
		btn7.setBounds(290,0,145,230);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5007);
			}
		}
				);
		btn7.setOpaque(false);




		Image imgBtn8 = new ImageIcon("images/sim/btnImg/5008.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn8 = new JButton(new ImageIcon(imgBtn8));
		btn8.setBounds(290,230,145,230);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5008);
			}
		}
				);
		btn8.setOpaque(false);




		Image imgBtn9 = new ImageIcon("images/sim/btnImg/5009.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn9 = new JButton(new ImageIcon(imgBtn9));
		btn9.setBounds(290,460,145,230);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddIngred().makeTreeSet(5009);
			}
		}
				);
		btn9.setOpaque(false);




















		//상단 패널 화면 구성
		topP.add(btnBack);
		topP.add(logIn);
		topP.add(barTitle);




		//하단 패널 화면 구성/////////////

		botP.add(btn1);
		botP.add(btn2);
		botP.add(btn3);
		botP.add(btn4);
		botP.add(btn5);
		botP.add(btn6);
		botP.add(btn7);
		botP.add(btn8);
		botP.add(btn9);


		//화면 완성 //component < eachP < nowp < mf
		this.add(botP);
		this.add(topP);

		mf.add(this);
		mf.repaint();









	}//constructor



}//class
