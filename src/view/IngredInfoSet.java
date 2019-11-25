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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.IngredControl;
import model.vo.IngredAll;

public class IngredInfoSet extends JPanel{


	//��� ����, ������� �Է� ��
	MainFrame mf ;
	JPanel nowp ;
	int IngredNo ;


	public IngredInfoSet(MainFrame mf, int IngredNo) {
		
		this.IngredNo = IngredNo;
		
		
		

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
		JLabel barTitle = new JLabel("��� ���� ����");
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
				new ChangePanel().changePanel(mf, nowp, new CheckIngred(mf));
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

		
		
		
		
		
		//��� �̹��� �� ����		//�̹��� ��δ� ������ �޾ƿ���
		Image ingredImg = new ImageIcon("images/sim/BtnImg/" + IngredNo + ".PNG").getImage().getScaledInstance(300, 300, 0);
		JLabel ingredImgLabel = new JLabel(new ImageIcon(ingredImg));
		ingredImgLabel.setBounds(100,100,300,300);
		
		
		//���� ��ư ����
		JButton btnDelete = new JButton("����");
		btnDelete.setBounds(100,500,100,100);
		btnDelete.addMouseListener(new MouseAdapter() {
			
			@Override
		    public void mouseReleased(MouseEvent e) {
				System.out.println("��� ���� ��ư Ŭ����");
				JOptionPane.showMessageDialog(null, "��� ���� �Ϸ� !");

				new IngredAll().deleteIngred(IngredAll.tempNo);
				
				
				
				//������� ��ü������ �ش� Ű,�� ����
				IngredAll.ingredExpiryMap.remove(String.valueOf(AllRecipe.loginId) + IngredAll.tempNo);
				System.out.println("������Ѱ�ü���� ���� �� ����, ���� ������� ��ü ����  : " + IngredAll.ingredExpiryMap);
				//������ ��ü���� ����
				new IngredAll().saveIngredExpiryMap();
				
				IngredAll.setIngredExpiryMap();		//������� ���� ����
				 new IngredControl().method();		//������� ���� ����
				
			}

			
		});
		
		
		
		//������� �Է� �� ����
		JLabel lbExpiry = new JLabel("������� : ");
		lbExpiry.setBounds(200,500,100,50);
		
		//������� �Է� ��ư ����
		String[] btnExpiry = {"1","2","3","4","5","6","7"};

		JComboBox cbExpiry = new JComboBox(btnExpiry);
		cbExpiry.setSize(50,50);
		cbExpiry.setLocation(300,500);
		
		cbExpiry.setSelectedIndex(0);



		cbExpiry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�޺��ڽ����� ��¥ ���ý� ����

				JComboBox cb = (JComboBox) e.getSource();

				String expiry = (String) cb.getSelectedItem();
				int expiryDay = Integer.parseInt(expiry);	//Ŭ���� �� int Ÿ������ ����
				
				new IngredAll().modifyIngredExpiryMap(expiryDay);	//����ƽ�� ����� ���� ����
				new IngredAll().saveIngredExpiryMap();				//������ ���� ���Ͽ� ����
				
				IngredAll.setIngredExpiryMap();
				 new IngredControl().method();
				
				//IngredControl.minIngredExpiry = expiry;			//����ƽ �� ������� �� ���� 
				
				
				///////////////

				
				

			}
		});


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		//��� �г� ȭ�� ����
		topP.add(btnBack);
		topP.add(logIn);
		topP.add(barTitle);
		
		
		//�ϴ� �г� ȭ�� ����
		botP.add(ingredImgLabel);
		botP.add(btnDelete);
		botP.add(cbExpiry);
		botP.add(lbExpiry);

		

		//���������� > ��ü�г� > ���&�ϴ� �г�
		nowp.add(topP);
		nowp.add(botP);
		mf.add(nowp);
		mf.repaint();
		









	}
	
	
	
	
	
	




}//class
