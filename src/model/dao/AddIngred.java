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

public class AddIngred{

	String nowUser = AllRecipe.loginId;
	HashMap tempMap = new HashMap();
	User tempU = new User();
	
	public static TreeSet ingredStatic = new TreeSet();			//이 라인 없애고 로그인 단계에서 스태틱에 선언하기	//라인32 참고
	
	
	
	
	
	public void makeTreeSet(int ingredNo) {
		
		
		//기존 유저는 냉장고 정보 유지해야하므로 로그인 단계에서 스태틱재료에 값 넣어줄것 	//라인23 참고
		
		ingredStatic.add(ingredNo);
		System.out.println(ingredStatic.toString());
		
		
		
	}
	
	
	public void modifyData() {
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userList.dat"));){
			
			tempMap = (HashMap) in.readObject();
			tempU = (User) tempMap.get(nowUser);
			
			tempU.setUserIngred(ingredStatic);
			
			tempMap.put(nowUser, tempU);
			
			saveData(tempMap);	//메소드 호출
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일낫파운드");
		} catch (IOException e) {
			System.out.println("아이오익셉션");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스낫파운드");
		}
		
		
		
	}//method
	
	
	
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
