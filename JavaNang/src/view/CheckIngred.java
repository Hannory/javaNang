package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import run.Run;

public class CheckIngred extends JPanel{
	//��� Ȯ�� ������
	MainFrame mf ;
	JPanel nowp ;


	public CheckIngred(MainFrame mf) {

		//�⺻ �г� ����
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);

		//��� �� �г� ����(����)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);

		//��� �� �г� �ٹ̱� //�ӽ� ���� ���� //�ڷΰ��� ��ư ����
		topP.setBackground(Color.BLUE);
		JButton btnBack = new JButton("<");
		btnBack.setBounds(10,10,50,50);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("�ڷΰ��� Ŭ��");
				new ChangePanel().changePanel(mf, nowp, new InputIngred(mf));
			}
		}
				);

		//�ϴ� �г� ����
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(5,75,432,680);




		//���Ȯ�ο� ���� (�̹��� ��� ������)
		
		int x = 0;
		if(Run.mStatic.getIngreds().contains(2)) 
		{
			x = 2;
		}
		/////////////////��ư ���� �� �ٿ�� ����, ��ư �̹��� �غ� �� �̹��� �ֱ�, ���콺Ŭ���� �̺�Ʈ ó��//////////////////////////
		System.out.println("x : " + x);
		Image imgBtn1 = new ImageIcon("images/sim/meatBtnImg/meat0" + x + ".PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn1 = new JButton(new ImageIcon(imgBtn1));
		btn1.setBounds(0,0,145,230);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");



			}
		}
				);


		//�ϴ� ��� ������ �߰�

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












		//����гο� ��ư �߰�
		topP.add(btnBack);

		//�ϴ��гο� ��ư �߰�
		botP.add(btn1);

		botP.add(btnList1);
		botP.add(btnList2);
		botP.add(btnList3);
		botP.add(btnList4);
		botP.add(btnList5);
		botP.add(btnList6);

		//���������� > ��ü�г� > ���&�ϴ� �г�
		nowp.add(topP);
		nowp.add(botP);
		mf.add(nowp);
		mf.repaint();


















	}//constructor






}//class
