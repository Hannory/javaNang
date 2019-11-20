package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dao.UserDao;
import model.vo.User;

public class LoginPage extends JPanel {
	
	MainFrame mf;
	JPanel lp;
	private JTextField idField;
	private JTextField pwField;


	
	public LoginPage(MainFrame mf) {
		
		
		this.mf = mf;
		this.lp = this;
		
		this.setSize(445,770);
		this.setBackground(Color.white);
		setLayout(null);
		
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
		
		JButton backBtn = new JButton("<-");
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.BLACK);
		backBtn.setBounds(14, 49, 74, 27);
		add(backBtn);
		
		
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, lp, new AllRecipe(mf, lp));
				
			}
			
			
		});
		
		
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			try {
				ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("userList.dat"));
				
				try {
					HashMap asds = (HashMap) objIn.readObject();
					
					
					String idd = idField.getText();
					
					User u1 = (User) asds.get(idd);
					
					if(pwField.getText().equals(u1.getUserPw())) {
						
						ChangePanel.changePanel(mf, lp, new MainMenu(mf));
						
						AllRecipe.login =  true;
						
						AllRecipe.loginId = idField.getText();
						
						
					}else {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인 후\n다시 로그인해주세요.");
						AllRecipe.login  = false;
					}
					
					
				  
				  
				  
				  
					
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
				
			}
		});
		
		
		signUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, lp, new Agree(mf));
			}
		});
		
		
		
		
		}
}
