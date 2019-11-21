package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class Agree extends JPanel{
	MainFrame mf;                 
	JPanel agree;                     //������� �г�
	private JCheckBox button1;        //ȸ����� ���� üũ�ڽ�
	private JCheckBox button2;        //�������� ���� ���� üũ�ڽ�
	private JButton btn1;             //������ ��ư
	private JButton btn2;             //���Ǿ��� ��ư

	
	
	
	public Agree(MainFrame mf) {
		
		this.mf = mf;
		this.agree = this;
		
		this.setSize(445, 770);
		this.setLayout(null);
		
		//�� ������ �г�
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setBackground(new Color(102, 204, 204));
		
		Font font = new Font("���� ���", Font.BOLD, 27);
	    Font font2 = new Font("���� ���", Font.BOLD, 20);
		
		//�ٿ� ���� �г� ����
		JLabel label = new JLabel("�̿��� ����");
		label.setLocation(80, 10);
		label.setSize(200, 50);
		label.setForeground(Color.white);
		label.setFont(font);
		
		
		//�ٿ� ���� �ڷΰ��� ��ư
		Image backImg = new ImageIcon("images/back sky.PNG").getImage().getScaledInstance(50, 50, 0);
		JButton button = new JButton(new ImageIcon(backImg));
		button.setLocation(10, 10);
		button.setSize(50, 50);
		
		//==========���ݺ��� ����==============
		//ȸ����� ����
		JLabel terms = new JLabel("ȸ�����");
		terms.setLocation(40, 110);
		terms.setSize(180, 20);
		
		//��� ���빰
		final JPanel terms2 = new JPanel();
		JTextPane tp = new JTextPane();
		TextFromFile(tp);
		terms2.setLayout(null);
		tp.setLocation(40, 140);
		tp.setPreferredSize(new Dimension(360, 170));
		
		//��ũ�ѹ�
		final JScrollPane scrollPane = new JScrollPane(tp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 140, 360, 170);
		this.add(scrollPane);
		scrollPane.setVisible(true);
		
		
		//ȸ����� ���� üũ�ڽ�
		button1 = new JCheckBox("(�ʼ�) �̿����� �����մϴ�.");
		button1.setLocation(45, 320);
		button1.setSize(250, 40);
		
		
		
		//�������� ���� ��� ����
		JLabel pterms = new JLabel("�������� ���� �� �̿� ����");
		pterms.setLocation(38, 370);
		pterms.setSize(180, 20);

		
		//�������� ���� ��� ����
		final JPanel pterms2 = new JPanel();
		JTextPane tp2 = new JTextPane();
		TextFromFile2(tp2);
		pterms2.setLayout(null);
		tp2.setLocation(40, 400);
		tp2.setPreferredSize(new Dimension(360, 170));
		
		//��ũ�ѹ�
		final JScrollPane scrollPane2 = new JScrollPane(tp2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(40, 400, 360, 170);
		this.add(scrollPane2);
		scrollPane2.setVisible(true);
		
	
		
		//�������� ���� ��� üũ�ڽ�
		button2 = new JCheckBox("(�ʼ�) �������� ���� �� �̿����� �����մϴ�.");
		button2.setLocation(45, 580);
		button2.setSize(300, 50);
		
		//������ ��ư
		btn1 = new JButton("������");
		btn1.setLocation(95, 650);
		btn1.setSize(110, 50);
		
		//���Ǿ��� ��ư 
		btn2 = new JButton("���Ǿ���");
		btn2.setLocation(225, 650);
		btn2.setSize(110, 50);
		
		
		this.add(panel);
		panel.add(label);
		panel.add(button);
		
		this.add(terms);
		this.add(terms2);
		this.add(button1);
		
		this.add(pterms);
		this.add(pterms2);
		this.add(button2);
		
		this.add(btn1);
		this.add(btn2);
		
		
		//�ڷΰ��� ��ư Ŭ���� �α��� �гη� �̵�
		button.addMouseListener(new MyMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, agree, new LoginPage(mf));
			}
		});
		
		
		//ȸ����� üũ�ڽ� Ŭ��
		button1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		//�������� ���� ��� üũ�ڽ� Ŭ��
		button2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		
		
		//������ ��ư(�ؿ� �ִ� Ŭ������ ����)
		btn1.addMouseListener(new MyMouseAdapter());
		
		//���Ǿ��� ��ư Ŭ���� �α��� �гη� �̵�
		btn2.addMouseListener(new MyMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, agree, new LoginPage(mf));
			}
		});
		
		
		
		
		mf.add(this);
	}
	

	//ȸ����� ���뿡 �� �ؽ�Ʈ ���� �ҷ�����
	private void TextFromFile(JTextPane tp) {
		FileReader fr = null;
		try {
			String terms3 = "documents/terms.txt";
			File file = new File(terms3);
			fr = new FileReader(terms3);
			while(fr.read() != -1) {
				tp.read(fr, null);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
		
	}
	
	//�������� ���� ��� ���뿡 �� �ؽ�Ʈ���� �ҷ�����
	private void TextFromFile2(JTextPane tp2) {
		FileReader fr = null;
		try {
			String pterms3 = "documents/pterms.txt";
			File file = new File(pterms3);
			fr = new FileReader(pterms3);
			while(fr.read() != -1) {
				tp2.read(fr, null);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr != null)
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	//ȸ������ �гη� �Ѿ�� ����...
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//��� üũ�ڽ� �� �� �� ���� �� ������ ��ư�� ������ ȸ������ �гη� �̵�
			if(button1.isSelected() && button2.isSelected()) {
				if(e.getSource() == btn1) {
					ChangePanel.changePanel(mf, agree, new SignUp(mf));

				}
			}else {//�� �� �ϳ��� �� �������� �˾�â�� ��
				if(e.getSource() == btn1) {
					JOptionPane.showMessageDialog(null, "��� �����ϼž� ������ �����մϴ�.");
				}
			}
		}



	}

}
