package model.vo;

import view.LoginPage;

public class IngredAll {
	
	public static int tempNo;

	
	//LoginPage.ingredStatic;	//���� ȸ�� �����
	
	
	
	
	//����ƽ ����� �ִ� ��� ����	//���� ������ X
	public void deleteIngred(int ingredNo) {
		LoginPage.ingredStatic.remove(ingredNo);
		System.out.println("stastic : " + LoginPage.ingredStatic);
	}
	
	
	

}
