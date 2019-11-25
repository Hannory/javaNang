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
	public static int recipeLength = 18;
	
	//�̹� ���� ������ ������ dat ���Ͽ� ����Ǿ� �־�, �߰��� Recommend���� �ϱ� �޼ҵ带 �ҷ����� �ʰ� �ּ�ó����.
	public void fileSave() {
		//¥���
		ArrayList rcIngred01 = new ArrayList();
		rcIngred01.add(1006);	
		rcIngred01.add(1007);
		rcIngred01.add(2001);
		rcIngred01.add(2008);
		rcIngred01.add(3002);
		rcIngred01.add(3006);		
		
		//�������
		ArrayList rcIngred02 = new ArrayList();
		rcIngred02.add(1005);			
		rcIngred02.add(3002);	
		rcIngred02.add(3005);	
				
		//�丶�� ���İ�Ƽ
		ArrayList rcIngred03 = new ArrayList();
		rcIngred03.add(1006);			
		rcIngred03.add(2009);	
		rcIngred03.add(3002);	
		
		//����
		ArrayList rcIngred04 = new ArrayList();
		rcIngred04.add(3004);
		
		//ġ�
		ArrayList rcIngred05 = new ArrayList();
		rcIngred05.add(2004);
		rcIngred05.add(3008);
		
		//���ڴ�ٺ���
		ArrayList rcIngred06 = new ArrayList();
		rcIngred06.add(2001);
		rcIngred06.add(2004);
		
		//�����
		ArrayList rcIngred07 = new ArrayList();
		rcIngred07.add(1005);
		rcIngred07.add(2005);
		
		//��������
		ArrayList rcIngred08 = new ArrayList();
		rcIngred08.add(1003);
		rcIngred08.add(2004);
		rcIngred08.add(2005);
		rcIngred08.add(2007);
		
		//�߾Ƚɵ����Ƴ�
		ArrayList rcIngred09 = new ArrayList();
		rcIngred09.add(1004);
		rcIngred09.add(2007);
		rcIngred09.add(3009);
		
		
		//������
		ArrayList rcIngred10 = new ArrayList();
		rcIngred10.add(2005);
		rcIngred10.add(3003);
		rcIngred10.add(3007);
		
		//�̿���
		ArrayList rcIngred11 = new ArrayList();
		rcIngred11.add(1007);
		rcIngred11.add(1008);
		
		
		//������ġ
		ArrayList rcIngred12 = new ArrayList();
		rcIngred12.add(1002);
		rcIngred12.add(2008);
		rcIngred12.add(2009);
		rcIngred12.add(3001);
		
		
		//�Ұ�����
		ArrayList rcIngred13 = new ArrayList();
		rcIngred13.add(1001);
		rcIngred13.add(2001);
		rcIngred13.add(2003);
		rcIngred13.add(2005);
		
		
		//ĥ������
		ArrayList rcIngred14 = new ArrayList();
		rcIngred14.add(1009);
		rcIngred14.add(2005);
		rcIngred14.add(2008);
		
		
		//�ᳪ����
		ArrayList rcIngred15 = new ArrayList();
		rcIngred15.add(2002);
		rcIngred15.add(2005);
		rcIngred15.add(2006);
		
		
		//�ᳪ����ħ
		ArrayList rcIngred16 = new ArrayList();
		rcIngred16.add(2002);
		rcIngred16.add(2005);
		rcIngred16.add(2006);
		rcIngred16.add(2007);
		
		
		//�佺Ʈ
		ArrayList rcIngred17 = new ArrayList();
		rcIngred17.add(1005);
		rcIngred17.add(3001);
		
				
		//�ܹ���
		ArrayList rcIngred18 = new ArrayList();
		rcIngred18.add(1004);
		rcIngred18.add(2008);
		rcIngred18.add(2009);
		rcIngred18.add(3004);
		rcIngred18.add(3009);
		
		
		//�丮 ������ txt ����
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
		
		
		
		//�丮 ������
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
		
		
		//��� ��Ʈ
		String rcMent1 = "<html># �߱��� �η��� ����<br>¥��� ����� ~!!<br></html>";
		String rcMent2 = "<html># ������� �η��� ����<br>ũ�� �Ľ�Ÿ ����� ~!!<br></html>";
		String rcMent3 = "<html># �ع� ���� ���� ��� <br>�丶�� ���İ�Ƽ ����� ~!!<br></hmtml>";
		String rcMent4 = "<html># �ްԼҿ��� �Դ� �׸�  <br>���縸�� ���� ����� ~!!<br></html>";	
		String rcMent5 = "<html># �˵��˵��� ġ� ������<br>�ٻ��� ġ� �����~!!<br></html>";
		String rcMent6 = "<html># �����ϰ� ���縸��~ <br> ���ڴ�ٺ��� ����� ~!!<br></html>";
		String rcMent7 = "<html># �������� ���� ���� <br> ����� ����� ~!!<br></html>";
		String rcMent8 = "<html># �������� �������ϴ� <br> ���� ���� ����� ~!!<br></html>";
		String rcMent9 = "<html># �޴��ϰ� �ε巯�� <br> �߾Ƚɵ����Ƴ� ����� ~!!<br></html>";
		String rcMent10 = "<html># ��� �б� �տ��� �Ծ��� <br> ���޴��� ������ ����� ~!!<br></html>";
		String rcMent11 = "<html># ���ϸ����� ���� <br> �̿��� ����� ~!!<br></html>";
		String rcMent12 = "<html># ȫ������ �������� ~! <br> ������ġ ����� ~!!<br></html>";
		String rcMent13 = "<html># �ƺ����ſ��� ���� �� �ִ� <br> �Ұ����� ����� ~!!<br></html>";
		String rcMent14 = "<html># �����Ͽ� ~ <br> ĥ������ ����� ~!!<br></html>";
		String rcMent15 = "<html># ���忡 ���� ~!! <br> �ᳪ���� ����� ~!!<br></html>";
		String rcMent16 = "<html># �ƻ�ƻ� ���޸��� ~ <br> �ᳪ�� ��ħ ����� ~!!<br></html>";
		String rcMent17 = "<html># �̻��佺Ʈ �Ȱ��� �Ǵ� ~ <br> �佺Ʈ ����� ~!!<br></html>";
		String rcMent18 = "<html># ���Ⱑ �ٷ� �������� ~ <br> �ܹ��� ����� ~!!<br></html>";
		
		
		
		
		//Recipe �ڷ������� �����
		recipeList.add(new Recipe("¥���", "documents/recipe/black noodle.txt", rcPic1,rcMent1, rcIngred01));
		recipeList.add(new Recipe("�������", "documents/recipe/carbonara.txt", rcPic2,rcMent2, rcIngred02));
		recipeList.add(new Recipe("�丶�� ���İ�Ƽ", rcTxt3, rcPic3,rcMent3, rcIngred03));
		recipeList.add(new Recipe("����", "documents/recipe/steamed potato.txt", rcPic4,rcMent4, rcIngred04));
		recipeList.add(new Recipe("ġ�", "documents/recipe/cheeseBall.txt", rcPic5,rcMent5, rcIngred05));
		recipeList.add(new Recipe("���ڴ�ٺ���", "documents/recipe/potato carrot.txt", rcPic6,rcMent6,rcIngred06));
		recipeList.add(new Recipe("�����", rcTxt7, rcPic7, rcMent7, rcIngred07));
		recipeList.add(new Recipe("��������", rcTxt8, rcPic8, rcMent8, rcIngred08));
		recipeList.add(new Recipe("�߾Ƚɵ����Ƴ�", rcTxt9, rcPic9, rcMent9, rcIngred09));
		recipeList.add(new Recipe("������", rcTxt10, rcPic10, rcMent10, rcIngred10));
		recipeList.add(new Recipe("�̿���", rcTxt11, rcPic11, rcMent11, rcIngred11));
		recipeList.add(new Recipe("������ġ", rcTxt12, rcPic12, rcMent12, rcIngred12));
		recipeList.add(new Recipe("�Ұ�����", rcTxt13, rcPic13, rcMent13, rcIngred13));
		recipeList.add(new Recipe("ĥ������", rcTxt14, rcPic14, rcMent14, rcIngred14));
		recipeList.add(new Recipe("�ᳪ����", rcTxt15, rcPic15, rcMent15, rcIngred15));
		recipeList.add(new Recipe("�ᳪ����ħ", rcTxt16, rcPic16, rcMent16, rcIngred16));
		recipeList.add(new Recipe("�佺Ʈ", rcTxt17, rcPic17, rcMent17, rcIngred17));
		recipeList.add(new Recipe("�ܹ���", rcTxt18, rcPic18, rcMent18, rcIngred18));
		
		
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
