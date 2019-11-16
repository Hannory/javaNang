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
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import view.ModiMember.MyMouseAdapter;

public class QuitMember extends JPanel{

	 MainFrame mf;
	 JPanel quitMember;
     JPanel lp;
    
	public QuitMember(MainFrame mf) {
		this.mf = mf;
		this.quitMember = this;

		this.setBounds(0,0,445,770);
		this.setLayout(null);


		JLabel lb = new JLabel("유의사항");
		lb.setSize(76,67);
		lb.setLocation(20,77);
		lb.setFont(new Font("Serif", Font.BOLD, 18));
		this.add(lb);

		JLabel lbb = new JLabel("ID");
		lbb.setBounds(73,359, 22,29);
		JLabel lbbb = new JLabel("PW 입력");
		lbbb.setBounds(49,386,61,50);
		JLabel lbbbb = new JLabel("탈퇴 사유");
		lbbbb.setBounds(48,436,100,50);

		this.add(lbb);
		this.add(lbbb);
		this.add(lbbbb);

		JLabel lb1 = new JLabel("회원탈퇴 전에 꼭 확인하세요.");
		lb1.setFont(new Font("Serif", Font.BOLD, 17));
		Font font = lb1.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lb1.setFont(font.deriveFont(attributes));
		lb1.setSize(220,34);
		lb1.setLocation(110,93);
		this.add(lb1);


		JPanel panel = new JPanel();
		panel.setSize(402,123);
		panel.setLocation(30,150);
		panel.setLayout(null); 

		panel.setBackground(Color.LIGHT_GRAY);

		JLabel lb2 = new JLabel("탈퇴 후 재가입시, 제한을 받을 수 있습니다.");
		JLabel lb3 = new JLabel("탈퇴 시 보유하고 계신 포인트, 쿠폰은 소멸되며");
		JLabel lb4 = new JLabel("재발급이 불가능합니다.");
		JLabel lb5 = new JLabel("한번 탈퇴한 아이디는 동일한 아이디로 재가입");
		JLabel lb6 = new JLabel("하거나 복구하는 것이 불가능하오니 탈퇴시 유의하십시오.");
		 lb2.setBounds(30,-20,323,100);
		 lb3.setBounds(30,0,387,100);
		 lb4.setBounds(30,20,300,100);  
		 lb5.setBounds(30,40,300,100);
		 lb6.setBounds(30,60,406,100);
		 panel.add(lb2);
		 panel.add(lb3);
		 panel.add(lb4);
		 panel.add(lb5);
		 panel.add(lb6);
		 this.add(panel);


			JPanel panel2 = new JPanel(); // 여기 윗 부분
			panel2.setLocation(0, 0);
			panel2.setSize(432,73);
			panel2.setLayout(null);
			
			panel2.setBackground(Color.black);
			
			this.add(panel2);
			
			JLabel label_1 = new JLabel("\uD68C\uC6D0 \uD0C8\uD1F4");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Serif", Font.BOLD, 20));
			label_1.setBounds(64, 25, 94, 26);
			panel2.add(label_1);
			
			JLabel label_2 = new JLabel("\u2190");
			label_2.setBounds(14, 31, 37, 18);
			panel2.add(label_2);
			label_2.setBackground(Color.WHITE);
			label_2.setForeground(Color.WHITE);
			
			JButton button = new JButton("");
			button.setBounds(65, 12, -59, 27);
			button.setForeground(Color.WHITE);
			button.setBackground(Color.BLACK);
			button.addMouseListener(new MyMouseAdapter1());
			panel2.add(button);
			
			JButton btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(14, 25, 37, 27);
			btnNewButton_1.addMouseListener(new MyMouseAdapter1());
			panel2.add(btnNewButton_1);
			
			
			JPanel panel3 = new JPanel();
			panel3.setSize(170,60);
			panel3.setLocation(160,620);
			panel3.setLayout(null);

			panel3.setBackground(Color.red);
			this.add(panel3);
			
			JButton btnNewButton = new JButton("회원 탈퇴");
			btnNewButton.setBounds(0, 0, 170, 60);
			btnNewButton.setBackground(Color.red);
			btnNewButton.setForeground(Color.WHITE);
			//이거 누르면  탈퇴하시겠습니까? 확인 취소
			// 확인 버튼 누르면 모든레시피(초기페이지)
			// 취소 버튼 누르면 다시 페이지
			Dialog sd = new Dialog(mf, "탈퇴 완료");
			sd.setBounds(200,200,300,100);
			JButton jbt11 = new JButton("탈퇴가 완료되었습니다. 안녕히 가세요..");
			jbt11.addMouseListener(new MyMouseAdapter2());
			sd.add(jbt11);
			panel3.add(btnNewButton);
			
			  btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
		                         sd.setVisible(true);				
					}
				});
				
				jbt11.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jbt11.addMouseListener(new MyMouseAdapter2());      
				//		sd.dispose();        //닫기 눌렀을때 닫히게
		                                              //쓸 일이 좀 있을거다
					}
				});
			
			
			
			JLabel label = new JLabel("현재 비밀번호를 입력해 주세요"); // 왜 안뜨누
			label.setBounds(137, 394, 197, 34);
			this.add(label);
			
			JPasswordField password = new JPasswordField();
			password.setBounds(130, 399, 230, 29);
			this.add(password);
			
			JLabel label2 = new JLabel("내용을 입력해주세요");
			label2.setBounds(139, 454, 159, 18);
			this.add(label2);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(135, 451, 230, 127);
			this.add(textArea);
			
			JLabel label3 = new JLabel("LYS");
			label3.setBounds(133, 359, 62, 18);
			this.add(label3);


	}


	 class MyMouseAdapter1 extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, quitMember, new ModiMember(mf));
		   }
	   }
	 class MyMouseAdapter2 extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
		   ChangePanel.changePanel(mf, quitMember, new AllRecipe(mf,lp));
		   }
	   }




}
