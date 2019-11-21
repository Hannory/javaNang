package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.vo.Ingred;

public class InputIngred extends JPanel{
	//재료입력 누르면 나오는 페이지
	//카테고리 선택 하는 화면

	MainFrame mf ;
	JPanel nowp ;

	public InputIngred(MainFrame mf) {

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
		JLabel barTitle = new JLabel(" 재료 입력 ");
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
				new ChangePanel().changePanel(mf, nowp, new MyFridge(mf));
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
		botP.setBounds(0,100,445,700);







		/////////////////버튼 생성 및 바운드 설정, 버튼이미지 준비 및 이미지 넣기, 마우스클릭드 이벤트 처리//////////////////////////

		Image imgbtn1 = new ImageIcon("images/sim/ingreCategory/ingredCategory01.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn1 = new JButton(new ImageIcon(imgbtn1));
		btn1.setBounds(0,0,220,220);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("카테고리 버튼1 클릭");
				ChangePanel.changePanel(mf, nowp, new InputIngredMeat(mf));
			}
		}
				);
		btn1.setOpaque(false);	//버튼 투명화




		Image imgbtn2 = new ImageIcon("images/sim/ingreCategory/ingredCategory02.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn2 = new JButton(new ImageIcon(imgbtn2));
		btn2.setBounds(0,220,220,220);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼2 클릭");
				ChangePanel.changePanel(mf, nowp, new InputIngredVegetables(mf));
			}
		}
				);
		btn2.setOpaque(false);




		Image imgbtn3 = new ImageIcon("images/sim/ingreCategory/ingredCategory03.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn3 = new JButton(new ImageIcon(imgbtn3));
		btn3.setBounds(0,440,220,220);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼3 클릭");
				ChangePanel.changePanel(mf, nowp, new InputIngredBread(mf));

			}
		}
				);
		btn3.setOpaque(false);



		Image imgbtn4 = new ImageIcon("images/sim/ingreCategory/ingredCategory04.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn4 = new JButton(new ImageIcon(imgbtn4));
		btn4.setBounds(220,0,220,220);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼4 클릭");
				ChangePanel.changePanel(mf, nowp, new InputIngredFish(mf));

			}
		}
				);
		btn4.setOpaque(false);



		Image imgbtn5 = new ImageIcon("images/sim/ingreCategory/ingredCategory05.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn5 = new JButton(new ImageIcon(imgbtn5));
		btn5.setBounds(220,220,220,220);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼5 클릭");
				ChangePanel.changePanel(mf, nowp, new InputIngredFruits(mf));

			}
		}
				);
		btn5.setOpaque(false);




		Image imgbtn6 = new ImageIcon("images/sim/ingreCategory/ingredCategory06.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn6 = new JButton(new ImageIcon(imgbtn6));
		btn6.setBounds(220,440,220,220);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼6 클릭");
				ChangePanel.changePanel(mf, nowp, new InputIngredMilk(mf));

			}
		}
				);
		btn6.setOpaque(false);

















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
		//botP.add(btn7);
		//botP.add(btn8);


		//화면 완성
		this.add(botP);
		this.add(topP);

		mf.add(this);
		mf.repaint();

















	}//constructor















}//class
