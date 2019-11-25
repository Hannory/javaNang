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
	public static int recipeLength = 18;
	
	//이미 수동 레시피 정보가 dat 파일에 저장되어 있어, 추가로 Recommend에서 하기 메소드를 불러오지 않게 주석처리함.
	public void fileSave() {
		//짜장면
		ArrayList rcIngred01 = new ArrayList();
		rcIngred01.add(1006);	
		rcIngred01.add(1007);
		rcIngred01.add(2001);
		rcIngred01.add(2008);
		rcIngred01.add(3002);
		rcIngred01.add(3006);		
		
		//까르보나라
		ArrayList rcIngred02 = new ArrayList();
		rcIngred02.add(1005);			
		rcIngred02.add(3002);	
		rcIngred02.add(3005);	
				
		//토마토 스파게티
		ArrayList rcIngred03 = new ArrayList();
		rcIngred03.add(1006);			
		rcIngred03.add(2009);	
		rcIngred03.add(3002);	
		
		//찐감자
		ArrayList rcIngred04 = new ArrayList();
		rcIngred04.add(3004);
		
		//치즈볼
		ArrayList rcIngred05 = new ArrayList();
		rcIngred05.add(2004);
		rcIngred05.add(3008);
		
		//감자당근볶음
		ArrayList rcIngred06 = new ArrayList();
		rcIngred06.add(2001);
		rcIngred06.add(2004);
		
		//계란찜
		ArrayList rcIngred07 = new ArrayList();
		rcIngred07.add(1005);
		rcIngred07.add(2005);
		
		//고등어조림
		ArrayList rcIngred08 = new ArrayList();
		rcIngred08.add(1003);
		rcIngred08.add(2004);
		rcIngred08.add(2005);
		rcIngred08.add(2007);
		
		//닭안심데리아끼
		ArrayList rcIngred09 = new ArrayList();
		rcIngred09.add(1004);
		rcIngred09.add(2007);
		rcIngred09.add(3009);
		
		
		//떡볶이
		ArrayList rcIngred10 = new ArrayList();
		rcIngred10.add(2005);
		rcIngred10.add(3003);
		rcIngred10.add(3007);
		
		//미역국
		ArrayList rcIngred11 = new ArrayList();
		rcIngred11.add(1007);
		rcIngred11.add(1008);
		
		
		//샌드위치
		ArrayList rcIngred12 = new ArrayList();
		rcIngred12.add(1002);
		rcIngred12.add(2008);
		rcIngred12.add(2009);
		rcIngred12.add(3001);
		
		
		//소갈비찜
		ArrayList rcIngred13 = new ArrayList();
		rcIngred13.add(1001);
		rcIngred13.add(2001);
		rcIngred13.add(2003);
		rcIngred13.add(2005);
		
		
		//칠리새우
		ArrayList rcIngred14 = new ArrayList();
		rcIngred14.add(1009);
		rcIngred14.add(2005);
		rcIngred14.add(2008);
		
		
		//콩나물국
		ArrayList rcIngred15 = new ArrayList();
		rcIngred15.add(2002);
		rcIngred15.add(2005);
		rcIngred15.add(2006);
		
		
		//콩나물무침
		ArrayList rcIngred16 = new ArrayList();
		rcIngred16.add(2002);
		rcIngred16.add(2005);
		rcIngred16.add(2006);
		rcIngred16.add(2007);
		
		
		//토스트
		ArrayList rcIngred17 = new ArrayList();
		rcIngred17.add(1005);
		rcIngred17.add(3001);
		
				
		//햄버거
		ArrayList rcIngred18 = new ArrayList();
		rcIngred18.add(1004);
		rcIngred18.add(2008);
		rcIngred18.add(2009);
		rcIngred18.add(3004);
		rcIngred18.add(3009);
		
		
		//요리 레시피 txt 파일
		String rcTxt3 = "documents/recipe/tomato seafood spaghetti.txt";
		String rcTxt7 = "documents/recipe/steamed eggs.txt";
		String rcTxt8 = "documents/recipe/braised mackerel.txt";
		String rcTxt9 = "documents/recipe/teriyaki chicken.txt";
		String rcTxt10 = "documents/recipe/stir-fried rice cake.txt";
		String rcTxt11 = "documents/recipe/seaweed soup.txt";
		String rcTxt12 = "documents/recipe/sandwich.txt";
		String rcTxt13 = "documents/recipe/braised short ribs.txt";
		String rcTxt14 = "documents/recipe/chili shrimp.txt";
		String rcTxt15 = "documents/recipe/bean sprout soup.txt";
		String rcTxt16 = "documents/recipe/seasoned bean sprouts.txt";
		String rcTxt17 = "documents/recipe/toast.txt";
		String rcTxt18 = "documents/recipe/hamburger.txt";
		
		
		
		//요리 사진들
		String rcPic1 = "images/park/black noodle.jpg";
		String rcPic2 = "images/park/carbonara.jpg";
		String rcPic3 = "images/park/tomato seafood spaghetti.jpg";
		String rcPic4 = "images/park/steamed potato.jpg";
		String rcPic5 = "images/park/cheeseBall.jpg";
		String rcPic6 = "images/park/potato carrot.jpg";
		String rcPic7 = "images/park/steamed eggs.PNG";
		String rcPic8 = "images/park/braised mackerel.jpg";
		String rcPic9 = "images/park/teriyaki chicken.jpg";
		String rcPic10 = "images/park/stir-fried rice cake.jpg";
		String rcPic11 = "images/park/seaweed soup.jpg";
		String rcPic12 = "images/park/sandwich.PNG";
		String rcPic13 = "images/park/braised short ribs.jpg";
		String rcPic14 = "images/park/chili shrimp.jpg";
		String rcPic15 = "images/park/bean sprout soup.jpg";
		String rcPic16 = "images/park/seasoned bean sprouts.jpg";
		String rcPic17 = "images/park/toast.PNG";
		String rcPic18 = "images/park/hamburger.jpg";
		
		
		//요라 맨트
		String rcMent1 = "<html># 중국집 부럽지 않은<br>짜장면 만들기 ~!!<br></html>";
		String rcMent2 = "<html># 레스토랑 부럽지 않은<br>크림 파스타 만들기 ~!!<br></html>";
		String rcMent3 = "<html># 해물 맛이 가득 담긴 <br>토마토 스파게티 만들기 ~!!<br></hmtml>";
		String rcMent4 = "<html># 휴게소에서 먹는 그맛  <br>영양만점 찐감자 만들기 ~!!<br></html>";	
		String rcMent5 = "<html># 쫀득쫀득한 치즈가 예술인<br>바삭한 치즈볼 만들기~!!<br></html>";
		String rcMent6 = "<html># 간편하고 영양만점~ <br> 감자당근볶음 만들기 ~!!<br></html>";
		String rcMent7 = "<html># 폭신폭신 구름 같은 <br> 계란찜 만들기 ~!!<br></html>";
		String rcMent8 = "<html># 이유승이 안좋아하는 <br> 고등어 조림 만들기 ~!!<br></html>";
		String rcMent9 = "<html># 달달하고 부드러운 <br> 닭안심데리아끼 만들기 ~!!<br></html>";
		String rcMent10 = "<html># 어릴때 학교 앞에서 먹었던 <br> 매콤달콤 떡볶이 만들기 ~!!<br></html>";
		String rcMent11 = "<html># 매일매일이 생일 <br> 미역국 만들기 ~!!<br></html>";
		String rcMent12 = "<html># 홍루이젠 저리가라 ~! <br> 샌드위치 만들기 ~!!<br></html>";
		String rcMent13 = "<html># 아빠생신에만 먹을 수 있는 <br> 소갈비찜 만들기 ~!!<br></html>";
		String rcMent14 = "<html># 따자하오 ~ <br> 칠리새우 만들기 ~!!<br></html>";
		String rcMent15 = "<html># 해장에 쵝오 ~!! <br> 콩나물국 만들기 ~!!<br></html>";
		String rcMent16 = "<html># 아삭아삭 매콤매콤 ~ <br> 콩나물 무침 만들기 ~!!<br></html>";
		String rcMent17 = "<html># 이삭토스트 안가도 되는 ~ <br> 토스트 만들기 ~!!<br></html>";
		String rcMent18 = "<html># 여기가 바로 쉑쉑버거 ~ <br> 햄버거 만들기 ~!!<br></html>";
		
		
		
		
		//Recipe 자료형으로 만들기
		recipeList.add(new Recipe("짜장면", "documents/recipe/black noodle.txt", rcPic1,rcMent1, rcIngred01));
		recipeList.add(new Recipe("까르보나라", "documents/recipe/carbonara.txt", rcPic2,rcMent2, rcIngred02));
		recipeList.add(new Recipe("토마토 스파게티", rcTxt3, rcPic3,rcMent3, rcIngred03));
		recipeList.add(new Recipe("찐감자", "documents/recipe/steamed potato.txt", rcPic4,rcMent4, rcIngred04));
		recipeList.add(new Recipe("치즈볼", "documents/recipe/cheeseBall.txt", rcPic5,rcMent5, rcIngred05));
		recipeList.add(new Recipe("감자당근볶음", "documents/recipe/potato carrot.txt", rcPic6,rcMent6,rcIngred06));
		recipeList.add(new Recipe("계란찜", rcTxt7, rcPic7, rcMent7, rcIngred07));
		recipeList.add(new Recipe("고등어조림", rcTxt8, rcPic8, rcMent8, rcIngred08));
		recipeList.add(new Recipe("닭안심데리아끼", rcTxt9, rcPic9, rcMent9, rcIngred09));
		recipeList.add(new Recipe("떡볶이", rcTxt10, rcPic10, rcMent10, rcIngred10));
		recipeList.add(new Recipe("미역국", rcTxt11, rcPic11, rcMent11, rcIngred11));
		recipeList.add(new Recipe("샌드위치", rcTxt12, rcPic12, rcMent12, rcIngred12));
		recipeList.add(new Recipe("소갈비찜", rcTxt13, rcPic13, rcMent13, rcIngred13));
		recipeList.add(new Recipe("칠리새우", rcTxt14, rcPic14, rcMent14, rcIngred14));
		recipeList.add(new Recipe("콩나물국", rcTxt15, rcPic15, rcMent15, rcIngred15));
		recipeList.add(new Recipe("콩나물무침", rcTxt16, rcPic16, rcMent16, rcIngred16));
		recipeList.add(new Recipe("토스트", rcTxt17, rcPic17, rcMent17, rcIngred17));
		recipeList.add(new Recipe("햄버거", rcTxt18, rcPic18, rcMent18, rcIngred18));
		
		
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
