package view.manager;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import model.vo.User;
import view.ChangePanel;
import view.LoginPage;
import view.MainFrame;

import javax.swing.JTextField;

public class SecondPage__2 extends JPanel {
//// 
   MainFrame mf;
   SecondPage__2 mp;
   private JTextField textField;




   public SecondPage__2(MainFrame mf) {
      
      //필드값 초기화 
      this.mf=mf;
      this.mp=this;
      
      
      //전체 패널 기본 설정 
      
      setBackground(UIManager.getColor("CheckBox.background"));
      setLayout(null);
      setSize(445,770);
      
      
      mf.getContentPane().add(mp);
      
      //상단패널 설정 

      JPanel panel_1 = new JPanel();
      panel_1.setBackground(new Color(102, 204, 204));
      panel_1.setBounds(0, 0, 445, 70);
      this.add(panel_1);
      panel_1.setLayout(null);

      //하단 패널 설정
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(Color.WHITE);
      panel_2.setBounds(0,70,445,700);
      mp.add(panel_2);
      panel_2.setLayout(null);
      
      JTextArea textArea_1 = new JTextArea();
      textArea_1.setBounds(130, 33, 208, 41);
      panel_2.add(textArea_1);
      textArea_1.setBackground(new Color(255, 255, 255));
      textArea_1.setFont(new Font("맑은 고딕", Font.BOLD, 32));
      textArea_1.setText("\uD68C\uC6D0\uC81C\uC7AC\uB300\uC0C1");
            
      JTextArea txtrId = new JTextArea();
      txtrId.setBounds(39, 108, 42, 32);
      panel_2.add(txtrId);
      txtrId.setBackground(new Color(255, 255, 255));
      txtrId.setFont(new Font("맑은 고딕", Font.BOLD, 23));
      txtrId.setText("ID");
                  
      JTextArea textArea_2 = new JTextArea();
      textArea_2.setBounds(14, 186, 113, 32);
      panel_2.add(textArea_2);
      textArea_2.setBackground(new Color(255, 255, 255));
      textArea_2.setText("\uC81C\uC7AC \uC0AC\uC720");
      textArea_2.setFont(new Font("맑은 고딕", Font.BOLD, 23));
                        
      JButton btnNewButton = new JButton("\uC81C\uC7AC \uB4F1\uB85D");
      btnNewButton.setBounds(151, 642, 148, 27);
      panel_2.add(btnNewButton);
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 23));

      textField = new JTextField();
      textField.setBounds(126, 112, 245, 31);
      panel_2.add(textField);
      textField.setColumns(10);
      
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased (MouseEvent e) {
         
            HashMap asds = new HashMap();

            ObjectInputStream objIn = null;

            try {
               objIn = new ObjectInputStream(new FileInputStream("userList.dat"));

               try {
                  asds = (HashMap) objIn.readObject();
                  System.out.println("asds : " + asds);
                  User u1 = (User) asds.get(textField.getText());
                  System.out.println("u1 : " + u1);
                  System.out.println("textField : " + textField.getText());
                  System.out.println("asds.containsKey(textField)" + asds.containsKey(textField));
                  
                         if(/*u1.getUserId().equals(textField)*/asds.containsKey(textField.getText())) {
                          u1.setUserId(null);
                          u1.setUserPw(null);
                          u1.setNickname(null);
                          u1.setEmail(null);
                          
                          
                          asds.put(textField, u1);
                          JOptionPane.showMessageDialog(null, "회원 제재가 완료되었습니다.");
                         }else {
                          JOptionPane.showMessageDialog(null, "존재하는 회원의 아이디를 입력하세요.");
                         }

                  
               } catch (ClassNotFoundException e1) {
                  e1.printStackTrace();
               } 
            } catch (FileNotFoundException e1) {
               e1.printStackTrace();
            } catch (IOException e1) {
               e1.printStackTrace();
            } finally {
               try {
                  objIn.close();
               } catch (IOException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
            }

            try {
               ObjectOutputStream oosOut = new ObjectOutputStream(new FileOutputStream("userList.dat"));
               oosOut.writeObject(asds);
               oosOut.flush();
            } catch (FileNotFoundException e1) {
               e1.printStackTrace();
            } catch (IOException e1) {
               e1.printStackTrace();
            }
         }
      });

      
      JRadioButton rdbtnNewRadioButton = new JRadioButton(" \uC6F9\uD558\uB4DC \uC544\uC774\uB514 \uD64D\uBCF4");
      rdbtnNewRadioButton.setBounds(126, 226, 245, 27);
      panel_2.add(rdbtnNewRadioButton);
      rdbtnNewRadioButton.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
                                    
      JRadioButton radioButton = new JRadioButton(" \uC131\uC778\uC790\uB8CC \uD64D\uBCF4");
      radioButton.setBounds(126, 281, 245, 27);
      panel_2.add(radioButton);
      radioButton.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      radioButton.setBackground(new Color(255, 255, 255));
                                          
      JRadioButton radioButton_1 = new JRadioButton(" \uBE44\uBC29 \uBC0F \uC695\uC124 \uAC8C\uC2DC\uBB3C");
      radioButton_1.setBounds(126, 335, 245, 27);
      panel_2.add(radioButton_1);
      radioButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      radioButton_1.setBackground(new Color(255, 255, 255));
                                                
      JRadioButton radioButton_2 = new JRadioButton(" \uC74C\uB780 \uAC8C\uC2DC\uBB3C");
      radioButton_2.setBounds(126, 452, 192, 27);
      panel_2.add(radioButton_2);
      radioButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      radioButton_2.setBackground(new Color(255, 255, 255));
                                                      
      JRadioButton radioButton_3 = new JRadioButton(" \uAD11\uACE0 \uAC8C\uC2DC\uBB3C");
      radioButton_3.setBounds(127, 517, 202, 27);
      panel_2.add(radioButton_3);
      radioButton_3.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      radioButton_3.setBackground(new Color(255, 255, 255));
                                                            
      JRadioButton radioButton_4 = new JRadioButton(" \uAE30\uD0C0 \uC0AC\uC720");
      radioButton_4.setBounds(126, 575, 164, 27);
      panel_2.add(radioButton_4);
      radioButton_4.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      radioButton_4.setBackground(new Color(255, 255, 255));
                                                                  
      JRadioButton radioButton_5 = new JRadioButton(" \uCD94\uCC9C \uC870\uC791");
      radioButton_5.setBounds(126, 395, 139, 27);
      panel_2.add(radioButton_5);
      radioButton_5.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
      radioButton_5.setBackground(new Color(255, 255, 255));
                              
      JTextArea textArea = new JTextArea();
      textArea.setForeground(new Color(255, 255, 255));
      textArea.setBackground(new Color(102, 204, 204));
      textArea.setFont(new Font("맑은 고딕", Font.BOLD, 27));
      textArea.setText("\uD68C\uC6D0 \uC81C\uC7AC");
      textArea.setBounds(145, 13, 153, 47);
      panel_1.add(textArea);
      textArea.setLayout(null);
      
      JButton button_1 = new JButton("\u2190");
      button_1.setBackground(new Color(72, 209, 204));
      button_1.setBounds(14, 14, 53, 48);
      panel_1.add(button_1);
       
   
      button_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(MouseEvent e) {
            ChangePanel.changePanel(mf,mp, new MainPage(mf));
         }
      });

      //제제 등록 누를때 삭제 기능을 추가 못할 시 팝업창이라도 띄우기
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased (MouseEvent e) {
            
             
         
            
            //JOptionPane.showMessageDialog(null, "제제 등록이 완료 되었습니다.");
         }
      });

      mf.repaint();

   }
}