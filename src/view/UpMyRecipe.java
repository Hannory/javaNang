package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class UpMyRecipe extends JPanel {
	MainFrame mf;
	JPanel mp;
	JTextField recipeCont;
	String str;

//
	public UpMyRecipe(MainFrame mf) {

		//�ʵ尪 �ʱ�ȭ
		this.mf=mf;  
		this.mp=this;
		
		//��ü �г�(���� ū �г�) �⺻ ���� 	//�� ����
		this.setSize(445,770);
		this.setBackground(new Color(190,190,190));
		setLayout(null);
		mf.getContentPane().add(mp);

		//��� �г� ����
		JPanel panel = new JPanel();
		panel.setBackground(new Color(63,141,197));
		panel.setBounds(0,0,445,70);
		mp.add(panel);
		panel.setLayout(null);

		//�ϴ� �г� ���� 
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0,70,445,700);
		mp.add(panel2);
		panel.setLayout(null);

		JButton button0 = new JButton("<<");
		button0.setBounds(29,22,58,33);
		panel.add(button0);
		button0.setBackground(new Color(70,130,180));

		JTextPane textpane4 = new JTextPane();
		panel.add(textpane4);
		textpane4.setBounds(112,15,209,43);
		textpane4.setEditable(false);
		textpane4.setBackground(new Color(70,130,180));
		textpane4.setForeground(Color.white);
		textpane4.setFont(new Font("����",Font.PLAIN,32));
		textpane4.setText("\uB098\uC758 \uB808\uC2DC\uD53C" );
		panel2.setLayout(null);

		JTextPane textpane1= new JTextPane();
		textpane1.setBounds(28,210,69,35);
		panel2.add(textpane1);
		textpane1.setText("�丮��"); 
		textpane1.setFont(new Font("�������",Font.BOLD,20));

		JTextPane textpane2 = new JTextPane();
		textpane2.setBounds(28,267,69,35);
		panel2.add(textpane2);
		textpane2.setText("������");
		textpane2.setFont(new Font("�������",Font.BOLD,20));

		JTextPane textpane3= new JTextPane();
		textpane3.setBounds(28,562,48,35);
		panel2.add(textpane3);
		textpane3.setText("����");
		textpane3.setFont(new Font("�������",Font.BOLD,20));

		
		
		
		ObjectInputStream oip = null;
		
		try {
			oip = new ObjectInputStream(new FileInputStream("recipeTitle.txt"));
			String str = (String) oip.readObject().toString(); 
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}finally {
	
		}try {
		oip.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

		
		//�ؽ�Ʈ �ʵ� �߰�
		JTextField recipeName = new JTextField();
		recipeName.setBounds(116,220,306,35);
		panel2.add(recipeName);
		
		JTextArea recipeCont = new JTextArea(str);
		recipeCont.setBounds(107, 267, 315, 248);
		panel2.add(recipeCont);
		//saveFile();
		//openFile();
		

		
		

		JTextField recipefile = new JTextField();
		recipefile.setBounds(112,562,299,32);
		panel2.add(recipefile);

		// �ڷΰ��� ��ư 
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new UpRecipe(mf )); //�ڷΰ��� ��ư�� ������ ���� �޴��� ���;� ��! 
			}
		});

		mf.repaint();
}
	
public void saveFile() {
		
		ObjectOutputStream oop =null;
		
		try {

			oop = new ObjectOutputStream (new FileOutputStream("recipeTitle.txt"));
			oop.writeObject(this.recipeCont.getText());

			oop.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {

			try {
				oop.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	public void openFile() {
		ObjectInputStream oip = null;
		
		try {
		oip =new ObjectInputStream(new FileInputStream ("recipeTitle.txt"));
		//�ܼ�â���� �� ����� �Ǵ��� ���� ����
		oip.readObject().toString();
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				oip.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

	
	
	




