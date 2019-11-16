package view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputIngredVegetables extends JPanel {
	//(����) ������
	
	MainFrame mf ;
	JPanel nowp ;

	public InputIngredVegetables(MainFrame mf) {

		//�⺻ �г� ����
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(432,753);

		//��� �� �г� ����(����)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,432,73);
		
		//�ϴ� �г� ����
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(0,73,432,680);
		
		//����̹��� �غ�
		Image imgBackground = new ImageIcon("images/sim/imgIngreDetailMeat.PNG").getImage().getScaledInstance(432, 680, 0);

		//�󺧻���, ���� �� ����̹��� �ֱ�
		JLabel lbBackground = new JLabel(new ImageIcon(imgBackground));
		lbBackground.setBounds(0,0,432,680);
		
		//�ϴ��гο� ���� ���̱�
		botP.add(lbBackground);

		

		/////////////////��ư ���� �� �ٿ�� ����, ���콺Ŭ���� �̺�Ʈ ó��//////////////////////////
		JButton btn1 = new JButton("111");
		btn1.setBounds(0,0,145,230);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư1 Ŭ��");
			}
		}
				);


		btn1.setOpaque(false);	//��ư ����ȭ
		
		
		JButton btn2 = new JButton("222");
		btn2.setBounds(0,230,145,230);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư2 Ŭ��");
			}
		}
				);
		btn2.setOpaque(false);
		
		
		
		
		JButton btn3 = new JButton("333");
		btn3.setBounds(0,460,145,230);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư3 Ŭ��");
			}
		}
				);
		btn3.setOpaque(false);
		
		
		
		
		JButton btn4 = new JButton("444");
		btn4.setBounds(145,0,145,230);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư4 Ŭ��");
			}
		}
				);
		btn4.setOpaque(false);
		
		
		
		
		
		JButton btn5 = new JButton("555");
		btn5.setBounds(145,230,145,230);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư5 Ŭ��");
			}
		}
				);
		btn5.setOpaque(false);
		
		
		
		
		JButton btn6 = new JButton("666");
		btn6.setBounds(145,460,145,230);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư6 Ŭ��");
			}
		}
				);
		btn6.setOpaque(false);
		
		
		
		
		JButton btn7 = new JButton("777");
		btn7.setBounds(290,0,145,230);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư7 Ŭ��");
			}
		}
				);
		btn7.setOpaque(false);
		
		
		
		
		JButton btn8 = new JButton("888");
		btn8.setBounds(290,230,145,230);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư8 Ŭ��");
			}
		}
				);
		btn8.setOpaque(false);
		
		
		
		
		JButton btn9 = new JButton("999");
		btn9.setBounds(290,460,145,230);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ư9 Ŭ��");
			}
		}
				);
		btn9.setOpaque(false);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		//ȭ�� ����/////////////

		botP.add(btn1);
		botP.add(btn2);
		botP.add(btn3);
		botP.add(btn4);
		botP.add(btn5);
		botP.add(btn6);
		botP.add(btn7);
		botP.add(btn8);
		botP.add(btn9);

		
		//ȭ�� �ϼ� //component < eachP < nowp < mf
		this.add(botP);
		this.add(topP);

		mf.add(this);
		mf.repaint();






		
		
		
	}//constructor
	
	

}//class
