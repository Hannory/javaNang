package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dao.AddUser;
import model.vo.User;

public class SignUp extends JPanel{
	MainFrame mf;
	JPanel signUp;
	JButton button;
	JButton join;
	JTextField idtf;
	JPasswordField pwpf;
	JPasswordField cpwpf;
	JTextField nicktf;
	JTextField emailtf;
	
	private String id;
	private String pw;
	private String cpw;
	private String nick;
	private String mail;
	
	ArrayList<User> list = null;
	
	public SignUp() {}
	
	public SignUp(MainFrame mf) {
		this.mf = mf;
		this.signUp = this;
		
		this.setSize(445, 770);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 50, 56));
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setLayout(null);
		
		JLabel label = new JLabel("회원가입");
		label.setLocation(90, 27);
		label.setSize(60, 30);
		label.setForeground(Color.WHITE);
		
		button = new JButton("<");
		button.setLocation(11, 13);
		button.setSize(50, 50);
		
		
		JLabel idlb = new JLabel("ID");
		idlb.setLocation(43, 170);
		idlb.setSize(60, 30);
		
		idtf = new JTextField();
		idtf.setLocation(90, 170);
		idtf.setSize(205, 30);
		
		
		
		JButton idbtn = new JButton("중복체크");
		idbtn.setLocation(300, 170);
		idbtn.setSize(100, 30);
		
		
		JLabel pwlb = new JLabel("PW");
		pwlb.setLocation(37, 270);
		pwlb.setSize(60, 30);
		
		pwpf = new JPasswordField();
		pwpf.setLocation(90, 270);
		pwpf.setSize(205, 30);
		
		
		
		JLabel cpwlb = new JLabel("PW 확인");
		cpwlb.setLocation(25, 340);
		cpwlb.setSize(60, 30);
		
		cpwpf = new JPasswordField();
		cpwpf.setLocation(90, 340);
		cpwpf.setSize(205, 30);
		
		
		
		
		JLabel nicklb = new JLabel("닉네임");
		nicklb.setLocation(28, 440);
		nicklb.setSize(60, 30);
		
		nicktf = new JTextField();
		nicktf.setLocation(90, 440);
		nicktf.setSize(205, 30);
		
		
		
		JButton nickbtn = new JButton("중복체크");
		nickbtn.setLocation(300, 440);
		nickbtn.setSize(100, 30);
		
		
		JLabel emaillb = new JLabel("E-MAIL");
		emaillb.setLocation(27, 540);
		emaillb.setSize(60, 30);
		
		emailtf = new JTextField();
		emailtf.setLocation(90, 540);
		emailtf.setSize(205, 30);
		
		
		
		JButton emailbtn = new JButton("인증받기");
		emailbtn.setLocation(300, 540);
		emailbtn.setSize(100, 30);
		
		
		join = new JButton("가입하기");
		join.setLocation(150, 650);
		join.setSize(120, 50);
		
		//가입하기 버튼 누르면 회원가입(텍스트필드에 있는 정보들을 user.dat 파일에 저장) 되게 하기
		
		join.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
				ChangePanel.changePanel(mf, signUp, new LoginPage(mf));
			  
				AddUser au = new AddUser();
				au.writeUserList(signUp, inputUser());
				au.readUserList();
				
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
		
		
		
	
		button.addMouseListener(new MyMouseAdapter());
		
		
	}
	
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == button) {
				ChangePanel.changePanel(mf, signUp, new Agree(mf));
			}
		}
	}
	
	
	
	
	public User inputUser() {
		User u = new User();
		
		u.setUserId(idtf.getText());
		u.setUserPw(String.valueOf(pwpf.getPassword()));
		u.setNickname(nicktf.getText());
		u.setEmail(emailtf.getText());
		
		return u;
	}
	
	
	/*public void saveUser() {
		
		System.out.println(inputUser());
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.dat", true));
			
			oos.writeObject(inputUser());
			
			oos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}*/
		
		
		
		
	}
	
	
	
	
	
	


