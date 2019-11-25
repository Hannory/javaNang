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
	
	//������ ���� �ּҰ� ��ȯ�� ���� �迭
	ArrayList now = new ArrayList();
	ArrayList add = new ArrayList();
	
	//Recipe�ڷ��� ��ü ��ȯ�� ���� �迭
	ArrayList nowRecipe = new ArrayList();
	ArrayList addRecipe = new ArrayList();
	
	//'�߰� ����' ��õ �޴����� �ʿ��� ���
	public static ArrayList addNeeded = new ArrayList();
	
	public void categorizing() {
		TreeSet userIngred = LoginPage.ingredStatic;		//�α����� ������ ���� �ִ� ��� ���
		ArrayList recipeList = new ArrayList();				//��ü ������ ��
		//������ ��� �ҷ�����
		try(ObjectInputStream objIn = 
				new ObjectInputStream(new FileInputStream("MgrRecipe.dat"));) {
			
			for(int i = 0; i < MgrRecipeDao.recipeLength; i++) {
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
			
			if(judgement(userIngred, mr[i].getRecipeIngred()) == 'a') {
				now.add(mr[i].getRecipePicAdr());
				nowRecipe.add(mr[i]);
			}else if(judgement(userIngred, mr[i].getRecipeIngred()) == 'b') {
				add.add(mr[i].getRecipePicAdr());
				addRecipe.add(mr[i]);
			}
		}
		
		//����/�߰����� ��õ�� �� �ִ� �� ����
		nowCtn = now.size();
		addCtn = add.size();
		
		System.out.println("������ ��� ��: " + MgrRecipeDao.recipeLength);
		System.out.println("now.size() : " + now.size());
		System.out.println("add.size() : " + add.size());
	}
	
	//"�����η�/�߰�����/��õ �� ��"�� �����ϱ� ���� �޼ҵ�
	public char judgement(TreeSet userIngred, ArrayList recipeIngred) {
			
		int count = 0;
		for(int i = 0; i < recipeIngred.size(); i++) {
			boolean contains = userIngred.contains(recipeIngred.get(i));
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
