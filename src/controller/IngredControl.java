package controller;

import java.util.Iterator;

import model.vo.IngredAll;
import view.AllRecipe;

public class IngredControl {

	//유통기한이 가장 짧게 남은 재료의 재료번호,남은일자 구하기(map의 key값 뒤 4글자, value 값)
	
	//키 리스트 만들어서 최소값 저장하기 or values 로 값 가져와서  최소값 구한 후 그 값을 가진 key값을 가져오기	//어떤걸로 할까 ..
	
	//substring 참조
	
	
	public static String minIngredNo;			//유통기한 제일 짧은 재료 번호
	public static String minIngredExpiry; 
	
	
	public void method() {
		
		Iterator iterator = IngredAll.ingredExpiryMap.keySet().iterator();	//유통기한 맵의 키셋을 이터레이터로 저장
		int[] arr = new int[IngredAll.ingredExpiryMap.size()];	//유통기한 맵의 사이즈 만큼 int 배열 할당
		int min = 99;
		String minKey = "";		//미니멈 value 를 가지는 키 값을 저장할 변수
		int minValue = 99;
		
		
		//value를 min 과 비교하여 작은 값 발견시 tempKey를 저장
		for(int i = 0;iterator.hasNext();i++) {
			String tempKey = (String) iterator.next();
			arr[i] = (int) IngredAll.ingredExpiryMap.get(tempKey);		//배열에 모든 value 값 저장
			
			if(arr[i] < min) {		
				min = arr[i];		//최소값 저장(남은 일자 반환을 위함)
				minKey = tempKey;	//반환용 키 값 추출
				minIngredNo = minKey.substring(minKey.length()-4,minKey.length());		//미니멈 value 를 가지는 key값의 재료 번호
				minIngredExpiry = String.valueOf(min);
			}
			
		}
		System.out.println("minIngredNo : " + minIngredNo);
		System.out.println("minIngredExpiry : " + minIngredExpiry);
		
		
		
	}//method 
	
	
	
	
	
	//유통기한 제일 짧은 재료 번호 반환
	public String getMinIngredNo() {
		return minIngredNo;
	}
	//해당 재료 남은 유통기한 일자 반환
	public String getMinIngredExpiry() {
		
		
		String str = null;
		
		
		
		str = String.valueOf(IngredAll.ingredExpiryMap.get(AllRecipe.loginId + minIngredNo));
		
		if(IngredAll.ingredExpiryMap.get(AllRecipe.loginId + minIngredNo) == null) {
			System.out.println("밸류 널 나옴, 널 유통기한 대입");
			str = "재료 유통기한을 입력해주세요";
			
		}else {
			str = "유통기한이 " + String.valueOf(IngredAll.ingredExpiryMap.get(AllRecipe.loginId + minIngredNo) + "일 남았습니다.");
		}
		
		
		
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//class
