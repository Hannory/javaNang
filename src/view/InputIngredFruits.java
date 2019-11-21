package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.AddIngred;

public class InputIngredFruits extends JPanel {
	//(육류) 페이지
	
	MainFrame mf ;
	JPanel nowp ;

	public InputIngredFruits(MainFrame mf) {

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

		

		

		/////////////////버튼 생성 및 바운드 설정, 버튼 이미지 준비 및 이미지 넣기, 마우스클릭드 이벤트 처리//////////////////////////
		Image imgBtn1 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits01.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn1 = new JButton(new ImageIcon(imgBtn1));
		btn1.setBounds(0,0,145,230);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼1 클릭");
				new AddIngred().makeTreeSet(4001);
				ChangePanel.changePanel(mf, nowp, new CheckIngred(mf));

			}
		}
				);

		
		Image imgBtn2 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits02.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn2 = new JButton(new ImageIcon(imgBtn2));
		btn2.setBounds(0,230,145,230);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼2 클릭");
				new AddIngred().makeTreeSet(4002);
			}
		}
				);
		btn2.setOpaque(false);
		
		
		
		
		Image imgBtn3 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits03.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn3 = new JButton(new ImageIcon(imgBtn3));
		btn3.setBounds(0,460,145,230);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼3 클릭");
				new AddIngred().makeTreeSet(4003);
			}
		}
				);
		btn3.setOpaque(false);
		
		
		
		
		Image imgBtn4 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits04.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn4 = new JButton(new ImageIcon(imgBtn4));
		btn4.setBounds(145,0,145,230);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼4 클릭");
				new AddIngred().makeTreeSet(4004);
			}
		}
				);
		btn4.setOpaque(false);
		
		
		
		
		
		Image imgBtn5 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits05.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn5 = new JButton(new ImageIcon(imgBtn5));
		btn5.setBounds(145,230,145,230);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼5 클릭");
				new AddIngred().makeTreeSet(4005);
			}
		}
				);
		btn5.setOpaque(false);
		
		
		
		
		Image imgBtn6 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits06.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn6 = new JButton(new ImageIcon(imgBtn6));
		btn6.setBounds(145,460,145,230);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼6 클릭");
				new AddIngred().makeTreeSet(4006);
			}
		}
				);
		btn6.setOpaque(false);
		
		
		
		
		Image imgBtn7 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits07.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn7 = new JButton(new ImageIcon(imgBtn7));
		btn7.setBounds(290,0,145,230);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼7 클릭");
				new AddIngred().makeTreeSet(4007);
			}
		}
				);
		btn7.setOpaque(false);
		
		
		
		
		Image imgBtn8 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits08.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn8 = new JButton(new ImageIcon(imgBtn8));
		btn8.setBounds(290,230,145,230);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼8 클릭");
				new AddIngred().makeTreeSet(4008);
			}
		}
				);
		btn8.setOpaque(false);
		
		
		
		
		Image imgBtn9 = new ImageIcon("images/sim/btnImg/fruitsBtnImg/fruits09.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn9 = new JButton(new ImageIcon(imgBtn9));
		btn9.setBounds(290,460,145,230);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼9 클릭");
				new AddIngred().makeTreeSet(4009);
			}
		}
				);
		btn9.setOpaque(false);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		//상단 패널 화면 구성
		topP.add(btnBack);
		


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
