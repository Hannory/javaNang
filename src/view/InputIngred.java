package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputIngred extends JPanel{

	MainFrame mf ;
	JPanel nowp ;

	public InputIngred(MainFrame mf) {

		//�г� �⺻ ����
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(432,753);

		//����̹��� �غ�
		Image imgBackground = new ImageIcon("images/sim/imgBackground.PNG").getImage().getScaledInstance(432, 653, 0);

		this.setBackground(Color.red);

		//�󺧻���, ���� �� �谻�̹��� �ֱ�
		JLabel lbBackground = new JLabel(new ImageIcon(imgBackground));
		lbBackground.setBounds(0,100,432,653);

		//�гο� ���� ���̱�
		this.add(lbBackground);








		/////////////////��ư ���� �� �ٿ�� ����, ���콺Ŭ���� �̺�Ʈ ó��//////////////////////////
		JButton btn1 = new JButton("111");
		btn1.setBounds(100,100,100,100);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);
		
		
		btn1.setOpaque(false);
		
		
		

		JButton btn2 = new JButton();
		btn2.setBounds(0,0,100,100);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);


		JButton btn3 = new JButton();
		btn3.setBounds(0,0,100,100);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);

		JButton btn4 = new JButton();
		btn4.setBounds(0,0,100,100);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);

		JButton btn5 = new JButton();
		btn5.setBounds(0,0,100,100);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);

		JButton btn6 = new JButton();
		btn6.setBounds(0,0,100,100);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);

		JButton btn7 = new JButton();
		btn7.setBounds(0,0,100,100);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);

		JButton btn8 = new JButton();
		btn8.setBounds(0,0,100,100);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);
















		//ȭ�� ����/////////////

		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);

		
		

		mf.add(this);

		mf.repaint();

















	}//constructor















}//class
