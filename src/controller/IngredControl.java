package controller;

import java.util.Iterator;

import model.vo.IngredAll;

public class IngredControl {

	//��������� ���� ª�� ���� ����� ����ȣ,�������� ���ϱ�(map�� key�� �� 4����, value ��)
	
	//Ű ����Ʈ ���� �ּҰ� �����ϱ� or values �� �� �����ͼ�  �ּҰ� ���� �� �� ���� ���� key���� ��������	//��ɷ� �ұ� ..
	
	//substring ����
	
	
	String minIngredNo;			//������� ���� ª�� ��� ��ȣ
	String minIngredExpiry; 
	
	
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
			}
			
		}
		
		this.minIngredNo = minKey.substring(minKey.length()-4,minKey.length());		//�̴ϸ� value �� ������ key���� ��� ��ȣ
		
		this.minIngredExpiry = String.valueOf(min);
		
		
	}//method 
	
	
	
	
	
	//������� ���� ª�� ��� ��ȣ ��ȯ
	public String getMinIngredNo() {
		return this.minIngredNo;
	}
	//�ش� ��� ���� ������� ���� ��ȯ
	public String getMinIngredExpiry() {
		return this.minIngredExpiry;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//class
