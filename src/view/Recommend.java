package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

import controller.RecMgt;
import model.dao.MgrRecipeDao;
import model.dao.UserDao;

public class Recommend extends JPanel {
	
	private MainFrame mf;
	private ChangePanel cp;
	private JPanel rc;
	
	private MgrRecipeDao mrd = new MgrRecipeDao();
	private UserDao ud = new UserDao();
	private RecMgt rm = new RecMgt();

	int nowClickCtn = 0;	// �������� Ŭ�� ī��Ʈ. ��õ ������ �����.
	int addClickCtn = 0;	// �߰����� Ŭ�� ī��Ʈ. ��õ ������ �����.
	
	JLabel label;
	JButton left;
	JButton right;
	JButton specificPage;
	
	JLabel label2;
	JButton left2;
	JButton right2;
	JButton specificPage2;
	
	public Recommend(MainFrame mf) {		
		
		this.mf = mf;
		rc = this;
		
		//User, Recipe ���� ����   ->  ���� �Է� ������ ��ü
		//ud.fileSave();
		//mrd.fileSave();
		
		//���� �г�
		this.setSize(445, 770);
		this.setLayout(null);
		
		//�� �� �� ����
		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(445, 70);
		bar.setLayout(null);
		bar.setBackground(new Color(52, 152, 219));
		
		Font font = new Font("MD��Ʈü", Font.BOLD, 25);
		Font font2 = new Font("MD��Ʈü", Font.BOLD, 20);
		
		JLabel barTitle = new JLabel("�丮 ��õ");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);
		
		Image backImg = new ImageIcon("images/park/back blue.png").getImage().getScaledInstance(50,  50,  0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10, 10);
		back.setSize(50, 50);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, rc, new MainMenu(mf));
				
			}
			
		});
		
		Image person = new ImageIcon("images/park/person in blue.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setLocation(380, 10);
		logIn.setSize(50, 50);
		
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, rc, new MyFridge(mf));
				
			}
			
		});		
		
		//������ ��õ �з�
		rm.categorizing();
		
		//���� ���� �г� ����
		JPanel panel = new JPanel();
		panel.setLocation(0, 70);
		panel.setSize(445, 233);
		panel.setLayout(null);
		

		
		//���� ���ο� ��µ� �̹���
		if(RecMgt.nowCtn != 0) {
			
			Image[] nowIcon = new Image[RecMgt.nowCtn];
			
			for(int i = 0; i < nowIcon.length; i++) {
				nowIcon[i] = new ImageIcon(rm.nowPicAdr(i)).getImage().getScaledInstance(345, 233, 0);
			}
			
			label = new JLabel(new ImageIcon(nowIcon[nowClickCtn]));
			
			label.setLocation(50, 0);
			label.setSize(345, 233);
			
			left = new JButton("��");
			left.setSize(50, 233);
			left.setLocation(0, 0);
			
			left.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					nowClickCtn--;
					if(nowClickCtn < 0) {
						nowClickCtn += RecMgt.nowCtn;
						label.setIcon(new ImageIcon(nowIcon[nowClickCtn % RecMgt.nowCtn]));
					}else {
						label.setIcon(new ImageIcon(nowIcon[nowClickCtn % RecMgt.nowCtn]));
					}
					
				}
				
			});
			
			right = new JButton("��");
			right.setSize(50, 233);
			right.setLocation(395, 0);
			
			right.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					nowClickCtn++;
					label.setIcon(new ImageIcon(nowIcon[nowClickCtn % RecMgt.nowCtn]));
					
				}
				
			});
			
			//�丮 �� �������� �̵� (nowClickCtn) Ȱ��
			specificPage = new JButton(" ");
			specificPage.setLocation(50, 0);
			specificPage.setSize(345, 233);
			specificPage.setOpaque(false);
			
			specificPage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cp.changePanel(mf, rc, new RecipePage2(mf, rm.nowRecipe(nowClickCtn % RecMgt.nowCtn)));
					
				}
				
			});		
			
		}else {
			
			Image nowIcon = new ImageIcon("images/park/no recommend.png").getImage().getScaledInstance(345, 233, 0);
			label = new JLabel(new ImageIcon(nowIcon));
			
			label.setLocation(50, 0);
			label.setSize(345, 233);
			
			left = new JButton("��");
			left.setSize(50, 233);
			left.setLocation(0, 0);
			
			right = new JButton("��");
			right.setSize(50, 233);
			right.setLocation(395, 0);		
			
			//My ����� �������� �̵�
			specificPage = new JButton(" ");
			specificPage.setLocation(50, 0);
			specificPage.setSize(345, 233);
			specificPage.setOpaque(false);
			
			specificPage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//cp.changePanel(mf, rc, new MyFridge(mf));
					JOptionPane.showMessageDialog(null, "����� ��� �ֽ��ϴ�.\n��Ḧ ���� �Է����ּ���.");
					
				}
				
			});
		}
		
		//�߰� ����
		JPanel panel2 = new JPanel();
		panel2.setLocation(0, 303);
		panel2.setSize(445, 233);
		panel2.setLayout(null);
		
		if(RecMgt.addCtn != 0) {
			
			Image[] addIcon = new Image[RecMgt.addCtn];
			
			for(int i = 0; i < addIcon.length; i++) {
				addIcon[i] = new ImageIcon(rm.addPicAdr(i)).getImage().getScaledInstance(345, 233, 0);
			}
			
			label2 = new JLabel(new ImageIcon(addIcon[addClickCtn]));
			label2.setLocation(50, 0);
			label2.setSize(345, 233);
			
			left2 = new JButton("��");
			left2.setSize(50, 233);
			left2.setLocation(0, 0);
			
			left2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					addClickCtn--;
					if(addClickCtn < 0) {
						addClickCtn += RecMgt.addCtn;
						label2.setIcon(new ImageIcon(addIcon[addClickCtn % RecMgt.addCtn]));
					}else {
						label2.setIcon(new ImageIcon(addIcon[addClickCtn % RecMgt.addCtn]));
					}
					
				}
				
			});
			
			right2 = new JButton("��");
			right2.setSize(50, 233);
			right2.setLocation(395, 0);
			
			right2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					addClickCtn++;
					label2.setIcon(new ImageIcon(addIcon[addClickCtn % RecMgt.addCtn]));
					
				}
				
			});
			
			//�丮 �� �������� �̵� (nowClickCtn) Ȱ��
			specificPage2 = new JButton(" ");
			specificPage2.setLocation(50, 0);
			specificPage2.setSize(345, 233);
			specificPage2.setOpaque(false);
			
			specificPage2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cp.changePanel(mf, rc, new RecipePage3(mf, rm.addRecipe(addClickCtn % RecMgt.addCtn)));
					
				}
				
			});	
			
		}else {
			
			Image nowIcon = new ImageIcon("images/park/no recommend.png").getImage().getScaledInstance(345, 233, 0);
			label2 = new JLabel(new ImageIcon(nowIcon));
			
			label2.setLocation(50, 0);
			label2.setSize(345, 233);
			
			left2 = new JButton("��");
			left2.setSize(50, 233);
			left2.setLocation(0, 0);
			
			right2 = new JButton("��");
			right2.setSize(50, 233);
			right2.setLocation(395, 0);		
			
			//My ����� �������� �̵�
			specificPage2 = new JButton(" ");
			specificPage2.setLocation(50, 0);
			specificPage2.setSize(345, 233);
			specificPage2.setOpaque(false);
			
			specificPage2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//cp.changePanel(mf, rc, new MyFridge(mf));
					JOptionPane.showMessageDialog(null, "����� ��� �ֽ��ϴ�.\n��Ḧ ���� �Է����ּ���.");
				}
				
			});
		}
		
		//��� ������ �г�
		JPanel panel3 = new JPanel();
		panel3.setLocation(0, 536);
		panel3.setSize(445, 233);
		panel3.setLayout(null);

		Image icon3 = new ImageIcon("images/park/allRecipePanel.png").getImage().getScaledInstance(445, 233, 0);
		JLabel label3 = new JLabel(new ImageIcon(icon3));
		label3.setSize(445, 233);
		label3.setLayout(null);
		
		JButton allBtn = new JButton("��� ������");
		allBtn.setLocation(175, 75);
		allBtn.setSize(160, 60);
		allBtn.setFont(font2);
		//allBtn.setVisible(false);
		
		//add ����
		bar.add(barTitle);
		bar.add(back);
		bar.add(logIn);
		
		panel.add(left);
		panel.add(right);
		panel.add(label);
		panel.add(specificPage);
		
		panel2.add(left2);
		panel2.add(right2);
		panel2.add(label2);
		panel2.add(specificPage2);
		
		label3.add(allBtn);
		panel3.add(label3);
		
		this.add(bar);
		this.add(panel);
		this.add(panel2);
		this.add(panel3);
		
		mf.add(this);
	}
	
}
