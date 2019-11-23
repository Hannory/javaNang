package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import model.vo.User;
import view.AllRecipe;
import view.LoginPage;

public class AddIngred{

	String nowUser = AllRecipe.loginId;
	HashMap tempMap = new HashMap();
	User tempU = new User();
	
	
	
	
	
	
	
	public void makeTreeSet(int ingredNo) {
		
		
		
		LoginPage.ingredStatic.add(ingredNo);
		System.out.println(LoginPage.ingredStatic.toString());
		
		
		
	}
	
	//현재 냉장고(static set) 수정 + 저장 메소드 호출
	public void modifyData() {
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userList.dat"));){
			
			tempMap = (HashMap) in.readObject();
			tempU = (User) tempMap.get(nowUser);
			
			tempU.setUserIngred(LoginPage.ingredStatic);
			
			tempMap.put(nowUser, tempU);
			
			saveData(tempMap);	//저장 메소드 호출
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일낫파운드");
		} catch (IOException e) {
			System.out.println("아이오익셉션");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스낫파운드");
		}
		
		
		
	}//method
	
	
	
	//변경된 데이터(static set/현재 냉장고) 저장하는 메소드
	public void saveData(HashMap m) {
		
		File f = new File("userList.dat");
		f.delete();
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userList.dat"));
			
			out.writeObject(m);
			out.flush();
			
			System.out.println("modifyData ~ SaveData //완료");
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일낫파운드");
		} catch (IOException e) {
			System.out.println("아이오익셉션");
		}
		
	}
		
		
		
		
		

	
	
	
	
	
}//class
