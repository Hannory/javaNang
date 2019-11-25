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
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ModiMember.MyMouseAdapter2;

public class Help extends JPanel {

	MainFrame mf;
	JPanel help;
	
	public Help(MainFrame mf) {
		
		this.mf = mf;
		this.help = this;
		

		this.setBounds(0,0,445,770);
		this.setLayout(null);
		
		
		JPanel panel1 = new JPanel(); //��� �г�
		panel1.setLocation(0,0);  
		panel1.setSize(445,70);
	    panel1.setLayout(null);
		panel1.setBackground(new Color(102, 204, 204));
		this.add(panel1);
		
		JLabel label = new JLabel("����");
		label.setFont(new Font("���� ���", Font.BOLD, 27)); 
		label.setForeground(Color.WHITE);
		label.setBounds(95, 11 ,207, 46);
		panel1.add(label);
		
		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50,50,0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10,10);
		back.setSize(50,50);
		back.addMouseListener(new MyMouseAdapter1());
		panel1.add(back);
	
		
		Font batang = new Font("���� ���", Font.BOLD, 15);
		
		JLabel lb1 = new JLabel("<�丮��õ>");
		lb1.setBounds(25, 70, 150, 50);
		lb1.setFont(new Font("���� ���", Font.BOLD, 20));  
		JLabel lb1a = new JLabel("��ܿ� ���� ���� ������ �� �ִ� �丮�� ǥ�����ְ�");
		JLabel lb1aa = new JLabel("�Ʒ��� ��Ḧ �߰��ؼ� ������ �� �ִ� �丮�� ǥ�����ݴϴ�.");
		JLabel lb1aaa = new JLabel("�� �¿� ��ư�� ������ �ٸ� �丮���� Ȯ���� �� �� �־��!");
		lb1a.setBounds(25,100, 500, 50);
		lb1a.setFont(batang);
		lb1aa.setBounds(25,120, 500, 50);
		lb1aa.setFont(batang);
		lb1aaa.setBounds(25,140, 500, 50);
		lb1aaa.setFont(batang);
		
		JLabel lb2 = new JLabel("<��� �Է�>");
		lb2.setBounds(25, 180, 150, 50);
		lb2.setFont(new Font("���� ���", Font.BOLD, 20));
		JLabel lb2a = new JLabel("ī�װ����� ���� ������ �ִ� ������ ���� �� �ֽ��ϴ�.");
		JLabel lb2aa = new JLabel("��� ���ĵ��� My������� ��� Ȯ�� ��ư�� ������");
		JLabel lb2aaa = new JLabel("Ȯ���� �� �־��!");
		lb2a.setBounds(25,210,500,50);
		lb2a.setFont(batang);
		lb2aa.setBounds(25,230,500,50);
		lb2aa.setFont(batang);
		lb2aaa.setBounds(25,250,500,50);
		lb2aaa.setFont(batang);
		
		JLabel lb3 = new JLabel("<������ ����>");
		lb3.setBounds(25, 290, 150 ,50);
		lb3.setFont(new Font("���� ���", Font.BOLD, 20));
		JLabel lb3a = new JLabel("�ڽ��� ���� �丮�� �����Ǹ� ������ ���� �ֽ��ϴ�.");
		JLabel lb3aa = new JLabel("�ٸ� �����е��� ���� ������ �Բ� �÷��ּ���!");
		lb3a.setBounds(25,320,500,50);
		lb3a.setFont(batang);
		lb3aa.setBounds(25,340,500,50);
		lb3aa.setFont(batang);
		
		JLabel lb4 = new JLabel("<��� Ȯ��>");
		lb4.setBounds(25, 385, 150 ,50);
		lb4.setFont(new Font("���� ���", Font.BOLD, 20));
		JLabel lb4a = new JLabel("���� �Է��� ������ Ȯ���� �� �ֽ��ϴ�.");		
		lb4a.setBounds(25,415,500,50);	
		lb4a.setFont(batang);
		
		JLabel lb5 = new JLabel("<�����丮>");
		lb5.setBounds(25, 475, 150 ,50);
		lb5.setFont(new Font("���� ���", Font.BOLD, 20));
		JLabel lb5a = new JLabel("���� ���� �丮���� Ȯ���� �� �ֽ��ϴ�.");
		lb5a.setBounds(25,505,500,50);
		lb5a.setFont(batang);
		
		JLabel lb6 = new JLabel("<ȸ������>");
		lb6.setBounds(25, 565, 150,50);
		lb6.setFont(new Font("���� ���", Font.BOLD, 20));
		JLabel lb6a = new JLabel("�ڽ��� ID,�г���,E-MAIL�� Ȯ���ϰ�");
		lb6a.setBounds(25,595,500,50);
		lb6a.setFont(batang);
		JLabel lb6aa = new JLabel("�н����带 ������ �� �ֽ��ϴ�.");
		lb6aa.setBounds(25,615,500,50);
		lb6aa.setFont(batang);

		
		this.add(lb1);
		this.add(lb1a);
		this.add(lb1aa);
		this.add(lb1aaa);
		this.add(lb2);
		this.add(lb2a);
		this.add(lb2aa);
		this.add(lb2aaa);
		this.add(lb3);
        this.add(lb3a);
        this.add(lb3aa);
		this.add(lb4);
		this.add(lb4a);
		this.add(lb5);
        this.add(lb5a);
		this.add(lb6);
	    this.add(lb6a);
	    this.add(lb6aa);
	    
	    JPanel panel2 = new JPanel(); //�ϴ� �г�
		panel2.setBounds(0, 685, 450, 78);
		add(panel2);
		panel2.setLayout(null);

		JButton btn = new JButton(new ImageIcon(new ImageIcon("images/won/ad.PNG").getImage().getScaledInstance(450, 78, 0)));
		btn.setBounds(-10, 0, 455, 88);
		panel2.add(btn);


		btn.addMouseListener(new MouseAdapter() {
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
	
	
	
	class MyMouseAdapter1 extends MouseAdapter{//���θ޴���(�ڷΰ���)
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, help, new MainMenu(mf));
			}
		}
		
		
		
	
	
	
	
	
	
	
}
