package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.util.TreeSet;
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
	JPanel signUp;           //È¸¿ø°¡ÀÔ ÆĞ³Î
	JButton button;          //µÚ·Î°¡±â ¹öÆ°
	JButton join;            //°¡ÀÔÇÏ±â ¹öÆ°
	JTextField idtf;         //¾ÆÀÌµğ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
	JButton idbtn;           //¾ÆÀÌµğ Áßº¹Ã¼Å© ¹öÆ°
	JPasswordField pwpf;     //ÆĞ½º¿öµå ÀÔ·Â¹Ş´Â ÆĞ½º¿öµåÇÊµå
	JLabel pwlb2;            //ÆĞ½º¿öµå À¯È¿¼º °Ë»ç Ç¥½Ã ¶óº§
	JPasswordField cpwpf;    //Ã¼Å©ÆĞ½º¿öµå ÀÔ·Â¹Ş´Â ÆĞ½º¿öµåÇÊµå
	JLabel cpwlb2;           //ÆĞ½º¿öµå ÀÏÄ¡ È®ÀÎ Ç¥½Ã ¶óº§
	JTextField nicktf;       //´Ğ³×ÀÓ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
	JButton nickbtn;         //´Ğ³×ÀÓ Áßº¹Ã¼Å© ¹öÆ°
	JTextField emailtf;      //ÀÌ¸ŞÀÏ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
	JButton emailbtn;        //ÀÌ¸ŞÀÏ ÀÎÁõ¹Ş±â ¹öÆ°
	JTextField numtf;        //ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
	JButton numbtn;          //ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£ Ã¼Å© ¹öÆ°
	
	User u = new User();
	UserDao ud = new UserDao();  //ÆÄÀÏÀÔÃâ·Â ¸Ş¼Òµå ¼ÒÈ¯À» À§ÇÑ °´Ã¼ »ı¼º
	HashMap<String, User> umap = null;
	
	boolean cid = false;         //¾ÆÀÌµğ Áßº¹È®ÀÎ¿¡ ¾²ÀÏ °ª
	boolean cnick = false;       //´Ğ³×ÀÓ Áßº¹È®ÀÎ¿¡ ¾²ÀÏ °ª
	boolean cn = false;          //ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£ È®ÀÎ¿¡ ¾²ÀÏ °ª
	
	String str = null;           //int¹è¿­ÀÎ ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£¸¦ String Å¸ÀÔÀ¸·Î º¯È¯ÇÏ¿© ÀúÀåÇÒ º¯¼ö
	
	public SignUp() {}       //±âº» »ı¼ºÀÚ 
	
	public SignUp(MainFrame mf) {
		this.mf = mf;
		this.signUp = this;
		
		this.setSize(445, 770);
		this.setLayout(null);
		
		//¹Ù 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setLocation(0, 0);
		panel.setSize(445, 70);
		panel.setLayout(null);
		
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 27);
	    Font font2 = new Font("¸¼Àº °íµñ", Font.BOLD, 20);
		
		//¹Ù¿¡ µé¾î°¥ Á¦¸ñ
		JLabel label = new JLabel("È¸¿ø°¡ÀÔ");
		label.setLocation(80, 10);
		label.setSize(200, 50);
		label.setForeground(Color.WHITE);
		label.setFont(font);
		
		//¹Ù¿¡ µé¾î°¥ µÚ·Î°¡±â ¹öÆ°
		Image backImg = new ImageIcon("images/back sky.PNG").getImage().getScaledInstance(50, 50, 0);
		button = new JButton(new ImageIcon(backImg));
		button.setLocation(10, 10);
		button.setSize(50, 50);
		
		
		//¾ÆÀÌµğ ¶óº§
		JLabel idlb = new JLabel("ID");
		idlb.setLocation(43, 120);
		idlb.setSize(60, 30);
		
		//¾ÆÀÌµğ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
		idtf = new JTextField();
		idtf.setLocation(90, 120);
		idtf.setSize(210, 30);
		
		
		//¾ÆÀÌµğ Áßº¹Ã¼Å© ¹öÆ°
		idbtn = new JButton("Áßº¹Ã¼Å©");
		idbtn.setLocation(310, 120);
		idbtn.setSize(100, 30);
		
		idbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkId(u);
			}
		});
		
		//ÆĞ½º¿öµå ¶óº§
		JLabel pwlb = new JLabel("PW");
		pwlb.setLocation(37, 220);
		pwlb.setSize(60, 30);
		
		//ÆĞ½º¿öµå ÀÔ·Â¹Ş´Â ÆĞ½º¿öµåÇÊµå
		pwpf = new JPasswordField();
		pwpf.setLocation(90, 220);
		pwpf.setSize(210, 30);
		pwpf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//pwPattern2();
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				pwPattern2();
				checkPw2();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//pwPattern2();
				
			}
		});
		
		pwlb2 = new JLabel("");
		pwlb2.setLocation(90, 255);
		pwlb2.setSize(340, 15);
		pwlb2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		
		
		//Ã¼Å©ÆĞ½º¿öµå ¶óº§
		JLabel cpwlb = new JLabel("PW È®ÀÎ");
		cpwlb.setLocation(25, 290);
		cpwlb.setSize(60, 30);
		
		//Ã¼Å©ÆĞ½º¿öµå ÀÔ·Â¹Ş´Â ÆĞ½º¿öµåÇÊµå
		cpwpf = new JPasswordField();
		cpwpf.setLocation(90, 290);
		cpwpf.setSize(210, 30);
		cpwpf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//checkPw2();
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkPw2();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//checkPw2();
				
			}
		});
		
		cpwlb2 = new JLabel("");
		cpwlb2.setLocation(90, 325);
		cpwlb2.setSize(340, 15);
		cpwlb2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		
		//´Ğ³×ÀÓ ¶óº§
		JLabel nicklb = new JLabel("´Ğ³×ÀÓ");
		nicklb.setLocation(28, 390);
		nicklb.setSize(60, 30);
		
		//´Ğ³×ÀÓ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
		nicktf = new JTextField();
		nicktf.setLocation(90, 390);
		nicktf.setSize(210, 30);
		
		
		//´Ğ³×ÀÓ Áßº¹Ã¼Å© ¹öÆ°
		nickbtn = new JButton("Áßº¹Ã¼Å©");
		nickbtn.setLocation(310, 390);
		nickbtn.setSize(100, 30);
		nickbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkNick(u);
			}
		});
		
		
		//ÀÌ¸ŞÀÏ ¶óº§
		JLabel emaillb = new JLabel("E-MAIL");
		emaillb.setLocation(27, 490);
		emaillb.setSize(60, 30);
		
		//ÀÌ¸ŞÀÏ ÀÔ·Â¹Ş´Â ÅØ½ºÆ®ÇÊµå
		emailtf = new JTextField();
		emailtf.setLocation(90, 490);
		emailtf.setSize(210, 30);
		
		
		//ÀÌ¸ŞÀÏ ÀÎÁõ¹Ş´Â ¹öÆ°
		emailbtn = new JButton("ÀÎÁõ¹Ş±â");
		emailbtn.setLocation(310, 490);
		emailbtn.setSize(100, 30);
		
		//ÀÎÁõ¹Ş±â ¹öÆ°À» ´©¸£¸é ÀÌ¸ŞÀÏ À¯È¿¼º °Ë»çÇÏ¿© Çü½ÄÀÌ ¸ÂÀ¸¸é ÀÌ¸ŞÀÏÀÌ ¹ß¼Û µÆ´Ù´Â ÆË¾÷Ã¢ÀÌ ¶ß°í, ¾Æ´Ï¸é Çü½ÄÀÌ ¿Ã¹Ù¸£Áö ¾Ê´Ù°í ÆË¾÷Ã¢ÀÌ ¶á´Ù.
		emailbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(emailtf.getText());
				
				if(m.find() == true) {
					JOptionPane.showMessageDialog(null, "ÀÌ¸ŞÀÏÀÌ ¹ß¼ÛµÇ¾ú½À´Ï´Ù.", "CHECK_EMAIL", JOptionPane.INFORMATION_MESSAGE);
					sendEmail();
				}else {
					JOptionPane.showMessageDialog(null, "ÀÌ¸ŞÀÏ Çü½ÄÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù.", "CHECK_EMAIL", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		
		//ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£ È®ÀÎ
		JLabel numlb = new JLabel("ÀÎÁõ¹øÈ£");
		numlb.setLocation(25, 560);
		numlb.setSize(60, 30);
		
		numtf = new JTextField();
		numtf.setLocation(90, 560);
		numtf.setSize(210, 30);
		
		numbtn = new JButton("ÀÎÁõÈ®ÀÎ");
		numbtn.setLocation(310, 560);
		numbtn.setSize(100, 30);
		numbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkNum();
				
			}
		});
		
		
		
		
		
		//°¡ÀÔÇÏ±â ¹öÆ°
		join = new JButton("°¡ÀÔÇÏ±â");
		join.setLocation(150, 660);
		join.setSize(120, 50);
		
		
		//°¡ÀÔÇÏ±â ¹öÆ° ´©¸£¸é È¸¿ø°¡ÀÔ(ÅØ½ºÆ®ÇÊµå¿¡ ÀÖ´Â Á¤º¸µéÀ» user.dat ÆÄÀÏ¿¡ ÀúÀå) -> ·Î±×ÀÎ ÆĞ³Î·Î ÀÌµ¿
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		this.add(pwlb2);
		
		this.add(cpwlb);
		this.add(cpwpf);
		this.add(cpwlb2);
		
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
		
		
		
		//µÚ·Î°¡±â ¹öÆ°
		button.addMouseListener(new MyMouseAdapter());
		
		
	}
	
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseReleased(MouseEvent e) {//µÚ·Î°¡±â ¹öÆ° ´©¸£¸é ¾à°üµ¿ÀÇ ÆĞ³Î·Î ÀÌµ¿
			if(e.getSource() == button) {
				ChangePanel.changePanel(mf, signUp, new Agree(mf));
			}
		}
	}
	
	
	
	//ÅØ½ºÆ®ÇÊµå, ÆĞ½º¿öµåÇÊµå·Î ÀÔ·Â¹ŞÀº °ªµéÀÇ ÅØ½ºÆ®¸¦ ÃßÃâÇÏ¿© setter·Î User Å¬·¡½ºÀÇ °´Ã¼u¸¦ »ı¼º..
	public User inputUser() {
		
		u.setUserId(idtf.getText());
		u.setUserPw(String.valueOf(pwpf.getPassword()));
		u.setNickname(nicktf.getText());
		u.setEmail(emailtf.getText());
		
		TreeSet ts = new TreeSet();
		ts.add(9999);
		u.setUserIngred(ts);
	
		return u;
	}
	
	
	//¾ÆÀÌµğ Áßº¹Ã¼Å© & À¯È¿¼º °Ë»ç
	public void checkId(User u) {
				ObjectInputStream ois = null;
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{4,12}$");
				Matcher m = p.matcher(idtf.getText());
				try {
					
					ois = new ObjectInputStream(new FileInputStream("userList.dat"));
					
					//System.out.println("ois.readObject() : " + ois.readObject());
					umap = (HashMap) ois.readObject();
					
					Set uset = umap.keySet();
					
					
					if(!uset.contains(idtf.getText()) && m.find() == true){
						JOptionPane.showMessageDialog(null, "»ç¿ë °¡´ÉÇÑ ¾ÆÀÌµğÀÔ´Ï´Ù.", "CHECK_ID", JOptionPane.INFORMATION_MESSAGE);
						cid = true;
					}else if(uset.contains(idtf.getText())) {
						JOptionPane.showMessageDialog(null, "Á¸ÀçÇÏ´Â ¾ÆÀÌµğÀÔ´Ï´Ù.", "CHECK_ID", JOptionPane.ERROR_MESSAGE);
						cid = false;
					}else if(m.find() == false) {
						JOptionPane.showMessageDialog(null, "»ç¿ëÇÒ ¼ö ¾ø´Â ¾ÆÀÌµğÀÔ´Ï´Ù.(¿µ¹®, ¼ıÀÚ Á¶ÇÕ, 4~12ÀÚ)", "CHECK_ID", JOptionPane.ERROR_MESSAGE);
						cid = false;
					}
				
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "»ç¿ë °¡´ÉÇÑ ¾ÆÀÌµğÀÔ´Ï´Ù.", "CHECK_ID", JOptionPane.INFORMATION_MESSAGE);
					cid = true;
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
		
	
	//ºñ¹Ğ¹øÈ£ À¯È¿¼º °Ë»ç(¿µ¹®ÀÚ, ¼ıÀÚ, Æ¯¼ö¹®ÀÚ ¸ğµÎ Æ÷ÇÔÇÏ°í 8~16±ÛÀÚ Á¦ÇÑ)
	public boolean pwPattern() {
		
		Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,16}$");
		Matcher m = p.matcher(String.valueOf(pwpf.getPassword()));
		
		return m.find();
	}
	
	//ºñ¹Ğ¹ø·Î À¯È¿¼º °Ë»ç¿¡ µû¸¥ ¶óº§ Ç¥½Ã
	public void pwPattern2() {
		if(pwPattern() == true) {
			pwlb2.setText("»ç¿ë°¡´ÉÇÑ ºñ¹Ğ¹øÈ£ÀÔ´Ï´Ù.");
		}else {
			pwlb2.setText("»ç¿ëºÒ°¡ÇÑ ºñ¹Ğ¹øÈ£ÀÔ´Ï´Ù.(¿µ¹®ÀÚ, ¼ıÀÚ, Æ¯¼ö¹®ÀÚ Á¶ÇÕ 8~16±ÛÀÚ)");
		}
	}
	
	//ºñ¹Ğ¹øÈ£¿Í ºñ¹Ğ¹øÈ£ È®ÀÎÀÌ ÀÏÄ¡ÇÏ´ÂÁö °Ë»ç
	public boolean checkPw() {
		
		if(String.valueOf(pwpf.getPassword()).equals(String.valueOf(cpwpf.getPassword()))) {
			return true;
		}
		
		return false;
	}
	
	//ºñ¹Ğ¹øÈ£ ÀÏÄ¡ ¿©ºÎ¿¡ µû¸¥ ¶óº§ Ç¥½Ã
	public void checkPw2() {
		if(checkPw() == true) {
			cpwlb2.setText("ºñ¹Ğ¹øÈ£°¡ ÀÏÄ¡ÇÕ´Ï´Ù.");
		}else {
			cpwlb2.setText("ºñ¹Ğ¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");	
		}
	}
	
	//´Ğ³×ÀÓ Áßº¹Ã¼Å©
	public void checkNick(User u) {
		
		ObjectInputStream ois = null;
		Pattern p = Pattern.compile("^[a-zA-Z°¡-ÆR0-9]{2,10}$");
		Matcher m = p.matcher(nicktf.getText());
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));
			
			HashMap umap = (HashMap) ois.readObject();
			
			Collection ucol = umap.values();
			
			Object[] uarr = ucol.toArray();

			if(m.find() == false) {
				JOptionPane.showMessageDialog(null, "»ç¿ëÇÒ ¼ö ¾ø´Â ´Ğ³×ÀÓÀÔ´Ï´Ù.(ÇÑ±Û, ¿µ¹®, ¼ıÀÚ¸¸ °¡´É 2~10ÀÚ)",
						"CHECK_NICKNAME", JOptionPane.ERROR_MESSAGE);
				cnick = false;
				return;
			}
			
			for(int i = 0; i < uarr.length; i++) {
				if(nicktf.getText().trim().equals(((User) uarr[i]).getNickname())) {
					JOptionPane.showMessageDialog(null, "Á¸ÀçÇÏ´Â ´Ğ³×ÀÓÀÔ´Ï´Ù.", "CHECK_NICKNAME", JOptionPane.ERROR_MESSAGE);
					cnick = false;
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "»ç¿ë°¡´ÉÇÑ ´Ğ³×ÀÓÀÔ´Ï´Ù.", "CHECK_NICKNAME", JOptionPane.INFORMATION_MESSAGE);
			cnick = true;
			
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "»ç¿ë °¡´ÉÇÑ ´Ğ³×ÀÓÀÔ´Ï´Ù.", "CHECK_NICKNAME", JOptionPane.INFORMATION_MESSAGE);
			cnick = true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	//ÀÌ¸ŞÀÏ Çü½ÄÀÌ À¯È¿ÇÑÁö °Ë»ç
	public boolean checkEmail() {
		
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(emailtf.getText());
		
		return m.find();
		
	}
	
	//ÀÌ¸ŞÀÏ º¸³»±â
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
			
			//¼ö½ÅÀÚ ¸ŞÀÏÁÖ¼Ò
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(emailtf.getText()));
			
			//¸ŞÀÏ Á¦¸ñ
			m.setSubject("java.nang ÀÎÁõ¹øÈ£");
			
			//ÀÎÁõ¹øÈ£¸¦ À§ÇÑ ³­¼ö ¹ß»ı½ÃÄÑ int¹è¿­·Î ¹Ş±â
			int[] arr = new int[4];
			arr[0] = (int) (Math.random() * 10);
			arr[1] = (int) (Math.random() * 10);
			arr[2] = (int) (Math.random() * 10);
			arr[3] = (int) (Math.random() * 10);
			
			//int¹è¿­À» StringÀ¸·Î º¯È¯ÇÏ±â
			str = Arrays.toString(arr).replaceAll("[^0-9]", "");
			System.out.println(str);
			
			//¸ŞÀÏ ³»¿ë
			m.setText("¾È³çÇÏ¼¼¿ä java.nangÀÔ´Ï´Ù.\n ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£ : " + str);
			
			
			//ÀÌ¸ŞÀÏ Àü¼Û
			Transport.send(m); 
			System.out.println("¸ŞÀÏ ¹ß¼Û ¿Ï·á");
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	//ÀÌ¸ŞÀÏ ÀÎÁõ¹øÈ£ È®ÀÎ
	public void checkNum() {
		if(numtf.getText().equals(str)) {
			JOptionPane.showMessageDialog(null, "ÀÌ¸ŞÀÏÀÌ ÀÎÁõµÇ¾ú½À´Ï´Ù.", "CHECK_EMAIL", JOptionPane.INFORMATION_MESSAGE);
			cn = true;
			return;
		}
		JOptionPane.showMessageDialog(null, "ÀÎÁõ¹øÈ£°¡ Æ²¸³´Ï´Ù.", "CHECK_EMAIL", JOptionPane.ERROR_MESSAGE);
		cn = false;
	}


	
	//°¡ÀÔÇÏ±â ¹öÆ°À» ´­·¯ °¡ÀÔ(À§ÀÇ ¸Ş¼ÒµåµéÀÌ trueÀÏ °æ¿ì¸¸ °¡´É)
	public void register() {
		if(pwPattern() == true && checkPw() == true && cid == true && cnick == true && cn == true) {

			ud.writeUserList(signUp, inputUser());

			JOptionPane.showMessageDialog(null, "°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
			ChangePanel.changePanel(mf, signUp, new LoginPage(mf));

		}else if(pwPattern() == false) {
			JOptionPane.showMessageDialog(null, "ºñ¹Ğ¹øÈ£¸¦ ´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä.(¿µ¹®ÀÚ, ¼ıÀÚ, Æ¯¼ö¹®ÀÚ Á¶ÇÕ, 8~16ÀÚ)", "CHECK_PASSWORD", JOptionPane.ERROR_MESSAGE);
		}else if(checkPw() == false) {
			JOptionPane.showMessageDialog(null, "ÀÔ·ÂÇÏ½Å ºñ¹Ğ¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.", "CHECK_PASSWORD", JOptionPane.ERROR_MESSAGE);
		}else if(cid == false) {
			JOptionPane.showMessageDialog(null, "¾ÆÀÌµğ Áßº¹Ã¼Å©¸¦ ÇØÁÖ¼¼¿ä.", "CHECK_ID", JOptionPane.ERROR_MESSAGE);
		}else if(cnick == false){
			JOptionPane.showMessageDialog(null, "´Ğ³×ÀÓ Áßº¹Ã¼Å©¸¦ ÇØÁÖ¼¼¿ä.", "CHECK_NICKNAME", JOptionPane.ERROR_MESSAGE);
		}else if(cn == false ) {
			JOptionPane.showMessageDialog(null, "ÀÌ¸ŞÀÏ ÀÎÁõÀ» ÇØÁÖ¼¼¿ä.", "CHECK_EMAIL", JOptionPane.ERROR_MESSAGE);
		}
	}



}



