package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MainMenu.MyMouseAdapter5;

public class MyFridge extends JPanel{

	MainFrame mf;
	JPanel myFridge;

	public MyFridge(MainFrame mf) {
		this.mf = mf;
		myFridge = this;

		this.setBounds(0,0,445,770);
		this.setLayout(null);

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
		mf.add(this);


		JLabel lb = new JLabel("My �����");
		lb.setBounds(95, 11 ,207 ,46); 
		lb.setLayout(null);

		lb.setForeground(Color.white);
		lb.setFont(new Font("���� ���", Font.BOLD, 27));     
		this.add(lb);
		
          
		JPanel panel1 = new JPanel(); //��� �г�
		panel1.setSize(445,70);
		panel1.setLayout(null);
		panel1.setBackground(new Color(102, 204, 204));

        Image logoutImg = new ImageIcon("images/logout char.png").getImage().getScaledInstance(79,34,0);
        JButton logOut = new JButton(new ImageIcon(logoutImg));
        logOut.setLocation(360,20);
        logOut.setSize(79,34);
        logOut.addMouseListener(new MyMouseAdapter5());
        panel1.add(logOut);
        
        
        Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50,50,0);
        JButton back = new JButton(new ImageIcon(backImg));
        back.setLocation(10,10);
        back.setSize(50,50);
        back.addMouseListener(new MyMouseAdapter6());
        panel1.add(back);

        this.add(panel1);

		JPanel panel2 = new JPanel(); //�ϴ� �г�
		panel2.setBounds(0, 685, 450, 78);
		add(panel2);
		panel2.setLayout(null);

		JButton btn5 = new JButton(new ImageIcon(new ImageIcon("images/won/ad.PNG").getImage().getScaledInstance(450, 78, 0)));
		btn5.setBounds(-10, 0, 455, 88);
		panel2.add(btn5);


		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try { Desktop.getDesktop().browse(new URI("https://www.iei.or.kr/main/main.kh")); 
				} catch (IOException e1) {
					e1.printStackTrace(); 
				} catch (URISyntaxException e1){ 
					e1.printStackTrace(); }


			}

		});
	}
	class MyMouseAdapter1 extends MouseAdapter{//����Է�
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new InputIngred(mf));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter{//���Ȯ��
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new CheckIngred(mf)); 
		}
	}
	class MyMouseAdapter3 extends MouseAdapter{//�����丮
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new History(mf));
		}
	}
	class MyMouseAdapter4 extends MouseAdapter{//ȸ������
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new ModiMember(mf));
		}
	}
	class MyMouseAdapter5 extends MouseAdapter{//�α���������
		@Override
		public void mouseReleased(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "�α׾ƿ��Ǿ����ϴ�.�α����������� �̵��մϴ�.");
			ChangePanel.changePanel(mf, myFridge, new LoginPage(mf)); 
		}          
	}
	class MyMouseAdapter6 extends MouseAdapter{//���θ޴�(�ڷΰ���)
		@Override
		public void mouseReleased(MouseEvent e) {
			ChangePanel.changePanel(mf, myFridge, new MainMenu(mf)); 
		}          
	}


}
