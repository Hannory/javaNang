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
	
	//���� �����(static set) ���� + ���� �޼ҵ� ȣ��
	public void modifyData() {
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userList.dat"));){
			
			tempMap = (HashMap) in.readObject();
			tempU = (User) tempMap.get(nowUser);
			
			tempU.setUserIngred(LoginPage.ingredStatic);
			
			tempMap.put(nowUser, tempU);
			
			saveData(tempMap);	//���� �޼ҵ� ȣ��
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("���ϳ��Ŀ��");
		} catch (IOException e) {
			System.out.println("���̿��ͼ���");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ�������Ŀ��");
		}
		
		
		
	}//method
	
	
	
	//����� ������(static set/���� �����) �����ϴ� �޼ҵ�
	public void saveData(HashMap m) {
		
		File f = new File("userList.dat");
		f.delete();
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userList.dat"));
			
			out.writeObject(m);
			out.flush();
			
			System.out.println("modifyData ~ SaveData //�Ϸ�");
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("���ϳ��Ŀ��");
		} catch (IOException e) {
			System.out.println("���̿��ͼ���");
		}
		
	}
		
		
		
		
		

	
	
	
	
	
}//class
