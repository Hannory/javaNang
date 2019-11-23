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

import view.QuitMember.MyMouseAdapter1;

public class MainMenu extends JPanel {
	MainFrame mf;
	JPanel mainMenu;

	public MainMenu(MainFrame mf) {
		this.mf = mf;
		mainMenu = this;

		this.setBounds(0, 0 , 445, 770);
		this.setLayout(null);


		JButton btn1 = new JButton("요리 추천");
		btn1.setBounds(140,170,180,50);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addMouseListener(new MyMouseAdapter1());
		JButton btn2 = new JButton("재료 입력");
		btn2.setBounds(140,300,180,50);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addMouseListener(new MyMouseAdapter2());
		JButton btn3 = new JButton("레시피 공유");
		btn3.setBounds(140,430,180,50);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addMouseListener(new MyMouseAdapter3());
		JButton btn4 = new JButton("My 냉장고");
		btn4.setBounds(140,560,180,50);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addMouseListener(new MyMouseAdapter4());		
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);

		mf.add(this);
		
//		Image backImg1 = new ImageIcon("images/a.png").getImage().getScaledInstance(180,50,0);
//		JButton back1 = new JButton(new ImageIcon(backImg1));
//		back1.setBounds(140,150,180,50);
//		back1.addMouseListener(new MyMouseAdapter1());
//
//		Image backImg2 = new ImageIcon("images/a.png").getImage().getScaledInstance(180,50,0);
//		JButton back2 = new JButton(new ImageIcon(backImg2));
//        back2.setBounds(140,280,180,50);
//		back2.addMouseListener(new MyMouseAdapter2());
//		Image backImg3 = new ImageIcon("images/a.png").getImage().getScaledInstance(180,50,0);
//		JButton back3 = new JButton(new ImageIcon(backImg3));
//        back3.setBounds(140,410,180,50);
//		back3.addMouseListener(new MyMouseAdapter3());
//		Image backImg4 = new ImageIcon("images/a.png").getImage().getScaledInstance(180,50,0);
//		JButton back4 = new JButton(new ImageIcon(backImg4));
//        back4.setBounds(140,540,180,50);
//		back4.addMouseListener(new MyMouseAdapter4());
//
//		this.add(back1);
//		this.add(back2);
//		this.add(back3);
//		this.add(back4);


		JPanel panel1 = new JPanel(); //하단 패널
		panel1.setSize(500,100);
		panel1.setLocation(0,665);
		panel1.setLayout(null);

		panel1.setBackground(Color.LIGHT_GRAY);
		JLabel lb1 = new JLabel("우유");
		//여기서는 유통기한이 제일 임박한 재료의 이름을 파일에서 불러와야 한다.

		lb1.setBounds(120,20,110,25);
		lb1.setFont(new Font("Serif", Font.BOLD, 23));        

		panel1.add(lb1);
		this.add(panel1);

		JLabel lb2 = new JLabel("유통기한이 3일 남았습니다.");
		lb2.setBounds(120,50,210,25);
		//여기서는 유통기한이 제일 임박한 재료의 유통기한 남은 일수를 파일에서 불러와야 한다.
		panel1.add(lb2);
		this.add(panel1);



		Image icon = new ImageIcon("images/hwang/milk.PNG").getImage().getScaledInstance(110, 110, 0);
		//여기서는 유통기한이 제일 임박한 재료의 사진을 파일에서 불러와야 한다. 


		JLabel lb3 = new JLabel(new ImageIcon(icon));
		lb3.setBounds(0,0,100,100);
		panel1.add(lb3); 

		this.add(panel1); 


		mf.add(this);

		JLabel lb4 = new JLabel("메인 메뉴");
		lb4.setBounds(95, 11 ,207 ,46); 
		lb4.setLayout(null);

		lb4.setForeground(Color.white);
		lb4.setFont(new Font("맑은 고딕", Font.BOLD, 27));     
		this.add(lb4);

//		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50,50,0);
//	      JButton logIn = new JButton(new ImageIcon(person));
//	      logIn.setLocation(380,10);
//	      logIn.setSize(50,50);
//	      this.add(logIn);
	      
          
		JPanel panel2 = new JPanel(); //상단 패널
		panel2.setSize(445,70);
		panel2.setLayout(null);
		panel2.setBackground(new Color(102, 204, 204));

		panel2.add(lb4);

		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50,50,0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10,10);
		back.setSize(50,50);
		back.addMouseListener(new MyMouseAdapter5());
		panel2.add(back);
		this.add(panel2);
	}

	class MyMouseAdapter1 extends MouseAdapter{//요리추천으로
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new Recommend(mf));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter{//재료입력으로
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new InputIngred(mf));
		}
	}
	class MyMouseAdapter3 extends MouseAdapter{//레시피 공유로
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new UpRecipe(mf));
		}
	}
	class MyMouseAdapter4 extends MouseAdapter{//My냉장고로
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new MyFridge(mf));
		}
	}
	class MyMouseAdapter5 extends MouseAdapter{//모든레시피로(뒤로가기)
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new AllRecipe(mf, mainMenu));
		}
	}
}
