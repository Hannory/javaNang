package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	JButton idbtn;           //���̵� �ߺ�üũ ��ư
	JPasswordField pwpf;     //�н����� �Է¹޴� �н������ʵ�
	JPasswordField cpwpf;    //üũ�н����� �Է¹޴� �н������ʵ�
	JTextField nicktf;       //�г��� �Է¹޴� �ؽ�Ʈ�ʵ�
	JButton nickbtn;         //�г��� �ߺ�üũ ��ư
	JTextField emailtf;      //�̸��� �Է¹޴� �ؽ�Ʈ�ʵ�
	JButton emailbtn;        //�̸��� �����ޱ� ��ư
	
	
	User u = new User();
	UserDao ud = new UserDao();  //��������� �޼ҵ� ��ȯ�� ���� ��ü ����
	HashMap umap = null;
	
	//Mail m = new Mail();
	
	boolean cid = true;
	boolean cnick = true;
	
	String[] sarr = {""};
	
	
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
		idbtn = new JButton("�ߺ�üũ");
		idbtn.setLocation(300, 170);
		idbtn.setSize(100, 30);
		
		idbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkId(u);
			}
		});
		
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
		nickbtn = new JButton("�ߺ�üũ");
		nickbtn.setLocation(300, 440);
		nickbtn.setSize(100, 30);
		nickbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkNick(u);
			}
		});
		
		
		//�̸��� ��
		JLabel emaillb = new JLabel("E-MAIL");
		emaillb.setLocation(27, 540);
		emaillb.setSize(60, 30);
		
		//�̸��� �Է¹޴� �ؽ�Ʈ�ʵ�
		emailtf = new JTextField();
		emailtf.setLocation(90, 540);
		emailtf.setSize(205, 30);
		
		
		//�̸��� �����޴� ��ư
		emailbtn = new JButton("�����ޱ�");
		emailbtn.setLocation(300, 540);
		emailbtn.setSize(100, 30);
		emailbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//m.sendEmail();
				
				
				
			}
		});
		
		//�����ϱ� ��ư
		join = new JButton("�����ϱ�");
		join.setLocation(150, 650);
		join.setSize(120, 50);
		
		
		//�����ϱ� ��ư ������ ȸ������(�ؽ�Ʈ�ʵ忡 �ִ� �������� user.dat ���Ͽ� ����) -> �α��� �гη� �̵�
		join.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				register();
		
				
				
				
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
		
		
		u.setUserId(idtf.getText());
		u.setUserPw(String.valueOf(pwpf.getPassword()));
		u.setNickname(nicktf.getText());
		u.setEmail(emailtf.getText());

		return u;
	}
	
	//���̵� �ߺ�üũ & ��ȿ�� �˻�
	public void checkId(User u) {
				ObjectInputStream ois = null;
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{4,12}$");
				Matcher m = p.matcher(idtf.getText());
				try {
					
					ois = new ObjectInputStream(new FileInputStream("userList.dat"));
					
					umap = (HashMap) ois.readObject();
					
					Set uset = umap.keySet();
					
					
					if(!uset.contains(idtf.getText()) && m.find() == true){
						JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.", "REGISTER_HELPER", JOptionPane.INFORMATION_MESSAGE);
						cid = true;
					}else if(uset.contains(idtf.getText())) {
						JOptionPane.showMessageDialog(null, "�����ϴ� ���̵��Դϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
						cid = false;
					}else if(m.find() == false) {
						JOptionPane.showMessageDialog(null, "����� �� ���� ���̵��Դϴ�.(����, ���� ����, 4~12��)", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
					}

				} catch (EOFException e1) {
					e1.printStackTrace();
				}catch(Exception e1){
					e1.printStackTrace();
				}finally {
					try {
						if(ois != null) {
							ois.close();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		
		
	
	

	
	
	//��й�ȣ ��ȿ�� �˻�(������, ����, Ư������ ��� �����ϰ� 8~16���� ����)
	public boolean pwPattern() {
		
		Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,16}$");
		Matcher m = p.matcher(String.valueOf(pwpf.getPassword()));
		
		return m.find();
	}
	
	//��й�ȣ�� ��й�ȣ Ȯ���� ��ġ�ϴ��� �˻�
	public boolean checkPw() {
		
		if(String.valueOf(pwpf.getPassword()).equals(String.valueOf(cpwpf.getPassword()))) {
			return true;
		}
		
		return false;
	}
	//�г��� �ߺ�üũ
	public void checkNick(User u) {
		
		
		
		
		
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));
			
			HashMap umap = (HashMap) ois.readObject();
			
			Collection ucol = umap.values();
			
			Object[] uarr = ucol.toArray();

			for(int i = 0; i < uarr.length; i++) {
				if(nicktf.getText().equals(((User) uarr[i]).getNickname())) {
					JOptionPane.showMessageDialog(null, "�����ϴ� �г����Դϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
					cnick = false;
				}else {
					JOptionPane.showMessageDialog(null, "��밡���� �г����Դϴ�.", "REGISTER_HELPER", JOptionPane.INFORMATION_MESSAGE);
					cnick = true;
				}
			}




		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}




	}

	
	//�̸��� ������ ��ȿ���� �˻�
	public boolean checkEmail() {
		
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(emailtf.getText());
		
		return m.find();
	}
	
	
	//�����ϱ� ��ư�� ���� ����(���� �޼ҵ���� true�� ��츸 ����)
	//���콺Ŭ���޼ҵ带 ���� �����߻� Ƚ������ �ߺ��Ǿ� ���� ����Ǿ� �׼����� �ٲ�
	public void register() {
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cid == true && pwPattern() == true && checkPw() == true && cnick == true && checkEmail() == true) {
					
					ud.writeUserList(signUp, inputUser());
					
					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
					ChangePanel.changePanel(mf, signUp, new LoginPage(mf));
				}else if(e.getSource() != idbtn) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�üũ�� ���ּ���.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(cid == false) {
					JOptionPane.showMessageDialog(null, "���̵� �ٽ� �Է��ϼ���.");
				}else if(pwPattern() == false) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է��ϼ���.(������, ����, Ư������ ����, 8~16��)", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(cnick == false || e.getSource() != nickbtn){
					JOptionPane.showMessageDialog(null, "�г��� �ߺ�üũ�� ���ּ���.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(checkEmail() == false) {
					JOptionPane.showMessageDialog(null, "��ȿ���� �ʴ� �̸��� �����Դϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(checkPw() == false) {
					JOptionPane.showMessageDialog(null, "�Է��Ͻ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				
				}
				
			}

		});
			
	}



}
		
		
		
	
	
	
	
	
	
	


