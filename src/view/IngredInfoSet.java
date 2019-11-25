package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.IngredControl;
import model.vo.IngredAll;

public class IngredInfoSet extends JPanel{


	//재료 삭제, 유통기한 입력 뷰
	MainFrame mf ;
	JPanel nowp ;
	int IngredNo ;


	public IngredInfoSet(MainFrame mf, int IngredNo) {
		
		this.IngredNo = IngredNo;
		
		
		

		//기본 패널 셋팅
		this.mf = mf;
		this.nowp = this;
		this.setLayout(null);
		this.setSize(445,770);

		//상단 바 패널 셋팅(고정)
		JPanel topP = new JPanel();
		topP.setLayout(null);
		topP.setBounds(0,0,445,70);
		topP.setBackground(new Color(102, 204, 204));


		//상단 타이틀 셋팅
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
		JLabel barTitle = new JLabel("재료 정보 수정");
		barTitle.setLocation(80, 10);
		barTitle.setSize(200, 50);
		barTitle.setForeground(Color.WHITE);
		barTitle.setFont(font);

		//상단 바 패널 꾸미기 //뒤로가기 버튼 셋팅
		Image backImg = new ImageIcon("images/back sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton btnBack = new JButton(new ImageIcon(backImg));
		btnBack.setBounds(10,10,50,50);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("뒤로가기 클릭");
				new ChangePanel().changePanel(mf, nowp, new CheckIngred(mf));
			}
		}
				);

		//상단 바 우측 마이페이지 버튼 셋팅
		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setBounds(380,10,50,50);
		logIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("뒤로가기 클릭");
				new ChangePanel().changePanel(mf, nowp, new MyFridge(mf));
				
			}
		});


		//하단 패널 셋팅
		JPanel botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(5,75,432,680);

		
		
		
		
		
		//재료 이미지 라벨 셋팅		//이미지 경로는 변수로 받아오기
		Image ingredImg = new ImageIcon("images/sim/BtnImg/" + IngredNo + ".PNG").getImage().getScaledInstance(300, 300, 0);
		JLabel ingredImgLabel = new JLabel(new ImageIcon(ingredImg));
		ingredImgLabel.setBounds(100,100,300,300);
		
		
		//삭제 버튼 셋팅
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(100,500,100,100);
		btnDelete.addMouseListener(new MouseAdapter() {
			
			@Override
		    public void mouseReleased(MouseEvent e) {
				System.out.println("재료 삭제 버튼 클릭됨");
				JOptionPane.showMessageDialog(null, "재료 삭제 완료 !");

				new IngredAll().deleteIngred(IngredAll.tempNo);
				
				
				
				//유통기한 객체에서도 해당 키,값 삭제
				IngredAll.ingredExpiryMap.remove(String.valueOf(AllRecipe.loginId) + IngredAll.tempNo);
				System.out.println("유통기한객체에서 삭제 된 상태, 현재 유통기한 객체 정보  : " + IngredAll.ingredExpiryMap);
				//수정된 객체정보 저장
				new IngredAll().saveIngredExpiryMap();
				
				IngredAll.setIngredExpiryMap();		//유통기한 정보 셋팅
				 new IngredControl().method();		//유통기한 정보 셋팅
				
			}

			
		});
		
		
		
		//유통기한 입력 라벨 셋팅
		JLabel lbExpiry = new JLabel("유통기한 : ");
		lbExpiry.setBounds(200,500,100,50);
		
		//유통기한 입력 버튼 셋팅
		String[] btnExpiry = {"1","2","3","4","5","6","7"};

		JComboBox cbExpiry = new JComboBox(btnExpiry);
		cbExpiry.setSize(50,50);
		cbExpiry.setLocation(300,500);
		
		cbExpiry.setSelectedIndex(0);



		cbExpiry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//콤보박스에서 날짜 선택시 진입

				JComboBox cb = (JComboBox) e.getSource();

				String expiry = (String) cb.getSelectedItem();
				int expiryDay = Integer.parseInt(expiry);	//클릭된 값 int 타입으로 저장
				
				new IngredAll().modifyIngredExpiryMap(expiryDay);	//스태틱의 냉장고 정보 수정
				new IngredAll().saveIngredExpiryMap();				//수정된 정보 파일에 저장
				
				IngredAll.setIngredExpiryMap();
				 new IngredControl().method();
				
				//IngredControl.minIngredExpiry = expiry;			//스태틱 내 유통기한 값 변경 
				
				
				///////////////

				
				

			}
		});


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		//상단 패널 화면 구성
		topP.add(btnBack);
		topP.add(logIn);
		topP.add(barTitle);
		
		
		//하단 패널 화면 구성
		botP.add(ingredImgLabel);
		botP.add(btnDelete);
		botP.add(cbExpiry);
		botP.add(lbExpiry);

		

		//메인프레임 > 전체패널 > 상단&하단 패널
		nowp.add(topP);
		nowp.add(botP);
		mf.add(nowp);
		mf.repaint();
		









	}
	
	
	
	
	
	




}//class
