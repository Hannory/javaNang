//���θ޴�  ȸ������ ��ư -> ȸ�������� �Ѿ��
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ModiMember.MyMouseAdapter;

public class MyFridge extends JPanel{

	 MainFrame mf;
     JPanel myFridge;

	public MyFridge(MainFrame mf) {
		this.mf = mf;
		myFridge = this;

		this.setBounds(0,0,445,770);
		this.setLayout(null);
		//������������ õõ���ٲ���

		JButton btn1 = new JButton("��� �Է�");
		btn1.setBounds(140, 170, 180, 50);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addMouseListener(new MyMouseAdapter1());
		JButton btn2 = new JButton("��� Ȯ��");
		btn2.setBounds(140,300, 180, 50);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addMouseListener(new MyMouseAdapter2());
		JButton btn3 = new JButton("�����丮");
		btn3.setBounds(140,430, 180, 50);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addMouseListener(new MyMouseAdapter3());
		JButton btn4 = new JButton("ȸ�� ����");
		btn4.setBounds(140,560, 180, 50);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addMouseListener(new MyMouseAdapter4());



		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		//�̰͵鵵 �гο� �ٿ�����?
		mf.add(this);


		JLabel lb = new JLabel("My �����");
		lb.setBounds(50,-20,100,100); 
		lb.setLayout(null);

		lb.setForeground(Color.white);
		lb.setFont(new Font("Serif", Font.BOLD, 20));     
		this.add(lb);

		JPanel panel2 = new JPanel();
		panel2.setSize(432,73);
		panel2.setLayout(null);
		panel2.setBackground(Color.black);
 

		JButton jbt2 = new JButton("��");
		jbt2.setBounds(14,14,24,27);
		jbt2.setForeground(Color.white);
		jbt2.setBackground(Color.black);
		jbt2.addMouseListener(new MyMouseAdapter5());
		panel2.add(lb);
		panel2.add(jbt2);
		this.add(panel2);

	}

	class MyMouseAdapter1 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new InputIngred(mf));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new InputIngred(mf));
		}
	}
	class MyMouseAdapter3 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new History(mf));
		}
	}
	class MyMouseAdapter4 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new ModiMember(mf));
		}
	}
	class MyMouseAdapter5 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new MainMenu(mf)); 
		}          
	}

}
