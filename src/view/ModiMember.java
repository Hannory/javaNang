//ȸ�� ���� ȸ��Ż�� ��ư-> ȸ��Ż��� �Ѿ��
//ȸ�� ������ �г� ��ü�ư� ���⼭ ȸ��Ż��� �� �� �ֵ���

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
		JLabel lb = new JLabel("ȸ������ ����");// ȸ����������
		lb.setBounds(120, 50, 200 ,100);
		lb.setFont(new Font("Serif", Font.BOLD, 30));  
		JLabel lb2 = new JLabel("ID");
		lb2.setBounds(60, 155, 27, 50);
		lb2.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb3 = new JLabel("���� PW");// ���� PW
		lb3.setBounds(26, 205, 92 ,50);
		lb3.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb4 = new JLabel("���� PW");// ���� PW
		lb4.setBounds(26, 255, 92 ,50);
		lb4.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb5 = new JLabel("Ȯ�� PW");// Ȯ�� PW
		lb5.setBounds(26, 305, 92 ,50);
		lb5.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb6 = new JLabel("�г���");// �г���
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
	    
	    JButton jbt1 = new JButton("Ȯ��");
	    jbt1.setBounds(0,0,90,50);	    	    
	    jbt1.setForeground(Color.white);
	    jbt1.setBackground(Color.orange);
	
	    
	//if(�Է��� PW�� ���� PW�� ���� && �н����� ��ȿ���˻翡 ����Ѵٸ�) { //ȸ���� PW�� ���� PW�� �������ִ� �۾��� �ؾ��Ѵ�.(�����?)
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
	    				jpf2.getText().length() >= 8  &&    //getPassword()�� ���� ����� �� �ҷ������� �񱳺Ұ�. . 
	    		        m.find()){ //�н������ʵ忡 �Է��� ���� ������ �н������ ���� &&
		 	    	              //���� PW�� Ȯ�� PW�� ���� &&
		 	    	              //���� PW�� 8~12���� �����̰�
		 	    	              //Ư�����ڿͿ����ڸ� ��� �ϳ��� �����ϰ� ������
	    			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
	    			ud.mar[0].setUserPw(input2); //�Է¹��� PW�� �����ϱ� ���� �۾� �� �۾��� ��������?
	    			//ȸ�������� ��� ���Ͽ��� �н����带 �������ִ� �۾��� �ؾ� �Ѵ�.
	   	}else if (!jpf1.getText().equals(ud.mar[0].getUserPw())) {
	   		        JOptionPane.showMessageDialog(null, "���� PW�� ��Ȯ�ϰ� �Է����ּ���");
	    		}else if(!jpf2.getText().equals(jpf3.getText())) {
	    			JOptionPane.showMessageDialog(null, "������ PW�� ��Ȯ�ϰ� �Է����ּ���");
	    		}else if(jpf2.getText().length() > 12 || jpf3.getText().length() > 12
	    		|| jpf3.getText().length() < 8 || jpf3.getText().length() < 8) {
	    			JOptionPane.showMessageDialog(null, "������ PW�� 8�����̻� 12�� ���Ϸ� �Է����ּ���");
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "������ PW�� �����ڿ� Ư�����ڸ� ��� �ϳ��� �����ϰ� �־�� �մϴ�.");
	    		}
	    	
	    	 }
	    	});

	
	//}else if(�Է��� PW�� ����PW�� ���� ���� ��){
	// ���� PW�� ��Ȯ�ϰ� �Է����ּ��� 
	//}else if(����PW�� Ȯ�� PW�� ���� ���� ������)     
	// ���� PW�� ��Ȯ�ϰ� �Է����ּ���    
	    panel.add(jbt1);
	    
	    
	    JPanel panel2 = new JPanel();
        panel2.setLocation(0,0);  
        panel2.setSize(432,73);
        panel2.setLayout(null);
        panel2.setBackground(new Color(100, 149, 237));
	    this.add(panel2);
	    
	    
	    JLabel label = new JLabel("ȸ������ ����");
	    label.setFont(new Font("Serif", Font.BOLD, 20)); 
		label.setForeground(Color.WHITE);
		label.setBounds(64, 25, 150, 26);
		panel2.add(label);
	
        JButton jbt2 = new JButton("��");
        jbt2.setBounds(14,25,50,27);
        panel2.add(jbt2);
        //�� ��ư�� �������� ������������ �ٽ� �� �� �ְ�
        jbt2.addMouseListener(new MyMouseAdapter());
	   
        jtf1 = new JTextField();
       
        jtf1.setBounds(135,162,239,35);
        this.add(jtf1);
        jtf1.setEditable(false);
        //ȸ�������� �ҷ� �� �� �־�� �Ѵ�. ������� �ҷ�����? get�� �̿��ϱ��ؾ����ٵ�.
         
        JLabel Label = new JLabel(ud.mar[0].getUserId()); 
        Label.setBounds(5,0,239,35);
        jtf1.add(Label);
        
        jpf1 = new JPasswordField();
        jpf1.setBounds(135, 212, 239, 35);
        this.add(jpf1);
        //����PW�� jpf1�� �Է��� PW�� ������
        jpf2 = new JPasswordField();
	    jpf2.setBounds(135, 262, 239, 35);
		
	    this.add(jpf2);
	  
	    //����PW�� ��ȿ���˻縦 ����ϴ���
	    jpf3 = new JPasswordField();
	    jpf3.setBounds(135,312,239,35);
	    this.add(jpf3);
	    //Ȯ��PW�� ����PW�� ������
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
        //�ؽ�Ʈ,�н������ʵ忡 �Էµ� ������ ���������� => ����.getText(); ����Ѵ�
        //�� �ʵ���� ȸ�������� ����ִ� ������ �ҷ��ͼ� ����Ѵ�. 
        //�׷� JTF,TPF�� ���� �д� �κ��� Ŭ������ �ٸ��ٵ� �װ� ��� ������?

	    JLabel label2 = new JLabel("");
	    label2.setBounds(176, 220, 62, 18);
	    this.add(label2);
	    
	    JButton jbt3 = new JButton("ȸ�� Ż��");
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
//		         //jtf,jpf�� �Է��� �������� UserŬ���� ������ ���� ����� �۾� �Ѱ�
//		         //�̰� ���� ���Ͽ� ����� �� �ִ� �۾��� �ʿ��� �� ����.
//		        //id,email,�г����̶� �н����� �Է��ϴ� �κ� �ٸ��� �ؾ��� �� ������?
//		        //id,email,�г����� ������ �ҷ��;��ϴ°ž�
             //�� �� �޾����� �Ʒ�ó�� �ؽ�Ʈ�ʵ�� ���� 
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
