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
	
	public static TreeSet ingredStatic = new TreeSet();			//�� ���� ���ְ� �α��� �ܰ迡�� ����ƽ�� �����ϱ�	//����32 ����
	
	
	
	
	
	public void makeTreeSet(int ingredNo) {
		
		
		//���� ������ ����� ���� �����ؾ��ϹǷ� �α��� �ܰ迡�� ����ƽ��ῡ �� �־��ٰ� 	//����23 ����
		
		ingredStatic.add(ingredNo);
		System.out.println(ingredStatic.toString());
		
		
		
	}
	
	
	public void modifyData() {
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userList.dat"));){
			
			tempMap = (HashMap) in.readObject();
			tempU = (User) tempMap.get(nowUser);
			
			tempU.setUserIngred(ingredStatic);
			
			tempMap.put(nowUser, tempU);
			
			saveData(tempMap);	//�޼ҵ� ȣ��
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("���ϳ��Ŀ��");
		} catch (IOException e) {
			System.out.println("���̿��ͼ���");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ�������Ŀ��");
		}
		
		
		
	}//method
	
	
	
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
