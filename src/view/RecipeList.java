package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import model.vo.Cont;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecipeList extends JPanel {
	MainFrame mf;
	JPanel mp;
	JTextField recipeCont;

//

	public RecipeList(MainFrame mf) {

		//필드값 초기화
		this.mf=mf;   
		this.mp=this;
		
		//전체 패널(제일 큰 패널) 기본 설정 	//색 설정
		this.setSize(445,770);
		this.setBackground(new Color(190,190,190));
		setLayout(null);
		mf.getContentPane().add(mp);

		//상단 패널 설정
		JPanel panel = new JPanel();
		panel.setBackground(new Color(63,141,197));
		panel.setBounds(0,0,445,70);
		mp.add(panel);
		panel.setLayout(null);

		//하단 패널 설정 
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0,70,445,700);
		mp.add(panel2);
		panel.setLayout(null);

		JButton button0 = new JButton("<<");
		button0.setBounds(29,22,58,33);
		panel.add(button0);
		button0.setBackground(new Color(70,130,180));
	
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new UpMyRecipe(mf));
			}
		});

		
		

		JTextPane textpane4 = new JTextPane();
		panel.add(textpane4);
		textpane4.setBounds(112,15,209,43);
		textpane4.setEditable(false);
		textpane4.setBackground(new Color(70,130,180));
		textpane4.setForeground(Color.white);
		textpane4.setFont(new Font("굴림",Font.PLAIN,32));
		textpane4.setText("\uB808\uC2DC\uD53C \uB9AC\uC2A4\uD2B8" );
		panel2.setLayout(null);

		JTextPane textpane1= new JTextPane();
		textpane1.setBounds(28,210,69,35);
		panel2.add(textpane1);
		textpane1.setText("요리명"); 
		textpane1.setFont(new Font("맑은고딕",Font.BOLD,20));

		JTextPane textpane2 = new JTextPane();
		textpane2.setBounds(28,267,69,35);
		panel2.add(textpane2);
		textpane2.setText("레시피");
		textpane2.setFont(new Font("맑은고딕",Font.BOLD,20));

		JTextPane textpane3= new JTextPane();
		textpane3.setBounds(28,562,48,35);
		panel2.add(textpane3);
		textpane3.setText("사진");
		textpane3.setFont(new Font("맑은고딕",Font.BOLD,20));

		//텍스트 필드 추가
		JTextField recipeName = new JTextField();
		recipeName.setBounds(116,220,306,35);
		panel2.add(recipeName);

		JTextField recipeCont = new JTextField();
		this.recipeCont = recipeCont;
		recipeCont.setBounds(111,278,311,235);
		panel2.add(recipeCont);

		JTextField recipefile = new JTextField();
		recipefile.setBounds(112,562,179,32);
		panel2.add(recipefile);
		
		
		mf.repaint();
}
	
	
	

		

	}








