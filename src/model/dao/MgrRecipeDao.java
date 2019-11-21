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
	
	//�ϱ⸦ ������ �Է� �ý����� ����� �Է��� ���� count�ؼ� �ϱ⿡ �Էµǵ��� ����.
	public static int recipeLength = 6;
	
	//�̹� ���� ������ ������ dat ���Ͽ� ����Ǿ� �־�, �߰��� Recommend���� �ϱ� �޼ҵ带 �ҷ����� �ʰ� �ּ�ó����.
	public void fileSave() {
		//�丮1
		ArrayList rcIngred01 = new ArrayList();
		rcIngred01.add(1009);
		rcIngred01.add(2004);
		
		//�丮2
		ArrayList rcIngred02 = new ArrayList();
		rcIngred02.add(1009);
		rcIngred02.add(2004);
		rcIngred02.add(3010);
		
		//�丮3
		ArrayList rcIngred03 = new ArrayList();
		rcIngred03.add(1009);
		rcIngred03.add(2004);
		rcIngred03.add(4001);
		rcIngred03.add(4002);
		rcIngred03.add(4003);
		
		//�丮4
		ArrayList rcIngred04 = new ArrayList();
		rcIngred04.add(1009);
		
		
		//�丮5
		ArrayList rcIngred05 = new ArrayList();
		rcIngred05.add(1009);
		rcIngred05.add(2004);
		rcIngred05.add(2005);
		rcIngred05.add(3001);
		
		//�丮6
		ArrayList rcIngred06 = new ArrayList();
		rcIngred06.add(1009);
		rcIngred06.add(2004);
		rcIngred06.add(2005);
		
		//�丮 ������
		
		String rcPic1 = "images/park/black noodle.jpg";
		String rcPic2 = "images/park/carbonara.jpg";
		String rcPic3 = "images/park/tomato seafood spaghetti.jpg";
		String rcPic4 = "images/park/steamed potato.jpg";
		String rcPic5 = "images/park/cheeseBall.jpg";
		String rcPic6 = "images/park/potato.jpg";
		
		recipeList.add(new Recipe("¥���", "documents/recipe/black noodle.txt", rcPic1, rcIngred01));
		recipeList.add(new Recipe("�������", "documents/recipe/steamed potato.txt", rcPic2, rcIngred02));
		recipeList.add(new Recipe("�丶�� ���İ�Ƽ", "���� �丶�並 �缼��", rcPic3, rcIngred03));
		recipeList.add(new Recipe("����", "documents/recipe/steamed potato.txt", rcPic4, rcIngred04));
		recipeList.add(new Recipe("ġ�", "ġ� ���Դϴ�.", rcPic5, rcIngred05));
		recipeList.add(new Recipe("���ڴ�ٺ���", "���ڿ� ����� ä��ϴ�.", rcPic6, rcIngred06));
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�丮�� : ");
		String rcName = sc.nextLine();
		System.out.print("������ ���� �ؽ�Ʈ���� �ּ� : ");
		String rcContAdr = sc.nextLine();
		System.out.print("������ ���� �̹������� �ּ� : ");
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
