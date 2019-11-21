package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.JPanel;

import model.vo.User;

public class UserDao {
	//userList�� �����Ͽ� SignUp �гο� �Է¹��� ���� ����
		public void writeUserList(JPanel SignUp, User u) { //SignUp �гζ����� �������� �Ű�����,,
			
			HashMap<String, User> umap = new HashMap();  //ȸ�������� ������ϰ� �Ǿ����ϴ�.. 
			umap.put(u.getUserId(), u);                  //Ű ������ userId��, value ������ ��ü u�� �־�u~
			
			System.out.print("umap : " );
			System.out.println(umap);
			
			
			ObjectOutputStream oos = null;
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream("userList.dat", true)); //true�� ����� ������ ����
			
				oos.writeObject(umap);
				
				
				oos.flush();      //���� �� �վ�帳�ϴ�.
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					oos.close();                   
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}
		
		//��������Ʈ�� �о��ִ� �޼ҵ�
		//����Ÿ������ HashMap 
		public HashMap<String, User> readUserList() {
			HashMap<String, User> umap = null;
			User u = new User();
			ObjectInputStream ois = null;
			
			
			try {
				ois = new ObjectInputStream(new FileInputStream("userList.dat"));
				
				umap = (HashMap<String, User>)ois.readObject();     //�Тh�� �ؽ������� �ٿ�ĳ��Ʈ~~
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(ois != null) {
						ois.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(umap);
			
			return umap;
		}
		
		//�ϱ� �޼ҵ�� ����Է��� �������� ���� ����.
		//���� �����̰� ����Է��� ����ڿ��� �޾� �������ָ� �ʿ������ �޼ҵ�.
		public void fileSave() {
			//���Ŀ��� �ϱ� ������ ����ڷκ��� �Է¹޾ƾ� ��
			//user1�� ����� ��� �Է�
			TreeSet userIngred01 = new TreeSet();
			userIngred01.add(2004);
			userIngred01.add(1009);
				
			//user2�� ����� ��� �Է�
			TreeSet userIngred02 = new TreeSet();
			userIngred02.add(2004);
			userIngred02.add(1001);
			userIngred02.add(3001);
				
				
			//������ �����ϰ� �Ϸ��� HashMap���� �ؾ� ��. ��ü�迭�� �ϸ� ���� �� �ڿ��� �ϳ��� ������ ��.	
			User[] mar = {
					new User("user01", userIngred01),
					new User("user02", userIngred02)
			};
			
			HashMap umap = new HashMap();
			umap.put("user01", new User("user01", userIngred01));
			//umap.put(mar[0].getUserId(), mar[0]);
			umap.put(mar[1].getUserId(), mar[1]);
			
			try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("userList.dat"/*"member.dat"*/, true));) {

				//�迭�� �ε��� �ϳ��ϳ� �ִ� ��ó��, hashMap�� Ű������ �ְų� ��°�� �־��ٰ� ��°�� ������
				objOut.writeObject(umap);
				/*for(int i = 0; i < mar.length; i++) {
					objOut.writeObject(mar[i]);
				}*/
				objOut.flush();
				
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		//�ϱ� �޼ҵ� �̸��� userIngredOpen() ���� ����
		/*public TreeSet fileOpen(int k) {
			User[] mar = new User[2];
			//HashMap umap = new HashMap();
			
			try(ObjectInputStream objIn = 
					new ObjectInputStream(new FileInputStream("member.dat"));) {
				
				for(int i = 0; i < mar.length; i++) {
					mar[i] = (User) objIn.readObject();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return mar[k].getUserIngred();
		}*/
		
		//��� �Է� ���� ���� ���� Ư�� ���� �� �׽�Ʈ�� �ҷ�����
		public TreeSet userIngred01() {
			HashMap umap = new HashMap();
			User u = new User();
			
			try(ObjectInputStream objIn = 
					new ObjectInputStream(new FileInputStream("userList.dat"/*"member.dat"*/));) {

				umap = (HashMap) objIn.readObject();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			//���Ŀ��� "user01"�� �α����� id�� �־��־�� ��.
			u = (User) umap.get("user01");
			//u.getUserPw(); 		// id�� user01�� ȸ���� ���� ��й�ȣ �ҷ�����
			//u.setUserPw("���ο� ��й�ȣ ��");  // id�� user01�� ȸ���� �Է��� ��й�ȣ�� ����
			

			
			
			System.out.println("4th check : " + u.getUserIngred());
			
			return u.getUserIngred();
		}
		
		/*public String userEmail(String logInId) {
			HashMap umap = new HashMap();
			User u = new User();
			
			try(ObjectInputStream objIn = 
					new ObjectInputStream(new FileInputStream("userList.dat""member.dat"));) {

				umap = (HashMap) objIn.readObject();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			u = (User) umap.get(logInId);
			
			return u.getEmail();
		}*/
	
}
