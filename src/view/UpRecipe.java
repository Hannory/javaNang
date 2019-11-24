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
////
public class UpRecipe extends JPanel {
	MainFrame mf;
	JPanel mp;
	JTextField recipeCont;
	JTextField recipeName;
	JLabel recipefile;
	
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

		JButton button0 = new JButton("\u2190");
		button0.setFont(new Font("굴림", Font.BOLD, 20));
		button0.setForeground(new Color(255, 255, 255));
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button0.setBounds(14,7,59,58);
		panel.add(button0);
		button0.setBackground(new Color(72, 209, 204));

		JTextPane textpane4 = new JTextPane();
		panel.add(textpane4);
		textpane4.setBounds(112,15,209,43);
		textpane4.setEditable(false);
		textpane4.setBackground(new Color(102, 204, 204));
		textpane4.setForeground(Color.white);
		textpane4.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		textpane4.setText("레시피 업로드" );
		panel2.setLayout(null);

		JButton button1 = new JButton("공유하기");
		button1.setBounds(175,636,129,41);
		panel2.add(button1);
		button1.setForeground(Color.DARK_GRAY);
		button1.setFont(new Font("Dialog", Font.BOLD, 21));
		button1.setBackground(Color.white);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				saveFile();
				saveFile2();
			//	saveFile3();
			}
		});


		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new UpMyRecipe(mf)); 
			}
		});

		mf.repaint();		

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

		Panel panel3 = new Panel();
		panel3.setBounds(0,12,90,162);
		panel2.add(panel3);
		panel3.setLayout(null);

		Panel panel5 = new Panel();
		panel5.setBounds(96,12,80,162);
		panel2.add(panel5);
		panel5.setLayout(null);

		Panel panel6 = new Panel();
		panel6.setBounds(182,12,80,162);
		panel2.add(panel6);
		panel6.setLayout(null);


		Panel panel4 = new Panel();
		panel4.setBounds(268,12,80,162);
		panel2.add(panel4);
		panel4.setLayout(null);

		JTextPane textpane3= new JTextPane();
		textpane3.setBounds(42,562,48,35);
		panel2.add(textpane3);
		textpane3.setText("사진");
		textpane3.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Panel panel7 = new Panel();
		panel7.setBounds(354,12,80,162);
		panel2.add(panel7);
		panel7.setLayout(null);


		JLabel recipePhoto = new JLabel(new ImageIcon(new ImageIcon("images/yu/vegetables.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto.setBounds(0,12,90,138);
		panel3.add(recipePhoto);

		JLabel recipePhoto3 = new JLabel(new ImageIcon(new ImageIcon("images/yu/fish.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto3.setBounds(0,12,80,138);
		panel5.add(recipePhoto3);

		JLabel recipePhoto4 = new JLabel(new ImageIcon(new ImageIcon("images/yu/meat.PNG").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto4.setBounds(0,12,80,138);
		panel6.add(recipePhoto4);


		JLabel recipePhoto5 = new JLabel (new ImageIcon(new ImageIcon("images/yu/bread.png").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto5.setBounds(0, 12, 80, 138);
		panel4.add(recipePhoto5);


		JLabel recipePhoto2 = new JLabel(new ImageIcon(new ImageIcon("images/yu/milk.png").getImage().getScaledInstance(130, 180, 0)));
		recipePhoto2.setBounds(0, 12, 80, 138);
		panel7.add(recipePhoto2);

		//텍스트 필드 추가
		JTextField recipeName = new JTextField();
		this.recipeName =recipeName;
		recipeName.setBounds(116,220,306,35);
		panel2.add(recipeName);
		saveFile2();

		JTextField recipeCont = new JTextField();
		this.recipeCont = recipeCont;
		recipeCont.setBounds(111,278,311,235);
		panel2.add(recipeCont);
		saveFile();





		// 뒤로가기 
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, mp, new MainMenu(mf )); 
			}
		});


		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//File();

				JTextField recipefile = new JTextField(File());
				recipefile.setBounds(112,562,179,32);
				panel2.add(recipefile);
				//saveFile3();
			}
		});


		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased (MouseEvent e) {
				JOptionPane.showMessageDialog(null, "등록이 완료되었습니다. 승인 요청에 2-3일 소요됩니다.");
			}
		});

		mf.repaint();
	}


	//파일찾기
	public String File(){

		String folderPath = " ";

		JFileChooser Photo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


		Photo.setCurrentDirectory(new File("/")); 
		Photo.setAcceptAllFileFilterUsed(true);  
		Photo.setDialogTitle("레시피 사진 탐색"); // 
		Photo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary File", "cd11"); 
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


		//파일탐색기에서 이미지 불러오기
		//텍스트 두줄 나오게 하기 
		//재료입력
		//로그인을 하면 관리자페이지랑 연결  
		//관리자 레시피 승인 및 회원 제제 
		//시험
	}

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

//	public void saveFile3() {
//
//	
//		ObjectOutputStream oop3 = null;
//
//		try {
//			oop3= new ObjectOutputStream(new FileOutputStream("recipefile.txt"));
//			//File();
//			oop3.writeObject(this.recipefile);
	
			//.folderPath.getImage().getScaledInstance(180,180,0));
			
			//oop3.writeObject(recipefile) (new ImageIcon(folderPath).getImage().getScaledInstance(180, 180, 0));
			
			//recipefile.setIcon(new ImageIcon("filePath").getImage().getScaledInstance(180, 180, 0));
			//oop3.writeObject(((Object) this.recipefile.folderpath()));/////////////이부분처리할것!!!!!!!!!!!!!!!!!!!!!!!!!
			//Image recipefile = new ImageIcon("folderpath").getImage().getScaledInstance(130, 180, 0);
			//	JLabel recipePhoto2 = new JLabel(new ImageIcon(new ImageIcon("images/yu/milk.png").getImage().getScaledInstance(130, 180, 0)));
			//	Image recipefile = new ImageIcon("folderpath").getImage().getScaledInstance(130, 180, 0);

//			oop3.flush();
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}finally {
//			try {
//				oop3.close();
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}

//	}

	}


