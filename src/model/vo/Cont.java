package model.vo;

import java.io.Serializable;
import java.util.Date;

public class Cont implements Serializable{
	
//	private String userId;
//	private String recipeName;
	private String recipeCont;
//	private String recipeFile;
//	private int boardNo;
//	private int readCount;
//	private Date boardDate;
	
//  public Cont(String userId, String recipeName, String recipeCont, String recipeFile, int boardNo, int readCount,
//			Date boardDate) {
	
	public Cont(String recipeCont) {
		
		
		super();
//		this.userId = userId;
//		this.recipeName = recipeName;
		this.recipeCont = recipeCont;
//		this.recipeFile = recipeFile;
//		this.boardNo = boardNo;
//		this.readCount = readCount;
//		this.boardDate = boardDate;
	}

//	public String getUserId() {
//		return userId;
//	}

//	public String getRecipeName() {
//		return recipeName;
//	}

	

	public String getRecipeCont() {
		return recipeCont;
	}

//	public String getRecipeFile() {
//		return recipeFile;
//	}

//	public int getBoardNo() {
//		return boardNo;
//	}

//	public int getReadCount() {
//		return readCount;
//	}

//	public Date getBoardDate() {
//		return boardDate;
//	}

//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

//	public void setRecipeName(String recipeName) {
//		this.recipeName = recipeName;
//	}

	public void setRecipeCont(String recipeCont) {
		this.recipeCont = recipeCont;
	}



//	public void setRecipeFile(String recipeFile) {
//		this.recipeFile = recipeFile;
//	}

//	public void setBoardNo(int boardNo) {
//		this.boardNo = boardNo;
//	}

//	public void setReadCount(int readCount) {
//		this.readCount = readCount;
//	}

//	public void setBoardDate(Date boardDate) {
//		this.boardDate = boardDate;
//	}

	@Override
	public String toString() {
		return "Cont [recipeCont=" + recipeCont + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Cont [userId=" + userId + ", recipeName=" + recipeName + ", recipeCont=" + recipeCont + ", recipeFile="
//				+ recipeFile + ", boardNo=" + boardNo + ", readCount=" + readCount + ", boardDate=" + boardDate + "]";
//	}

	
	
	
	
}
