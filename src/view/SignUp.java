package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JPanel{
	MainFrame mf;
	JPanel signUp;
	private JButton button;
	
	public SignUp(MainFrame mf) {
		this.mf = mf;
		this.signUp = this;
		
		this.setSize(450, 800);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 50, 56));
		panel.setLocation(0, 0);
		panel.setSize(450, 80);
		panel.setLayout(null);
		
		JLabel label = new JLabel("회원가입");
		label.setLocation(90, 27);
		label.setSize(60, 30);
		label.setForeground(Color.WHITE);
		
		button = new JButton("<");
		button.setLocation(15, 17);
		button.setSize(50, 50);
		
		
		JLabel id = new JLabel("ID");
		id.setLocation(43, 170);
		id.setSize(60, 30);
		
		JTextField id2 = new JTextField();
		id2.setLocation(90, 170);
		id2.setSize(205, 30);
		
		JButton id3 = new JButton("중복체크");
		id3.setLocation(300, 170);
		id3.setSize(100, 30);
		
		
		JLabel pw = new JLabel("PW");
		pw.setLocation(37, 270);
		pw.setSize(60, 30);
		
		JPasswordField pw2 = new JPasswordField();
		pw2.setLocation(90, 270);
		pw2.setSize(205, 30);
		
		JLabel cpw = new JLabel("PW 확인");
		cpw.setLocation(25, 340);
		cpw.setSize(60, 30);
		
		JPasswordField cpw2 = new JPasswordField();
		cpw2.setLocation(90, 340);
		cpw2.setSize(205, 30);
		
		
		JLabel nick = new JLabel("닉네임");
		nick.setLocation(28, 440);
		nick.setSize(60, 30);
		
		JTextField nick2 = new JTextField();
		nick2.setLocation(90, 440);
		nick2.setSize(205, 30);
		
		JButton nick3 = new JButton("중복체크");
		nick3.setLocation(300, 440);
		nick3.setSize(100, 30);
		
		
		JLabel email = new JLabel("E-MAIL");
		email.setLocation(27, 540);
		email.setSize(60, 30);
		
		JTextField email2 = new JTextField();
		email2.setLocation(90, 540);
		email2.setSize(205, 30);
		
		JButton email3 = new JButton("인증받기");
		email3.setLocation(300, 540);
		email3.setSize(100, 30);
		
		
		JButton join = new JButton("가입하기");
		join.setLocation(150, 650);
		join.setSize(120, 50);
		
		
		this.add(panel);
		panel.add(label);
		panel.add(button);
		
		this.add(id);
		this.add(id2);
		this.add(id3);
		
		this.add(pw);
		this.add(pw2);
		
		this.add(cpw);
		this.add(cpw2);
		
		this.add(nick);
		this.add(nick2);
		this.add(nick3);
		
		this.add(email);
		this.add(email2);
		this.add(email3);
		
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

}
