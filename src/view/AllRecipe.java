package view;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.MgrRecipeDao;
import model.vo.Recipe;

public class AllRecipe extends JPanel {
	
	public static Boolean login = false;
	public static String loginId;
	
	MainFrame mf;
	JPanel mp;
	JPanel lp;

	MgrRecipeDao mrd = new MgrRecipeDao();
	

	public AllRecipe(MainFrame mf,JPanel lp) {

		this.lp = lp;

		this.mf = mf;
		this.mp = this;

		this.setSize(445,770);
		this.setBackground(new Color(190, 190, 190));

		setLayout(null);

		mf.remove(lp);
		mf.getContentPane().add(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 0, 445, 73);
		add(panel);
		panel.setLayout(null);

		Image person = new ImageIcon("images/person sky.png").getImage().getScaledInstance(50, 50, 0);
		JButton logIn = new JButton(new ImageIcon(person));
		logIn.setLocation(380, 10);
		logIn.setSize(50, 50);
		panel.add(logIn);

		JLabel label = new JLabel("모든 레시피");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.white);
		label.setBounds(138, 26, 146, 39);
		panel.add(label);
		
		mrd.fileSave();
		
		Recipe[] rc = new Recipe[MgrRecipeDao.recipeLength];
		//Recipe rc = new Recipe();
		
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < MgrRecipeDao.recipeLength; i++) {
				rc[i] = (Recipe) objIn.readObject();
			}
 		//ArrayList arr = (ArrayList) objIn.readObject();
		
		//rc = (Recipe) arr.get(0);
		
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		JPanel recipe1 = new JPanel();
		recipe1.setBounds(0, 85, 445, 145);
		add(recipe1);
		recipe1.setLayout(null);

		Image rcPic = new ImageIcon(rc[0].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0);
		JLabel recipeImage1 = new JLabel(new ImageIcon(rcPic));
		recipeImage1.setBounds(0, 0, 220, 180);
		recipe1.add(recipeImage1);

		System.out.println("1st check : " + rc[0].getRecipePicAdr());
		
		//JLabel rp1 = new JLabel(rc[0].getRecipeName());
		JLabel rp1 = new JLabel("<html># 중국집 부럽지 않은<br>짜장면 만들기 ~!!<br></html>");
		rp1.setFont(new Font("굴림", Font.BOLD, 15));
		rp1.setBounds(240,-50,350,250);
		recipe1.add(rp1);

		JPanel recipe2 = new JPanel();
		recipe2.setBounds(0, 235, 445, 145);
		add(recipe2);
		recipe2.setLayout(null);

		JLabel recipeImage2  = new JLabel(new ImageIcon(new ImageIcon(rc[1].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0)));
		recipeImage2.setBounds(0, 0, 220 , 145);
		recipe2.add(recipeImage2);

		JLabel rp2 = new JLabel("<html># 레스토랑 부럽지 않은<br>크림 파스타 만들기 ~!!<br></html>");
		rp2.setBounds(240, -50, 350, 250);
		recipe2.add(rp2);
		rp2.setFont(new Font("굴림", Font.BOLD, 15));

		JPanel recipe3 = new JPanel();
		recipe3.setBounds(0, 385, 445, 145);
		add(recipe3);
		recipe3.setLayout(null);

		JLabel recipeImage3 =  new JLabel(new ImageIcon(new ImageIcon(rc[2].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0)));
		recipeImage3.setBounds(0, 0, 220, 145);
		recipe3.add(recipeImage3);

		JLabel rp3 = new JLabel("<html>#해물 맛이 가득 담긴 <br>토마토 스파게티 만들기 ~!!");
		rp3.setFont(new Font("굴림",Font.BOLD, 15));
		rp3.setBounds(240, -50, 350, 250);
		recipe3.add(rp3);

		JPanel recipe4 = new JPanel();
		recipe4.setBounds(0, 537, 445, 145);
		add(recipe4);
		recipe4.setLayout(null);

		JLabel recipeImage4 = new JLabel(new ImageIcon(new ImageIcon(rc[3].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0)));
		recipeImage4.setBounds(0, 0, 220, 145);
		recipe4.add(recipeImage4);

		JLabel rp4 = new JLabel("<html>#휴게소에서 먹는 그맛  <br>영양만점 찐감자 만들기 ~!!");
		rp4.setFont(new Font("굴림", Font.BOLD, 15));
		rp4.setBounds(240, -50, 350, 250);
		recipe4.add(rp4);

		JPanel ad = new JPanel();
		ad.setBounds(0, 685, 450, 78);
		add(ad);
		ad.setLayout(null);

		JButton adBtn = new JButton(new ImageIcon(new ImageIcon("images/won/ad.PNG").getImage().getScaledInstance(450, 78, 0)));
		adBtn.setBounds(-10, 0, 455, 88);
		ad.add(adBtn);

		Recipe rc1 = new Recipe();
		
		recipe1.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage(mf, lp));

			}

		});
		
		recipe2.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage11(mf,lp));
				//ChangePanel.changePanel(mf, mp, new RecipePage11(mf,rc1));
			}

		});
		recipe3.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage12(mf,lp));

			}

		});
		recipe4.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage13(mf,lp));

			}

		});
		

		logIn.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(AllRecipe.login == true) {

					ChangePanel.changePanel(mf, mp, new MainMenu(mf));

				}else {
					ChangePanel.changePanel(mf,mp, new LoginPage(mf));
				}


			}

		});

		adBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try { Desktop.getDesktop().browse(new URI("https://www.iei.or.kr/main/main.kh")); 
				} catch (IOException e1) {
					e1.printStackTrace(); 
				} catch (URISyntaxException e1){ 
					e1.printStackTrace(); }


			}

		});


		mf.repaint();

	}
	}
