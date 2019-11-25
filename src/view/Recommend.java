package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.plaf.FontUIResource;

import controller.RecMgt;
import model.dao.MgrRecipeDao;
import model.dao.UserDao;

public class Recommend extends JPanel {
	
	private MainFrame mf;
	private ChangePanel cp;
	private JPanel rc;
	
	private MgrRecipeDao mrd = new MgrRecipeDao();
	private UserDao ud = new UserDao();
	private RecMgt rm = new RecMgt();

	int nowClickCtn = 0;	// 현재재료로 클릭 카운트. 추천 로직과 연결됨.
	int addClickCtn = 0;	// 추가재료로 클릭 카운트. 추천 로직과 연결됨.
	
	JLabel label;
	JButton left;
	JButton right;
	JButton specificPage;
	
	JLabel label2;
	JButton left2;
	JButton right2;
	JButton specificPage2;
	
	public Recommend(MainFrame mf) {		
		
		this.mf = mf;
		rc = this;
		
		//User, Recipe 정보 저장   ->  향후 입력 값으로 대체
		//ud.fileSave();
		mrd.fileSave();
		System.out.println("수동레시피 새로 저장");
		
		//바탕 패널
		this.setSize(445, 770);
		this.setLayout(null);
		
		//맨 위 바 영억
		JPanel bar = new JPanel();
		bar.setLocation(0, 0);
		bar.setSize(445, 70);
		bar.setLayout(null);
		bar.setBackground(new Color(102, 204, 204));
		
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		
		JLabel barTitle = new JLabel("요리 추천");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);
		
		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50,  50,  0);
		JButton back = new JButton(new ImageIcon(backImg));
		back.setLocation(10, 10);
		back.setSize(50, 50);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, rc, new MainMenu(mf));
				
			}
			
		});
		
		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setLocation(380, 10);
		logIn.setSize(50, 50);
		
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.changePanel(mf, rc, new MyFridge(mf));
				
			}
			
		});		
		
		//레시피 추천 분류
		rm.categorizing();
		
		//현재재료로 제목과 요리이름, 개수 등이 들어갈 패널	
		JPanel titleBar1 = new JPanel();
		titleBar1.setLocation(0, 70);
		titleBar1.setSize(445, 70);
		titleBar1.setLayout(null);
		titleBar1.setBackground(Color.white);
		
		//"현재 재료로"를 감싸는 네모
		JPanel title1 = new JPanel();
		title1.setLocation(0, 20);
		title1.setSize(180, 50);
		title1.setBackground(new Color(243, 156, 18));
		title1.setLayout(null);
		
		//"현재 재료로" 문장
		JLabel whichRe1 = new JLabel("현재 재료로");
		whichRe1.setLocation(25, 0);
		whichRe1.setSize(155, 50);
		whichRe1.setFont(font2);
		whichRe1.setForeground(Color.white);
		
		//현재재료로 추천된 요리명 
		JTextPane recipeName1 = new JTextPane();
		
		if(RecMgt.nowCtn == 0) {
			
		}else {
			recipeName1.setText(rm.nowName((nowClickCtn) % RecMgt.nowCtn));
			
		}
		recipeName1.setFont(font2);
		recipeName1.setLocation(215, 28);
		recipeName1.setSize(165, 50);
		recipeName1.setForeground(new Color(13, 145, 68));
		
		//현재 재료로 추천 개수
		JTextPane nowNum = new JTextPane();
		
		if(RecMgt.nowCtn == 0) {
			nowNum.setText("0/0");
		}else {
			nowNum.setText(((nowClickCtn) % RecMgt.nowCtn + 1) + "/" + RecMgt.nowCtn);			
		}
		nowNum.setFont(font2);
		nowNum.setLocation(385, 28);
		nowNum.setSize(50, 50);
		nowNum.setForeground(Color.gray);
		
		//현재 재료로 사진이 담기는 패널 영역
		JPanel panel = new JPanel();
		panel.setLocation(0, 140);
		panel.setSize(445, 233);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		//현재 재료로에 출력될 이미지
		if(RecMgt.nowCtn != 0) {
			
			Image[] nowIcon = new Image[RecMgt.nowCtn];
			
			for(int i = 0; i < nowIcon.length; i++) {
				nowIcon[i] = new ImageIcon(rm.nowPicAdr(i)).getImage().getScaledInstance(345, 233, 0);
			}
			
			label = new JLabel(new ImageIcon(nowIcon[nowClickCtn]));
			
			label.setLocation(50, 0);
			label.setSize(345, 233);
			
			Image leftSky = new ImageIcon("images/park/leftSky.png").getImage().getScaledInstance(50,  50, 0);
			left = new JButton(new ImageIcon(leftSky));
			left.setSize(50, 50);
			left.setLocation(0, 91);
			
			left.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					nowClickCtn--;
					if(nowClickCtn < 0) {
						nowClickCtn += RecMgt.nowCtn;
						label.setIcon(new ImageIcon(nowIcon[nowClickCtn % RecMgt.nowCtn]));
						recipeName1.setText(rm.nowName((nowClickCtn) % RecMgt.nowCtn));
						nowNum.setText(((nowClickCtn) % RecMgt.nowCtn + 1) + "/" + RecMgt.nowCtn);
					}else {
						label.setIcon(new ImageIcon(nowIcon[nowClickCtn % RecMgt.nowCtn]));
						recipeName1.setText(rm.nowName((nowClickCtn) % RecMgt.nowCtn));
						nowNum.setText(((nowClickCtn) % RecMgt.nowCtn + 1) + "/" + RecMgt.nowCtn);
					}
					
				}
				
			});
			
			Image rightSky = new ImageIcon("images/park/rightSky.png").getImage().getScaledInstance(50,  50, 0);
			right = new JButton(new ImageIcon(rightSky));
			right.setSize(50, 50);
			right.setLocation(395, 91);	
			
			right.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					nowClickCtn++;
					label.setIcon(new ImageIcon(nowIcon[nowClickCtn % RecMgt.nowCtn]));
					recipeName1.setText(rm.nowName((nowClickCtn) % RecMgt.nowCtn));
					nowNum.setText(((nowClickCtn) % RecMgt.nowCtn + 1) + "/" + RecMgt.nowCtn);
				}
				
			});
			
			//요리 상세 페이지로 이동 (nowClickCtn) 활용
			specificPage = new JButton(" ");
			specificPage.setLocation(50, 0);
			specificPage.setSize(345, 233);
			specificPage.setOpaque(false);
			
			specificPage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cp.changePanel(mf, rc, new RecipePage2(mf, rm.nowRecipe(nowClickCtn % RecMgt.nowCtn)));
					
				}
				
			});		
			
		}else {
			
			Image nowIcon = new ImageIcon("images/park/no recommend.png").getImage().getScaledInstance(345, 233, 0);
			label = new JLabel(new ImageIcon(nowIcon));
			
			label.setLocation(50, 0);
			label.setSize(345, 233);
			
			Image leftSky = new ImageIcon("images/park/leftSky.png").getImage().getScaledInstance(50,  50, 0);
			left = new JButton(new ImageIcon(leftSky));
			left.setSize(50, 50);
			left.setLocation(0, 91);
			
			Image rightSky = new ImageIcon("images/park/rightSky.png").getImage().getScaledInstance(50,  50, 0);
			right = new JButton(new ImageIcon(rightSky));
			right.setSize(50, 50);
			right.setLocation(395, 91);		
			
			//My 냉장고 페이지로 이동
			specificPage = new JButton(" ");
			specificPage.setLocation(50, 0);
			specificPage.setSize(345, 233);
			specificPage.setOpaque(false);
			
			specificPage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//cp.changePanel(mf, rc, new MyFridge(mf));
					JOptionPane.showMessageDialog(null, "냉장고가 비어 있습니다.\n재료를 새로 입력해주세요.");
					
				}
				
			});
		}
		
		//추가재료로 제목 등이 들어갈 패널
		JPanel titleBar2 = new JPanel();
		titleBar2.setLocation(0, 140+233);
		titleBar2.setSize(445, 70);
		titleBar2.setLayout(null);
		titleBar2.setBackground(Color.white);
		
		//title background
		JPanel title2 = new JPanel();
		title2.setLocation(0, 20);
		title2.setSize(180, 50);
		title2.setBackground(new Color(243, 156, 18));
		title2.setLayout(null);
		
		JLabel whichRe2 = new JLabel("추가 재료로");
		whichRe2.setLocation(25, 0);
		whichRe2.setSize(155, 50);
		whichRe2.setFont(font2);
		whichRe2.setForeground(Color.white);
		
		//추가재료로 추천된 요리명
		JTextPane recipeName2 = new JTextPane();
		
		if(RecMgt.addCtn == 0) {
			
		}else {
			recipeName2.setText(rm.addName((addClickCtn) % RecMgt.addCtn));
		}
		recipeName2.setFont(font2);
		recipeName2.setLocation(215, 28);
		recipeName2.setSize(165, 50);
		recipeName2.setForeground(new Color(13, 145, 68));
		
		//추가 재료로 추천 개수
		JTextPane addNum = new JTextPane();
		addNum.setText(((addClickCtn) % RecMgt.addCtn + 1) + "/" + Integer.valueOf(RecMgt.addCtn).toString());
		addNum.setFont(font2);
		addNum.setLocation(380, 28);
		addNum.setSize(60, 50);
		addNum.setForeground(Color.gray);
		
		//추가 재료로 사진 패널
		JPanel panel2 = new JPanel();
		panel2.setLocation(0, 140+233+70);
		panel2.setSize(445, 233);
		panel2.setLayout(null);
		panel2.setBackground(Color.white);
		
		if(RecMgt.addCtn != 0) {
			
			Image[] addIcon = new Image[RecMgt.addCtn];
			
			for(int i = 0; i < addIcon.length; i++) {
				addIcon[i] = new ImageIcon(rm.addPicAdr(i)).getImage().getScaledInstance(345, 233, 0);
			}
			
			label2 = new JLabel(new ImageIcon(addIcon[addClickCtn]));
			label2.setLocation(50, 0);
			label2.setSize(345, 233);
			
			Image leftSky = new ImageIcon("images/park/leftSky.png").getImage().getScaledInstance(50,  50, 0);
			left2 = new JButton(new ImageIcon(leftSky));
			left2.setSize(50, 50);
			left2.setLocation(0, 91);
			
			left2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					addClickCtn--;
					if(addClickCtn < 0) {
						addClickCtn += RecMgt.addCtn;
						label2.setIcon(new ImageIcon(addIcon[addClickCtn % RecMgt.addCtn]));
						recipeName2.setText(rm.addName((addClickCtn) % RecMgt.addCtn));
						addNum.setText(((addClickCtn) % RecMgt.addCtn + 1) + "/" + Integer.valueOf(RecMgt.addCtn).toString());
					}else {
						label2.setIcon(new ImageIcon(addIcon[addClickCtn % RecMgt.addCtn]));
						recipeName2.setText(rm.addName((addClickCtn) % RecMgt.addCtn));
						addNum.setText(((addClickCtn) % RecMgt.addCtn + 1) + "/" + Integer.valueOf(RecMgt.addCtn).toString());
					}
					
				}
				
			});
			
			Image rightSky = new ImageIcon("images/park/rightSky.png").getImage().getScaledInstance(50,  50, 0);
			right2 = new JButton(new ImageIcon(rightSky));
			right2.setSize(50, 50);
			right2.setLocation(395, 91);	
			
			right2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					addClickCtn++;
					label2.setIcon(new ImageIcon(addIcon[addClickCtn % RecMgt.addCtn]));
					recipeName2.setText(rm.addName((addClickCtn) % RecMgt.addCtn));
					addNum.setText(((addClickCtn) % RecMgt.addCtn + 1) + "/" + Integer.valueOf(RecMgt.addCtn).toString());
					
				}
				
			});
			
			//요리 상세 페이지로 이동 (nowClickCtn) 활용
			specificPage2 = new JButton(" ");
			specificPage2.setLocation(50, 0);
			specificPage2.setSize(345, 233);
			specificPage2.setOpaque(false);
			
			specificPage2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cp.changePanel(mf, rc, new RecipePage3(mf, rm.addRecipe(addClickCtn % RecMgt.addCtn)));
					
				}
				
			});	
			
		}else {
			
			Image nowIcon = new ImageIcon("images/park/no recommend.png").getImage().getScaledInstance(345, 233, 0);
			label2 = new JLabel(new ImageIcon(nowIcon));
			
			label2.setLocation(50, 0);
			label2.setSize(345, 233);
			
			Image leftSky = new ImageIcon("images/park/leftSky.png").getImage().getScaledInstance(50,  50, 0);
			left2 = new JButton(new ImageIcon(leftSky));
			left2.setSize(50, 50);
			left2.setLocation(0, 91);
			
			Image rightSky = new ImageIcon("images/park/rightSky.png").getImage().getScaledInstance(50,  50, 0);
			right2 = new JButton(new ImageIcon(rightSky));
			right2.setSize(50, 50);
			right2.setLocation(395, 91);		
			
			//My 냉장고 페이지로 이동
			specificPage2 = new JButton(" ");
			specificPage2.setLocation(50, 0);
			specificPage2.setSize(345, 233);
			specificPage2.setOpaque(false);
			
			specificPage2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//cp.changePanel(mf, rc, new MyFridge(mf));
					JOptionPane.showMessageDialog(null, "냉장고가 비어 있습니다.\n재료를 새로 입력해주세요.");
				}
				
			});
		}
		
		JPanel panel3 = new JPanel();
		panel3.setLocation(0, 140+233+70+233);
		panel3.setSize(445, 94);
		panel3.setLayout(null);
		
		
		Image bottomBar = new ImageIcon("images/bottomBar.png").getImage().getScaledInstance(445, 94, 0);
		JLabel panelPic3 = new JLabel(new ImageIcon(bottomBar));
		panelPic3.setSize(445, 94);
			
		//add 영역
		bar.add(barTitle);
		bar.add(back);
		bar.add(logIn);
		
		titleBar1.add(title1);
		titleBar1.add(recipeName1);
		titleBar1.add(nowNum);
		
		title1.add(whichRe1);
		
		panel.add(left);
		panel.add(right);
		panel.add(label);
		panel.add(specificPage);
		
		titleBar2.add(title2);
		titleBar2.add(recipeName2);
		titleBar2.add(addNum);
		
		title2.add(whichRe2);
		
		panel2.add(left2);
		panel2.add(right2);
		panel2.add(label2);
		panel2.add(specificPage2);
		
		panel3.add(panelPic3);
		
		this.add(bar);
		this.add(titleBar1);
		this.add(panel);
		this.add(titleBar2);
		this.add(panel2);
		this.add(panel3);
		
		mf.add(this);
	}
	
}
