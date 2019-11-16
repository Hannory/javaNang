package view;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class RecipePage extends JPanel {

	MainFrame mf;
	JPanel rp;
	JPanel lp;
	
	
	public RecipePage(MainFrame mf, JPanel lp) {
		
		this.mf = mf;
		this.rp = this;
		this.lp = lp;
		
		this.setSize(450,770);
		this.setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(63, 141, 197));
		panel.setBounds(0, 0, 450, 73);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("레시피 정보");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(150, 25, 139, 30);
		panel.add(lblNewLabel);
		
		JButton button = new JButton("<-");
		button.setBounds(14, 23, 59, 27);
		panel.add(button);
		
		JButton button_1 = new JButton("로그인");
		button_1.setBounds(360, 23, 75, 27);
		panel.add(button_1);
		
		JLabel recipeImage = new JLabel(new ImageIcon(new ImageIcon("images/won/까르보나라.PNG").getImage().getScaledInstance(450, 280, 0)));
		recipeImage.setBounds(0, 85, 450, 280);
		add(recipeImage);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 389, 450, 430);
		add(textPane);
		
		
		
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, rp, new LoginPage(mf));
			}
		});
		
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, rp, new AllRecipe(mf , lp));
			}
			
		});
		
		mf.repaint();
		

	}
}
