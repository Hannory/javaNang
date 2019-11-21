package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//

public class AddCont {

	public void saveFile() {

		ObjectOutputStream oop = null;
		try {
			oop = new ObjectOutputStream(new FileOutputStream("recipeCont.txt"));
			oop.writeObject("마라탕 만들기");
			oop.flush();

		}catch (IOException e) {
			e.printStackTrace();
		} try {
			oop.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile2() {
		ObjectOutputStream oop1 = null;
		try { 
			oop1 = new ObjectOutputStream(new FileOutputStream("recipeTitle.txt"));
			oop1.writeObject("햄버거 만들기");
			oop1.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}try {
			oop1.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

public void openFile() {
	ObjectInputStream oip = null;
	
	try {
	oip =new ObjectInputStream(new FileInputStream ("recipeCont.txt"));
	//콘솔창에서 잘 출력이 되는지 보기 위함
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

public void openFile2() {
	ObjectInputStream oip2 = null;
	try {
		oip2 = new ObjectInputStream(new FileInputStream ("recipetitle.txt"));
		System.out.println(oip2.readObject().toString());
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
		try {
			oip2.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

}

