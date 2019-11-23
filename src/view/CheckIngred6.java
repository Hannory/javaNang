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

import model.dao.AddIngred;
import run.Run;

public class CheckIngred6 extends JPanel{
	//��� Ȯ�� ������
	MainFrame mf ;
	JPanel nowp ;


	public CheckIngred6(MainFrame mf) {

		//�⺻ �г� ����
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);

		//��� �� �г� ����(����)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);
		topP.setBackground(new Color(102, 204, 204));


		//��� Ÿ��Ʋ ����
		Font font = new Font("���� ���", Font.BOLD, 27);
		JLabel barTitle = new JLabel("���Ȯ�� <6>");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);

		//��� �� �г� �ٹ̱� //�ڷΰ��� ��ư ����
		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton btnBack = new JButton(new ImageIcon(backImg));
		btnBack.setBounds(10,10,50,50);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("�ڷΰ��� Ŭ��");
				new ChangePanel().changePanel(mf, nowp, new MyFridge(mf));
			}
		}
				);

		//��� �� ���� ���������� ��ư ����
		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setBounds(380,10,50,50);
		logIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("�ڷΰ��� Ŭ��");
				new ChangePanel().changePanel(mf, nowp, new MyFridge(mf));
			}
		});


		//�ϴ� �г� ����
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(5,75,432,680);









		//���� ��Ḧ ���� �ε��� �����
		Object[] al = LoginPage.ingredStatic.toArray();
		String[] sarr = new String[55];


		for(int i = 0; i< sarr.length;i++) {
			sarr[i] = "9999";
		}
		for(int i = 0; i< al.length;i++) {
			sarr[i] = String.valueOf(al[i]) ;
		}


		///////////////��ư ���� �� �ٿ�� ����, ��ư �̹��� �غ� �� �̹��� �ֱ�, ���콺Ŭ���� �̺�Ʈ ó��//////////////////////////
		Image imgBtn1 = new ImageIcon("images/sim/BtnImg/"+ sarr[45] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn1 = new JButton(new ImageIcon(imgBtn1));
		btn1.setBounds(0,0,145,200);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn2 = new ImageIcon("images/sim/BtnImg/"+ sarr[46] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn2 = new JButton(new ImageIcon(imgBtn2));
		btn2.setBounds(0,200,145,200);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn3 = new ImageIcon("images/sim/BtnImg/"+ sarr[47] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn3 = new JButton(new ImageIcon(imgBtn3));
		btn3.setBounds(0,400,145,200);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn4 = new ImageIcon("images/sim/BtnImg/"+ sarr[48] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn4 = new JButton(new ImageIcon(imgBtn4));
		btn4.setBounds(145,0,145,200);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn5= new ImageIcon("images/sim/BtnImg/"+ sarr[49] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn5= new JButton(new ImageIcon(imgBtn5));
		btn5.setBounds(145,200,145,200);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn6 = new ImageIcon("images/sim/BtnImg/"+ sarr[50] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn6 = new JButton(new ImageIcon(imgBtn6));
		btn6.setBounds(145,400,145,200);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn7 = new ImageIcon("images/sim/BtnImg/"+ sarr[51] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn7 = new JButton(new ImageIcon(imgBtn7));
		btn7.setBounds(290,0,145,200);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn8 = new ImageIcon("images/sim/BtnImg/"+ sarr[52] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn8 = new JButton(new ImageIcon(imgBtn8));
		btn8.setBounds(290,200,145,200);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);

		Image imgBtn9 = new ImageIcon("images/sim/BtnImg/"+ sarr[53] +".PNG").getImage().getScaledInstance(145, 200, 0);
		JButton btn9 = new JButton(new ImageIcon(imgBtn9));
		btn9.setBounds(290,400,145,200);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("���Ȯ�ο� �ִ� ��ư");
			}
		}
				);


		//�ϴ� ��� ������ �߰�
		JButton btnList1 = new JButton("1");
		btnList1.setBounds(70,600,50,50);
		btnList1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePanel().changePanel(mf, nowp, new CheckIngred(mf));
			}


		});

		JButton btnList2 = new JButton("2");
		btnList2.setBounds(120,600,50,50);
		btnList2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePanel().changePanel(mf, nowp, new CheckIngred2(mf));
			}


		});

		JButton btnList3 = new JButton("3");
		btnList3.setBounds(170,600,50,50);
		btnList3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePanel().changePanel(mf, nowp, new CheckIngred3(mf));
			}


		});

		JButton btnList4 = new JButton("4");
		btnList4.setBounds(220,600,50,50);
		btnList4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePanel().changePanel(mf, nowp, new CheckIngred4(mf));
			}


		});

		JButton btnList5 = new JButton("5");
		btnList5.setBounds(270,600,50,50);
		btnList5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePanel().changePanel(mf, nowp, new CheckIngred5(mf));
			}


		});

		JButton btnList6 = new JButton("6");
		btnList6.setBounds(320,600,50,50);
		btnList6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePanel().changePanel(mf, nowp, new CheckIngred6(mf));
			}


		});












		//��� �г� ȭ�� ����
		topP.add(btnBack);
		topP.add(logIn);
		topP.add(barTitle);

		//�ϴ��гο� ��ư �߰�
		botP.add(btn1);
		botP.add(btn2);
		botP.add(btn3);
		botP.add(btn4);
		botP.add(btn5);
		botP.add(btn6);
		botP.add(btn7);
		botP.add(btn8);
		botP.add(btn9);

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




	//���� ��Ḧ Ȯ���Ͽ� ��(�̹��� ��ΰ� �� ��)���� ��ȯ�ϴ� �޼ҵ�
	public String checkNowIngred() {




		//����� �о
		//�������  ��ȯ
		//��Ʈ���� �Ѱ���





		return null;
	}

















}//class
