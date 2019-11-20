//초기메뉴 화면을 만들어 놨어
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
		btn1.setBounds(140,130,180,50);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addMouseListener(new MyMouseAdapter1());
		JButton btn2 = new JButton("재료 입력");
		btn2.setBounds(140,230,180,50);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addMouseListener(new MyMouseAdapter2());
		JButton btn3 = new JButton("레시피 공유");
		btn3.setBounds(140,330,180,50);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addMouseListener(new MyMouseAdapter3());
		JButton btn4 = new JButton("My 냉장고");
		btn4.setBounds(140,430,180,50);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addMouseListener(new MyMouseAdapter4());

		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);

		mf.add(this);

		JPanel panel2 = new JPanel();
		panel2.setSize(500,100);
		panel2.setLocation(0,665);
		panel2.setLayout(null);

		panel2.setBackground(Color.LIGHT_GRAY);
		JLabel lb2 = new JLabel("우유");
		//여기서는 유통기한이 제일 임박한 재료의 이름을 파일에서 불러와야 한다.
		
		lb2.setBounds(120,20,110,25);
		lb2.setFont(new Font("Serif", Font.BOLD, 23));        

		panel2.add(lb2);
		this.add(panel2);

		JLabel lb3 = new JLabel("유통기한이 3일 남았습니다.");
		lb3.setBounds(120,50,210,25);
        //여기서는 유통기한이 제일 임박한 재료의 유통기한 남은 일수를 파일에서 불러와야 한다.
		panel2.add(lb3);
		this.add(panel2);
		
		

		Image icon = new ImageIcon("images/hwang/milk.PNG").getImage().getScaledInstance(110, 110, 0);
        //여기서는 유통기한이 제일 임박한 재료의 사진을 파일에서 불러와야 한다. 
		
		
		JLabel lb4 = new JLabel(new ImageIcon(icon));
		lb4.setBounds(0,0,100,100);
		panel2.add(lb4); 

		this.add(panel2); 


		mf.add(this);

		//여기서 파일에 저장된 재료 중 유통기한이 제일 임박한 상품의 이미지를 불러와서
		//위 라벨에 재료명적고,아래 라벨에 유통기한이 몇일 남았는지 넣어줘야해
		
		


		JLabel lb = new JLabel("메인 메뉴");
		lb.setBounds(64, 25, 94, 26); 
		lb.setLayout(null);

		lb.setForeground(Color.white);
		lb.setFont(new Font("Serif", Font.BOLD, 20));     
		this.add(lb);

		JPanel panel3 = new JPanel();
		panel3.setSize(432,73);
		panel3.setLayout(null);
        panel3.setBackground(new Color(100, 149, 237));

		panel3.add(lb);
		this.add(panel3);
	
		JButton btnNewButton_1 = new JButton("←");
		btnNewButton_1.setBounds(14, 25, 50, 27);
		btnNewButton_1.addMouseListener(new MyMouseAdapter5());
		panel3.add(btnNewButton_1);

	}

	class MyMouseAdapter1 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new Recommend(mf));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new InputIngred(mf));
		}
	}
	class MyMouseAdapter3 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new UpRecipe(mf));
		}
	}
	class MyMouseAdapter4 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new MyFridge(mf));
		}
	}
	class MyMouseAdapter5 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
            ChangePanel.changePanel(mf, mainMenu, new AllRecipe(mf, mainMenu));
		}
	}
}
