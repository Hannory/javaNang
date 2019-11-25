package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class UpRecipe extends JPanel {

	MainFrame mf;
	JPanel mp;
	JTextField recipeCont;
	JTextField recipeName;
	JLabel recipefile;

	static String picAdr;

	public UpRecipe() {}

	public UpRecipe(MainFrame mf) {

		//필드값 초기화  
		this.mf=mf; 
		this.mp=this;

		//전체 패널(제일 큰 패널) 기본 설정
		this.setSize(445,770);
		this.setBackground(new Color(190,190,190));
		setLayout(null);
		mf.getContentPane().add(mp);

		//상단 패널 설정
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0,0,445,70);
		mp.add(panel);
		panel.setLayout(null);

		//하단 패널 설정 
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0,70,445,700);
		mp.add(panel2);
		panel.setLayout(null);

		Panel panel3 = new Panel();
		panel3.setBounds(0,12,90,162);
		panel2.add(panel3);
		panel3.setLayout(null);


		Panel panel4 = new Panel();
		panel4.setBounds(268,12,80,162);
		panel2.add(panel4);
		panel4.setLayout(null);

		Panel panel5 = new Panel();
		panel5.setBounds(96,12,80,162);
		panel2.add(panel5);
		panel5.setLayout(null);

		Panel panel6 = new Panel();
		panel6.setBounds(182,12,80,162);
		panel2.add(panel6);
		panel6.setLayout(null);


		Panel panel7 = new Panel();
		panel7.setBounds(354,12,80,162);
		panel2.add(panel7);
		panel7.setLayout(null);


		JButton button0 = new JButton("\u2190");
		button0.setFont(new Font("굴림", Font.BOLD, 20));
		button0.setForeground(new Color(255, 255, 255));
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button0.setBounds(14,7,59,58);
		button0.setBackground(new Color(72, 209, 204));
		panel.add(button0);


		JButton button1 = new JButton("공유하기");
		button1.setBounds(175,636,129,41);
		button1.setForeground(Color.DARK_GRAY);
		button1.setFont(new Font("Dialog", Font.BOLD, 21));
		button1.setBackground(Color.white);
		panel2.add(button1);

		JButton button2 = new JButton("파일선택");
		button2.setBounds(305,562,117,37);
		panel2.add(button2);
		button2.setForeground(Color.DARK_GRAY);
		button2.setFont(new Font("Dialog", Font.BOLD, 18));
		button2.setBackground(Color.WHITE);


		JTextPane textpane1= new JTextPane();
		textpane1.setBounds(28,210,69,35);
		panel2.add(textpane1);
		textpane1.setText("요리명"); 
		textpane1.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JTextPane textpane2 = new JTextPane();
		textpane2.setBounds(28,267,69,35);
		panel2.add(textpane2);
		textpane2.setText("레시피");
		textpane2.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JTextPane textpane3= new JTextPane();
		textpane3.setBounds(42,562,48,35);
		panel2.add(textpane3);
		textpane3.setText("사진");
		textpane3.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JTextPane textpane4 = new JTextPane();
		textpane4.setBounds(112,15,209,43);
		textpane4.setEditable(false);
		textpane4.setBackground(new Color(102, 204, 204));
		textpane4.setForeground(Color.white);
		textpane4.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		textpane4.setText("레시피 업로드" );
		panel2.setLayout(null);
		panel.add(textpane4);



		JLabel recipePhoto = new JLabel(new ImageIcon(new ImageIcon("images/yu/vegetables.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto.setBounds(0,12,90,138);
		panel3.add(recipePhoto);

		JLabel recipePhoto2 = new JLabel(new ImageIcon(new ImageIcon("images/yu/milk.png").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto2.setBounds(0, 12, 80, 138);
		panel7.add(recipePhoto2);

		JLabel recipePhoto3 = new JLabel(new ImageIcon(new ImageIcon("images/yu/fish.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto3.setBounds(0,12,80,138);
		panel5.add(recipePhoto3);

		JLabel recipePhoto4 = new JLabel(new ImageIcon(new ImageIcon("images/yu/meat.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto4.setBounds(0,12,80,138);
		panel6.add(recipePhoto4);


		JLabel recipePhoto5 = new JLabel (new ImageIcon(new ImageIcon("images/yu/bread.png").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto5.setBounds(0, 12, 80, 138);
		panel4.add(recipePhoto5);




		//텍스트 필드 추가
		JTextField recipeName = new JTextField();
		this.recipeName =recipeName;
		recipeName.setBounds(116,220,306,35);
		panel2.add(recipeName);


		JTextField recipeCont = new JTextField();
		this.recipeCont = recipeCont;
		recipeCont.setBounds(111,278,311,235);
		panel2.add(recipeCont);



		mf.repaint();		


		// 뒤로가기 
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new MainMenu(mf )); 
			}
		});

		//공유하기
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				saveFile();
				saveFile2();

				JOptionPane.showMessageDialog(null, "등록이 완료되었습니다. 승인 요청에 2-3일 소요됩니다.");

				ChangePanel.changePanel(mf, mp, new UpMyRecipe(mf)); 
			}
		});


		//파일찾기
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				picAdr = file();

				JTextField recipefile = new JTextField(picAdr);
				recipefile.setBounds(112,562,179,32);
				panel2.add(recipefile);		
			}
		});


		mf.repaint();
	}


	//파일찾기
	public String file(){

		String folderPath = " ";

		JFileChooser Photo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


		Photo.setCurrentDirectory(new File("/")); 
		Photo.setAcceptAllFileFilterUsed(true);  
		Photo.setDialogTitle("레시피 사진 탐색"); // 
		Photo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 

		FileNameExtensionFilter filter = new FileNameExtensionFilter("jiyeon File", "cd11"); 
		Photo.setFileFilter(filter); 

		int returnVal = Photo.showOpenDialog(null); 

		if(returnVal == JFileChooser.APPROVE_OPTION) { 

			folderPath = Photo.getSelectedFile().getPath();
		}else if(returnVal == JFileChooser.CANCEL_OPTION){
			System.out.println("cancel"); 
			folderPath =  " ";

		}


		System.out.println("폴더 어딨냐 : " + folderPath);		

		return folderPath;
	}


	//제목 파일 생성
	public void saveFile2() {
		ObjectOutputStream oop2 =null;

		try {
			oop2 = new ObjectOutputStream(new FileOutputStream("recipeTitle.txt"));
			oop2.writeObject(this.recipeName.getText());
			oop2.flush();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				oop2.close();
			}catch(IOException e) {
				e.printStackTrace();

			}
		}
	}



	//레시피 내용 파일 생성
	public void saveFile() {

		ObjectOutputStream oop =null;

		try {

			oop = new ObjectOutputStream (new FileOutputStream("recipeCont.txt"));
			oop.writeObject(this.recipeCont.getText());

			oop.flush();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}finally {

			try {
				oop.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}


}


