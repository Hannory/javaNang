package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.dao.AddIngred;
import run.Run;

public class CheckIngred extends JPanel{
	//재료 확인 페이지
	MainFrame mf ;
	JPanel nowp ;


	public CheckIngred(MainFrame mf) {

		//기본 패널 셋팅
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);

		//상단 바 패널 셋팅(고정)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);

		//상단 바 패널 꾸미기 //임시 색상 지정 //뒤로가기 버튼 셋팅
		topP.setBackground(Color.BLUE);
		JButton btnBack = new JButton("<");
		btnBack.setBounds(10,10,50,50);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("뒤로가기 클릭");
				new ChangePanel().changePanel(mf, nowp, new InputIngred(mf));
			}
		}
				);

		//하단 패널 셋팅
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(5,75,432,680);




//		//재료확인용 변수 (이미지 경로 설정용)
//		
//		int x = 0;
//		if(Run.mStatic.getIngreds().contains(2)) 
//		{
//			x = 2;
//		}
		/////////////////버튼 생성 및 바운드 설정, 버튼 이미지 준비 및 이미지 넣기, 마우스클릭드 이벤트 처리//////////////////////////
//		System.out.println("x : " + x);
		Image imgBtn1 = new ImageIcon("images/sim/btnImg/meatBtnImg/meat09.PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn1 = new JButton(new ImageIcon(imgBtn1));
		btn1.setBounds(0,0,145,200);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
				
				
				
				//////삭제할것
				
				System.out.println();
				
				
				///////////
				
				
				
				
				
				
			}
		}
				);
		
		Image imgBtn2 = new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn2 = new JButton(new ImageIcon(imgBtn2));
		btn2.setBounds(0,200,145,200);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn3 = new ImageIcon("images/sim/meatBtnImg/meat03.PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn3 = new JButton(new ImageIcon(imgBtn3));
		btn3.setBounds(0,400,145,200);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn4 = new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn4 = new JButton(new ImageIcon(imgBtn4));
		btn4.setBounds(145,0,145,200);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn5= new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn5= new JButton(new ImageIcon(imgBtn5));
		btn5.setBounds(145,200,145,200);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn6 = new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn6 = new JButton(new ImageIcon(imgBtn6));
		btn6.setBounds(145,400,145,200);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn7 = new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn7 = new JButton(new ImageIcon(imgBtn7));
		btn7.setBounds(290,0,145,200);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn8 = new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn8 = new JButton(new ImageIcon(imgBtn8));
		btn8.setBounds(290,200,145,200);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);
		
		Image imgBtn9 = new ImageIcon("이미지 경로 넣기").getImage().getScaledInstance(145, 200, 0);
		JButton btn9 = new JButton(new ImageIcon(imgBtn9));
		btn9.setBounds(290,400,145,200);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("재료확인에 있는 버튼");
			}
		}
				);


		//하단 목록 페이지 추가

		JButton btnList1 = new JButton("1");
		btnList1.setBounds(70,600,50,50);

		JButton btnList2 = new JButton("2");
		btnList2.setBounds(120,600,50,50);

		JButton btnList3 = new JButton("3");
		btnList3.setBounds(170,600,50,50);

		JButton btnList4 = new JButton("4");
		btnList4.setBounds(220,600,50,50);

		JButton btnList5 = new JButton("5");
		btnList5.setBounds(270,600,50,50);

		JButton btnList6 = new JButton("6");
		btnList6.setBounds(320,600,50,50);












		//상단패널에 버튼 추가
		topP.add(btnBack);

		//하단패널에 버튼 추가
		botP.add(btn1);
		botP.add(btn2);
		botP.add(btn3);
		botP.add(btn4);
		botP.add(btn5);
		botP.add(btn6);
		botP.add(btn7);
		botP.add(btn8);
		botP.add(btn9);

		botP.add(btnList1);
		botP.add(btnList2);
		botP.add(btnList3);
		botP.add(btnList4);
		botP.add(btnList5);
		botP.add(btnList6);

		//메인프레임 > 전체패널 > 상단&하단 패널
		nowp.add(topP);
		nowp.add(botP);
		mf.add(nowp);
		mf.repaint();


















	}//constructor






}//class
