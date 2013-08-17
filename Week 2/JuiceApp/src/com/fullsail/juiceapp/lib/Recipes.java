package com.fullsail.juiceapp.lib;

public interface Recipes {
	//set the name of a juice recipe
	public boolean setRecipeName(String name);
	
	//set the price of a juice recipe
	public boolean setRecipePrice(double price);
	
	//get the name of the juice recipe
	public String getRecipeName();
	
	//get the price of a juice recipe
	public double getRecipePrice();
}
