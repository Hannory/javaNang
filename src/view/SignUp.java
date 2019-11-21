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
	JPanel signUp;           //회원가입 패널
	JButton button;          //뒤로가기 버튼
	JButton join;            //가입하기 버튼
	JTextField idtf;         //아이디 입력받는 텍스트필드
	JButton idbtn;           //아이디 중복체크 버튼
	JPasswordField pwpf;     //패스워드 입력받는 패스워드필드
	JPasswordField cpwpf;    //체크패스워드 입력받는 패스워드필드
	JTextField nicktf;       //닉네임 입력받는 텍스트필드
	JButton nickbtn;         //닉네임 중복체크 버튼
	JTextField emailtf;      //이메일 입력받는 텍스트필드
	JButton emailbtn;        //이메일 인증받기 버튼
	
	
	User u = new User();
	UserDao ud = new UserDao();  //파일입출력 메소드 소환을 위한 객체 생성
	HashMap umap = null;
	
	//Mail m = new Mail();
	
	boolean cid = true;
	boolean cnick = true;
	
	String[] sarr = {""};
	
	
	public SignUp() {}       //기본 생성자 
	
	public SignUp(MainFrame mf) {
		this.mf = mf;
		this.signUp = this;
		
		this.setSize(445, 770);
		
		//바 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 50, 56));
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setLayout(null);
		
		//바에 들어갈 제목
		JLabel label = new JLabel("회원가입");
		label.setLocation(90, 27);
		label.setSize(60, 30);
		label.setForeground(Color.WHITE);
		
		//바에 들어갈 뒤로가기 버튼
		button = new JButton("<");
		button.setLocation(11, 13);
		button.setSize(50, 50);
		
		//아이디 라벨
		JLabel idlb = new JLabel("ID");
		idlb.setLocation(43, 170);
		idlb.setSize(60, 30);
		
		//아이디 입력받는 텍스트필드
		idtf = new JTextField();
		idtf.setLocation(90, 170);
		idtf.setSize(205, 30);
		
		
		//아이디 중복체크 버튼
		idbtn = new JButton("중복체크");
		idbtn.setLocation(300, 170);
		idbtn.setSize(100, 30);
		
		idbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkId(u);
			}
		});
		
		//패스워드 라벨
		JLabel pwlb = new JLabel("PW");
		pwlb.setLocation(37, 270);
		pwlb.setSize(60, 30);
		
		//패스워드 입력받는 패스워드필드
		pwpf = new JPasswordField();
		pwpf.setLocation(90, 270);
		pwpf.setSize(205, 30);
		
		
		//체크패스워드 라벨
		JLabel cpwlb = new JLabel("PW 확인");
		cpwlb.setLocation(25, 340);
		cpwlb.setSize(60, 30);
		
		//체크패스워드 입력받는 패스워드필드
		cpwpf = new JPasswordField();
		cpwpf.setLocation(90, 340);
		cpwpf.setSize(205, 30);
		
		
		
		//닉네임 라벨
		JLabel nicklb = new JLabel("닉네임");
		nicklb.setLocation(28, 440);
		nicklb.setSize(60, 30);
		
		//닉네임 입력받는 텍스트필드
		nicktf = new JTextField();
		nicktf.setLocation(90, 440);
		nicktf.setSize(205, 30);
		
		
		//닉네임 중복체크 버튼
		nickbtn = new JButton("중복체크");
		nickbtn.setLocation(300, 440);
		nickbtn.setSize(100, 30);
		nickbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkNick(u);
			}
		});
		
		
		//이메일 라벨
		JLabel emaillb = new JLabel("E-MAIL");
		emaillb.setLocation(27, 540);
		emaillb.setSize(60, 30);
		
		//이메일 입력받는 텍스트필드
		emailtf = new JTextField();
		emailtf.setLocation(90, 540);
		emailtf.setSize(205, 30);
		
		
		//이메일 인증받는 버튼
		emailbtn = new JButton("인증받기");
		emailbtn.setLocation(300, 540);
		emailbtn.setSize(100, 30);
		emailbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//m.sendEmail();
				
				
				
			}
		});
		
		//가입하기 버튼
		join = new JButton("가입하기");
		join.setLocation(150, 650);
		join.setSize(120, 50);
		
		
		//가입하기 버튼 누르면 회원가입(텍스트필드에 있는 정보들을 user.dat 파일에 저장) -> 로그인 패널로 이동
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
		
		
		
		//뒤로가기 버튼
		button.addMouseListener(new MyMouseAdapter());
		
		
	}
	
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {//뒤로가기 버튼 누르면 약관동의 패널로 이동
			if(e.getSource() == button) {
				ChangePanel.changePanel(mf, signUp, new Agree(mf));
			}
		}
	}
	
	
	
	//텍스트필드, 패스워드필드로 입력받은 값들의 텍스트를 추출하여 setter로 User 클래스의 객체u를 생성..
	public User inputUser() {
		
		
		u.setUserId(idtf.getText());
		u.setUserPw(String.valueOf(pwpf.getPassword()));
		u.setNickname(nicktf.getText());
		u.setEmail(emailtf.getText());

		return u;
	}
	
	//아이디 중복체크 & 유효성 검사
	public void checkId(User u) {
				ObjectInputStream ois = null;
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{4,12}$");
				Matcher m = p.matcher(idtf.getText());
				try {
					
					ois = new ObjectInputStream(new FileInputStream("userList.dat"));
					
					umap = (HashMap) ois.readObject();
					
					Set uset = umap.keySet();
					
					
					if(!uset.contains(idtf.getText()) && m.find() == true){
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.", "REGISTER_HELPER", JOptionPane.INFORMATION_MESSAGE);
						cid = true;
					}else if(uset.contains(idtf.getText())) {
						JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
						cid = false;
					}else if(m.find() == false) {
						JOptionPane.showMessageDialog(null, "사용할 수 없는 아이디입니다.(영문, 숫자 조합, 4~12자)", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
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
		
		
	
	

	
	
	//비밀번호 유효성 검사(영문자, 숫자, 특수문자 모두 포함하고 8~16글자 제한)
	public boolean pwPattern() {
		
		Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,16}$");
		Matcher m = p.matcher(String.valueOf(pwpf.getPassword()));
		
		return m.find();
	}
	
	//비밀번호와 비밀번호 확인이 일치하는지 검사
	public boolean checkPw() {
		
		if(String.valueOf(pwpf.getPassword()).equals(String.valueOf(cpwpf.getPassword()))) {
			return true;
		}
		
		return false;
	}
	//닉네임 중복체크
	public void checkNick(User u) {
		
		
		
		
		
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));
			
			HashMap umap = (HashMap) ois.readObject();
			
			Collection ucol = umap.values();
			
			Object[] uarr = ucol.toArray();

			for(int i = 0; i < uarr.length; i++) {
				if(nicktf.getText().equals(((User) uarr[i]).getNickname())) {
					JOptionPane.showMessageDialog(null, "존재하는 닉네임입니다.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
					cnick = false;
				}else {
					JOptionPane.showMessageDialog(null, "사용가능한 닉네임입니다.", "REGISTER_HELPER", JOptionPane.INFORMATION_MESSAGE);
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

	
	//이메일 형식이 유효한지 검사
	public boolean checkEmail() {
		
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(emailtf.getText());
		
		return m.find();
	}
	
	
	//가입하기 버튼을 눌러 가입(위의 메소드들이 true일 경우만 가능)
	//마우스클릭메소드를 쓰면 오류발생 횟수까지 중복되어 값이 저장되어 액션으로 바꿈
	public void register() {
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cid == true && pwPattern() == true && checkPw() == true && cnick == true && checkEmail() == true) {
					
					ud.writeUserList(signUp, inputUser());
					
					JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
					ChangePanel.changePanel(mf, signUp, new LoginPage(mf));
				}else if(e.getSource() != idbtn) {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(cid == false) {
					JOptionPane.showMessageDialog(null, "아이디를 다시 입력하세요.");
				}else if(pwPattern() == false) {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력하세요.(영문자, 숫자, 특수문자 조합, 8~16자)", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(cnick == false || e.getSource() != nickbtn){
					JOptionPane.showMessageDialog(null, "닉네임 중복체크를 해주세요.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(checkEmail() == false) {
					JOptionPane.showMessageDialog(null, "유효하지 않는 이메일 형식입니다.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				}else if(checkPw() == false) {
					JOptionPane.showMessageDialog(null, "입력하신 비밀번호가 일치하지 않습니다.", "REGISTER_HELPER", JOptionPane.WARNING_MESSAGE);
				
				}
				
			}

		});
			
	}



}
		
		
		
	
	
	
	
	
	
	


