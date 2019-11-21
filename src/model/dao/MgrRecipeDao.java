package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import controller.RecMgt;
//import controller.RecommendMgt;
import model.vo.Recipe;

public class MgrRecipeDao {
	
	ArrayList recipeList = new ArrayList();
	
	//하기를 레시피 입력 시스템을 만들면 입력한 수를 count해서 하기에 입력되도록 변경.
	public static int recipeLength = 6;
	
	//이미 수동 레시피 정보가 dat 파일에 저장되어 있어, 추가로 Recommend에서 하기 메소드를 불러오지 않게 주석처리함.
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
		
		recipeList.add(new Recipe("짜장면", "documents/recipe/black noodle.txt", rcPic1, rcIngred01));
		recipeList.add(new Recipe("까르보나라", "documents/recipe/steamed potato.txt", rcPic2, rcIngred02));
		recipeList.add(new Recipe("토마토 스파게티", "먼저 토마토를 사세요", rcPic3, rcIngred03));
		recipeList.add(new Recipe("찐감자", "documents/recipe/steamed potato.txt", rcPic4, rcIngred04));
		recipeList.add(new Recipe("치즈볼", "치즈를 녹입니다.", rcPic5, rcIngred05));
		recipeList.add(new Recipe("감자당근볶음", "감자와 당근을 채썹니다.", rcPic6, rcIngred06));
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("요리명 : ");
		String rcName = sc.nextLine();
		System.out.print("레시피 내용 텍스트파일 주소 : ");
		String rcContAdr = sc.nextLine();
		System.out.print("레시피 사진 이미지파일 주소 : ");
		String rcPicAdr = sc.nextLine();
		
		
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
	
}
