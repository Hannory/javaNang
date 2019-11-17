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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.MainMenu.MyMouseAdapter5;

public class ModiMember extends JPanel{

	 MainFrame mf;
	 JPanel modiMember;
	 
	private JPasswordField jpf1;
	private JPasswordField jpf2;
	private JPasswordField jpf3;

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
	    Dialog sd = new Dialog(mf, "수정 완료");
	    sd.setBounds(100,100,200,100);
	    JButton jbt11 = new JButton("확인");
	    jbt11.setSize(50,50);
	    sd.add(jbt11);
	    panel.add(jbt1);
	    //비밀번호 확인해서 비밀번호 맞으면 변경 완료
	    //비밀번호 확인해서 비밀번호 맞지않으면 
        jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                         sd.setVisible(true);				
			}
		});
		
		jbt11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                         sd.dispose();        //닫기 눌렀을때 닫히게
                                              //쓸 일이 좀 있을거다
			}
		});
	    
	    
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
	   
        JTextField jtf1 = new JTextField();
        jtf1.setBounds(135,162,239,35);
        this.add(jtf1);
        jtf1.setEditable(false);
        
        jpf1 = new JPasswordField();
        jpf1.setBounds(135, 212, 239, 35);
        this.add(jpf1);

        jpf2 = new JPasswordField();
	    jpf2.setBounds(135, 262, 239, 35);
	    this.add(jpf2);
	    
	    jpf3 = new JPasswordField();
	    jpf3.setBounds(135,312,239,35);
	    this.add(jpf3);
	    
	    
	    JTextField jtf2 = new JTextField();
        jtf2.setBounds(135,362,239,35);
        this.add(jtf2);
        jtf2.setEditable(false);
        
        JTextField jtf3 = new JTextField();
        jtf3.setBounds(135,412,239,35);
        this.add(jtf3);
        jtf3.setEditable(false);
	    
	    
	    JLabel label2 = new JLabel("");
	    label2.setBounds(176, 220, 62, 18);
	    this.add(label2);
	    
	    JButton jbt3 = new JButton("회원 탈퇴");
	    jbt3.setBounds(325, 700, 96, 35);
	    jbt3.setBackground(Color.LIGHT_GRAY);
	    jbt3.addMouseListener(new MyMouseAdapter2());
	    this.add(jbt3);
	
	}
	
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
