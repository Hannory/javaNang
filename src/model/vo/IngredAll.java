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
	//재료삭제
	//재료 유통기한 입력
	
	
	
	public static int tempNo;	//재료삭제 및 유통기한 입력용 임시변수(재료확인에서 재료 클릭시 셋팅되는 값)//
	
	//AllRecipe.loginId+tempNo를 키값으로, day(유통기한 입력에서 받을것) 를 value로 하는 맵 
	//유통기한 관련 맵
	public static HashMap ingredExpiryMap = new HashMap();		
	
	
	
	//스태틱에 있는 유통기한 맵 불러올지 말지 판단 //재료확인 진입 시 호출
	public static void setIngredExpiryMap() {
		
		File f = new File(AllRecipe.loginId+"ingredInfo.dat");
		
		if(f.exists()) {
			System.out.println("파일 이미 있으므로 불러와서 ingredExpiryMap 에 넣음.");
			//파일 존재하므로 기존 파일(맵) 읽어와서 복사 후 ingredExpiryMap 에 저장
			//ingredExpiryMap 수정하여 다시 파일에 덮어쓰기
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
			System.out.println("그런파일 없음 // 안불러오고 기본 할당된 뉴 맵 에 바로 작업");
			//파일 없으므로 intgredExpiryMap 바로 수정해서 저장해주면 됨
		}
		
		
		
		
	}//method
	
	
	
	
	
	
	//스태틱에 있는 ingredExpiryMap 수정하는 메소드
	public void modifyIngredExpiryMap(int day) {
		ingredExpiryMap.put(AllRecipe.loginId+tempNo, day);
		System.out.println("키값 : " + AllRecipe.loginId+tempNo + "//전달받은 day 값을 유통기한 맵에 value로 입력");
		System.out.println("현재 유통기한 맵 정보(ingredExpiryMap) : " + ingredExpiryMap);
	}
	
	
	
	
	
	//스태틱에 있는 유통기한 정보(맵) 저장하는 메소드
	public void saveIngredExpiryMap() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(AllRecipe.loginId+"ingredInfo.dat"));){
			
			out.writeObject(ingredExpiryMap);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("유통기한 정보 파일에 저장 완료");
	}
	
	
	
	
	
	//스태틱 냉장고에 있는 재료 삭제	//파일 저장은 X
	public void deleteIngred(int ingredNo) {
		LoginPage.ingredStatic.remove(ingredNo);
		System.out.println("static 냉장고 set 정보 : " + LoginPage.ingredStatic);
		System.out.println("삭제 완료");
		
		new AddIngred().modifyData();		//파일에 저장하기
	}
	
	
	

}//class
