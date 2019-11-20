package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dao.UserDao;
import model.vo.User;

public class SignUp extends JPanel{
	MainFrame mf;
	JPanel signUp;           //ȸ������ �г�
	JButton button;          //�ڷΰ��� ��ư
	JButton join;            //�����ϱ� ��ư
	JTextField idtf;         //���̵� �Է¹޴� �ؽ�Ʈ�ʵ�
	JPasswordField pwpf;     //�н����� �Է¹޴� �н������ʵ�
	JPasswordField cpwpf;    //üũ�н����� �Է¹޴� �н������ʵ�
	JTextField nicktf;       //�г��� �Է¹޴� �ؽ�Ʈ�ʵ�
	JTextField emailtf;      //�̸��� �Է¹޴� �ؽ�Ʈ�ʵ�
	
	
	public SignUp() {}       //�⺻ ������ 
	
	public SignUp(MainFrame mf) {
		this.mf = mf;
		this.signUp = this;
		
		this.setSize(445, 770);
		
		//�� 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 50, 56));
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setLayout(null);
		
		//�ٿ� �� ����
		JLabel label = new JLabel("ȸ������");
		label.setLocation(90, 27);
		label.setSize(60, 30);
		label.setForeground(Color.WHITE);
		
		//�ٿ� �� �ڷΰ��� ��ư
		button = new JButton("<");
		button.setLocation(11, 13);
		button.setSize(50, 50);
		
		//���̵� ��
		JLabel idlb = new JLabel("ID");
		idlb.setLocation(43, 170);
		idlb.setSize(60, 30);
		
		//���̵� �Է¹޴� �ؽ�Ʈ�ʵ�
		idtf = new JTextField();
		idtf.setLocation(90, 170);
		idtf.setSize(205, 30);
		
		
		//���̵� �ߺ�üũ ��ư
		JButton idbtn = new JButton("�ߺ�üũ");
		idbtn.setLocation(300, 170);
		idbtn.setSize(100, 30);
		
		//�н����� ��
		JLabel pwlb = new JLabel("PW");
		pwlb.setLocation(37, 270);
		pwlb.setSize(60, 30);
		
		//�н����� �Է¹޴� �н������ʵ�
		pwpf = new JPasswordField();
		pwpf.setLocation(90, 270);
		pwpf.setSize(205, 30);
		
		
		//üũ�н����� ��
		JLabel cpwlb = new JLabel("PW Ȯ��");
		cpwlb.setLocation(25, 340);
		cpwlb.setSize(60, 30);
		
		//üũ�н����� �Է¹޴� �н������ʵ�
		cpwpf = new JPasswordField();
		cpwpf.setLocation(90, 340);
		cpwpf.setSize(205, 30);
		
		
		
		//�г��� ��
		JLabel nicklb = new JLabel("�г���");
		nicklb.setLocation(28, 440);
		nicklb.setSize(60, 30);
		
		//�г��� �Է¹޴� �ؽ�Ʈ�ʵ�
		nicktf = new JTextField();
		nicktf.setLocation(90, 440);
		nicktf.setSize(205, 30);
		
		
		//�г��� �ߺ�üũ ��ư
		JButton nickbtn = new JButton("�ߺ�üũ");
		nickbtn.setLocation(300, 440);
		nickbtn.setSize(100, 30);
		
		//�̸��� ��
		JLabel emaillb = new JLabel("E-MAIL");
		emaillb.setLocation(27, 540);
		emaillb.setSize(60, 30);
		
		//�̸��� �Է¹޴� �ؽ�Ʈ�ʵ�
		emailtf = new JTextField();
		emailtf.setLocation(90, 540);
		emailtf.setSize(205, 30);
		
		
		//�̸��� �����޴� ��ư
		JButton emailbtn = new JButton("�����ޱ�");
		emailbtn.setLocation(300, 540);
		emailbtn.setSize(100, 30);
		
		//�����ϱ� ��ư
		join = new JButton("�����ϱ�");
		join.setLocation(150, 650);
		join.setSize(120, 50);
		
		//�����ϱ� ��ư ������ ȸ������(�ؽ�Ʈ�ʵ忡 �ִ� �������� user.dat ���Ͽ� ����) -> �α��� �гη� �̵�
		join.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
				ChangePanel.changePanel(mf, signUp, new LoginPage(mf));
			  
				UserDao ud = new UserDao();
				ud.writeUserList(signUp, inputUser());
		
				
				
				
			}
			
		});
		
		
		
		this.add(panel);
		panel.add(label);
		panel.add(button);
		
		this.add(idlb);
		this.add(idtf);
		this.add(idbtn);
		
		this.add(pwlb);
		this.add(pwpf);
		
		this.add(cpwlb);
		this.add(cpwpf);
		
		this.add(nicklb);
		this.add(nicktf);
		this.add(nickbtn);
		
		this.add(emaillb);
		this.add(emailtf);
		this.add(emailbtn);
		
		this.add(join);
		
		
		
		//�ڷΰ��� ��ư
		button.addMouseListener(new MyMouseAdapter());
		
		
	}
	
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {//�ڷΰ��� ��ư ������ ������� �гη� �̵�
			if(e.getSource() == button) {
				ChangePanel.changePanel(mf, signUp, new Agree(mf));
			}
		}
	}
	
	
	
	//�ؽ�Ʈ�ʵ�, �н������ʵ�� �Է¹��� ������ �ؽ�Ʈ�� �����Ͽ� setter�� User Ŭ������ ��üu�� ����..
	public User inputUser() {
		User u = new User();
		
		u.setUserId(idtf.getText());
		u.setUserPw(String.valueOf(pwpf.getPassword()));
		u.setNickname(nicktf.getText());
		u.setEmail(emailtf.getText());

		return u;
	}



}
		
		
		
	
	
	
	
	
	
	


