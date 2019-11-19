package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.vo.User;
import view.MainFrame;
import view.SignUp;

public class AddUser {
	
	
	public void writeUserList(JPanel SignUp, User u) {	
		
		System.out.println("test");
		
		System.out.println(u);
		
		System.out.println("test2");
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.dat", true));
			
			oos.writeObject(u);
			
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
	
	public void readUserList() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));
			
			User user = (User) ois.readObject();
			
			System.out.println(user);
			
			//ois.readObject();
			
			 
		
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
		
	}

	
	
	
	/*public ArrayList<User> readUserList() {
		ObjectInputStream ois = null;
		ArrayList<User> list = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));
			
			list = (ArrayList<User>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return list;
		
		
	}
	
	
	public int writeUserList(ArrayList<User> list) {
		ObjectOutputStream oos = null;
		
		int result = 0;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.dat", true));
			
			oos.writeObject(list);
			
			result++;
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	*/
	
}
