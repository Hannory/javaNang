package view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputIngredMeat extends JPanel {
	//(육류) 페이지
	
	MainFrame mf ;
	JPanel nowp ;

	public InputIngredMeat(MainFrame mf) {

		//기본 패널 셋팅
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);

		//상단 바 패널 셋팅(고정)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);

		//상단 바 패널 꾸미기
		//아직 패널 안정했음//


		//하단 패널 셋팅
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(5,75,432,680);

		
		//배경이미지 준비
		//Image imgBackground = new ImageIcon("images/sim/imgIngreDetailMeat.PNG").getImage().getScaledInstance(432, 680, 0);
		//라벨생성, 설정 및 배경이미지 넣기
		//JLabel lbBackground = new JLabel(new ImageIcon(imgBackground));
		//lbBackground.setBounds(0,0,432,680);
		//하단패널에 배경라벨 붙이기
		//botP.add(lbBackground);

		

		/////////////////버튼 생성 및 바운드 설정, 버튼 이미지 준비 및 이미지 넣기, 마우스클릭드 이벤트 처리//////////////////////////
		Image imgBtn1 = new ImageIcon("images/sim/meatBtnImg/meat01.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn1 = new JButton(new ImageIcon(imgBtn1));
		btn1.setBounds(0,0,145,230);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼1 클릭");
			}
		}
				);


		btn1.setOpaque(false);	//버튼 투명화
		
		
		Image imgBtn2 = new ImageIcon("images/sim/meatBtnImg/meat02.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn2 = new JButton(new ImageIcon(imgBtn2));
		btn2.setBounds(0,230,145,230);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼2 클릭");
			}
		}
				);
		btn2.setOpaque(false);
		
		
		
		
		Image imgBtn3 = new ImageIcon("images/sim/meatBtnImg/meat03.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn3 = new JButton(new ImageIcon(imgBtn3));
		btn3.setBounds(0,460,145,230);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼3 클릭");
			}
		}
				);
		btn3.setOpaque(false);
		
		
		
		
		Image imgBtn4 = new ImageIcon("images/sim/meatBtnImg/meat04.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn4 = new JButton(new ImageIcon(imgBtn4));
		btn4.setBounds(145,0,145,230);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼4 클릭");
			}
		}
				);
		btn4.setOpaque(false);
		
		
		
		
		
		Image imgBtn5 = new ImageIcon("images/sim/meatBtnImg/meat05.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn5 = new JButton(new ImageIcon(imgBtn5));
		btn5.setBounds(145,230,145,230);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼5 클릭");
			}
		}
				);
		btn5.setOpaque(false);
		
		
		
		
		Image imgBtn6 = new ImageIcon("images/sim/meatBtnImg/meat06.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn6 = new JButton(new ImageIcon(imgBtn6));
		btn6.setBounds(145,460,145,230);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼6 클릭");
			}
		}
				);
		btn6.setOpaque(false);
		
		
		
		
		Image imgBtn7 = new ImageIcon("images/sim/meatBtnImg/meat07.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn7 = new JButton(new ImageIcon(imgBtn7));
		btn7.setBounds(290,0,145,230);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼7 클릭");
			}
		}
				);
		btn7.setOpaque(false);
		
		
		
		
		Image imgBtn8 = new ImageIcon("images/sim/meatBtnImg/meat08.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn8 = new JButton(new ImageIcon(imgBtn8));
		btn8.setBounds(290,230,145,230);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼8 클릭");
			}
		}
				);
		btn8.setOpaque(false);
		
		
		
		
		Image imgBtn9 = new ImageIcon("images/sim/meatBtnImg/meat09.PNG").getImage().getScaledInstance(145, 230, 0);
		JButton btn9 = new JButton(new ImageIcon(imgBtn9));
		btn9.setBounds(290,460,145,230);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼9 클릭");
			}
		}
				);
		btn9.setOpaque(false);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		//하단 패널 화면 구성/////////////

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
