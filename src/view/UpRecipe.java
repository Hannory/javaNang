package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class UpRecipe extends JFrame {
	//Ãß°¡ ÇØ¾ß ÇÔ 
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpRecipe frame = new UpRecipe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public UpRecipe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 432, 783);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton button_1 = new JButton("\uACF5\uC720\uD558\uAE30");
		button_1.setBounds(112, 664, 204, 48);
		panel_1.add(button_1);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
		button_1.setBackground(Color.WHITE);

		JButton button_2 = new JButton("\uD30C\uC77C \uC120\uD0DD");
		button_2.setBounds(315, 571, 103, 33);
		panel_1.add(button_2);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		button_2.setBackground(Color.WHITE);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(14, 236, 73, 36);
		panel_1.add(textPane_1);
		textPane_1.setText("\uC694\uB9AC\uBA85");
		textPane_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(14, 296, 73, 36);
		panel_1.add(textPane_2);
		textPane_2.setText("\uB808\uC2DC\uD53C");
		textPane_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));


		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(28, 568, 52, 36);
		panel_1.add(textPane_3);
		textPane_3.setText("\uC0AC\uC9C4");
		textPane_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 76);
		panel_1.add(panel);
		panel.setBackground(new Color(70, 130, 180));
		panel.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(104, 12, 220, 52);
		textPane.setEditable(false);
		panel.add(textPane);
		textPane.setBackground(new Color(70, 130, 180));
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("±¼¸²", Font.PLAIN, 32));
		textPane.setText("\uB808\uC2DC\uD53C \uC5C5\uB85C\uB4DC ");

		Button button = new Button("\u226A");
		button.setBounds(29, 22, 38, 33);
		panel.add(button);
		button.setBackground(new Color(70, 130, 180));

		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 82, 80, 123);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
				
				//À½½Ä »çÁø 5°³ Ãß°¡ 
		
				JLabel recipePhoto = new JLabel(new ImageIcon(new ImageIcon("images/YU/Ã¤¼Ò·ù.PNG").getImage().getScaledInstance(130, 180, 0)));
				recipePhoto.setBounds(0, 0, 80, 123);
				panel_2.add(recipePhoto);

		Panel panel_4 = new Panel();
		panel_4.setBounds(80, 82, 80, 123);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
				JLabel recipePhoto2 = new JLabel(new ImageIcon(new ImageIcon("images/YU/À°·ù.PNG").getImage().getScaledInstance(130, 180, 0)));
				recipePhoto2.setBounds(0, 0, 80, 123);
				panel_4.add(recipePhoto2);

		Panel panel_5 = new Panel();
		panel_5.setBounds(175, 82, 80, 123);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		
				JLabel recipePhoto5 = new JLabel(new ImageIcon(new ImageIcon("images/YU/¼ö»ê¹°.PNG").getImage().getScaledInstance(130, 180, 0)));
				recipePhoto5.setBounds(0, 0, 80, 123);
				panel_5.add(recipePhoto5);

		Panel panel_6 = new Panel();
		panel_6.setBounds(261, 82, 80, 123);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
				JLabel recipePhoto3 = new JLabel(new ImageIcon(new ImageIcon("images/YU/À¯Á¦Ç°.PNG").getImage().getScaledInstance(130, 180, 0)));
				recipePhoto3.setBounds(0, 0, 80, 123);
				panel_6.add(recipePhoto3);

		Panel panel_7 = new Panel();
		panel_7.setBounds(347, 82, 80, 123);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		
				JLabel recipePhoto4 = new JLabel(new ImageIcon(new ImageIcon("images/YU/±âÅ¸.PNG").getImage().getScaledInstance(130, 180, 0)));
				recipePhoto4.setBounds(0, 0, 73, 123);
				panel_7.add(recipePhoto4);

		//ÅØ½ºÆ® ÇÊµå Ãß°¡ÇÑ°Å 
		JTextField recipeName = new JTextField();
		recipeName.setBounds(117, 236, 255, 33);
		panel_1.add(recipeName);

		JTextField recipeCont = new JTextField();
		recipeCont.setBounds(117,305,255,233);
		panel_1.add(recipeCont);

		JTextField recipefile = new JTextField();
		recipefile.setBounds(103,571,204,33);
		panel_1.add(recipefile);



		//µÚ·Î°¡±â ¹öÆ°
		//button.addMouseListener(new MouseAdapter() {

		//	@Override
		//	public void mouseClicked(MouseEvent e) {
		//		ChangePanel.changePanel(mf, rp, new MainMenu(mf , lp));
		//	}

		// });

	}
}
