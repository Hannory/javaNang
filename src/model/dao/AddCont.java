package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.vo.Cont;
//

public class AddCont {

	public void saveFile() {

		ObjectOutputStream oop = null;
		try {
			oop = new ObjectOutputStream(new FileOutputStream("recipeTitle.txt"));
			oop.writeObject("������ �����");
			oop.flush();

		}catch (IOException e) {
			e.printStackTrace();
		} try {
			oop.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	 


public void openFile() {
	ObjectInputStream oip = null;
	
	try {
	oip =new ObjectInputStream(new FileInputStream ("recipeTitle.txt"));
	//�ܼ�â���� �� ����� �Ǵ��� ���� ����
	System.out.println(oip.readObject().toString());
	
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
		try {
			oip.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}

//������ ���� ����1.�ϰ� ����  ������ �ؽ�Ʈ���� �����ؽ�Ʈ�ʵ�� > ����ϱ⸦ ���� ������ �����ڸ� �����ִ� �Խ��� ����.���� 
