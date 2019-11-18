package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class UpRecipe extends JPanel {
MainFrame mf;
JPanel mp;



//�غ��� ���ֱ� 

public UpRecipe(MainFrame mf) {
	
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
		textpane4.setText("������ ���ε�" );
	panel2.setLayout(null);
	
	JButton button1 = new JButton("�����ϱ�");
	button1.setBounds(175,632,129,41);
	panel2.add(button1);
	button1.setForeground(Color.DARK_GRAY);
	button1.setFont(new Font("Dialog", Font.BOLD, 21));
	button1.setBackground(Color.white);
	
	JButton button2 = new JButton("���ϼ���");
	button2.setBounds(305,562,117,37);
	panel2.add(button2);
	button2.setForeground(Color.DARK_GRAY);
	button2.setFont(new Font("Dialog", Font.BOLD, 18));
	button2.setBackground(Color.WHITE);
	
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
	textpane3.setBounds(28,562,48,35);
	panel2.add(textpane3);
	textpane3.setText("����");
	textpane3.setFont(new Font("�������",Font.BOLD,20));
	
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
	
	//�ؽ�Ʈ �ʵ� �߰�
	
	JTextField recipeName = new JTextField();
	recipeName.setBounds(116,220,306,35);
	panel2.add(recipeName);
	
	
	
	JTextField recipeCont = new JTextField();
	recipeCont.setBounds(111,278,311,235);
	panel2.add(recipeCont);
	
	JTextField recipefile = new JTextField();
	recipefile.setBounds(112,562,179,32);
	panel2.add(recipefile);

	// �ڷΰ��� ��ư 
	button0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, mp, new MainMenu(mf )); //�ڷΰ��� ��ư�� ������ ���� �޴��� ���;� ��! 
		}
	});
	
	
	button2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			File();
		}
	});
  	mf.repaint();
  	
  	
}
	    public String File(){
	        
	        String folderPath = "";
	        
	        JFileChooser Photo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	        Photo.setCurrentDirectory(new File("/")); 
	        Photo.setAcceptAllFileFilterUsed(true);  
	        Photo.setDialogTitle("������ ���� Ž��"); // 
	        Photo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
	        
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary File", "cd11"); 
	        Photo.setFileFilter(filter); 
	        
	        int returnVal = Photo.showOpenDialog(null); 
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION) { 
	            folderPath = Photo.getSelectedFile().toString();
	        }else if(returnVal == JFileChooser.CANCEL_OPTION){
	            System.out.println("cancel"); 
	            folderPath = "";
	        }
	        
	        return folderPath;

	    }

}



