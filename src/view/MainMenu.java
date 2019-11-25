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

import controller.IngredControl;
import model.vo.IngredAll;
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
		
		JPanel panel1 = new JPanel(); //하단 패널
		panel1.setSize(500,100);
		panel1.setLocation(0,665);
		panel1.setLayout(null);

		panel1.setBackground(new Color(128,128,192));
		
		Image expi = new ImageIcon("images/sim/BtnImg/9999.PNG").getImage().getScaledInstance(180, 100, 0);
		JButton btnExpiry = new JButton(new ImageIcon(expi));	
		//btnExpiry.setOpaque(false);
		btnExpiry.setSize(100,100);
		btnExpiry.addMouseListener(new MouseAdapter() {
		    public void mouseReleased(MouseEvent e) {
		    	new ChangePanel().changePanel(mf, mainMenu, new CheckIngred(mf));
		    }
		});
		
		panel1.add(btnExpiry);
		
		JLabel lb2 = new JLabel(new IngredControl().getMinIngredExpiry());
		lb2.setFont(new Font("Serif", Font.BOLD, 20));
		lb2.setBounds(120,5,300,100);
		panel1.add(lb2);
		this.add(panel1);

		IngredAll.setIngredExpiryMap();
		 new IngredControl().method();
		Image icon = new ImageIcon("images/sim/BtnImg/" + IngredControl.minIngredNo + ".PNG")
				.getImage().getScaledInstance(110, 110, 0);

		JLabel lb3 = new JLabel(new ImageIcon(icon));
		lb3.setBounds(0,0,100,100);
		btnExpiry.add(lb3);

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
	
		  Image qstImg = new ImageIcon("images/HELP.png").getImage().getScaledInstance(50,50,0);
	      JButton qst = new JButton(new ImageIcon(qstImg));
	      qst.setLocation(380,10);
	      qst.setSize(50,50);
	      qst.addMouseListener(new MyMouseAdapter6());
	      panel2.add(qst);
	 
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
	class MyMouseAdapter6 extends MouseAdapter{//모든레시피로(뒤로가기)
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new Help(mf));
		}
	}
}
