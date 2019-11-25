package view;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

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

		JLabel label = new JLabel("ø¿¥√¿« ∏ﬁ¥∫ √ﬂ√µ");
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 27));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.white);
		label.setBounds(108, 26, 350, 39);
		panel.add(label);
		

		
		MgrRecipeDao mrd = new MgrRecipeDao();
		
		Recipe[] rc = new Recipe[MgrRecipeDao.recipeLength];;
		
		mrd.fileSave();
		
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < MgrRecipeDao.recipeLength; i++) {
				rc[i] = (Recipe) objIn.readObject();
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//∑πΩ√««∆–≥Œ
		
		int rd[] = new int[4];
		
		for(int i = 0; i < 4; i++) {		
			rd[i] = (int)(Math.random()* (rc.length - 1));
			
			for(int j = 0; j < i; j++) {
				if(rd[i]==rd[j]) {
					i--;
					break;
				}
			}
		}
		
		
		JPanel recipe1 = new JPanel();
		recipe1.setBounds(0, 85, 445, 145);
		add(recipe1);
		recipe1.setLayout(null);

		Image rcPic = new ImageIcon(rc[rd[0]].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0);
		JLabel recipeImage1 = new JLabel(new ImageIcon(rcPic));
		recipeImage1.setBounds(0, 0, 220, 145);
		recipe1.add(recipeImage1);
		
		
		
		JLabel rp1 = new JLabel(rc[rd[0]].getRecipeMent());
		rp1.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 15));
		rp1.setBounds(240,-50,350,250);
		recipe1.add(rp1);

		JPanel recipe2 = new JPanel();
		recipe2.setBounds(0, 235, 445, 145);
		add(recipe2);
		recipe2.setLayout(null);

		JLabel recipeImage2  = new JLabel(new ImageIcon(new ImageIcon(rc[rd[1]].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0)));
		recipeImage2.setBounds(0, 0, 220 , 145);
		recipe2.add(recipeImage2);

		JLabel rp2 = new JLabel(rc[rd[1]].getRecipeMent());
		rp2.setBounds(240, -50, 350, 250);
		recipe2.add(rp2);
		rp2.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 15));

		JPanel recipe3 = new JPanel();
		recipe3.setBounds(0, 385, 445, 145);
		add(recipe3);
		recipe3.setLayout(null);

		JLabel recipeImage3 =  new JLabel(new ImageIcon(new ImageIcon(rc[rd[2]].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0)));
		recipeImage3.setBounds(0, 0, 220, 145);
		recipe3.add(recipeImage3);

		JLabel rp3 = new JLabel(rc[rd[2]].getRecipeMent());
		rp3.setFont(new Font("∏º¿∫∞ÌµÒ",Font.BOLD, 15));
		rp3.setBounds(240, -50, 350, 250);
		recipe3.add(rp3);

		JPanel recipe4 = new JPanel();
		recipe4.setBounds(0, 537, 445, 145);
		add(recipe4);
		recipe4.setLayout(null);

		JLabel recipeImage4 = new JLabel(new ImageIcon(new ImageIcon(rc[rd[3]].getRecipePicAdr()).getImage().getScaledInstance(220, 145, 0)));
		recipeImage4.setBounds(0, 0, 220, 145);
		recipe4.add(recipeImage4);

		JLabel rp4 = new JLabel(rc[rd[3]].getRecipeMent());
		rp4.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 15));
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
			public void	mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage(mf, lp, rc[rd[0]]));

			}

		});
		
		
		recipe2.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage(mf,lp,rc[rd[1]]));
			}

		});
		recipe3.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage(mf,lp,rc[rd[2]]));

			}

		});
		recipe4.addMouseListener(new MouseAdapter() {

			@Override 
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage(mf,lp,rc[rd[3]]));

			}

		});
		

		logIn.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseReleased(MouseEvent e) {
				if(AllRecipe.login == true) {

					ChangePanel.changePanel(mf, mp, new MainMenu(mf));

				}else {
					ChangePanel.changePanel(mf,mp, new LoginPage(mf));
				}


			}

		});

		adBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try { Desktop.getDesktop().browse(new URI("https://chqdlstjd2.github.io/web1/")); 
				} catch (IOException e1) {
					e1.printStackTrace(); 
				} catch (URISyntaxException e1){ 
					e1.printStackTrace(); }


			}

		});


		mf.repaint();

	}
	}
