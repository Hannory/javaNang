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
	//userList를 생성하여 SignUp 패널에 입력받은 값들 쓰기
		public void writeUserList(JPanel SignUp, User u) { //SignUp 패널때문에 더러워진 매개변수,,
			
			HashMap<String, User> umap = new HashMap();  //회원정보를 입출력하게 되었습니다.. 
			umap.put(u.getUserId(), u);                  //키 값으로 userId를, value 값으로 객체 u를 넣어u~
			
			System.out.print("umap : " );
			System.out.println(umap);
			
			
			ObjectOutputStream oos = null;
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream("userList.dat", true)); //true를 써줘야 정보가 누적
			
				oos.writeObject(umap);
				
				
				oos.flush();      //막힌 거 뚫어드립니다.
				
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
		
		//유저리스트를 읽어주는 메소드
		//리턴타입으로 HashMap 
		public HashMap<String, User> readUserList() {
			HashMap<String, User> umap = null;
			User u = new User();
			ObjectInputStream ois = null;
			
			try {
				ois = new ObjectInputStream(new FileInputStream("userList.dat"));
				
				umap = (HashMap<String, User>)ois.readObject();     //압줵을 해쉬맵으로 다운캐스트~~
				
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
		
		//하기 메소드는 재료입력을 수동으로 해준 것임.
		//향후 원용이가 재료입력을 사용자에서 받아 저장해주면 필요없어질 메소드.
		public void fileSave() {
			//추후에는 하기 값들을 사용자로부터 입력받아야 함
			//user1의 냉장고에 재료 입력
			TreeSet userIngred01 = new TreeSet();
			userIngred01.add(2004);
			userIngred01.add(1009);
				
			//user2의 냉장고에 재료 입력
			TreeSet userIngred02 = new TreeSet();
			userIngred02.add(2004);
			userIngred02.add(1001);
			userIngred02.add(3001);
				
				
			//삭제를 용이하게 하려면 HashMap으로 해야 함. 객체배열로 하면 삭제 시 뒤에서 하나씩 당겨줘야 함.	
			User[] mar = {
					new User("user01", userIngred01),
					new User("user02", userIngred02)
			};
			
			HashMap umap = new HashMap();
			umap.put("user01", new User("user01", userIngred01));
			//umap.put(mar[0].getUserId(), mar[0]);
			umap.put(mar[1].getUserId(), mar[1]);
			
			try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("userList.dat"/*"member.dat"*/, true));) {

				//배열의 인덱스 하나하나 넣는 것처럼, hashMap도 키값별로 넣거나 통째로 넣었다가 통째로 빼내야
				objOut.writeObject(umap);
				/*for(int i = 0; i < mar.length; i++) {
					objOut.writeObject(mar[i]);
				}*/
				objOut.flush();
				
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		//하기 메소드 이름을 userIngredOpen() 으로 변경
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
		
		//재료 입력 로직 구현 전에 특정 유저 값 테스트로 불러오기
		public TreeSet userIngred01() {
			HashMap umap = new HashMap();
			User u = new User();
			
			try(ObjectInputStream objIn = 
					new ObjectInputStream(new FileInputStream("userList.dat"/*"member.dat"*/));) {

				umap = (HashMap) objIn.readObject();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			//향후에는 "user01"을 로그인한 id로 넣어주어야 함.
			u = (User) umap.get("user01");
			//u.getUserPw(); 		// id가 user01인 회원의 현재 비밀번호 불러오기
			//u.setUserPw("새로운 비밀번호 값");  // id가 user01인 회원이 입력한 비밀번호로 수정
			

			
			
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
