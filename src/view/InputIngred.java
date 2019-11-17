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

import model.vo.Ingred;

public class InputIngred extends JPanel{
	//����Է� ������ ������ ������
	//ī�װ� ���� �ϴ� ȭ��

	MainFrame mf ;
	JPanel nowp ;
	
	int x;

	public InputIngred(MainFrame mf) {

		//�⺻ �г� ����
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);
		
		//��� �� �г� ����(����)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);
		
		//��� �� �г� �ٹ̱�
		//���� �г� ��������//
		
		
		//�ϴ� �г� ����
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(0,100,445,700);
		
		

		//����̹��� �غ�
		//Image imgBackground = new ImageIcon("images/sim/imgIngreCategory.PNG").getImage().getScaledInstance(445, 680, 0);
		//�󺧻���, ���� �� ����̹��� �ֱ�
		//JLabel lbBackground = new JLabel(new ImageIcon(imgBackground));
		//lbBackground.setBounds(0,0,432,680);
		//�ϴ��гο� ���� ���̱�
		//botP.add(lbBackground);








		/////////////////��ư ���� �� �ٿ�� ����, ��ư�̹��� �غ� �� �̹��� �ֱ�, ���콺Ŭ���� �̺�Ʈ ó��//////////////////////////
		
		
		Image imgbtn1 = new ImageIcon("images/sim/ingreCategory/ingredCategory01.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn1 = new JButton(new ImageIcon(imgbtn1));
		btn1.setBounds(0,0,220,220);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ī�װ� ��ư1 Ŭ��");
				ChangePanel.changePanel(mf, nowp, new InputIngredMeat(mf));
			}
		}
				);
		btn1.setOpaque(false);	//��ư ����ȭ
		
		
		

		Image imgbtn2 = new ImageIcon("images/sim/ingreCategory/ingredCategory02.PNG").getImage().getScaledInstance(220, 220, 0);
		JButton btn2 = new JButton(new ImageIcon(imgbtn2));
		btn2.setBounds(0,220,220,220);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư2 Ŭ��");
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
				System.out.println("��ư3 Ŭ��");
				ChangePanel.changePanel(mf, nowp, new InputIngredEtc(mf));

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
				System.out.println("��ư4 Ŭ��");
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
				System.out.println("��ư5 Ŭ��");
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
				System.out.println("��ư6 Ŭ��");
				ChangePanel.changePanel(mf, nowp, new InputIngredMilk(mf));

			}
		}
				);
		btn6.setOpaque(false);
		
		
		

















		//ȭ�� ����/////////////

		botP.add(btn1);
		botP.add(btn2);
		botP.add(btn3);
		botP.add(btn4);
		botP.add(btn5);
		botP.add(btn6);
		//botP.add(btn7);
		//botP.add(btn8);
		
		
		//ȭ�� �ϼ�
		this.add(botP);
		this.add(topP);

		mf.add(this);
		mf.repaint();

















	}//constructor















}//class
