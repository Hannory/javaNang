//�ʱ�޴� ȭ���� ����� ����
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

import view.MyFridge.MyMouseAdapter;

public class MainMenu extends JPanel {
	private MainFrame mf;
	private JPanel mainPage1;

	public MainMenu(MainFrame mf) {
		this.mf = mf;
		mainPage1 = this;
		
		this.setBounds(0, 0 , 500, 750);
        this.setLayout(null);
		
        JButton btn = new JButton("�丮 ��õ");
		btn.setBounds(140,130,180,50);
		btn.setBackground(Color.LIGHT_GRAY);
		//��ư�������� changepanel �ǵ����ؾ�
		//subpage�� �Ѿ��? �³�? �ϴ� change�� ����

		JButton btn2 = new JButton("��� �Է�");
		btn2.setBounds(140,230,180,50);
		  btn2.setBackground(Color.LIGHT_GRAY);
		JButton btn3 = new JButton("������ ����");
		btn3.setBounds(140,330,180,50);
		 btn3.setBackground(Color.LIGHT_GRAY);
		JButton btn4 = new JButton("My �����");
		btn4.setBounds(140,430,180,50);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addMouseListener(new MyMouseAdapter());
		
		this.add(btn);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		
		mf.add(this);

		//���� ������ �г� ���� �ǰ�¡ �� ū �гξȿ�
		//�Ƿ��� �ϴ� �غ���
		JPanel panel2 = new JPanel();
		panel2.setSize(500,150);
		panel2.setLocation(0,620);
		panel2.setLayout(null);

		panel2.setBackground(Color.LIGHT_GRAY);
		JLabel lb2 = new JLabel("����");
		lb2.setBounds(120,20,110,25);
		lb2.setFont(new Font("Serif", Font.BOLD, 23));        

		panel2.add(lb2);
		this.add(panel2);

		JLabel lb3 = new JLabel("��������� 3�� ���ҽ��ϴ�.");
		lb3.setBounds(120,50,210,25);

		panel2.add(lb3);
		this.add(panel2);


        Image icon = new ImageIcon("images/hwang/milk.PNG").getImage().getScaledInstance(110, 110, 0);
        
         JLabel lb4 = new JLabel(new ImageIcon(icon));
          lb4.setBounds(0,0,100,100);
         panel2.add(lb4); // �̰� �ƹ� �ҿ���µ� �� �ٿ� ��ž� �̾� ��ġ�� ��� ���ұ�?
                          
          this.add(panel2); 
         

	  mf.add(this);
	  
	  

		JLabel lb = new JLabel("���� �޴�");
		lb.setBounds(50,-20,100,100); 
		lb.setLayout(null);

	    lb.setForeground(Color.white);
      lb.setFont(new Font("Serif", Font.BOLD, 20));     
		this.add(lb);
		
		JPanel panel3 = new JPanel();
		panel3.setSize(500,70);
		panel3.setLayout(null);
		panel3.setBackground(Color.black);
		
      panel3.add(lb);
      this.add(panel3);
	}

	 class MyMouseAdapter extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
			   ChangePanel.changePanel(mf, mainPage1, new MyFridge(mf));
		   }
	   }
	}
	