//ȸ�� ���� ȸ��Ż�� ��ư-> ȸ��Ż��� �Ѿ��
//ȸ�� ������ �г� ��ü�ư� ���⼭ ȸ��Ż��� �� �� �ֵ���

package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ModiMember extends JPanel{

	public MainFrame mf;
	public JPanel subPage2;
	 
	private JPasswordField jpf1;
	private JPasswordField jpf2;
	private JPasswordField jpf3;

	
	
	public ModiMember(MainFrame mf) {
		this.mf = mf;
		this.subPage2 = this;
		
		this.setBounds(0,0,500,750);
        this.setLayout(null);
		JLabel lb = new JLabel("ȸ������ ����");// ȸ����������
		lb.setBounds(150, 50, 200 ,100);
		lb.setFont(new Font("Serif", Font.BOLD, 30));  
		JLabel lb2 = new JLabel("ID");
		lb2.setBounds(90, 150, 27, 50);
		lb2.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb3 = new JLabel("���� PW");// ���� PW
		lb3.setBounds(56, 202, 92 ,50);
		lb3.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb4 = new JLabel("���� PW");// ���� PW
		lb4.setBounds(56, 252, 92 ,50);
		lb4.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb5 = new JLabel("Ȯ�� PW");// Ȯ�� PW
		lb5.setBounds(56, 309, 92 ,50);
		lb5.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb6 = new JLabel("�г���");// �г���
		lb6.setBounds(66, 364, 83 ,50);
		lb6.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb7 = new JLabel("E-MAIL");// Email
		lb7.setBounds(65, 406, 83 ,50);
		lb7.setFont(new Font("Serif", Font.BOLD, 20));

		this.add(lb);
		this.add(lb2);
		this.add(lb3);
		this.add(lb4);
		this.add(lb5);
		this.add(lb6);
		this.add(lb7);

		
		
		JPasswordField password = new JPasswordField();

		JPanel panel = new JPanel();
		panel.setSize(120,50);
		panel.setLocation(191,572);
		panel.setLayout(null);
		panel.setBackground(Color.orange);

	    this.add(panel);
	    
	    JButton jbt1 = new JButton("Ȯ��");
	    jbt1.setBounds(0,0,120,50);	    	    
	    jbt1.setForeground(Color.white);
	    jbt1.setBackground(Color.orange);
	    Dialog sd = new Dialog(mf, "���� �Ϸ�");
	    sd.setBounds(200,200,300,100);
	    JButton jbt11 = new JButton("��й�ȣ�� �����Ǿ����ϴ�.");
	    sd.add(jbt11);
	    panel.add(jbt1);
	    //��й�ȣ Ȯ���ؼ� ��й�ȣ ������ ���� �Ϸ�
	    //��й�ȣ Ȯ���ؼ� ��й�ȣ ���������� 
        jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                         sd.setVisible(true);				
			}
		});
		
		jbt11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                         sd.dispose();        //�ݱ� �������� ������
                                              //�� ���� �� �����Ŵ�
			}
		});
	    
	    
	    JPanel panel2 = new JPanel();
        panel2.setLocation(0,0);
        panel2.setSize(1000,70);
        panel2.setLayout(null);
        panel2.setBackground(Color.black);
	    this.add(panel2);
	    
	    JLabel label = new JLabel("ȸ������ ����");
	    label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		label.setBounds(83, 12, 141, 26);
		panel2.add(label);
	
        JButton jbt2 = new JButton("��");
        jbt2.setBounds(14,14,24,27);
        jbt2.setForeground(Color.white);
        jbt2.setBackground(Color.black);
        panel2.add(jbt2);
        //�� ��ư�� �������� ������������ �ٽ� �� �� �ְ�
        jbt2.addMouseListener(new MyMouseAdapter());
	   
        jpf1 = new JPasswordField();
	    jpf1.setBounds(165, 262, 269, 35);
	    this.add(jpf1);
	    
	    jpf2 = new JPasswordField();
	    jpf2.setBounds(165,312,269,35);
	    this.add(jpf2);
	    
	    jpf3 = new JPasswordField();
	    jpf3.setBounds(165, 212, 269, 35);
	    this.add(jpf3);
	    
	    JLabel label2 = new JLabel("");
	    label2.setBounds(176, 220, 62, 18);
	    this.add(label2);
	    
	    JButton jbt3 = new JButton("ȸ�� Ż��");
	    jbt3.setBounds(384, 668, 96, 35);
	    jbt3.setBackground(Color.LIGHT_GRAY);
	    jbt3.addMouseListener(new MyMouseAdapter2());
	    this.add(jbt3);
	
	}
	
	 class MyMouseAdapter extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, subPage2, new MyFridge(mf));
		   }
	   }
	 class MyMouseAdapter2 extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, subPage2, new QuitMember(mf));
		   }
	   }
}
