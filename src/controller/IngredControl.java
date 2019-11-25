package controller;

import java.util.Iterator;

import model.vo.IngredAll;
import view.AllRecipe;

public class IngredControl {

	//��������� ���� ª�� ���� ����� ����ȣ,�������� ���ϱ�(map�� key�� �� 4����, value ��)
	
	//Ű ����Ʈ ���� �ּҰ� �����ϱ� or values �� �� �����ͼ�  �ּҰ� ���� �� �� ���� ���� key���� ��������	//��ɷ� �ұ� ..
	
	//substring ����
	
	
	public static String minIngredNo;			//������� ���� ª�� ��� ��ȣ
	public static String minIngredExpiry; 
	
	
	public void method() {
		
		Iterator iterator = IngredAll.ingredExpiryMap.keySet().iterator();	//������� ���� Ű���� ���ͷ����ͷ� ����
		int[] arr = new int[IngredAll.ingredExpiryMap.size()];	//������� ���� ������ ��ŭ int �迭 �Ҵ�
		int min = 99;
		String minKey = "";		//�̴ϸ� value �� ������ Ű ���� ������ ����
		int minValue = 99;
		
		
		//value�� min �� ���Ͽ� ���� �� �߽߰� tempKey�� ����
		for(int i = 0;iterator.hasNext();i++) {
			String tempKey = (String) iterator.next();
			arr[i] = (int) IngredAll.ingredExpiryMap.get(tempKey);		//�迭�� ��� value �� ����
			
			if(arr[i] < min) {		
				min = arr[i];		//�ּҰ� ����(���� ���� ��ȯ�� ����)
				minKey = tempKey;	//��ȯ�� Ű �� ����
				minIngredNo = minKey.substring(minKey.length()-4,minKey.length());		//�̴ϸ� value �� ������ key���� ��� ��ȣ
				minIngredExpiry = String.valueOf(min);
			}
			
		}
		System.out.println("minIngredNo : " + minIngredNo);
		System.out.println("minIngredExpiry : " + minIngredExpiry);
		
		
		
	}//method 
	
	
	
	
	
	//������� ���� ª�� ��� ��ȣ ��ȯ
	public String getMinIngredNo() {
		return minIngredNo;
	}
	//�ش� ��� ���� ������� ���� ��ȯ
	public String getMinIngredExpiry() {
		
		
		String str = null;
		
		
		
		str = String.valueOf(IngredAll.ingredExpiryMap.get(AllRecipe.loginId + minIngredNo));
		
		if(IngredAll.ingredExpiryMap.get(AllRecipe.loginId + minIngredNo) == null) {
			System.out.println("��� �� ����, �� ������� ����");
			str = "��� ��������� �Է����ּ���";
			
		}else {
			str = "��������� " + String.valueOf(IngredAll.ingredExpiryMap.get(AllRecipe.loginId + minIngredNo) + "�� ���ҽ��ϴ�.");
		}
		
		
		
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//class
