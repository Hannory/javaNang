package model.vo;

import view.LoginPage;

public class IngredAll {
	
	public static int tempNo;

	
	//LoginPage.ingredStatic;	//현재 회원 냉장고
	
	
	
	
	//스태틱 냉장고에 있는 재료 삭제	//파일 저장은 X
	public void deleteIngred(int ingredNo) {
		LoginPage.ingredStatic.remove(ingredNo);
		System.out.println("stastic : " + LoginPage.ingredStatic);
	}
	
	
	

}
