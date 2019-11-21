package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
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
	JTextField numtf;        //�̸��� ������ȣ �Է¹޴� �ؽ�Ʈ�ʵ�
	JButton numbtn;          //�̸��� ������ȣ üũ ��ư
	
	User u = new User();
	UserDao ud = new UserDao();  //��������� �޼ҵ� ��ȯ�� ���� ��ü ����
	HashMap<String, User> umap = null;
	
	boolean cid = false;         //���̵� �ߺ�Ȯ�ο� ���� ��
	boolean cnick = false;       //�г��� �ߺ�Ȯ�ο� ���� ��
	boolean cn = false;          //�̸��� ������ȣ Ȯ�ο� ���� ��
	
	String str = null;
	
	public SignUp() {}       //�⺻ ������ 
	
	public SignUp(MainFrame mf) {
		this.mf = mf;
		this.signUp = this;
		
		this.setSize(445, 770);
		
		//�� 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setLayout(null);
		
		Font font = new Font("���� ���", Font.BOLD, 27);
	    Font font2 = new Font("���� ���", Font.BOLD, 20);
		
		//�ٿ� �� ����
		JLabel label = new JLabel("ȸ������");
		label.setLocation(80, 10);
		label.setSize(200, 50);
		label.setForeground(Color.WHITE);
		label.setFont(font);
		
		//�ٿ� �� �ڷΰ��� ��ư
		Image backImg = new ImageIcon("images/back sky.PNG").getImage().getScaledInstance(50, 50, 0);
		button = new JButton(new ImageIcon(backImg));
		button.setLocation(10, 10);
		button.setSize(50, 50);
		
		
		//���̵� ��
		JLabel idlb = new JLabel("ID");
		idlb.setLocation(43, 120);
		idlb.setSize(60, 30);
		
		//���̵� �Է¹޴� �ؽ�Ʈ�ʵ�
		idtf = new JTextField();
		idtf.setLocation(90, 120);
		idtf.setSize(210, 30);
		
		
		//���̵� �ߺ�üũ ��ư
		idbtn = new JButton("�ߺ�üũ");
		idbtn.setLocation(310, 120);
		idbtn.setSize(100, 30);
		
		idbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkId(u);
			}
		});
		
		//�н����� ��
		JLabel pwlb = new JLabel("PW");
		pwlb.setLocation(37, 220);
		pwlb.setSize(60, 30);
		
		//�н����� �Է¹޴� �н������ʵ�
		pwpf = new JPasswordField();
		pwpf.setLocation(90, 220);
		pwpf.setSize(210, 30);
		
		
		//üũ�н����� ��
		JLabel cpwlb = new JLabel("PW Ȯ��");
		cpwlb.setLocation(25, 290);
		cpwlb.setSize(60, 30);
		
		//üũ�н����� �Է¹޴� �н������ʵ�
		cpwpf = new JPasswordField();
		cpwpf.setLocation(90, 290);
		cpwpf.setSize(210, 30);
		
		
		
		//�г��� ��
		JLabel nicklb = new JLabel("�г���");
		nicklb.setLocation(28, 390);
		nicklb.setSize(60, 30);
		
		//�г��� �Է¹޴� �ؽ�Ʈ�ʵ�
		nicktf = new JTextField();
		nicktf.setLocation(90, 390);
		nicktf.setSize(210, 30);
		
		
		//�г��� �ߺ�üũ ��ư
		nickbtn = new JButton("�ߺ�üũ");
		nickbtn.setLocation(310, 390);
		nickbtn.setSize(100, 30);
		nickbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkNick(u);
			}
		});
		
		
		//�̸��� ��
		JLabel emaillb = new JLabel("E-MAIL");
		emaillb.setLocation(27, 490);
		emaillb.setSize(60, 30);
		
		//�̸��� �Է¹޴� �ؽ�Ʈ�ʵ�
		emailtf = new JTextField();
		emailtf.setLocation(90, 490);
		emailtf.setSize(210, 30);
		
		
		//�̸��� �����޴� ��ư
		emailbtn = new JButton("�����ޱ�");
		emailbtn.setLocation(310, 490);
		emailbtn.setSize(100, 30);
		emailbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEmail();
				
				
				
			}
		});
		
		//�̸��� ������ȣ Ȯ��
		JLabel numlb = new JLabel("������ȣ");
		numlb.setLocation(25, 560);
		numlb.setSize(60, 30);
		
		numtf = new JTextField();
		numtf.setLocation(90, 560);
		numtf.setSize(210, 30);
		
		numbtn = new JButton("����Ȯ��");
		numbtn.setLocation(310, 560);
		numbtn.setSize(100, 30);
		numbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkNum();
				
			}
		});
		
		
		
		
		
		//�����ϱ� ��ư
		join = new JButton("�����ϱ�");
		join.setLocation(150, 660);
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
		
		this.add(numlb);
		this.add(numtf);
		this.add(numbtn);
		
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
						cid = false;
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
	
	//�̸��� ������
	public void sendEmail() {
		
		String user = "jvnmaster";
		String password = "Dnsdudwk123@";
		
		
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", 465);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		
		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(user));
			
			//������ �����ּ�
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(emailtf.getText()));
			
			//���� ����
			m.setSubject("java.nang ������ȣ");
			
			//������ȣ�� ���� ���� �߻����� int�迭�� �ޱ�
			int[] arr = new int[4];
			arr[0] = (int) (Math.random() * 10);
			arr[1] = (int) (Math.random() * 10);
			arr[2] = (int) (Math.random() * 10);
			arr[3] = (int) (Math.random() * 10);
			
			//int�迭�� String���� ��ȯ�ϱ�
			str = Arrays.toString(arr).replaceAll("[^0-9]", "");
			System.out.println(str);
			
			//���� ����
			m.setText("�ȳ��ϼ��� java.nang�Դϴ�.\n �̸��� ������ȣ : " + str);
			
			
			//�̸��� ����
			Transport.send(m); 
			System.out.println("���� �߼� �Ϸ�");
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	//�̸��� ������ȣ Ȯ��
	public void checkNum() {
		if(numtf.getText().equals(str)) {
			JOptionPane.showMessageDialog(null, "�̸����� �����Ǿ����ϴ�.", "REGISTER_HELPER", JOptionPane.INFORMATION_MESSAGE);
			cn = true;
		}else {
			JOptionPane.showMessageDialog(null, "������ȣ�� Ʋ���ϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
			cn = false;
		}
	}
	
	
	
	
	//�����ϱ� ��ư�� ���� ����(���� �޼ҵ���� true�� ��츸 ����)
	//���콺Ŭ���޼ҵ带 ���� �����߻� Ƚ������ �ߺ��Ǿ� ���� ����Ǿ� �׼����� �ٲ�
	public void register() {
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cid == true && pwPattern() == true && checkPw() == true && cnick == true && checkEmail() == true && cn == true) {

					ud.writeUserList(signUp, inputUser());

					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
					ChangePanel.changePanel(mf, signUp, new LoginPage(mf));

				}else if(cid == false) {
					JOptionPane.showMessageDialog(null, "���̵� �ٽ� �Է��ϼ���.");
				}else if(pwPattern() == false) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է��ϼ���.(������, ����, Ư������ ����, 8~16��)", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(checkEmail() == false) {
					JOptionPane.showMessageDialog(null, "��ȿ���� �ʴ� �̸��� �����Դϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(checkPw() == false) {
					JOptionPane.showMessageDialog(null, "�Է��Ͻ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(e.getSource() != idbtn) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�üũ�� ���ּ���.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(cnick == false || e.getSource() != nickbtn){
					JOptionPane.showMessageDialog(null, "�г��� �ߺ�üũ�� ���ּ���.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(cn == false || e.getSource() != emailbtn) {
					JOptionPane.showMessageDialog(null, "�̸��� ������ ���ּ���.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}
			}

		});

	}

	

}