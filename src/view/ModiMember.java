//회원 정보 회원탈퇴 버튼-> 회원탈퇴로 넘어가게
//회원 정보로 패널 교체됐고 여기서 회원탈퇴로 갈 수 있도록

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
  
	 UserDao ud = new UserDao();
	
     MainFrame mf;
	 JPanel modiMember;
	 Matcher m;
	 
	private JPasswordField jpf1;
	private JPasswordField jpf2;
	private JPasswordField jpf3;
    private JTextField jtf1;
    private JTextField jtf2;
    private JTextField jtf3;
	
	private String userId = "";
	private String userPw = "";
	private String checkPw = "";
	private String nickname = "";
	private String email = "";
	
	
	
	public ModiMember(MainFrame mf) {
	
		this.mf = mf;
		this.modiMember = this;
		
		this.setBounds(0,0,445,770);
        this.setLayout(null);
		JLabel lb = new JLabel("회원정보 수정");// 회원정보수정
		lb.setBounds(120, 50, 200 ,100);
		lb.setFont(new Font("Serif", Font.BOLD, 30));  
		JLabel lb2 = new JLabel("ID");
		lb2.setBounds(60, 155, 27, 50);
		lb2.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb3 = new JLabel("현재 PW");// 현재 PW
		lb3.setBounds(26, 205, 92 ,50);
		lb3.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb4 = new JLabel("변경 PW");// 변경 PW
		lb4.setBounds(26, 255, 92 ,50);
		lb4.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb5 = new JLabel("확인 PW");// 확인 PW
		lb5.setBounds(26, 305, 92 ,50);
		lb5.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb6 = new JLabel("닉네임");// 닉네임
		lb6.setBounds(36, 355, 83 ,50);
		lb6.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb7 = new JLabel("E-MAIL");// Email
		lb7.setBounds(30, 405, 83 ,50);
		lb7.setFont(new Font("Serif", Font.BOLD, 20));

		this.add(lb);
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
	
	    
	//if(입력한 PW가 현재 PW와 같고 && 패스워드 유효성검사에 통과한다면) { //회원의 PW를 변경 PW로 변경해주는 작업도 해야한다.(덮어쓰기?)
	jbt1.addMouseListener(new MyMouseAdapter() {
		     @Override
	    	public void mouseClicked(MouseEvent e) {
		    	 char[] input = jpf2.getPassword();
		 	    String input2 = new String(input);
		 			
		 	    Pattern p = Pattern.compile("([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])");
		 	    m = p.matcher(input2);
		    	 
		 	    if(jpf1.getText().equals(ud.mar[0].getUserPw())&&
	    				jpf2.getText().equals(jpf3.getText())&&
	    				jpf2.getText().length() <= 12 &&
	    				jpf2.getText().length() >= 8  &&    //getPassword()는 값이 제대로 안 불러와져서 비교불가. . 
	    		        m.find()){ //패스워드필드에 입력한 값이 유저의 패스워드와 같고 &&
		 	    	              //변경 PW와 확인 PW이 같고 &&
		 	    	              //변경 PW이 8~12글자 사이이고
		 	    	              //특수문자와영문자를 적어도 하나씩 포함하고 있으면
	    			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다");
	    			ud.mar[0].setUserPw(input2); //입력받은 PW로 수정하기 위한 작업 이 작업이 맞으려나?
	    			//회원정보가 담긴 파일에서 패스워드를 수정해주는 작업도 해야 한다.
	   	}else if (!jpf1.getText().equals(ud.mar[0].getUserPw())) {
	   		        JOptionPane.showMessageDialog(null, "현재 PW를 정확하게 입력해주세요");
	    		}else if(!jpf2.getText().equals(jpf3.getText())) {
	    			JOptionPane.showMessageDialog(null, "변경할 PW를 정확하게 입력해주세요");
	    		}else if(jpf2.getText().length() > 12 || jpf3.getText().length() > 12
	    		|| jpf3.getText().length() < 8 || jpf3.getText().length() < 8) {
	    			JOptionPane.showMessageDialog(null, "변경할 PW는 8글자이상 12자 이하로 입력해주세요");
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "변경할 PW는 영문자와 특수문자를 적어도 하나씩 포함하고 있어야 합니다.");
	    		}
	    	
	    	 }
	    	});

	
	//}else if(입력한 PW가 현재PW와 맞지 않을 때){
	// 현재 PW를 정확하게 입력해주세요 
	//}else if(변경PW와 확인 PW가 서로 같지 않을때)     
	// 변경 PW를 정확하게 입력해주세요    
	    panel.add(jbt1);
	    
	    
	    JPanel panel2 = new JPanel();
        panel2.setLocation(0,0);  
        panel2.setSize(432,73);
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
        //이 버튼을 누르면은 메인페이지로 다시 갈 수 있게
        jbt2.addMouseListener(new MyMouseAdapter());
	   
        jtf1 = new JTextField();
       
        jtf1.setBounds(135,162,239,35);
        this.add(jtf1);
        jtf1.setEditable(false);
        //회원정보를 불러 올 수 있어야 한다. 어떤식으로 불러올지? get을 이용하긴해야할텐데.
         
        JLabel Label = new JLabel(ud.mar[0].getUserId()); 
        Label.setBounds(5,0,239,35);
        jtf1.add(Label);
        
        jpf1 = new JPasswordField();
        jpf1.setBounds(135, 212, 239, 35);
        this.add(jpf1);
        //현재PW와 jpf1에 입력한 PW가 같은지
        jpf2 = new JPasswordField();
	    jpf2.setBounds(135, 262, 239, 35);
		
	    this.add(jpf2);
	  
	    //변경PW이 유효성검사를 통과하는지
	    jpf3 = new JPasswordField();
	    jpf3.setBounds(135,312,239,35);
	    this.add(jpf3);
	    //확인PW이 변경PW와 같은지
	    jtf2 = new JTextField();
        jtf2.setBounds(135,362,239,35);
        this.add(jtf2);
        jtf2.setEditable(false);
        
        JLabel Label2 = new JLabel(ud.mar[0].getNickname());
        Label2.setBounds(5,0,239,35);
        jtf2.add(Label2);
        
        jtf3 = new JTextField();
        jtf3.setBounds(135,412,239,35);
        this.add(jtf3);
        jtf3.setEditable(false);
	    
        JLabel Label3 = new JLabel(ud.mar[0].getEmail());
        Label3.setBounds(5,0,239,35);
        jtf3.add(Label3);
        //텍스트,패스워드필드에 입력된 값들을 꺼내려면은 => 변수.getText(); 사용한다
        //각 필드들은 회원정보가 들어있는 파일을 불러와서 써야한다. 
        //그럼 JTF,TPF랑 파일 읽는 부분의 클래스가 다를텐데 그걸 어떻게 받을지?

	    JLabel label2 = new JLabel("");
	    label2.setBounds(176, 220, 62, 18);
	    this.add(label2);
	    
	    JButton jbt3 = new JButton("회원 탈퇴");
	    jbt3.setBounds(325, 700, 96, 35);
	    jbt3.setBackground(Color.LIGHT_GRAY);
	    jbt3.addMouseListener(new MyMouseAdapter2());
	    this.add(jbt3);
	}

	
//	   void insertData() {
//		      User u = new User();
//		        u.setUserId(jtf1.getText());
//		        u.setUserPw(jpf1.getText());
//		        u.setCheckPw(jpf2.getPassword());
//		        u.setNickname(jtf2.getText());
//		        u.setEmail(jtf3.getText()); // User
//		         //jtf,jpf에 입력한 정보들을 User클래스 변수에 각가 담아준 작업 한거
//		         //이것 들을 파일에 담아줄 수 있는 작업이 필요할 것 같다.
//		        //id,email,닉네임이랑 패스워드 입력하는 부분 다르게 해야할 것 같은데?
//		        //id,email,닉네임은 파일을 불러와야하는거야
             //값 안 받아질때 아래처럼 텍스트필드로 받자 
	//		 //TextField passwordText = new TextField(6);
         //passwordText.setEchoChar('*');   
//	   }
	
	 class MyMouseAdapter extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, modiMember, new MyFridge(mf));
		   }
	   }
	 class MyMouseAdapter2 extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, modiMember, new QuitMember(mf));
		   }
	   }
}
