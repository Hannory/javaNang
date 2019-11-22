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
		//짜장면
		ArrayList rcIngred01 = new ArrayList();
		rcIngred01.add(5005);	//면(도넛)
		rcIngred01.add(6006);	//짜장소스(요구르트)
		
		//까르보나라
		ArrayList rcIngred02 = new ArrayList();
		rcIngred02.add(5005);	//면(도넛)		
		rcIngred02.add(6002);	//파마산 치즈
		rcIngred02.add(6005);	//모짜렐라 치즈
		
		//토마토 스파게티
		ArrayList rcIngred03 = new ArrayList();
		rcIngred03.add(5005);	//면(도넛)		
		rcIngred03.add(4004);	//토마토(포도)
		rcIngred03.add(6002);	//파마산 치즈
		rcIngred03.add(6005);	//모짜렐라 치즈
		
		//찐감자
		ArrayList rcIngred04 = new ArrayList();
		rcIngred04.add(3004);
		
		//치즈볼
		ArrayList rcIngred05 = new ArrayList();
		rcIngred05.add(3004);
		rcIngred05.add(6002);	//파마산 치즈
		rcIngred05.add(6005);	//모짜렐라 치즈
		
		//감자당근볶음
		ArrayList rcIngred06 = new ArrayList();
		rcIngred06.add(3001);
		rcIngred06.add(3004);
		
		//요리 사진들
		
		String rcPic1 = "images/park/black noodle.jpg";
		String rcPic2 = "images/park/carbonara.jpg";
		String rcPic3 = "images/park/tomato seafood spaghetti.jpg";
		String rcPic4 = "images/park/steamed potato.jpg";
		String rcPic5 = "images/park/cheeseBall.jpg";
		String rcPic6 = "images/park/potato.jpg";
		
		
		//요라 맨트
		String rcMent1 = "<html># 중국집 부럽지 않은<br>짜장면 만들기 ~!!<br></html>";
		String rcMent2 = "<html># 레스토랑 부럽지 않은<br>크림 파스타 만들기 ~!!<br></html>";
		String rcMent3 = "<html># 해물 맛이 가득 담긴 <br>토마토 스파게티 만들기 ~!!<br></hmtml>";
		String rcMent4 = "<html># 휴게소에서 먹는 그맛  <br>영양만점 찐감자 만들기 ~!!<br></html>";	
		String rcMent5 = "<html># 쫀득쫀득한 치즈가 예술인<br>바삭한 치즈볼 만들기~!!<br></html>";
		String rcMent6 = "<html># 간편하고 영양만점인 <br> 감자당근볶음 만들기 ~!!<br></html>";
		
		
		recipeList.add(new Recipe("짜장면", "documents/recipe/black noodle.txt", rcPic1,rcMent1, rcIngred01));
		recipeList.add(new Recipe("까르보나라", "documents/recipe/carbonara.txt", rcPic2,rcMent2, rcIngred02));
		recipeList.add(new Recipe("토마토 스파게티", "documents/recipe/tomato seafood spaghetti.txt", rcPic3,rcMent3, rcIngred03));
		recipeList.add(new Recipe("찐감자", "documents/recipe/steamed potato.txt", rcPic4,rcMent4, rcIngred04));
		recipeList.add(new Recipe("치즈볼", "documents/recipe/cheeseBall.txt", rcPic5,rcMent5, rcIngred05));
		recipeList.add(new Recipe("감자당근볶음", "documents/recipe/potato.txt", rcPic6,rcMent6,rcIngred06));
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("요리명 : ");
		String rcName = sc.nextLine();
		System.out.print("레시피 내용 텍스트파일 주소 : ");
		String rcContAdr = sc.nextLine();
		System.out.print("레시피 사진 이미지파일 주소 : ");
		String rcPicAdr = sc.nextLine();
		*/
		
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
