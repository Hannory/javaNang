package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import model.vo.User;
import view.MainFrame;
import view.SignUp;

public class AddUser {
	
	
	public void writeUserList(JPanel SignUp, User u) {	
		
		HashMap umap = new HashMap();
		umap.put(u.getUserId(), u);
		
		System.out.print("umap : " );
		System.out.println(umap);
		
		/*Collection users = umap.values();
		
		Object[] uar = users.toArray();*/
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.dat", true));
		
			oos.writeObject(umap);
			
			
			oos.flush();
			
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

	/*public Object readUserList() {

		System.out.println("리드 메소드 진입 ");
		Object umap = null;

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));

			umap =   ois.readObject();



			System.out.println("Object umap : " + umap);





		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("리턴 직전");
		return umap;






}*/
}
