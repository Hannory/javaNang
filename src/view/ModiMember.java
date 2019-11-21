package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.vo.User;
import model.dao.UserDao;
import view.MainMenu.MyMouseAdapter5;

public class ModiMember extends JPanel{

	MainFrame mf;
	JPanel modiMember;
	
	private JPasswordField jpf1;
	private JPasswordField jpf2;
	private JPasswordField jpf3;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;

	public ModiMember(MainFrame mf) {

		this.mf = mf;
		this.modiMember = this;

		String id = AllRecipe.loginId; //로그인한 id값을 사용하기 위해

		this.setBounds(0,0,445,770);
		this.setLayout(null);
		JLabel lb1 = new JLabel("회원정보 수정");
		lb1.setBounds(120, 50, 200 ,100);
		lb1.setFont(new Font("Serif", Font.BOLD, 30));  
		JLabel lb2 = new JLabel("ID");
		lb2.setBounds(60, 155, 27, 50);
		lb2.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb3 = new JLabel("현재 PW");
		lb3.setBounds(26, 205, 92 ,50);
		lb3.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb4 = new JLabel("변경 PW");
		lb4.setBounds(26, 255, 92 ,50);
		lb4.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb5 = new JLabel("확인 PW");
		lb5.setBounds(26, 305, 92 ,50);
		lb5.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb6 = new JLabel("닉네임");
		lb6.setBounds(36, 355, 83 ,50);
		lb6.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb7 = new JLabel("E-MAIL");
		lb7.setBounds(30, 405, 83 ,50);
		lb7.setFont(new Font("Serif", Font.BOLD, 20));

		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
		this.add(lb4);
		this.add(lb5);
		this.add(lb6);
		this.add(lb7);



		JPanel panel = new JPanel();
		panel.setSize(90,50);
		panel.setLocation(191,570);
		panel.setLayout(null);
		panel.setBackground(Color.orange);

		this.add(panel);

		JButton jbt1 = new JButton("확인");
		jbt1.setBounds(0,0,90,50);	    	    
		jbt1.setForeground(Color.white);
		jbt1.setBackground(Color.orange);


		jbt1.addMouseListener(new MyMouseAdapter() {


			@Override        
			public void mouseClicked(MouseEvent e) { 

				char[] input = jpf2.getPassword();
				String input2 = new String(input);

				String JPF1 = String.valueOf(jpf1.getPassword());
				String JPF2 = String.valueOf(jpf2.getPassword());
				String JPF3 = String.valueOf(jpf3.getPassword()); //PasswordField를 String형으로 변환(문자열비교를 위해)

				Pattern p = Pattern.compile("([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])");
				Matcher m = p.matcher(input2);        //문자+특수문자or특수문자+문자의 조합으로 생성될 수 있도록

				HashMap asds = new HashMap();

				try {

					ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("userList.dat"));
					//    
					try {
						asds = (HashMap) objIn.readObject(); //Object형이니까 ->HashMap으로 받아야

						User u1 = (User) asds.get(id);//키가 id인 해쉬맵을 u1에 담았다. 

						//if(입력한 PW가 현재 PW와 같고 && 패스워드 유효성검사에 통과한다면)
						if(JPF1.equals(u1.getUserPw()) && //jpf1.getPassword()는 값이 문자열이 아니라 비교 불가
								JPF2.equals(JPF3) &&
								JPF2.length() <= 16 &&
								JPF2.length() >= 8  &&    
								m.find()){ //패스워드 필드에 입력한 값이 유저의 패스워드와 같고 &&
							//변경 PW와 확인 PW이 같고 &&
							//변경 PW이 8~16글자 사이이고
							//특수문자와영문자를 적어도 하나씩 포함하고 있으면

							//여기서 변경한 PW(JPF2orJPF3)로 로그인 한 유저의 PW(u1.getUserPw)를 변경해줘야 한다
							u1.setUserPw(JPF2); //이 변경한 Pw를 다시 oosOut파일에 적어야 함
							asds.put(id, u1); 
                            //oosOut파일에 넣기 위해서 해쉬맵 asds에 덮어쓰기형식으로 u1을 다시 넣었다.
							
							//System.out.println("변경한 PW : " + u1.getUserPw());
                            
							JOptionPane.showMessageDialog(null, "수정이 완료되었습니다. 다시 로그인 해주세요.");

							ChangePanel.changePanel(mf, modiMember, new LoginPage(mf));
						}else if (!JPF1.equals(u1.getUserPw())) {
							JOptionPane.showMessageDialog(null, "현재 PW를 정확하게 입력해주세요");
						}else if(!JPF2.equals(JPF3)) {
							JOptionPane.showMessageDialog(null, "변경할 PW를 정확하게 입력해주세요");
						}else if(JPF2.length() > 16 || JPF3.length() > 16
								|| JPF3.length() < 8 || JPF3.length() < 8) {
							JOptionPane.showMessageDialog(null, "변경할 PW는 8글자이상 16자 이하로 입력해주세요");
						}
						else {
							JOptionPane.showMessageDialog(null, "변경할 PW는 영문자와 특수문자를 적어도 하나씩 포함하고 있어야 합니다.");
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					ObjectOutputStream oosOut = new ObjectOutputStream(new FileOutputStream("userList.dat"));
					oosOut.writeObject(asds); //PW를 수정한 회원의 정보를 다시 파일에 저장하기
					oosOut.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		panel.add(jbt1);

		JPanel panel2 = new JPanel();
		panel2.setLocation(0,0);  
		panel2.setSize(445,73);
		panel2.setLayout(null);
		panel2.setBackground(new Color(100, 149, 237));
		this.add(panel2);


		JLabel label = new JLabel("회원정보 수정");
		label.setFont(new Font("Serif", Font.BOLD, 20)); 
		label.setForeground(Color.WHITE);
		label.setBounds(64, 25, 150, 26);
		panel2.add(label);

		JButton jbt2 = new JButton("←");
		jbt2.setBounds(14,25,50,27);
		panel2.add(jbt2);
		jbt2.addMouseListener(new MyMouseAdapter());

		jtf1 = new JTextField();

		jtf1.setBounds(135,162,239,35);
		this.add(jtf1);
		jtf1.setEditable(false);

		JLabel Label = new JLabel(id); //static 선언했던 로그인한 사용자의 id 
		Label.setBounds(5,0,239,35);
		jtf1.add(Label);

		jpf1 = new JPasswordField();
		jpf1.setBounds(135, 212, 239, 35);
		this.add(jpf1);

		jpf2 = new JPasswordField();
		jpf2.setBounds(135, 262, 239, 35);
		this.add(jpf2);

		jpf3 = new JPasswordField();
		jpf3.setBounds(135,312,239,35);
		this.add(jpf3);
		
		try {

			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("userList.dat"));
                      
			try {
				HashMap asds = (HashMap) objIn.readObject();

				User u1 = (User) asds.get(id);//키가 id인 해쉬맵을 u1에 담았다. 

				JLabel Label2 = new JLabel(u1.getNickname()); //로그인한 유저의 닉네임
				Label2.setBounds(5,0,239,35);
				
				jtf2 = new JTextField();
				jtf2.setBounds(135,362,239,35);
				this.add(jtf2);
				jtf2.setEditable(false); // 닉네임 변경 불가
				jtf2.add(Label2);
       
				jtf3 = new JTextField();
				jtf3.setBounds(135,412,239,35);
				this.add(jtf3);
				jtf3.setEditable(false); //이메일 변경 불가

				JLabel Label3 = new JLabel(u1.getEmail()); //로그인한 유저의 이메일
				Label3.setBounds(5,0,239,35);
				jtf3.add(Label3);
				//각 필드들은 회원정보가 들어있는 파일을 불러와서 써야한다. 
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel label2 = new JLabel("");
		label2.setBounds(176, 220, 62, 18);
		this.add(label2);

		JButton jbt3 = new JButton("회원 탈퇴");
		jbt3.setBounds(325, 700, 96, 35);
		jbt3.setBackground(Color.LIGHT_GRAY);
		jbt3.addMouseListener(new MyMouseAdapter2());
		this.add(jbt3);
	}

	//값 안 받아질때 아래처럼 텍스트필드로 받자 
	//TextField passwordText = new TextField(6);
	//passwordText.setEchoChar('*'); 안정성떨어질거같음   
	
	class MyMouseAdapter extends MouseAdapter{//My냉장고로 돌아가기
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, modiMember, new MyFridge(mf));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter{//회원탈퇴로
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, modiMember, new QuitMember(mf));
		}
	}
}
