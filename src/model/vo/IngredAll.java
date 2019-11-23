package model.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.imageio.stream.FileCacheImageOutputStream;

import model.dao.AddIngred;
import view.AllRecipe;
import view.LoginPage;

public class IngredAll {
	//������
	//��� ������� �Է�
	
	
	
	public static int tempNo;	//������ �� ������� �Է¿� �ӽú���(���Ȯ�ο��� ��� Ŭ���� ���õǴ� ��)//
	
	//AllRecipe.loginId+tempNo�� Ű������, day(������� �Է¿��� ������) �� value�� �ϴ� �� 
	//������� ���� ��
	public static HashMap ingredExpiryMap = new HashMap();		
	
	
	
	//����ƽ�� �ִ� ������� �� �ҷ����� ���� �Ǵ� //���Ȯ�� ���� �� ȣ��
	public static void setIngredExpiryMap() {
		
		File f = new File(AllRecipe.loginId+"ingredInfo.dat");
		
		if(f.exists()) {
			System.out.println("���� �̹� �����Ƿ� �ҷ��ͼ� ingredExpiryMap �� ����.");
			//���� �����ϹǷ� ���� ����(��) �о�ͼ� ���� �� ingredExpiryMap �� ����
			//ingredExpiryMap �����Ͽ� �ٽ� ���Ͽ� �����
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));){
				
				HashMap hm = (HashMap) in.readObject();
				ingredExpiryMap = (HashMap) hm.clone();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("�׷����� ���� // �Ⱥҷ����� �⺻ �Ҵ�� �� �� �� �ٷ� �۾�");
			//���� �����Ƿ� intgredExpiryMap �ٷ� �����ؼ� �������ָ� ��
		}
		
		
		
		
	}//method
	
	
	
	
	
	
	//����ƽ�� �ִ� ingredExpiryMap �����ϴ� �޼ҵ�
	public void modifyIngredExpiryMap(int day) {
		ingredExpiryMap.put(AllRecipe.loginId+tempNo, day);
		System.out.println("Ű�� : " + AllRecipe.loginId+tempNo + "//���޹��� day ���� ������� �ʿ� value�� �Է�");
		System.out.println("���� ������� �� ����(ingredExpiryMap) : " + ingredExpiryMap);
	}
	
	
	
	
	
	//����ƽ�� �ִ� ������� ����(��) �����ϴ� �޼ҵ�
	public void saveIngredExpiryMap() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(AllRecipe.loginId+"ingredInfo.dat"));){
			
			out.writeObject(ingredExpiryMap);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("������� ���� ���Ͽ� ���� �Ϸ�");
	}
	
	
	
	
	
	//����ƽ ����� �ִ� ��� ����	//���� ������ X
	public void deleteIngred(int ingredNo) {
		LoginPage.ingredStatic.remove(ingredNo);
		System.out.println("static ����� set ���� : " + LoginPage.ingredStatic);
		System.out.println("���� �Ϸ�");
		
		new AddIngred().modifyData();		//���Ͽ� �����ϱ�
	}
	
	
	

}//class
