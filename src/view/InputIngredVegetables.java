package view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputIngredVegetables extends JPanel {
	//(육류) 페이지
	
	MainFrame mf ;
	JPanel nowp ;

	public InputIngredVegetables(MainFrame mf) {

		//기본 패널 셋팅
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(432,753);

		//상단 바 패널 셋팅(고정)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,432,73);
		
		//하단 패널 셋팅
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(0,73,432,680);
		
		//배경이미지 준비
		Image imgBackground = new ImageIcon("images/sim/imgIngreDetailMeat.PNG").getImage().getScaledInstance(432, 680, 0);

		//라벨생성, 설정 및 배경이미지 넣기
		JLabel lbBackground = new JLabel(new ImageIcon(imgBackground));
		lbBackground.setBounds(0,0,432,680);
		
		//하단패널에 배경라벨 붙이기
		botP.add(lbBackground);

		

		/////////////////버튼 생성 및 바운드 설정, 마우스클릭드 이벤트 처리//////////////////////////
		JButton btn1 = new JButton("111");
		btn1.setBounds(0,0,145,230);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼1 클릭");
			}
		}
				);


		btn1.setOpaque(false);	//버튼 투명화
		
		
		JButton btn2 = new JButton("222");
		btn2.setBounds(0,230,145,230);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼2 클릭");
			}
		}
				);
		btn2.setOpaque(false);
		
		
		
		
		JButton btn3 = new JButton("333");
		btn3.setBounds(0,460,145,230);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼3 클릭");
			}
		}
				);
		btn3.setOpaque(false);
		
		
		
		
		JButton btn4 = new JButton("444");
		btn4.setBounds(145,0,145,230);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼4 클릭");
			}
		}
				);
		btn4.setOpaque(false);
		
		
		
		
		
		JButton btn5 = new JButton("555");
		btn5.setBounds(145,230,145,230);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼5 클릭");
			}
		}
				);
		btn5.setOpaque(false);
		
		
		
		
		JButton btn6 = new JButton("666");
		btn6.setBounds(145,460,145,230);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼6 클릭");
			}
		}
				);
		btn6.setOpaque(false);
		
		
		
		
		JButton btn7 = new JButton("777");
		btn7.setBounds(290,0,145,230);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼7 클릭");
			}
		}
				);
		btn7.setOpaque(false);
		
		
		
		
		JButton btn8 = new JButton("888");
		btn8.setBounds(290,230,145,230);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼8 클릭");
			}
		}
				);
		btn8.setOpaque(false);
		
		
		
		
		JButton btn9 = new JButton("999");
		btn9.setBounds(290,460,145,230);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼9 클릭");
			}
		}
				);
		btn9.setOpaque(false);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		//화면 구성/////////////

		botP.add(btn1);
		botP.add(btn2);
		botP.add(btn3);
		botP.add(btn4);
		botP.add(btn5);
		botP.add(btn6);
		botP.add(btn7);
		botP.add(btn8);
		botP.add(btn9);

		
		//화면 완성 //component < eachP < nowp < mf
		this.add(botP);
		this.add(topP);

		mf.add(this);
		mf.repaint();






		
		
		
	}//constructor
	
	

}//class
