package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

public class UpRecipe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public UpRecipe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 432, 753);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_1 = new JButton("\uACF5\uC720\uD558\uAE30");
		button_1.setBounds(139, 645, 204, 48);
		panel_1.add(button_1);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
		button_1.setBackground(Color.WHITE);
		
		JButton button_2 = new JButton("\uD30C\uC77C \uC120\uD0DD");
		button_2.setBounds(309, 568, 118, 33);
		panel_1.add(button_2);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
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
		button.setBounds(22, 20, 40, 42);
		panel.add(button);
		button.setBackground(new Color(70, 130, 180));
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(86, 568, 217, 32);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 82, 80, 123);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(89, 82, 80, 123);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		Panel panel_5 = new Panel();
		panel_5.setBounds(175, 82, 80, 123);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		Panel panel_6 = new Panel();
		panel_6.setBounds(261, 82, 80, 123);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(347, 82, 80, 123);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
	}
}
