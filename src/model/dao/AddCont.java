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
	
		
	 


public void openFile() {
	ObjectInputStream oip = null;
	
	try {
	oip =new ObjectInputStream(new FileInputStream ("recipeTitle.txt"));
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
}

//레시피 제목 내용1.하고 사진  내용을 텍스트파일 제이텍스트필드랑 > 등록하기를 눌러 관리자 관리자만 볼수있는 게시판 승인.제제 
