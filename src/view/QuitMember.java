//회원정보수정 

package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dao.UserDao;
import model.vo.User;
import view.ModiMember.MyMouseAdapter;

public class QuitMember extends JPanel{

	UserDao ud = new UserDao();
	HashMap hmap = new HashMap();
	 MainFrame mf;
	 JPanel quitMember;
     JPanel lp;
     private JPasswordField jpf1;
     private JTextField jtf1;
     
	public QuitMember(MainFrame mf) {
		this.mf = mf;
		this.quitMember = this;

		String id = AllRecipe.loginId;
		
		this.setBounds(0,0,445,770);
		this.setLayout(null);


		JLabel lb1 = new JLabel("유의사항");
		lb1.setSize(76,67);
		lb1.setLocation(20,77);
		lb1.setFont(new Font("Serif", Font.BOLD, 18));
		this.add(lb1);

		JLabel lb2 = new JLabel("ID");
		lb2.setBounds(65,360, 22,29);
		lb2.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb3 = new JLabel("PW 입력");
		lb3.setBounds(39,400,100,50);
		lb3.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lb4 = new JLabel("탈퇴 사유");
		lb4.setBounds(30,450,100,50);
		lb4.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
        this.add(lb4);
		
		JLabel lb5 = new JLabel("회원탈퇴 전에 꼭 확인하세요.");
		lb1.setFont(new Font("Serif", Font.BOLD, 17));
		Font font = lb5.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lb5.setFont(font.deriveFont(attributes));
		lb5.setSize(220,34);
		lb5.setLocation(110,93);
		this.add(lb5);


		JPanel panel = new JPanel();
		panel.setSize(402,123);
		panel.setLocation(20,150);
		panel.setLayout(null); 

		panel.setBackground(Color.LIGHT_GRAY);

		JLabel lb6 = new JLabel("탈퇴 후 재가입시, 제한을 받을 수 있습니다.");
		JLabel lb7 = new JLabel("탈퇴 시 보유하고 계신 포인트, 쿠폰은 소멸되며");
		JLabel lb8 = new JLabel("재발급이 불가능합니다.");
		JLabel lb9 = new JLabel("한번 탈퇴한 아이디는 동일한 아이디로 재가입하거나");
		JLabel lb10 = new JLabel("복구하는 것이 불가능하오니 탈퇴시 유의하십시오.");
		 lb6.setBounds(30,-30,450,100);
		 lb7.setBounds(30,-10,450,100);
		 lb8.setBounds(30,10,450,100);  
		 lb9.setBounds(30,30,450,100);
		 lb10.setBounds(30,50,450,100);
		 panel.add(lb6);
		 panel.add(lb7);
		 panel.add(lb8);
		 panel.add(lb9);
		 panel.add(lb10);
		 this.add(panel);


			JPanel panel2 = new JPanel(); // 여기 윗 부분
			panel2.setLocation(0, 0);
			panel2.setSize(445,73);
			panel2.setLayout(null);
			panel2.setBackground(new Color(100, 149, 237));
			
			this.add(panel2);
			
			JLabel label_1 = new JLabel("회원 탈퇴");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Serif", Font.BOLD, 20));
			label_1.setBounds(64, 25, 94, 26);
			panel2.add(label_1);
			
			
			
			JButton btnNewButton_1 = new JButton("←");
			btnNewButton_1.setBounds(14, 25, 50, 27);
			btnNewButton_1.addMouseListener(new MyMouseAdapter1());
			panel2.add(btnNewButton_1);
			
			
			JPanel panel3 = new JPanel();
			panel3.setSize(170,60);
			panel3.setLocation(160,650);
			panel3.setLayout(null);

			panel3.setBackground(Color.red);
			this.add(panel3);
			
			JButton btnNewButton = new JButton("회원 탈퇴");
			btnNewButton.setBounds(0, 0, 170, 60);
			btnNewButton.setBackground(Color.red);
			btnNewButton.setForeground(Color.WHITE);
			
               
	//if(PW입력을 정확하게 했을 때){//그 회원의 정보를 삭제한다. delete? or 
			btnNewButton.addMouseListener(new MyMouseAdapter1() {
				
				@Override
			 public void mouseClicked(MouseEvent e) {
					
					try {
						ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("userList.dat"));
					
						try {
							HashMap asds = (HashMap) objIn.readObject();
							
							User u1 = (User) asds.get(id);
						    
							String JPF1 = String.valueOf(jpf1.getPassword());
							
							if(JPF1.equals(u1.getUserPw())) {

								//이 안에서 파일에 담긴 회원정보를 삭제하는 작업을 해줘야 할텐데 . . 
								
								JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다");

								ChangePanel.changePanel(mf, quitMember, new LoginPage(mf));
								
							}else {
								JOptionPane.showMessageDialog(null, "비밀번호를 정확하게 입력해주세요");
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
           	
			
			
				
			panel3.add(btnNewButton);
		
			JLabel label = new JLabel("현재 비밀번호를 입력해 주세요"); // 왜 안뜨누
			label.setBounds(140, 400, 197, 34);
			this.add(label);
			
			
			JLabel label2 = new JLabel("탈퇴 사유를 입력해주세요");
			label2.setBounds(145, 465, 200, 18);
			this.add(label2);
			
			
			JTextField jtf1 = new JTextField();
			jtf1.setBounds(135, 360, 230, 29);
            jtf1.setEditable(false);
			this.add(jtf1);
	
			 JLabel Label = new JLabel(id);
		        Label.setBounds(5,0,230,29);
		        jtf1.add(Label);
		        
		        jpf1 = new JPasswordField();
			jpf1.setBounds(135, 411, 230, 29);
			this.add(jpf1);

			JTextArea textArea = new JTextArea();
			textArea.setBounds(135, 462, 230, 130);
			this.add(textArea);
			
//			try {
//				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userList.dat"));
//			
//				try {
//					HashMap asds = (HashMap) pps.readObject();
//					
//					User u1 = (User) asds.get(id);
//				
//					String JPF1 = String.valueOf(jpf1.getPassword());
//					
//				} catch (ClassNotFoundException e1) {
//					e1.printStackTrace();
//				} 
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
			
			
	
	}

//	//게시물 삭제용 메소드 //게시물이 아닌 회원삭제때도 쓰일 수 있지 않을까 일단 주석처리
//		public void deleteBoard(int boardNo) {
//			//전체 게시물 조회
//			ArrayList<Board> list = bd.readBoardList();
//			//성공 실패 여부를 담을 변수 선언
//			int result = 0;
//			
//			//게시물번호와 일치하는 게시물 탐색
//			for(int i = 0; i < list.size(); i++) {
//				//일치하는 게시물이 있는 경우 삭제
//				if(list.get(i).getBoardNo() == boardNo) {
//					list.remove(i);
//					//삭제 후 파일에 기록
//					result = bd.writeBoardList(list);
//					break;
//				}
//			}

	 class MyMouseAdapter1 extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, quitMember, new ModiMember(mf));
		   }
	   }




}
