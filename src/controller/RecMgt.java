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

public class RecMgt {
	
	//int recipeLength = MgrRecipeDao.recipeList.size();
	public static int nowCtn = 0;
	public static int addCtn = 0;
	
	UserDao ud = new UserDao();
	
	ArrayList now = new ArrayList();
	ArrayList add = new ArrayList();
	
	
	public void categorizing() {
		//MgrRecipe[] rar = new MgrRecipe[recipeLength];
		/*TreeSet userIngred01 = ud.fileOpen(0);
		TreeSet userIngred02 = ud.fileOpen(1);*/
		TreeSet userIngred01 = ud.userIngred01();
		
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
		
			
		for(int i = 0; i < MgrRecipeDao.recipeLength; i++) {
			
			Recipe[] mr = new Recipe[MgrRecipeDao.recipeLength];
			
			
			mr[i] = (Recipe) recipeList.get(i);
			
			
			if(judgement(userIngred01, mr[i].getRecipeIngred()) == 'a') {
				now.add(mr[i].getRecipePicAdr());
			}else if(judgement(userIngred01, mr[i].getRecipeIngred()) == 'b') {
				add.add(mr[i].getRecipePicAdr());
			}
			System.out.println((i + 1) + "번째 요리의 추천 여부 : " + judgement(userIngred01, mr[i].getRecipeIngred()));
		}
		
		nowCtn = now.size();
		addCtn = add.size();
		
		System.out.println("now.size() : " + now.size());
		System.out.println("add.size() : " + add.size());
	}
	
	public char judgement(TreeSet userIngred, ArrayList recipeIngred) {
		int count = 0;
		for(int i = 0; i < recipeIngred.size(); i++) {
			boolean contains = userIngred.contains(recipeIngred.get(i));
			if(contains == false) {
				count++;
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
}
