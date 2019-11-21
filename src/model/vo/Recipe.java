package model.vo;

import java.util.ArrayList;

public class Recipe implements java.io.Serializable {
	
	private String recipeName;
	private String recipeCont;
	//private String recipeContAdr;
	private String recipePicAdr;
	private ArrayList recipeIngred;
	
	public Recipe(String recipeName, String recipeCont, String recipePicAdr, ArrayList recipeIngred) {
		super();
		this.recipeName = recipeName;
		this.recipeCont = recipeCont;
		this.recipePicAdr = recipePicAdr;
		this.recipeIngred = recipeIngred;
	}
	
	
	public String getRecipeName() {
		return recipeName;
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
