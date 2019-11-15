package view.manager;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainPage extends JPanel {

	JFrame mf;
	JPanel mp;
	private JTextField textField;





	public MainPage(JFrame mf) {

		this.mf = mf;
		this.mp = this;


		this.setBounds(0, 0, 432, 753);
		this.setBackground(UIManager.getColor("CheckBox.background"));
		this.setLayout(null);

		/*JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 450, 800);
		add(panel_1);
		panel_1.setLayout(null);*/
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);*/

		mf.getContentPane().add(this);

		JButton btnNewButton = new JButton("\uB808\uC2DC\uD53C \uC2B9\uC778");
		btnNewButton.setBounds(129, 265, 174, 58);
		add(btnNewButton);
		btnNewButton.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));
		//mp.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uC81C\uC7AC");
		btnNewButton_1.setBounds(141, 476, 174, 58);
		add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 432, 77);
		add(panel_3);
		panel_3.setBackground(new Color(70, 130, 180));
		panel_3.setLayout(null);

		textField = new JTextField();
		textField.setBackground(new Color(70, 130, 180));
		textField.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 32));
		textField.setText("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		textField.setBounds(109, 12, 204, 65);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\uD68C\uC6D0 \uC81C\uC7AC");
		label_1.setBounds(113, 546, 174, 50);
		add(label_1);
		
		JLabel label = new JLabel("\uB808\uC2DC\uD53C \uC2B9\uC778");
		label.setBounds(192, 220, 147, 18);
		add(label);
		
		
	
		
		btnNewButton_1.addMouseListener(new MyItem2());
		btnNewButton.addMouseListener(new MyItem());
		mf.repaint();


	}

	class MyItem extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new SecondPage_1(mf));


		}

	}

	class MyItem2 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			new ChangePanel().changePanel(mf, mp, new SecondPage__2(mf));
		}
	}
}

