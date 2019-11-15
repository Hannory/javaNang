package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AllRecipe extends JPanel {
	
	MainFrame mf;
	JPanel mp;
	JPanel lp;
	
	
	public AllRecipe(MainFrame mf,JPanel lp) {
		
		this.lp = lp;
		
		this.mf = mf;
		this.mp = this;
		
		this.setSize(432,753);
		this.setBackground(Color.lightGray);
		
		setLayout(null);
		
		mf.remove(lp);
		mf.getContentPane().add(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 432, 100);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("·Î±×ÀÎ");
		btnNewButton.setBounds(332, 35, 93, 27);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("¸ðµç ·¹½ÃÇÇ");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.white);
		label.setBounds(138, 26, 146, 39);
		panel.add(label);
		
		JPanel recipe1 = new JPanel();
		recipe1.setBounds(0, 113, 430, 130);
		add(recipe1);
		recipe1.setLayout(null);
		
		JLabel recipeImage1 = new JLabel(new ImageIcon(new ImageIcon("images/won/±î¸£º¸³ª¶ó.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipeImage1.setBounds(0, 0, 130, 130);
		recipe1.add(recipeImage1);
		
		JLabel rp1 = new JLabel("# \uB808\uC2A4\uD1A0\uB791 \uBD80\uB7FD\uC9C0\uC54A\uC740 \uD06C\uB9BC \uD30C\uC2A4\uD0C0 \uB9CC\uB4E4\uAE30~!");
		rp1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		rp1.setBounds(135,13,295,104);
		recipe1.add(rp1);
		
		JPanel recipe2 = new JPanel();
		recipe2.setBounds(0, 256, 430, 130);
		add(recipe2);
		recipe2.setLayout(null);
		
		JLabel recipeImage2  = new JLabel(new ImageIcon(new ImageIcon("images/won/¸êÄ¡ººÀ½.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipeImage2.setBounds(0, 0, 130, 180);
		recipe2.add(recipeImage2);
		
		JLabel rp2 = new JLabel("# \uB808\uC2A4\uD1A0\uB791 \uBD80\uB7FD\uC9C0\uC54A\uC740 \uD06C\uB9BC \uD30C\uC2A4\uD0C0 \uB9CC\uB4E4\uAE30~!");
		rp2.setBounds(135, 13, 295, 104);
		recipe2.add(rp2);
		rp2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		
		JPanel recipe3 = new JPanel();
		recipe3.setBounds(0, 399, 430, 130);
		add(recipe3);
		recipe3.setLayout(null);
		
		JLabel recipeImage3 =  new JLabel(new ImageIcon(new ImageIcon("images/won/°¨ÀÚ´ç±Ù.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipeImage3.setBounds(0, 0, 130, 180);
		recipe3.add(recipeImage3);
		
		JLabel rp3 = new JLabel("# \uB808\uC2A4\uD1A0\uB791 \uBD80\uB7FD\uC9C0\uC54A\uC740 \uD06C\uB9BC \uD30C\uC2A4\uD0C0 \uB9CC\uB4E4\uAE30~!");
		rp3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		rp3.setBounds(135, 13, 295, 104);
		recipe3.add(rp3);
		
		JPanel recipe4 = new JPanel();
		recipe4.setBounds(0, 542, 430, 130);
		add(recipe4);
		recipe4.setLayout(null);
		
		JLabel recipeImage4 = new JLabel(new ImageIcon(new ImageIcon("images/won/°¨ÀÚººÀ½.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipeImage4.setBounds(0, 0, 130, 180);
		recipe4.add(recipeImage4);
		
		JLabel rp4 = new JLabel("# \uB808\uC2A4\uD1A0\uB791 \uBD80\uB7FD\uC9C0\uC54A\uC740 \uD06C\uB9BC \uD30C\uC2A4\uD0C0 \uB9CC\uB4E4\uAE30~!");
		rp4.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		rp4.setBounds(135, 13, 295, 104);
		recipe4.add(rp4);
		
		JPanel ad = new JPanel();
		ad.setBounds(0, 685, 430, 68);
		add(ad);
		ad.setLayout(null);
		
		JLabel adlb = new JLabel(new ImageIcon(new ImageIcon("images/won/±¤°í2.PNG").getImage().getScaledInstance(430, 68, 0)));
		adlb.setBounds(0, 0, 430, 68);
		ad.add(adlb);
		
		recipe1.addMouseListener(new MouseAdapter() {
			
			@Override 
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new RecipePage(mf,lp));
				
			}
			
		});
		
		
		btnNewButton.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf,mp, new LoginPage(mf));
				
			}
			
		});
		mf.repaint();

	}
}
