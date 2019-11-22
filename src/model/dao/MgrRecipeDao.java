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
		//¥���
		ArrayList rcIngred01 = new ArrayList();
		rcIngred01.add(5005);	//��(����)
		rcIngred01.add(6006);	//¥��ҽ�(�䱸��Ʈ)
		
		//�������
		ArrayList rcIngred02 = new ArrayList();
		rcIngred02.add(5005);	//��(����)		
		rcIngred02.add(6002);	//�ĸ��� ġ��
		rcIngred02.add(6005);	//��¥���� ġ��
		
		//�丶�� ���İ�Ƽ
		ArrayList rcIngred03 = new ArrayList();
		rcIngred03.add(5005);	//��(����)		
		rcIngred03.add(4004);	//�丶��(����)
		rcIngred03.add(6002);	//�ĸ��� ġ��
		rcIngred03.add(6005);	//��¥���� ġ��
		
		//����
		ArrayList rcIngred04 = new ArrayList();
		rcIngred04.add(3004);
		
		//ġ�
		ArrayList rcIngred05 = new ArrayList();
		rcIngred05.add(3004);
		rcIngred05.add(6002);	//�ĸ��� ġ��
		rcIngred05.add(6005);	//��¥���� ġ��
		
		//���ڴ�ٺ���
		ArrayList rcIngred06 = new ArrayList();
		rcIngred06.add(3001);
		rcIngred06.add(3004);
		
		//�丮 ������
		
		String rcPic1 = "images/park/black noodle.jpg";
		String rcPic2 = "images/park/carbonara.jpg";
		String rcPic3 = "images/park/tomato seafood spaghetti.jpg";
		String rcPic4 = "images/park/steamed potato.jpg";
		String rcPic5 = "images/park/cheeseBall.jpg";
		String rcPic6 = "images/park/potato.jpg";
		
		
		//��� ��Ʈ
		String rcMent1 = "<html># �߱��� �η��� ����<br>¥��� ����� ~!!<br></html>";
		String rcMent2 = "<html># ������� �η��� ����<br>ũ�� �Ľ�Ÿ ����� ~!!<br></html>";
		String rcMent3 = "<html># �ع� ���� ���� ��� <br>�丶�� ���İ�Ƽ ����� ~!!<br></hmtml>";
		String rcMent4 = "<html># �ްԼҿ��� �Դ� �׸�  <br>���縸�� ���� ����� ~!!<br></html>";	
		String rcMent5 = "<html># �˵��˵��� ġ� ������<br>�ٻ��� ġ� �����~!!<br></html>";
		String rcMent6 = "<html># �����ϰ� ���縸���� <br> ���ڴ�ٺ��� ����� ~!!<br></html>";
		
		
		recipeList.add(new Recipe("¥���", "documents/recipe/black noodle.txt", rcPic1,rcMent1, rcIngred01));
		recipeList.add(new Recipe("�������", "documents/recipe/carbonara.txt", rcPic2,rcMent2, rcIngred02));
		recipeList.add(new Recipe("�丶�� ���İ�Ƽ", "documents/recipe/tomato seafood spaghetti.txt", rcPic3,rcMent3, rcIngred03));
		recipeList.add(new Recipe("����", "documents/recipe/steamed potato.txt", rcPic4,rcMent4, rcIngred04));
		recipeList.add(new Recipe("ġ�", "documents/recipe/cheeseBall.txt", rcPic5,rcMent5, rcIngred05));
		recipeList.add(new Recipe("���ڴ�ٺ���", "documents/recipe/potato.txt", rcPic6,rcMent6,rcIngred06));
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("�丮�� : ");
		String rcName = sc.nextLine();
		System.out.print("������ ���� �ؽ�Ʈ���� �ּ� : ");
		String rcContAdr = sc.nextLine();
		System.out.print("������ ���� �̹������� �ּ� : ");
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
