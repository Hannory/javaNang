package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;

import controller.RecMgt;
//import controller.RecommendMgt;
import model.vo.Recipe;

public class MgrRecipeDao {
	
	//public int recipeLength = 4;	// 전체 레시피 수
	
	//UserDao ud = new UserDao();
	
	//TreeSet userIngred01 = ud.fileOpen(0);
	//TreeSet userIngred02 = ud.fileOpen(1);
	
	//public static int nowCtn = 0;
	
	//RecommendMgt rm = new RecommendMgt();
	
	ArrayList recipeList = new ArrayList();
	public static int recipeLength = 0;
	
	public void fileSave() {
		//요리1
		ArrayList rcIngred01 = new ArrayList();
		rcIngred01.add(1009);
		rcIngred01.add(2004);
		
		//요리2
		ArrayList rcIngred02 = new ArrayList();
		rcIngred02.add(1009);
		rcIngred02.add(2004);
		rcIngred02.add(3010);
		
		//요리3
		ArrayList rcIngred03 = new ArrayList();
		rcIngred03.add(1009);
		rcIngred03.add(2004);
		rcIngred03.add(4001);
		rcIngred03.add(4002);
		rcIngred03.add(4003);
		
		//요리4
		ArrayList rcIngred04 = new ArrayList();
		rcIngred04.add(1009);
		
		
		//요리5
		ArrayList rcIngred05 = new ArrayList();
		rcIngred05.add(1009);
		rcIngred05.add(2004);
		rcIngred05.add(2005);
		rcIngred05.add(3001);
		
		//요리6
		ArrayList rcIngred06 = new ArrayList();
		rcIngred06.add(1009);
		rcIngred06.add(2004);
		rcIngred06.add(2005);
		
		//요리 사진들
		
		String rcPic1 = "images/park/black noodle.jpg";
		String rcPic2 = "images/park/carbonara.jpg";
		String rcPic3 = "images/park/tomato seafood spaghetti.jpg";
		String rcPic4 = "images/park/steamed potato.jpg";
		String rcPic5 = "images/park/cheeseBall.jpg";
		String rcPic6 = "images/park/potato.jpg";
		
		/*Recipe[] rar = {
				new Recipe("recipe01", "content1", rcPic1, rcIngred01),
				new Recipe("recipe02", "content2", rcPic2, rcIngred02),
				new Recipe("recipe03", "content3", rcPic3, rcIngred03),
				new Recipe("recipe04", "content4", rcPic4, rcIngred04)
		};*/
		
		recipeList.add(new Recipe("짜장면", "짜장면을 볶습니다.", rcPic1, rcIngred01));
		recipeList.add(new Recipe("까르보나라", "크림을 준비합니다.", rcPic2, rcIngred02));
		recipeList.add(new Recipe("토마토 스파게티", "먼저 토마토를 사세요", rcPic3, rcIngred03));
		recipeList.add(new Recipe("찐감자", "감자를 찝니다.", rcPic4, rcIngred04));
		recipeList.add(new Recipe("치즈볼", "치즈를 녹입니다.", rcPic5, rcIngred05));
		recipeList.add(new Recipe("감자당근볶음", "감자와 당근을 채썹니다.", rcPic6, rcIngred06));
		
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < recipeList.size(); i++) {
				objOut.writeObject(recipeList.get(i));
			}
			objOut.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.recipeLength = recipeList.size();
	}
	
	public ArrayList fileOpenIngred(int k) {
		Recipe[] rar = new Recipe[recipeLength];
		
		try(ObjectInputStream objIn = 
				new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < rar.length; i++) {
				rar[i] = (Recipe) objIn.readObject();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rar[k].getRecipeIngred();
	}
	
	/*public String fileOpenNowPicAdr(int k) {
		Recipe[] rar = new Recipe[recipeLength];

		try(ObjectInputStream objIn = 
				new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < rar.length; i++) {
				rar[i] = (Recipe) objIn.readObject();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//rar[0]
		
		ArrayList now = new ArrayList();
		ArrayList add = new ArrayList();
		
		for(int i = 0; i < recipeLength; i++) {
			if(judgement(userIngred01, rar[i].getRecipeIngred()) == 'a') {
				now.add(rar[i].getRecipePicAdr());
			}else if(judgement(userIngred01, rar[i].getRecipeIngred()) == 'b') {
				add.add(rar[i].getRecipePicAdr());
			}
		}
		//System.out.println(judgement(userIngred01, rar[0].getRecipeIngred()));
		
		RecMgt.nowCtn = now.size();
		
		return (String) now.get(k);
	}*/
	
	/*public String AddPicAdr(int k) {
		Recipe[] rar = new Recipe[recipeLength];

		try(ObjectInputStream objIn = 
				new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < rar.length; i++) {
				rar[i] = (Recipe) objIn.readObject();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//rar[0]
		
		ArrayList now = new ArrayList();
		ArrayList add = new ArrayList();
		
		for(int i = 0; i < recipeLength; i++) {
			if(judgement(userIngred01, rar[i].getRecipeIngred()) == 'a') {
				now.add(rar[i].getRecipePicAdr());
			}else if(judgement(userIngred01, rar[i].getRecipeIngred()) == 'b') {
				add.add(rar[i].getRecipePicAdr());
			}
		}
		//System.out.println(judgement(userIngred01, rar[0].getRecipeIngred()));
		
		RecMgt.nowCtn = now.size();
		
		return (String) now.get(k);
	}*/
	
	
	//현재 추천된 레시피 수
	/*public int nowLength() {
		//int fileLength = 2;
		System.out.println(RecMgt.nowCtn);
		return 2nowCtn;
	}*/
	
	/*public char judgement(TreeSet userIngred, ArrayList recommendMgrIngred) {
		int count = 0;
		for(int i = 0; i < recommendMgrIngred.size(); i++) {
			boolean contains = userIngred.contains(recommendMgrIngred.get(i));
			if(contains == false) {
				count++;
			}
		}

		char recommend = ' ';
		switch(count) {
		case 0: recommend = 'a'; break;
		case 1: case 2: recommend = 'b'; break;
		default: recommend = 'c';
		}
		
		return recommend;
	}*/
}
