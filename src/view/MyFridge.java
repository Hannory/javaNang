//메인메뉴  회원정보 버튼 -> 회원정보로 넘어가게
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ModiMember.MyMouseAdapter;

public class MyFridge extends JPanel{
   
	public MainFrame mf;
	private JPanel mainPage2;
	
	public MyFridge(MainFrame mf) {
		this.mf = mf;
		mainPage2 = this;
		
		this.setBounds(0,0,500,750);
		this.setLayout(null);
		//냉장고아이콘은 천천히바꾸자
		
		JButton btn = new JButton("재료 입력");
		btn.setBounds(140, 170, 180, 50);
		btn.setBackground(Color.LIGHT_GRAY);
		JButton btn2 = new JButton("재료 확인");
        btn2.setBounds(140,300, 180, 50);
        btn2.setBackground(Color.LIGHT_GRAY);
        JButton btn3 = new JButton("히스토리");
        btn3.setBounds(140,430, 180, 50);
        btn3.setBackground(Color.LIGHT_GRAY);
        JButton btn4 = new JButton("회원 정보");
		btn4.setBounds(140,560, 180, 50);
		btn4.setBackground(Color.LIGHT_GRAY);
		
		btn4.addMouseListener(new MyMouseAdapter());
	       
		
		
		this.add(btn);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
        //이것들도 패널에 붙여야지?
		mf.add(this);
		
		
		JLabel lb = new JLabel("My 냉장고");
		lb.setBounds(50,-20,100,100); 
		lb.setLayout(null);

	    lb.setForeground(Color.white);
        lb.setFont(new Font("Serif", Font.BOLD, 20));     
		this.add(lb);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(500,70);
		panel2.setLayout(null);
		panel2.setBackground(Color.black);
		

        JButton jbt2 = new JButton("←");
        jbt2.setBounds(14,14,24,27);
        jbt2.setForeground(Color.white);
        jbt2.setBackground(Color.black);
        jbt2.addMouseListener(new MyMouseAdapter2());
        panel2.add(lb);
        panel2.add(jbt2);
        this.add(panel2);
        
	}

	class MyMouseAdapter extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
			   ChangePanel.changePanel(mf, mainPage2, new ModiMember(mf));
		   }
	   }
	class MyMouseAdapter2 extends MouseAdapter{
		   @Override
		   public void mouseClicked(MouseEvent e) {
			   ChangePanel.changePanel(mf, mainPage2, new MainMenu(mf)); 
		   }            //My냉장고에서 메인메뉴류 듈아가게 하려고 한건데
	   }
		
}
