package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

import model.dao.MgrRecipeDao;
import model.dao.UserDao;
import model.vo.Recipe;
import view.AllRecipe;
import view.LoginPage;

public class RecMgt {
	
	//int recipeLength = MgrRecipeDao.recipeList.size();
	public static int nowCtn = 0;
	public static int addCtn = 0;
	
	UserDao ud = new UserDao();
	
	//레시피 사진 주소값 반환을 위한 배열
	ArrayList now = new ArrayList();
	ArrayList add = new ArrayList();
	
	//Recipe자료형 객체 반환을 위한 배열
	ArrayList nowRecipe = new ArrayList();
	ArrayList addRecipe = new ArrayList();
	
	//'추가 재료로' 추천 메뉴에서 필요한 재료
	public static ArrayList addNeeded = new ArrayList();
	
	//public static ArrayList toAddIngred;
	
	
	public void categorizing() {
		TreeSet userIngred = LoginPage.ingredStatic;
		//TreeSet userIngred = ud.userIngred();
		//TreeSet userIngred01 = AllRecipe.loginId;
		
		//전체 레시피 수
		ArrayList recipeList = new ArrayList();

		try(ObjectInputStream objIn = 
				new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < MgrRecipeDao.recipeLength; i++) {
				//rar[i] = (MgrRecipe) objIn.readObject();
				recipeList.add(objIn.readObject());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("레시피 목록 수: " + MgrRecipeDao.recipeLength);
			
		for(int i = 0; i < MgrRecipeDao.recipeLength; i++) {
			
			Recipe[] mr = new Recipe[MgrRecipeDao.recipeLength];
			
			
			mr[i] = (Recipe) recipeList.get(i);
			
			
			
			if(judgement(userIngred, mr[i].getRecipeIngred()) == 'a') {
				now.add(mr[i].getRecipePicAdr());
				nowRecipe.add(mr[i]);
			}else if(judgement(userIngred, mr[i].getRecipeIngred()) == 'b') {
				add.add(mr[i].getRecipePicAdr());
				addRecipe.add(mr[i]);
				
				
				//재료 표시 테스트
				/*for(int k = 0; k < mr[i].getRecipeIngred().size(); k++) {
					if(!userIngred.contains(mr[i].getRecipeIngred().get(k))) {
						addNeeded.add(mr[i].getRecipeIngred().get(k));
					}
					
				}*/
				
			}
			//System.out.println((i + 1) + "번째 요리의 추천 여부 : " + judgement(userIngred01, mr[i].getRecipeIngred()));
		}
		
		nowCtn = now.size();
		addCtn = add.size();
		
		System.out.println("now.size() : " + now.size());
		System.out.println("add.size() : " + add.size());
	}
	
	public char judgement(TreeSet userIngred, ArrayList recipeIngred) {
		
		//추가 재료 표시 하기 위해서 시도
		//toAddIngred = new ArrayList();
		
		int count = 0;
		for(int i = 0; i < recipeIngred.size(); i++) {
			boolean contains = userIngred.contains(recipeIngred.get(i));
			if(contains == false) {
				count++;
				//이렇게 하면 현재 추천 아니면 모두 들어감. 게다가 버튼과 연동시켜야함.
				//toAddIngred.add(recipeIngred.get(i));
			}
		}
		
		//System.out.println(userIngred.contains(recipeIngred.get(i));

		char recommend = ' ';
		switch(count) {
		case 0: recommend = 'a'; break;
		case 1: case 2: recommend = 'b'; break;
		default: recommend = 'c';
		}
		
		return recommend;
	}
	
	public String nowPicAdr(int k) {				
		return (String) now.get(k);
	}
	
	public String addPicAdr(int k) {
		return (String) add.get(k);
	}
	
	public Recipe nowRecipe(int k) {
		return (Recipe) nowRecipe.get(k);
	}
	
	public Recipe addRecipe(int k) {
		return (Recipe) addRecipe.get(k);
	}
	
	public String nowName(int k) {
		Recipe recipe = new Recipe();
		recipe = (Recipe) nowRecipe.get(k);
		String name = recipe.getRecipeName();
		
		return name;
	}
	
	public String addName(int k) {
		Recipe recipe = new Recipe();
		recipe = (Recipe) addRecipe.get(k);
		String name = recipe.getRecipeName();
		
		return name;
	}
	
}
