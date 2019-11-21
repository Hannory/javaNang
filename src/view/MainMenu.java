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


		JButton btn1 = new JButton("�丮 ��õ");
		btn1.setBounds(140,170,180,50);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addMouseListener(new MyMouseAdapter1());
		JButton btn2 = new JButton("��� �Է�");
		btn2.setBounds(140,300,180,50);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addMouseListener(new MyMouseAdapter2());
		JButton btn3 = new JButton("������ ����");
		btn3.setBounds(140,430,180,50);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addMouseListener(new MyMouseAdapter3());
		JButton btn4 = new JButton("My �����");
		btn4.setBounds(140,560,180,50);
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
		JLabel lb1 = new JLabel("����");
		//���⼭�� ��������� ���� �ӹ��� ����� �̸��� ���Ͽ��� �ҷ��;� �Ѵ�.

		lb1.setBounds(120,20,110,25);
		lb1.setFont(new Font("Serif", Font.BOLD, 23));        

		panel2.add(lb1);
		this.add(panel2);

		JLabel lb2 = new JLabel("��������� 3�� ���ҽ��ϴ�.");
		lb2.setBounds(120,50,210,25);
		//���⼭�� ��������� ���� �ӹ��� ����� ������� ���� �ϼ��� ���Ͽ��� �ҷ��;� �Ѵ�.
		panel2.add(lb2);
		this.add(panel2);



		Image icon = new ImageIcon("images/hwang/milk.PNG").getImage().getScaledInstance(110, 110, 0);
		//���⼭�� ��������� ���� �ӹ��� ����� ������ ���Ͽ��� �ҷ��;� �Ѵ�. 


		JLabel lb3 = new JLabel(new ImageIcon(icon));
		lb3.setBounds(0,0,100,100);
		panel2.add(lb3); 

		this.add(panel2); 


		mf.add(this);

		JLabel lb4 = new JLabel("���� �޴�");
		lb4.setBounds(95, 11 ,207 ,46); 
		lb4.setLayout(null);

		lb4.setForeground(Color.white);
		lb4.setFont(new Font("���� ���", Font.BOLD, 27));     
		this.add(lb4);

//		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50,50,0);
//	      JButton logIn = new JButton(new ImageIcon(person));
//	      logIn.setLocation(380,10);
//	      logIn.setSize(50,50);
//	      this.add(logIn);
	      
          
		JPanel panel3 = new JPanel();
		panel3.setSize(445,70);
		panel3.setLayout(null);
		panel3.setBackground(new Color(102, 204, 204));

		panel3.add(lb4);

		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50,50,0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10,10);
		back.setSize(50,50);
		back.addMouseListener(new MyMouseAdapter5());
		panel3.add(back);
		this.add(panel3);
	}

	class MyMouseAdapter1 extends MouseAdapter{//�丮��õ����
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new Recommend(mf));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter{//����Է�����
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new InputIngred(mf));
		}
	}
	class MyMouseAdapter3 extends MouseAdapter{//������ ������
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new UpRecipe(mf));
		}
	}
	class MyMouseAdapter4 extends MouseAdapter{//My������
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new MyFridge(mf));
		}
	}
	class MyMouseAdapter5 extends MouseAdapter{//��緹���Ƿ�(�ڷΰ���)
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mainMenu, new AllRecipe(mf, mainMenu));
		}
	}
}
