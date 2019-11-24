package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.ObjIntConsumer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.vo.Recipe;
import model.vo.User;
import view.manager.MainPage;

public class LoginPage extends JPanel {

	MainFrame mf;
	JPanel lp;
	private JTextField idField;
	private JTextField pwField;
	public static TreeSet ingredStatic = new TreeSet();	


	public LoginPage(MainFrame mf) {


		this.mf = mf;
		this.lp = this;

		this.setSize(445,770);
		this.setBackground(Color.white);
		setLayout(null);

		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(445, 70);
		bar.setLayout(null);
		bar.setBackground(new Color(102, 204, 204));
		bar.setLayout(null);
		add(bar);


		JLabel label = new JLabel("로그인");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.white);
		label.setBounds(70, 18, 146, 39);
		bar.add(label);

		JLabel logo = new JLabel(new ImageIcon(new ImageIcon("images/won/java.PNG").getImage().getScaledInstance(130, 100, 0)));
		logo.setBounds(140, 101, 150, 180);
		add(logo);


		JLabel idlb = new JLabel("ID");
		idlb.setBounds(63, 301, 62, 18);
		add(idlb);

		JLabel pwlb = new JLabel("PW");
		pwlb.setBounds(63, 366, 62, 18);
		add(pwlb);

		idField = new JTextField();
		idField.setBounds(151, 294, 171, 32);
		add(idField);
		idField.setColumns(10);

		pwField = new JPasswordField();
		pwField.setColumns(10);
		pwField.setBounds(151, 359, 171, 32);
		add(pwField);

		JButton loginBtn = new JButton("로그인");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(Color.GRAY);
		loginBtn.setBounds(151, 525, 150, 40);
		loginBtn.setBorderPainted(false);
		add(loginBtn);


		JButton signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(151, 605, 150, 40);
		//외각선 없애주기
		signUpBtn.setBorderPainted(false);
		signUpBtn.setFocusPainted(false);
		add(signUpBtn);

		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50,  50,  0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10, 10);
		back.setSize(50, 50);
		bar.add(back);

		back.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, lp, new AllRecipe(mf, lp));

			}


		});


		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				ObjectInputStream objIn = null;

				try {
					objIn = new ObjectInputStream(new FileInputStream("userList.dat"));

					//해쉬맵으로 읽어온 객체를 형변환해줌
					HashMap map = (HashMap) objIn.readObject();

					String id = idField.getText();

					User u1 = (User) map.get(id);
					
					/*if(idField.getText() != map.get(id)) {
						System.out.println("아이디트림");
					}*/
					
					 if (map.containsKey(id) &&/*idField.getText().equals(map.get(id))*/ pwField.getText().equals(u1.getUserPw())) {
						 
						 if(!id.equals("manager")) {
							 ChangePanel.changePanel(mf, lp, new MainMenu(mf));
							 
							 AllRecipe.login =  true;
							 
							 AllRecipe.loginId = idField.getText();
							 
							 TreeSet ts = (TreeSet) u1.getUserIngred().clone();
							 System.out.println(ts);
							 ingredStatic = ts;
							 
						 }else {
							 ChangePanel.changePanel(mf, lp, new MainPage(mf));

							 AllRecipe.login =  true;

							 AllRecipe.loginId = idField.getText();

							 TreeSet ts = (TreeSet) u1.getUserIngred().clone();
							 System.out.println(ts);
							 ingredStatic = ts;
						 }
						 	

					}else if(!map.containsKey(id)||pwField.getText() != u1.getUserPw()) {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인 후\n다시 로그인해주세요.");
						AllRecipe.login  = false;
						System.out.println("아이디비밀번호틀림");
					}
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}finally {
					try {
						objIn.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				
			}
		});
		signUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, lp, new Agree(mf));
			}
		});

	}
}
