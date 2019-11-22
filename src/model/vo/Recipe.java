package model.vo;

import java.util.ArrayList;

public class Recipe implements java.io.Serializable {
	
	private String recipeName;
	private String recipeCont;
	//private String recipeContAdr;
	private String recipePicAdr;
	private String recipeMent;
	private ArrayList recipeIngred;
	
	public Recipe() {}
	
	public Recipe(String recipeName, String recipeCont, String recipePicAdr, String recipeMent, ArrayList recipeIngred) {
		super();
		this.recipeName = recipeName;
		this.recipeCont = recipeCont;
		this.recipePicAdr = recipePicAdr;
		this.recipeMent = recipeMent;
		this.recipeIngred = recipeIngred;
	}
	
	
	
	
	
	public String getRecipeName() {
		return recipeName;
	}

	public String getRecipeMent() {
		return recipeMent;
	}

	public void setRecipeMent(String recipeMent) {
		this.recipeMent = recipeMent;
	}

	public String getRecipeCont() {
		return recipeCont;
	}

	public String getRecipePicAdr() {
		return recipePicAdr;
	}

	public ArrayList getRecipeIngred() {
		return recipeIngred;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public void setRecipeCont(String recipeCont) {
		this.recipeCont = recipeCont;
	}

	public void setRecipePicAdr(String recipePicAdr) {
		this.recipePicAdr = recipePicAdr;
	}

	public void setRecipeIngred(ArrayList recipeIngred) {
		this.recipeIngred = recipeIngred;
	}

	
	
	
	
}
